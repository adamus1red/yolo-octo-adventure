package model;

import java.awt.Color;

public class Gizmo implements IGizmo {

	private String name;
	private Color color;
	private String type;
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public Gizmo() {
		name = null;
		color = new Color(0);
		type = null;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
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
	public void setStartPoints(int x, int y) {
		if ((x < 21) && (y < 21) && (x >= 0) && (y >= 0)) {
			startX = x;
			startY = y;
		}
	}
	@Override
	public void setEndPoints(int x, int y) {
		if ((x < 21) && (y < 21) && (x >= 0) && (y >= 0)) {
			endX = x;
			endY = y;
		}
	}

	@Override
	public int getStartXPoints() {
		return startX;
	}

	@Override
	public int getStartYPoints() {
		return startY;
	}
	
	@Override
	public int getEndXPoints() {
		return endX;
	}

	@Override
	public int getEndYPoints() {
		return endY;
	}
}
