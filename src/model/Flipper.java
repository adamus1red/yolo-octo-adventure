package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;

public class Flipper extends Gizmo {

	private final int width = 16;
	private final int height = 35;
	private final int radius = 0; // 10 for testing change to 0 when not

	public Flipper(int x, int y, String n, Model m) {
		super(x, y);
		super.setColor(Color.RED);
		super.setName(n);
		super.setType("Flipper");
		super.circles = new ArrayList<>();
		super.lines = new ArrayList<>();
		
		// vertical lines
		super.lines.add(new LineSegment(x, y, x, y + height));
		super.lines.add(new LineSegment(x + width, y, x + width, y + height));

		// horizontal lines
		super.lines.add(new LineSegment(x, y, x + width, y));
		super.lines.add(new LineSegment(x, y + height, x + width, y + height));

		// for ends of the lines
<<<<<<< HEAD
		super.circles.add(new Circle(x, y, radius));
		super.circles.add(new Circle(x, y + height, radius));
		super.circles.add(new Circle(x + width, y, radius));
		super.circles.add(new Circle(x + width, y + height, radius));

		// for ends of flippers
		super.circles.add(new Circle(x + (width / 2), y, width / 2));
		super.circles.add(new Circle(x + (width / 2), y + height, width / 2));
		m.addGizmo(this);
=======
		m.addCircles(new Circle(x, y, radius));
		m.addCircles(new Circle(x, y + height, radius));
		m.addCircles(new Circle(x + width, y, radius));
		m.addCircles(new Circle(x + width, y + height, radius));

		// for ends of flippers
		m.addFipperCircle(new Circle(x + (width / 2), y, width / 2));
		m.addFipperCircle(new Circle(x + (width / 2), y + height, width / 2));
>>>>>>> origin/master
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getRadius() {
		return radius;
	}
}
