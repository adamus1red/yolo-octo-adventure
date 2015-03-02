package model;

import java.awt.Color;

import physics.Circle;

public class CircleBumper implements IGizmo {
	private int xPos;
	private int yPos;
	private Color color;
	private int radius = 25;
	
	public CircleBumper(int x, int y, Model m) {
		this.xPos = x;
		this.yPos = y;
		this.color = Color.YELLOW;
		
		// add circle  then model can deal with collisions
		m.addCircles(new Circle(x, y, radius));
	}
	
	// used for the circles at the end of flippers
	public CircleBumper(int x, int y, int r ,Color c, Model m) {
		this.xPos = x;
		this.yPos = y;
		this.radius = r;
		this.color = c;
		
		// add circle  then model can deal with collisions
		m.addCircles(new Circle(x, y, r));
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRadius() {
		return radius;
	}

}
