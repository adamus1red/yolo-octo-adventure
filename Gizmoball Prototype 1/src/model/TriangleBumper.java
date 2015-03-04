package model;

import java.awt.Color;

import physics.Circle;

public class TriangleBumper implements IGizmo {

	private int xpos;
	private int ypos;
	private int width;
	private int height;
	private Color color;
	private final int radius = 0; // 10 for testing change to 0 when not
	private String type;
	


	public TriangleBumper(int x, int y, int w, int h, Model m) {
		type = "Triangle";
		xpos = x;
		ypos = y;
		width = w;
		height = h;
		this.color = Color.RED;


		// left lines 
		m.addLine(new VerticalLine(x,y,1,h));


		// bottom lines 
		m.addLine(new VerticalLine(x,y+h,w,1));

//		diagonal lines
		m.addLine(new VerticalLine(x,y,w,h-1));

		// for ends of the lines
		m.addCircles(new Circle(x, y, radius));      // top left circle of triangle
		m.addCircles(new Circle(x, y+h, radius));  // bottom left circle of triangle
		m.addCircles(new Circle(x + w, y + h, radius)); //bottom right circle of triangle
	}

	public int getXPos() {
		return xpos;
	}

	public int getYPos(){
		return ypos;
	}
	
	public int getXPos2(){
		return xpos;
	}

	public int getYPos2() {
		return ypos+height;
	}

	public int getXPos3() {
		return xpos+width;
	}

	public int getYPos3() {
		return ypos+height;
	}

	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}

	public Color getColor() {
		return color;
	}

	public int getRadius() {
		return radius;
	}





	@Override
	public String getType() {
		return type;
	}


}
