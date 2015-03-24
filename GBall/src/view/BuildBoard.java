package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import physics.Circle;
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
		this.setBackground(Color.black);
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
			g2.setColor(Color.WHITE);
			g2.drawLine(i * w, 0, i * w, height);
		}
		for (int i = 0; i < width; i++) {
			g2.setColor(Color.WHITE);
			g2.drawLine(0, i * h, width, i * h);
		}

		for (IGizmo gz : buildModel.getGizmos()) {
			if (gz.getType().equals("Circle")) {
				g2.setColor(gz.getColor());
				ArrayList<Circle> gc = buildModel.getCircles();
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
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();

	}
}
