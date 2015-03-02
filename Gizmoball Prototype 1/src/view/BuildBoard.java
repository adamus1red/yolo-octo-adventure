package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Model;

public class BuildBoard extends JPanel implements IBoard, Observer {

	private static final long serialVersionUID = 1L;
	protected int width;
	protected int height;
	protected Model bbm;

	public BuildBoard(int w, int h, Model m) {
		m.addObserver(this);
		this.width = w;
		this.height = h;
		this.bbm = m;
	}
	
	@Override
	public Dimension getPrefferedSize() {
		return null;
	}

	@Override
	public void paintComponent(Graphics g) {

	}

	@Override
	public void update(Observable o, Object arg) {

	}
}
