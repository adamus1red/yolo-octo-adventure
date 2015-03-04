package model;

import java.awt.Color;

import physics.Circle;
import physics.LineSegment;

public class TriangleBumper implements IGizmo {

	private final String name = "triangle";
	private int xpos;
	private int ypos;
	private final int heightWidth = 24;
	private Color color;
	private final int radius = 0; // 10 for testing change to 0 when not
	private VerticalLine leftLine;
	private VerticalLine rightLine;
	private VerticalLine topLine;
	private VerticalLine bottomLine;
	private VerticalLine diagonalLine;
	
	
	public TriangleBumper(int x, int y, Model m) {
			xpos = x;
			ypos = y;
			this.color = Color.green;
//			leftLine = new VerticalLine(x,y,1,heightWidth);
//			diagonalLine = new VerticalLine(x,y,w-h,1);
//			rightLine = new VerticalLine(x+w-1,y,1,h);
////			topLine = new VerticalLine(x,y,w,1);
//			bottomLine = new VerticalLine(x,y+h-1,w,1);
			
			// vertical lines 
			m.addLine(new VerticalLine(x,y - heightWidth,1,heightWidth));
//			int yPoints[] = {102, 102, 78};
//			int xPoints[] = {102, 126, 102};
			
			// horizontal lines 
			m.addLine(new VerticalLine(x, y, heightWidth, 1));
			
			//diagonal lines
//			g2.drawLine(129, 102, 105 , 78);
			m.addLine(new VerticalLine(x, y, 0, 1));
			
			// for ends of the lines
			m.addCircles(new Circle(x, y, radius));
			m.addCircles(new Circle(x, y - heightWidth, radius));
			m.addCircles(new Circle(x + heightWidth, y, radius));
		}
			
		

		

		public int getXPos() {
			return xpos;
		}

		public int getYPos() {
			return ypos;
		}

		public int getWidth() {
			return heightWidth;
		}

		
		public int getHeight() {
			return 0;
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





		@Override
		public String getName() {
			return name;
		}
		
}
	