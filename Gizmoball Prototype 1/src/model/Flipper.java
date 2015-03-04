package model;

import java.awt.Color;

import physics.Circle;

public class Flipper implements IGizmo {
	private int xPos;
	private int yPos;
	private final int width = 16;
	private final int height = 35;
	private final int radius = 0; // 10 for testing change to 0 when not
	private Color color;
	private String type;

	public Flipper(int x, int y,  Model m) {
		this.xPos = x;
		this.yPos = y;
		this.color = Color.RED;
		type = "Flipper";

		// vertical lines
		m.addLine(new VerticalLine(x, y, 1, height));
		m.addLine(new VerticalLine(x + width - 1, y, 1, height));

		// horizontal lines 
		m.addLine(new VerticalLine(x, y, width, 1));
		m.addLine(new VerticalLine(x, y + height - 1, width, 1));

		// for ends of the lines 
		m.addCircles(new Circle(x, y, radius));
		m.addCircles(new Circle(x, y + height, radius));
		m.addCircles(new Circle(x + width, y, radius));
		m.addCircles(new Circle(x + width, y + height, radius));
		
		// for circles at the end of flipper
		m.addGizmo(new CircleBumper(x + width / 2, y, width / 2, this.color, m));
		m.addGizmo(new CircleBumper(x + width / 2, y + height, width / 2, this.color, m));
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

	@Override
	public String getType() {
		return type;
	}




}
