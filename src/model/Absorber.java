package model;

import java.awt.Color;

import physics.Circle;

public class Absorber extends Gizmo implements IGizmo {
	private int width;
	private int height = 25;
	private final int radius = 0; // 10 for testing change to 0 when not

	public Absorber(int x, int y, int w, int h, String n, Model m) {
		super(x, y);
		width = w;
		height = h;
		super.setName(n);
		setColor(Color.ORANGE);
		super.setType("Absorber");
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
	
	public int getWidth(){
		return width; 
	}
	
	public int getHeight(){
		return height; 
	}
}
