package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;

public class Gizmo implements IGizmo {

	private String name;
	private Color color;
	private String type = "Gizmo";
	private int xPos;
	private int yPos;
	private int rotation = 90;
	protected ArrayList<Circle> circles;
	protected ArrayList<LineSegment> lines;

	public Gizmo(int x, int y) {
		xPos = x;
		yPos = y;
		name = null;
		color = Color.CYAN;
		type = null;
	}

	public Gizmo() {
		name = null;
		color = new Color(0);
		type = null;
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	@Override
	public void setName(String s) {
		// TODO Auto-generated method stub
		name = s;
	}

	@Override
	public void setType(String s) {
		type = s;
	}

	@Override
	public void setXPos(int x) {
		if ((x < 21) && (x >= 0)) {
			xPos = x;
		}
	}

	@Override
	public void setYPos(int y) {
		if ((y < 21) && (y >= 0)) {
			yPos = y;
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public void setRotation(int r) {
		rotation = r;
	}

	@Override
	public int getXPos() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public int getYPos() {
		// TODO Auto-generated method stub
		return yPos;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getRotation() {
		// TODO Auto-generated method stub
		return rotation;
	}

	@Override
	public int getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<LineSegment> getLines() {
		return lines;
	}

	@Override
	public ArrayList<Circle> getCircles() {
		return circles;
	}

	@Override
	public void setColor() {
		// TODO Auto-generated method stub
		
	}
}
