package model;

import java.awt.Color;

import physics.Circle;
import physics.LineSegment;

public class SquareBumper extends Gizmo implements IGizmo {
	private int width;
	private int height;
	private final int radius = 0; // 10 for testing change to 0 when not
	private Color color;

	public SquareBumper(int x, int y, String n, Model m) {
		super(x, y);
		width = 25;
		height = 25;
		super.setName(n);
		super.setColor(Color.CYAN);
		super.setType("Square");
		// vertical lines
		m.addLine(new LineSegment(x, y, x, y + height));
		m.addLine(new LineSegment(x + width, y, x + width, y + height));

		// horizontal lines
		m.addLine(new LineSegment(x, y, x + width, y));
		m.addLine(new LineSegment(x, y + height, x + width, y + height));

		// for ends of the lines
		m.addCircles(new Circle(x, y, radius));
		m.addCircles(new Circle(x, y + height, radius));
		m.addCircles(new Circle(x + width, y, radius));
		m.addCircles(new Circle(x + width, y + height, radius));
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}