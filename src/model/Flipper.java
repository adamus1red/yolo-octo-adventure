package model;

import java.awt.Color;

import physics.Circle;

public class Flipper extends Gizmo implements IGizmo {

	private final int width = 16;
	private final int height = 35;
	private final int radius = 0; // 10 for testing change to 0 when not
	private Color color;

	public Flipper(int x, int y, String n, Model m) {
		super(x ,y);
		super.setColor(Color.RED);
		super.setName(n);
		super.setType("Flipper");
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
		m.addGizmo(new CircleBumper(x + width / 2, y, width / 2, this.color, this.getName(),m));
		m.addGizmo(new CircleBumper(x + width / 2, y + height, width / 2, this.color, this.getName(), m));
	}
	public int getWidth(){
		return width; 
	}
	public int getHeight(){
		return height; 
	}
	public int getRadius(){
		return radius; 
	}
}
