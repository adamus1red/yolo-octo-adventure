package model;

import physics.LineSegment;

public class VerticalLine {

	private int xpos;
	private int ypos;
	private int width;
	private int height;
	private LineSegment l;

	public VerticalLine(int x, int y, int w, int h) {
		xpos = x;
		ypos = y;
		width = w;
		height = 1;
		l = new LineSegment(x, y, x + w, y + h);
	}

	public LineSegment getLineSeg() {
		return l;
	}

	public int getX() {
		return xpos;
	}

	public int getY() {
		return ypos;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight(){
		return height;
	}

}
