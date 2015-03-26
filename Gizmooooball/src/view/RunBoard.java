package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import physics.Circle;
import model.Ball;
import model.IGizmo;
import model.Model;

public class RunBoard extends JPanel implements Observer {

	private static final long serialVersionUID = 4546557205846642694L;
	protected int width;
	protected int height;
	protected Model gm;

	public RunBoard(int w, int h, Model m) {
		// Observe changes in Model
		m.addObserver(this);
		width = w;
		height = h;
		gm = m;
		this.setBorder(BorderFactory.createLineBorder(Color.PINK));
		this.setBackground(Color.BLACK);
	}

	// Fix onscreen size
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		for (IGizmo gz : gm.getGizmos()) {
			if (gz.getType().equals("Square")) {
				g2.setColor(gz.getColor());
				g2.fillRect(gz.getXPos(), gz.getYPos(), gz.getWidth(),
						gz.getHeight());
			} else if (gz.getType().equals("Absorber")) {
				g2.setColor(gz.getColor());
				g2.fillRect(gz.getXPos(), gz.getYPos(), gz.getWidth(),
						gz.getHeight());
			} else if (gz.getType().equals("Circle")) {
				g2.setColor(gz.getColor());
				g2.fillOval(gz.getXPos() - gz.getRadius(),
						gz.getYPos() - gz.getRadius(), gz.getRadius() * 2,
						gz.getRadius() * 2);
			} else if (gz.getType().equals("Triangle")) {
				g2.setColor(gz.getColor());
				int[] xPoints = { gz.getXPos(), gz.getXPos(),
						gz.getXPos() + gz.getWidth() };
				int[] yPoints = { gz.getYPos(), gz.getYPos() + gz.getHeight(),
						gz.getYPos() + gz.getHeight() };
				g2.fillPolygon(xPoints, yPoints, 3);
			} else if (gz.getType().toLowerCase().contains("flipper")) {
				g2.setColor(gz.getColor());
				g2.fillRect(gz.getXPos(), gz.getYPos(), gz.getWidth(),
						gz.getHeight());
				ArrayList<Circle> gc = gm.getFlipperCircles();
				for (int i = 0; i < gc.size(); i++) {
					g2.fillOval((int) (gc.get(i).getCenter().x() - gc.get(i)
							.getRadius()),
							(int) (gc.get(i).getCenter().y() - gc.get(i)
									.getRadius()),
							(int) (gc.get(i).getRadius() * 2), (int) (gc.get(i)
									.getRadius() * 2));
				}
			}
		}

		// Debug for showing all generated lines
		// for (LineSegment l : gm.getLines()) {
		// g2.drawLine((int) l.p1().x(), (int) l.p1().y(), (int) l.p2().x(),
		// (int) l.p2().y());
		// }

		Ball b = gm.getBall();
		if (b != null) {
			g2.setColor(b.getColour());
			int x = (int) (b.getExactX() - b.getRadius());
			int y = (int) (b.getExactY() - b.getRadius());
			int width = (int) (2 * b.getRadius());
			g2.fillOval(x, y, width, width);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

}
