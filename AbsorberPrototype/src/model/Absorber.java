package model;

import java.awt.Color;

import physics.Circle;
import physics.LineSegment;

public class Absorber implements IGizmo {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
	

	public Absorber(int x, int y, int w, Model m) {
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.height = 30;
		this.color = Color.ORANGE;
		m.addLine(new VerticalLine(x, y, w));
		m.addLine(new VerticalLine(x, y + w, w));
		
		// for ends of the lines in the absorber
		Circle tl = new Circle(x, y, 10);
		Circle tr = new Circle(x, w, 0);
		Circle bl = new Circle(y, w, 0);
		Circle br  = new Circle(w, w, 0);
	}

	@Override
	public void setYPos(int y) {
		yPos = y;
	}

	@Override
	public void setXPos(int x) {
		xPos = x;
	}

	@Override
	public void setWidth(int w) {
		width = w;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setEndPoints() {

	}

	@Override
	public void setHeight(int h) {
		height = h;
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
}
