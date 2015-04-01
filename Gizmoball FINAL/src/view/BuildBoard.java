package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
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
			switch (gz.getType()) {
			case "Square":
				g2.setColor(gz.getColor());
				g2.fillRect(gz.getXPos(), gz.getYPos(), gz.getWidth(),
						gz.getHeight());
				break;
			case "Absorber":
				g2.setColor(gz.getColor());
				g2.fillRect(gz.getXPos(), gz.getYPos(), gz.getWidth(),
						gz.getHeight());
				break;
			case "Circle":
				g2.setColor(gz.getColor());
				g2.fillOval(gz.getXPos() - gz.getRadius(),
						gz.getYPos() - gz.getRadius(), gz.getRadius() * 2,
						gz.getRadius() * 2);
				break;
			case "Triangle":
				g2.setColor(gz.getColor());
				// works with collisions however very buggy and rotates 2/4 successfully
				int[] xPoints = { (int) gz.getLines().get(0).p1().x(), (int) gz.getLines().get(1).p1().x(),
						(int) gz.getLines().get(2).p1().x() + gz.getWidth() };
				int[] yPoints = { (int) gz.getLines().get(0).p2().y()-25, (int) gz.getLines().get(1).p2().y()-25 + gz.getHeight(),
						(int) gz.getLines().get(2).p2().y()-25 + gz.getHeight() };
				
				//works with collisions but doesn't rotate for draw
//				int[] xPoints = { (int) gz.getLines().get(0).p1().x(), (int) gz.getLines().get(1).p1().x(),
//						(int) gz.getLines().get(2).p1().x() + gz.getWidth() };
//				int[] yPoints = { (int) gz.getLines().get(0).p2().y(), (int) gz.getLines().get(1).p2().y() + gz.getHeight(),
//						(int) gz.getLines().get(2).p2().y() + gz.getHeight() };
				g2.fillPolygon(xPoints, yPoints, 3);
				break;
				//works with collisions but doesn't rotate for draw
				

			case "Flipper":
				g2.setColor(gz.getColor());
				g2.fillRoundRect(gz.getXPos(),
						gz.getYPos() - (gz.getWidth() / 2), gz.getWidth(),
						gz.getHeight() + gz.getWidth(), gz.getWidth(),
						gz.getWidth());
				break;
			}
		}

		for (int i = 0; i < buildModel.getBalls().size(); i++) {

			Ball b = buildModel.getBalls().get(i);
			if (b != null) {
				g2.setColor(b.getColour());
				int x = (int) (b.getExactX() - b.getRadius());
				int y = (int) (b.getExactY() - b.getRadius());
				int width = (int) (2 * b.getRadius());
				g2.fillOval(x, y, width, width);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();

	}
}
