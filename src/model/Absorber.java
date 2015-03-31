package model;

import java.awt.Color;
import java.util.ArrayList;

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
		setColor(Color.PINK);
		super.setType("Absorber");
		super.circles = new ArrayList<>();
		super.lines = new ArrayList<>();

		// vertical lines
		super.lines.add(new LineSegment(x, y, x, y + height));
		super.lines.add(new LineSegment(x + width, y, x + width, y + height));

		// horizontal lines
		super.lines.add(new LineSegment(x, y, x + width, y));
		super.lines.add(new LineSegment(x, y + height, x + width, y + height));

		// for ends of the lines
		super.circles.add(new Circle(x, y, radius));
		super.circles.add(new Circle(x, y + height, radius));
		super.circles.add(new Circle(x + w, y, radius));
		super.circles.add(new Circle(x + w, y + height, radius));
		m.addGizmo(this);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
