package model;

import java.awt.Color;
import physics.Circle;

public class Absorber implements IGizmo {
	private int xPos;
	private int yPos;
	private int width;
	private final int height = 25;
	private final int radius = 0; // 10 for testing change to 0 when not
	private Color color;
	

	public Absorber(int x, int y, int w, Model m) {
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.color = Color.ORANGE;
		
		// vertical lines 
		m.addLine(new VerticalLine(x,y,1,height));
		m.addLine(new VerticalLine(x+w-1,y,1,height));
		
		// horizontal lines 
		m.addLine(new VerticalLine(x, y, w, 1));
		m.addLine(new VerticalLine(x, y + height -1, w, 1));
		
		// for ends of the lines
		m.addCircles(new Circle(x, y, radius));
		m.addCircles(new Circle(x, y + height, radius));
		m.addCircles(new Circle(x + w, y, radius));
		m.addCircles(new Circle(x + w, y + height, radius));
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
}
