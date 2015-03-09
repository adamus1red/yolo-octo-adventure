package model;

import java.awt.Color;
import physics.Circle;

public class SquareBumper extends Gizmo implements IGizmo {
	private int width;
	private int height;
	private final int radius = 0; // 10 for testing change to 0 when not
	private Color color;
	

	public SquareBumper(int x, int y, String n, Model m) {
		super(x ,y);
		this.width = 25;
		this.height = 25;
		super.setName(n);
		super.setColor(Color.CYAN);
		super.setType("Square");
		// vertical lines 
		m.addLine(new VerticalLine(x,y,1,height));
		m.addLine(new VerticalLine(x+width-1,y,1,height));
		
		// horizontal lines 
		m.addLine(new VerticalLine(x, y, width, 1));
		m.addLine(new VerticalLine(x, y + height -1, width, 1));
		
		// for ends of the lines
		m.addCircles(new Circle(x, y, radius));
		m.addCircles(new Circle(x, y + height, radius));
		m.addCircles(new Circle(x + width, y, radius));
		m.addCircles(new Circle(x + width, y + height, radius));
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}