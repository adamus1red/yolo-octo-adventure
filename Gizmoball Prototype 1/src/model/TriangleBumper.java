package model;

import java.awt.Color;

import physics.Circle;
import physics.LineSegment;

public class TriangleBumper implements IGizmo {

	private int xpos;
	private int ypos;
	private int width;
	private int height;
	private Color color;
	private final int radius = 0; // 10 for testing change to 0 when not
	private VerticalLine leftLine;
	private VerticalLine rightLine;
	private VerticalLine topLine;
	private VerticalLine bottomLine;
	private VerticalLine diagonalLine;
	
	
	public TriangleBumper(int x, int y, int w, int h, Model m) {
			xpos = x;
			ypos = y;
			width = w;
			height = h;
			this.color = Color.PINK;
			leftLine = new VerticalLine(x,y,1,h);
			diagonalLine = new VerticalLine(x,y,w-h,1);
			rightLine = new VerticalLine(x+w-1,y,1,h);
			topLine = new VerticalLine(x,y,w,1);
			bottomLine = new VerticalLine(x,y+h-1,w,1);
			
			// vertical lines 
			m.addLine(new VerticalLine(x,y,1,h));
			//m.addLine(new VerticalLine(x+w-1,y,1,h));
			
			// horizontal lines 
			//m.addLine(new VerticalLine(x, y, w, 1));
			m.addLine(new VerticalLine(x, y + h -1, w, 1));
			
			//diagonal lines
			m.addLine(new VerticalLine(x, y, w, 1));
			
			// for ends of the lines
			m.addCircles(new Circle(x, y, radius));
			//m.addCircles(new Circle(x, y + h, radius));
			m.addCircles(new Circle(x + w, y, radius));
			m.addCircles(new Circle(x + w, y + h, radius));
		}
			
		

		

		public int getXPos() {
			return xpos;
		}

		public int getYPos() {
			return ypos;
		}

		public int getWidth() {
			return width;
		}

		
		public int getHeight() {
			return height;
	}
		
		public VerticalLine getLeftLine(){
			return leftLine;
		}
		
		public VerticalLine getRightLine(){
			return rightLine;
		}
		
		public VerticalLine getTopLine(){
			return topLine;
		}
		
		public VerticalLine getBottomLine(){
			return bottomLine;
		}



		@Override
		public Color getColor() {
			return color;
		}


		@Override
		public int getRadius() {
			return radius;
		}

		public VerticalLine getDiagonalLine() {
			return diagonalLine;
		}
		
}
	