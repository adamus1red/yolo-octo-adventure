package model;

import java.awt.Color;

public interface IGizmo {

	Color getColor();

	void setName(String s);

	void setType(String s);

	void setStartPoints(int x, int y);

	void setEndPoints(int x, int y);

	int getStartXPoints();

	int getStartYPoints();

	int getEndXPoints();

	int getEndYPoints();
}
