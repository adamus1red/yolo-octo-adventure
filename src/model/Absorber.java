package model;

import java.awt.Color;

import physics.Circle;
import physics.LineSegment;

public class Absorber extends Gizmo implements IGizmo {
	private int width;
	private int height = 25;
	private final int radius = 0; // 10 for testing change to 0 when not

	public Absorber(int x, int y, int w, int h, String n, Model m) {
		super(x, y);
		width = w;
		height = h;
		super.setName(n);
		setColor(Color.ORANGE);
		super.setType("Absorber");
		// vertical lines
		m.addLine(new LineSegment(x, y, x, y + height));
		m.addLine(new LineSegment(x + width, y, x + width, y + height));

		// horizontal lines
		m.addLine(new LineSegment(x, y, x + width, y));
		m.addLine(new LineSegment(x, y + height, x + width, y + height));

		// for ends of the lines
		m.addCircles(new Circle(x, y, radius));
		m.addCircles(new Circle(x, y + height, radius));
		m.addCircles(new Circle(x + w, y, radius));
		m.addCircles(new Circle(x + w, y + height, radius));
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
