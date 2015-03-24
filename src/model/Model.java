package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import controller.LoadState;
import controller.SaveState;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;


public class Model extends Observable {

	private ArrayList<LineSegment> lines;
	private ArrayList<IGizmo> gizmos;
	private ArrayList<Circle> circles;
//	private int vx, vy;
	private ArrayList<Ball> balls;
	
	
	private Walls gws;
	private float gravity;
	private float friction;
	
	public Model() {
		
		balls = new ArrayList<Ball>();
		// Wall size 500 x 500 pixels
		gws = new Walls(0, 0, 500, 500);

		// Lines added in Main
		lines = new ArrayList<LineSegment>();

		// Gizmos added
		gizmos = new ArrayList<IGizmo>();

		// circles added
		circles = new ArrayList<Circle>();
	}
	
	/**
	 * Moves the ball by for at most 20 times a second
	 */
	
	public void moveBalls(Ball ball) {
		double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball

		if (ball != null && !ball.stopped()) {

			CollisionDetails cd = timeUntilCollision(ball);
			double tuc = cd.getTuc();
			if (tuc > moveTime) {
				// No collision ...
				ball = movelBallForTime(ball, moveTime);
			} else {
				// We've got a collision in tuc
				ball = movelBallForTime(ball, tuc);
				// Post collision velocity ...
				ball.setVelo(cd.getVelo());
			}

			// Notify observers ... redraw updated view
			this.setChanged();
			this.notifyObservers();
		}
	
	}

	
	/**
	 * Moves a ball for a specified time
	 * @param ball
	 * @param time
	 * @return ball
	 */
	private Ball movelBallForTime(Ball ball, double time) {

		double newX = 0.0;
		double newY = 0.0;
		double xVel = ball.getVelo().x();
		double yVel = ball.getVelo().y();
		newX = ball.getExactX() + (xVel * time);
		newY = ball.getExactY() + (yVel * time);
		ball.setExactX(newX);
		ball.setExactY(newY);
		return ball;
	}

	private CollisionDetails timeUntilCollision(Ball ball) {
		Vect newVelo = new Vect(0, 0);
		double shortestTime = Double.MAX_VALUE;
	//	for(int i = 0; i <balls.size(); i++){
	//		Ball ball = balls.get(i);
		// Find Time Until Collision and also, if there is a collision, the new
		// speed vector.
		// Create a physics.Circle from Ball
		Circle ballCircle = ball.getCircle();
		Vect ballVelocity = ball.getVelo();
		
		
		// Now find shortest time to hit a vertical line or a wall line
		
		double time = 0.0;

		
		/*for (Ball b : balls){
		
			time = Geometry. timeUntilBallBallCollision(b.getCircle(), b.getVelo(), ballCircle, ballVelocity);
			if (time < shortestTime){
				shortestTime = time;
				//ballVelocity = Geometry.reflectBalls(b.getCenter(), 1, b.getVelo(), ball.getCenter(), 1, ballVelocity).v2;
				//secondBallVelo = Geometry.reflectBalls(b.getCenter(), 1, b.getVelo(), ball.getCenter(), 1, ballVelocity).v1;
				//b.setVelo(Geometry.reflectBalls(b.getCenter(), 1, b.getVelo(), ball.getCenter(), 1,  ball.getVelo()).v1);
				ball.setVelo(Geometry.reflectBalls(b.getCenter(), 1, b.getVelo(), ball.getCenter(), 1,  ball.getVelo()).v2);
				newVelo = ball.getVelo();
			}
		}*/
		// Time to collide with 4 walls
		ArrayList<LineSegment> lss = gws.getLineSegments();
		for (LineSegment line : lss) {
			time = Geometry.timeUntilWallCollision(line, ballCircle,
					ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);
			}
		}
		
		// Time to collide with circles
		for (Circle c : circles){
			time = Geometry.timeUntilCircleCollision(c, ballCircle, ballVelocity);
			if (time < shortestTime){
				shortestTime = time;
				newVelo = Geometry.reflectCircle(c.getCenter(), ballCircle.getCenter(), ballVelocity, 1.0);
			}
		}

		// Time to collide with any vertical lines
		for (LineSegment line : lines) {
			LineSegment ls = line;
			time = Geometry
					.timeUntilWallCollision(ls, ballCircle, ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
			}
		}
//	}
		return new CollisionDetails(shortestTime, newVelo);
		
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public ArrayList<LineSegment> getLines() {
		return lines;
	}

	public void addLine(LineSegment l) {
		lines.add(l);
	}

	//public void setBallSpeed(float x, float y) {
	//	ball.setVelo(new Vect(x, y));
//	}
	public void addBall(Ball b){
		balls.add(b);
		//balls.add(new Ball(75, 215, 100, 100));
		//moveBalls(b);
		//for(int i = 0; i<balls.size(); i ++)
		//System.out.println(balls.get(i).getVelo());
		}

	public void addGizmo(IGizmo g) {
		gizmos.add(g);
		this.notifyObservers();
	}
	
	public void setGizmo(ArrayList<IGizmo> gl) {
		gizmos = gl;
		this.notifyObservers();
	}

	public ArrayList<IGizmo> getGizmos() {
		return gizmos;
	}
	
	public ArrayList<Circle> getCircles(){
		return circles;
	}
	
	public void addCircles(Circle c){
		circles.add(c);
	}

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public float getFriction() {
		return friction;
	}

	public void setFriction(float friction) {
		this.friction = friction;
	}

	public void startLoad(String in) {
		clearBoard();
		LoadState loader = new LoadState(this);
		setGizmo(loader.load(in));
	}

	public void startSave(String out) {
		SaveState saver = new SaveState(this);
		try {
			saver.save(out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearBoard(){
		lines.clear();
		circles.clear();
		gizmos.clear();
	}

}

