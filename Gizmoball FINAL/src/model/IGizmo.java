package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;

public interface IGizmo {

	String type = null;
	
	String getType();

	int getXPos();

	int getYPos();

	int getWidth();

	int getHeight();

	int getRotation();

	String getName();

	void setName(String s);

	void setType(String s);

	void setXPos(int x);
	
	void setYPos(int y);

	void setRotation(int r);

	Color getColor();
	
	void setColor();

	int getRadius();
	
	ArrayList<LineSegment> getLines();
	
	ArrayList<Circle> getCircles();
}
