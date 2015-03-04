package model;

import java.awt.Color;

import physics.Circle;

public class SquareBumper implements IGizmo {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private final int radius = 0; // 10 for testing change to 0 when not
	private Color color;
	private String type;
	

	public SquareBumper(int x, int y, int w, int h, Model m) {
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.height = h;
		this.color = Color.CYAN;
		type = "Square";
		
		// vertical lines 
		m.addLine(new VerticalLine(x,y,1,h));
		m.addLine(new VerticalLine(x+w-1,y,1,h));
		
		// horizontal lines 
		m.addLine(new VerticalLine(x, y, w, 1));
		m.addLine(new VerticalLine(x, y + h -1, w, 1));
		
		// for ends of the lines
		m.addCircles(new Circle(x, y, radius));
		m.addCircles(new Circle(x, y + h, radius));
		m.addCircles(new Circle(x + w, y, radius));
		m.addCircles(new Circle(x + w, y + h, radius));
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
	
	public int getRadius(){
		return radius;
	}

	@Override
	public String getType() {
		return type;
	}



}