package model;

import java.awt.Color;

public class Absorber implements IGizmo {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
//	private Circle crcl;
//	private Shape absorber;

	public Absorber(int x, int y, int w, int h) {
		this.xPos = x;
		this.yPos = y;
		this.height = h;
		this.width = w;
		this.color = Color.ORANGE;
//		this.absorber = new Rectangle(x, y, w, h);
		// for ends of the lines in the absorber
//		this.crcl = new Circle(x, x, 0);
//		this.crcl = new Circle(y, y, 0);
//		this.crcl = new Circle(x, x + w, 0);
//		this.crcl = new Circle(y, y + h, 0);
	}

	@Override
	public void setYPos(int y) {
		yPos = y;
	}

	@Override
	public void seXPos(int x) {
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
