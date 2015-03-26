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

public class BuildBoard extends JPanel implements Observer {

	private static final long serialVersionUID = 8200776054429574704L;
	protected int width;
	protected int height;
	protected Model buildModel;

	public BuildBoard(int w, int h, Model m) {
		// Observe changes in Model
		m.addObserver(this);
		height = h;
		width = w;
		buildModel = m;
		this.setBorder(BorderFactory.createLineBorder(Color.PINK));
		this.setBackground(Color.WHITE);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		int h = height / 20;
		int w = width / 20;

		for (int i = 0; i < height; i++) {
			g2.setColor(Color.BLACK);
			g2.drawLine(i * w, 0, i * w, height);
		}
		for (int i = 0; i < width; i++) {
			g2.setColor(Color.BLACK);
			g2.drawLine(0, i * h, width, i * h);
		}

		for (IGizmo gz : buildModel.getGizmos()) {
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
				ArrayList<Circle> gc = buildModel.getFlipperCircles();
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
		
		Ball b = buildModel.getBall();
		if (b != null) {
			g2.setColor(b.getColour());
			int x = (int) (b.getExactX() - b.getRadius());
			int y = (int) (b.getExactY() - b.getRadius());
			int width = (int) (2 * b.getRadius());
			g2.fillOval(x, y, width, width);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();

	}
}
