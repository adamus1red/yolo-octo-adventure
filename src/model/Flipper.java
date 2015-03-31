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
		
		// vertical lines
		super.addLines(new LineSegment(x, y, x, y + height));
		super.addLines(new LineSegment(x + width, y, x + width, y + height));

		// horizontal lines
		super.addLines(new LineSegment(x, y, x + width, y));
		super.addLines(new LineSegment(x, y + height, x + width, y + height));

		// for ends of the lines
		super.addCircles(new Circle(x, y, radius));
		super.addCircles(new Circle(x, y + height, radius));
		super.addCircles(new Circle(x + width, y, radius));
		super.addCircles(new Circle(x + width, y + height, radius));

		// for ends of flippers
		super.addCircles(new Circle(x + (width / 2), y, width / 2));
		super.addCircles(new Circle(x + (width / 2), y + height, width / 2));
		m.addGizmo(this);
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
