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

public class RunBoard extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	protected int width;
	protected int height;
	protected Model gm;

	public RunBoard(int w, int h, Model m) {
		// Observe changes in Model
		m.addObserver(this);
		width = w;
		height = h;
		gm = m;
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setBackground(Color.BLACK);
	}

	// Fix onscreen size
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// draw created gizmos to the screen
		for (IGizmo gz : gm.getGizmos()) {
			g2.setColor(gz.getColor());
			g2.fillRect(gz.getXPos(), gz.getYPos(), gz.getWidth(), gz.getHeight());
			g2.fillOval(gz.getXPos() - gz.getRadius() / 2, gz.getYPos()  - gz.getRadius() / 2, gz.getRadius(), gz.getRadius());
		}

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
