package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;

public class CircleBumper extends Gizmo  {

	private int radius = 12;
	
	public CircleBumper(int x, int y, String n, Model m) {
		super(x ,y);
		super.setColor(Color.MAGENTA);
		super.setName(n);
		super.setType("Circle");
		
		// add circle  then model can deal with collisions
		super.addCircles(new Circle(x, y, radius));
		m.addGizmo(this);
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
