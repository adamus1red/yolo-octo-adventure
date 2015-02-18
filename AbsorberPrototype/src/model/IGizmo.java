package model;

import java.awt.Color;

public interface IGizmo {

	Color getColor();

	void setEndPoints();

	void setWidth(int w);

	void seXPos(int x);

	void setYPos(int y);

	void setHeight(int h);

	int getXPos();

	int getYPos();

	int getWidth();

	int getHeight();

}
