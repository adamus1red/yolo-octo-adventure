package model;

import java.awt.Color;

import physics.Circle;

public class CircleBumper extends Gizmo implements IGizmo {

	private int radius = 12;
	
	public CircleBumper(int x, int y, String n, Model m) {
		super(x ,y);
		super.setColor(Color.YELLOW);
		super.setName(n);
		super.setType("Circle");
		// add circle  then model can deal with collisions
		m.addCircles(new Circle(x, y, radius));
	}
	
	// used for the circles at the end of flippers
	public CircleBumper(int x, int y, int r ,Color c, String n, Model m) {
		super(x ,y);
		this.radius = r;
		super.setColor(c);
		super.setName(n);
		super.setType("Circle");
		
		// add circle  then model can deal with collisions
		m.addCircles(new Circle(x, y, r));
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

	public int getRadius() {
		return radius;
	}

}
