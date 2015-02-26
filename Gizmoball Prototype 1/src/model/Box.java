package model;

import physics.LineSegment;

public class Box {

	private int xpos;
	private int ypos;
	private int width;
	private int height;
	private VerticalLine leftLine;
	private VerticalLine rightLine;
	private VerticalLine topLine;
	private VerticalLine bottomLine;
	
	
	public Box(int x, int y, int w, int h) {
			xpos = x;
			ypos = y;
			width = w;
			height = h;
			leftLine = new VerticalLine(x,y,1,h);
			rightLine = new VerticalLine(x+w-1,y,1,h);
			topLine = new VerticalLine(x,y,w,1);
			bottomLine = new VerticalLine(x,y+h-1,w,1);
			
		}

		

		public int getX() {
			return xpos;
		}

		public int getY() {
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
		
}
	
	

