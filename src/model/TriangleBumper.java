package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;

public class TriangleBumper extends Gizmo {

	private int xpos;
	private int ypos;
	private int width;
	private int height;
	private Color color;
	private final int radius = 0; // 10 for testing change to 0 when not

	public TriangleBumper(int x, int y, String n, Model m) {
		xpos = x;
		ypos = y;
		width = 25;
		height = 25;
		super.setName(n);
		super.setType("Triangle");
		this.color = Color.ORANGE;
		super.circles = new ArrayList<>();
		super.lines = new ArrayList<>();
		
		// vertical lines
		super.lines.add(new LineSegment(x, y, x, y + height));

		// horizontal lines
		super.lines.add(new LineSegment(x, y + height, x + width, y + height));

		// diagonal lines
		super.lines.add(new LineSegment(x, y, x + width, y + height));

		// for ends of the lines
		super.circles.add(new Circle(x, y, radius));
		super.circles.add(new Circle(x, y + height, radius));
		super.circles.add(new Circle(x + width, y + height, radius));
		m.addGizmo(this);
	}

	@Override
	public int getXPos() {
		return xpos;
	}

	@Override
	public int getYPos() {
		return ypos;
	}

	public int getXPos2() {
		return xpos;
	}

	public int getYPos2() {
		return ypos + height;
	}

	public int getXPos3() {
		return xpos + width;
	}

	public int getYPos3() {
		return ypos + height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public Color getColor() {
		return color;
	}
	
	public void setColor(){
		this.color = Color.CYAN;
	}
}