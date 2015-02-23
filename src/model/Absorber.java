package model;

import java.awt.Color;

public class Absorber extends Gizmo {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

	// private Circle crcl;
	// private Shape absorber;

	public Absorber(int x, int y, int w, int h) {
		this.setStartPoints(x, y);
		this.height = h;
		this.width = w;
		this.color = Color.ORANGE;
		// this.absorber = new Rectangle(x, y, w, h);
		// for ends of the lines in the absorber
		// this.crcl = new Circle(x, x, 0);
		// this.crcl = new Circle(y, y, 0);
		// this.crcl = new Circle(x, x + w, 0);
		// this.crcl = new Circle(y, y + h, 0);
	}

	public void setWidth(int w) {
		width = w;
	}

	public void setHeight(int h) {
		height = h;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
