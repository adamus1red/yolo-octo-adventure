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

import model.Ball;
import model.IGizmo;
import model.Model;
import model.VerticalLine;

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
	}

	// Fix onscreen size
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		// good flipper dimensions just adjust for dimesions for smaller ie 100 or 85 == 25 for last three
//		g2.setColor(Color.BLUE);
//		g2.fillRoundRect(60, 60, 85, 25, 25, 25);
//		g2.fillRoundRect(100, 100, 85, 25, 25, 25);
//		g2.fillOval(100, 100, 25, 25);
//		g2.fillRoundRect(60, 60, 50, 12, 12, 12);

		// add absorber here
		
//		ArrayList<IGizmo> giz = gm.getGizmos();
//		for (int i = 0; i < giz.size(); i++) {
//			g2.setColor(giz.get(i).getColor());
//			g2.fillRect(giz.get(i).getXPos(), giz.get(i).getYPos(), giz.get(i).getWidth(), 1);
//		}
		for (IGizmo gz : gm.getGizmos()) {
			g2.setColor(gz.getColor());
			g2.fillRect(gz.getXPos(), gz.getYPos(), gz.getWidth(), gz.getHeight());
		}
		
//		for (VerticalLine vl : gm.getLines()) {
//			g2.fillRect(vl.getX(), vl.getY(), vl.getWidth(), vl.getHeight());
//		}
//		

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
