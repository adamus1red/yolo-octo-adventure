package model;

import java.awt.Color;

import physics.Circle;

public class Flipper implements IGizmo {
	private int xPos;
	private int yPos;
	private int width;
	private final int height = 35;
	private final int radius = 0; // 10 for testing change to 0 when not
	private Color color;

	public Flipper(int x, int y, int w, Model m) {
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.color = Color.RED;

		// vertical lines
		m.addLine(new VerticalLine(x, y, 1, height));
		m.addLine(new VerticalLine(x + w - 1, y, 1, height));

		// horizontal lines 
		m.addLine(new VerticalLine(x, y, w, 1));
		m.addLine(new VerticalLine(x, y + height - 1, w, 1));

		// for ends of the lines 
		m.addCircles(new Circle(x, y, radius));
		m.addCircles(new Circle(x, w, radius));
		m.addCircles(new Circle(y, w, radius));
		m.addCircles(new Circle(w, w, radius));
		
		// for circles at the end of flipper
		m.addGizmo(new CircleBumper(x + w / 2, y, w, this.color, m));
		m.addGizmo(new CircleBumper(x + w / 2, y + height, w, this.color, m));
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int getXPos() {
		return xPos;
	}

	@Override
	public int getYPos() {
		return yPos;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getRadius() {
		return radius;
	}
}
