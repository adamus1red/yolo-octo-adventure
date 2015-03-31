package model;

import java.util.ArrayList;
import java.util.Observable;
import controller.LoadState;
import controller.SaveState;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

public class Model extends Observable {

	private ArrayList<IGizmo> gizmos;
	private Ball ball;
	private Walls gws;
	private float gravity;
	private float friction;
	private double mu = 0.025;
	private double mu2 = 0.00125;
	private double deltaT = 0.05;
	private ArrayList<Ball> balls;

	public Model() {

		// Ball position (250, 25) in pixels. Ball velocity (100, 100) pixels
		// per tick
		balls = new ArrayList<Ball>();
		ball = new Ball(400, 25, 100, 100, "Gball1");
		balls.add(ball);

		// Wall size 500 x 500 pixels
		gws = new Walls(0, 0, 500, 500);

		// Gizmos added
		gizmos = new ArrayList<IGizmo>();

	}

	/**
	 * Moves the ball by for at most 20 times a second
	 */
	public void moveBalls(Ball ball) {

		double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball

		if (ball != null && !ball.stopped()) {

			// // Vnew = Vold * (1 - mu * delta_t - mu2 * |Vold| * delta_t).
			double frictionX = ball.getVelo().x()
					* (1 - mu * deltaT - mu2
							* Math.abs(ball.getVelo().x() * deltaT));
			double frictionY = ball.getVelo().y()
					* (1 - mu * deltaT - mu2
							* Math.abs(ball.getVelo().y() * deltaT));
			Vect velo = new Vect(frictionX, frictionY + 25);
			ball.setVelo(velo);

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
	 * 
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
		// Find Time Until Collision and also, if there is a collision, the new
		// speed vector.
		// Create a physics.Circle from Ball
		Circle ballCircle = ball.getCircle();
		Vect ballVelocity = ball.getVelo();
		Vect newVelo = new Vect(0, 0);

		// Now find shortest time to hit a vertical line or a wall line
		double shortestTime = Double.MAX_VALUE;
		double time = 0.0;

		// Time to collide with squares triangles and circles
		for (IGizmo gz : this.getGizmos()) {
			if (gz.getType().equals("Square")
					|| gz.getType().equals("Triangle")
					|| gz.getType().equals("Flipper")) {

				for (LineSegment line : gz.getLines()) {
					time = Geometry.timeUntilWallCollision(line, ballCircle,
							ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectWall(line, ball.getVelo(),
								1.0);
						gz.setColor();
					}
				}
				for (Circle c1 : gz.getCircles()) {
					time = Geometry.timeUntilCircleCollision(c1, ballCircle,
							ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(c1.getCenter(),
								ballCircle.getCenter(), ballVelocity, 1.0);
						gz.setColor();
					}
				}
			} else if (gz.getType().equals("Circle")) {
				for (Circle c : gz.getCircles()) {
					time = Geometry.timeUntilCircleCollision(c, ballCircle,
							ballVelocity);
					if (time < shortestTime) {
						shortestTime = time;
						newVelo = Geometry.reflectCircle(c.getCenter(),
								ballCircle.getCenter(), ballVelocity, 1.0);
					}
				}
			} else if (gz.getType().equals("Absorber")) {
				for (Circle c1 : gz.getCircles()) {
					time = Geometry.timeUntilCircleCollision(c1, ballCircle,
							ballVelocity);
					}
				for (LineSegment line : gz.getLines()) {
					LineSegment ls = line;
					time = Geometry.timeUntilWallCollision(ls, ballCircle,
							ballVelocity);
					if (time < shortestTime) {
						if (gz.getType().equals("Absorber")) {
							if (time < .05) {
								for (int z = 0; z < balls.size(); z++) {
									Ball b = balls.get(z);
									if (b.equals(ball)) {
										balls.remove(z);
										balls.add(new Ball(gz.getXPos()
												+ gz.getWidth() - 10, gz
												.getYPos() - 5, 0, -1000,
												"Gball1"));
										System.out.println(ls.toString());
									}
								}
							}
						}
						shortestTime = time;
						newVelo = Geometry.reflectWall(ls, ball.getVelo(), 1.0);
					}
				}
			}
		}

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

		return new CollisionDetails(shortestTime, newVelo);
	}

	public void removeGizmo(int x, int y) {
		System.out.println("Remove called at: " + x + " " + y);
		for (int i = 0; i < gizmos.size(); i++) {
			if ((gizmos.get(i).getXPos() >= x-25 && gizmos.get(i).getYPos() >= y-25)
					&& !(gizmos.get(i).getXPos() > x + 25)
					&& !(gizmos.get(i).getYPos() > y + 25)) {
				gizmos.remove(i);
			}
		}
		this.setChanged();
		this.notifyObservers();
	}

	public Ball getBall() {
		return ball;
	}

	public void setBallSpeed(float x, float y) {
		ball.setVelo(new Vect(x, y));
	}

	public void addGizmo(IGizmo g) {
		gizmos.add(g);
		this.setChanged();
		this.notifyObservers();
	}

	public void setGizmo(ArrayList<IGizmo> gl) {
		gizmos = gl;
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<IGizmo> getGizmos() {
		return gizmos;
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

	public void addBall(Ball b) {
		balls.add(b);
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public void clearBoard() {
		gizmos.clear();
		this.setChanged();
		this.notifyObservers();
	}

}
