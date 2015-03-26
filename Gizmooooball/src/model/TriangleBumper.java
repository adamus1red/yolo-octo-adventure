package model;

import java.awt.Color;

import physics.Circle;
import physics.LineSegment;

public class TriangleBumper extends Gizmo implements IGizmo {

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
		// vertical lines
		m.addLine(new LineSegment(x, y, x, y + height));
		// m.addLine(new VerticalLine(x+w-1,y,1,h));

		// horizontal lines
		// m.addLine(new VerticalLine(x, y, w, 1));
		m.addLine(new LineSegment(x, y + height, x + width, y + height));

		// diagonal lines
		m.addLine(new LineSegment(x, y, x + width, y + height));

		// for ends of the lines
		m.addCircles(new Circle(x, y, radius));
		// m.addCircles(new Circle(x, y + h, radius));
		m.addCircles(new Circle(x, y + height, radius));
		m.addCircles(new Circle(x + width, y + height, radius));
	}
	
	public void rotateTriangle(){
		
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
	
	public void clearLevel(){
		
	}
}