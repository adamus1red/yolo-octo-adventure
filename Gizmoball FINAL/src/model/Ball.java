package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;


public class Ball implements IGizmo{

	private Vect velocity;
	private int radius;
	private double xpos;
	private double ypos;
	private Color colour;

	private boolean stopped;
	private String name;

	// x, y coordinates and x,y velocity
	public Ball(double x, double y, double xv, double yv, String n) {
		xpos = x;
		ypos = y;
		colour = Color.BLUE;
		velocity = new Vect(xv, yv);
		radius = 6;
		stopped = false;
		setName(n);
	}
	
	public void setName(String n) {
		name = n;
	}

	public Vect getVelo() {
		return velocity;
	}

	public void setVelo(Vect v) {
		velocity = v;
	}

	public int getRadius() {
		return radius;
	}

	public Circle getCircle() {
		return new Circle(xpos, ypos, radius);

	}
	
	public void setGravity(){
		
	}

	// Ball specific methods that deal with double precision.
	public double getExactX() {
		return xpos;
	}

	public double getExactY() {
		return ypos;
	}

	public void setExactX(double x) {
		xpos = x;
	}

	public void setExactY(double y) {
		ypos = y;
	}

	public void stop() {
		stopped = true;
	}

	public void start() {
		stopped = false;
	}

	public boolean stopped() {
		return stopped;
	}

	public Color getColour() {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getXPos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYPos() {
		// TODO Auto-generated method stub
		return 0;
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
	public int getRotation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setXPos(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setYPos(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRotation(int r) {
		// TODO Auto-generated method stub
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public ArrayList<LineSegment> getLines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Circle> getCircles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor() {
		// TODO Auto-generated method stub
		
	}
}
