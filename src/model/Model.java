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

	private ArrayList<LineSegment> lines;
	private ArrayList<IGizmo> gizmos;
	private ArrayList<Circle> circles;
	private ArrayList<Circle> flipperCircles;

	private Ball ball;
	private Walls gws;
	private float gravity;
	private float friction;
	private double mu = 0.025;
	private double mu2 = 0.00125;
	private double deltaT = 0.05;

	public Model() {

		// Ball position (250, 25) in pixels. Ball velocity (100, 100) pixels
		// per tick
		ball = new Ball(475, 25, 100, 100, "Gball1");

		// Wall size 500 x 500 pixels
		gws = new Walls(0, 0, 500, 500);

		// Lines added in Main
		lines = new ArrayList<LineSegment>();

		// Gizmos added
		gizmos = new ArrayList<IGizmo>();

		// circles added
		circles = new ArrayList<Circle>();

		// flippers circles
		flipperCircles = new ArrayList<Circle>();
	}

	/**
	 * Moves the ball by for at most 20 times a second
	 */
	public void moveBall() {

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

			CollisionDetails cd = timeUntilCollision();
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

	private CollisionDetails timeUntilCollision() {
		// Find Time Until Collision and also, if there is a collision, the new
		// speed vector.
		// Create a physics.Circle from Ball
		Circle ballCircle = ball.getCircle();
		Vect ballVelocity = ball.getVelo();
		Vect newVelo = new Vect(0, 0);

		// Now find shortest time to hit a vertical line or a wall line
		double shortestTime = Double.MAX_VALUE;
		double time = 0.0;

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
		for (Circle c : circles) {
			time = Geometry.timeUntilCircleCollision(c, ballCircle,
					ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectCircle(c.getCenter(),
						ballCircle.getCenter(), ballVelocity, 1.0);
			}
		}

		// Time to collide with flipper circles
		for (Circle fc : flipperCircles) {
			time = Geometry.timeUntilCircleCollision(fc, ballCircle,
					ballVelocity);
			if (time < shortestTime) {
				shortestTime = time;
				newVelo = Geometry.reflectCircle(fc.getCenter(),
						ballCircle.getCenter(), ballVelocity, 1.0);
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

	public ArrayList<LineSegment> getLines() {
		return lines;
	}

	public void addLine(LineSegment l) {
		lines.add(l);
	}

	public void setBallSpeed(float x, float y) {
		ball.setVelo(new Vect(x, y));
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

	public ArrayList<Circle> getCircles() {
		return circles;
	}

	public void addCircles(Circle c) {
		circles.add(c);
		this.setChanged();
		this.notifyObservers();
	}

	public void rotateGizmo(int x, int y) {
		System.out.println("ping");
		String tmpType = null, tmpName = null;
		int tmpRot = 0, tmpX = 0, tmpY = 0;
		for (int i = 0; i < gizmos.size(); i++) {
			if ((gizmos.get(i).getXPos() >= x-25 && gizmos.get(i).getYPos() >= y-25)
					&& !(gizmos.get(i).getXPos() > x + 25)
					&& !(gizmos.get(i).getYPos() > y + 25)) {
				tmpType = gizmos.get(i).getType();
				tmpName = gizmos.get(i).getName();
				tmpRot = gizmos.get(i).getRotation();
				tmpX = gizmos.get(i).getXPos();
				tmpY = gizmos.get(i).getYPos();
				gizmos.remove(i);
			}
		}
		IGizmo g;
		if (tmpType.toUpperCase().equals("TRIANGLE")) {
			g = new TriangleBumper(tmpX, tmpY, tmpName, this, tmpRot);
			gizmos.add(g);
		} else if (tmpType.toUpperCase().equals("SQUARE")) {
			g = new SquareBumper(tmpX, tmpY, tmpName, this);
			gizmos.add(g);
		} else if (tmpType.toUpperCase().equals("CIRCLE")) {
			g = new CircleBumper(tmpX, tmpY, tmpName, this);
			gizmos.add(g);
		} else if (tmpType.toUpperCase().equals("FLIPPER")) {
			g = new Flipper(tmpX, tmpY, tmpName, this);
			gizmos.add(g);
		} else {
			System.out.println("removed something don't know what though.");
			System.err.println("Removed " + tmpType);
		}
		this.setChanged();
		this.notifyObservers();

	}

	public void addFipperCircle(Circle c) {
		flipperCircles.add(c);
		this.setChanged();
		this.notifyObservers();
	}

	public ArrayList<Circle> getFlipperCircles() {
		return flipperCircles;
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

	public void clearBoard() {
		lines.clear();
		circles.clear();
		gizmos.clear();
		flipperCircles.clear();
		this.setChanged();
		this.notifyObservers();
	}

}
