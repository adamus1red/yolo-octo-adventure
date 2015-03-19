package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Model;

public class BuildBoard extends JPanel implements IBoard, Observer {

	private static final long serialVersionUID = 8200776054429574704L;
	protected int width;
	protected int height;
	protected Model buildModel;

	public BuildBoard(int w, int h, Model m) {
		// Observe changes in Model
		m.addObserver(this);
		height = h;
		buildModel = m;
		this.setBorder(BorderFactory.createLineBorder(Color.PINK));
		this.setBackground(Color.BLACK);
	}

	@Override
	public Dimension getPrefferedSize() {
		return new Dimension(width, height);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
