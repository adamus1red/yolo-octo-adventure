package model;

import java.awt.Color;

import physics.Circle;

public class TriangleBumper extends Gizmo implements IGizmo {

	private int width;
	private int height;
	private Color color;
	private final int radius = 0; // 10 for testing change to 0 when not
	private VerticalLine leftLine;
	private VerticalLine rightLine;
	private VerticalLine topLine;
	private VerticalLine bottomLine;
	private VerticalLine diagonalLine;

	public TriangleBumper(int x, int y, String n, Model m) {
		super(x ,y);
		width = 25;
		height = 25;
		super.setName(n);
		super.setType("Triangle");
		this.color = Color.PINK;
		leftLine = new VerticalLine(x, y, 1, height);
		diagonalLine = new VerticalLine(x, y, width - height, 1);
		rightLine = new VerticalLine(x + width - 1, y, 1, height);
		topLine = new VerticalLine(x, y, width, 1);
		bottomLine = new VerticalLine(x, y + height - 1, width, 1);

		// vertical lines
		m.addLine(new VerticalLine(x, y, 1, height));
		// m.addLine(new VerticalLine(x+w-1,y,1,h));

		// horizontal lines
		// m.addLine(new VerticalLine(x, y, w, 1));
		m.addLine(new VerticalLine(x, y + height - 1, width, 1));

		// diagonal lines
		m.addLine(new VerticalLine(x, y, width, 1));

		// for ends of the lines
		m.addCircles(new Circle(x, y, radius));
		// m.addCircles(new Circle(x, y + h, radius));
		m.addCircles(new Circle(x + width, y, radius));
		m.addCircles(new Circle(x + width, y + height, radius));
	}
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public VerticalLine getLeftLine() {
		return leftLine;
	}

	public VerticalLine getRightLine() {
		return rightLine;
	}

	public VerticalLine getTopLine() {
		return topLine;
	}

	public VerticalLine getBottomLine() {
		return bottomLine;
	}

	@Override
	public Color getColor() {
		return color;
	}

	public VerticalLine getDiagonalLine() {
		return diagonalLine;
	}

}
