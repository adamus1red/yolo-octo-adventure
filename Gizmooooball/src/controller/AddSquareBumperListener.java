package controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import physics.LineSegment;
import view.GBallGui;
import model.IGizmo;
import model.Model;
import model.SquareBumper;

public class AddSquareBumperListener implements MouseInputListener {

	private Model m;
	private GBallGui view;

	public AddSquareBumperListener(Model m, GBallGui v) {
		this.m = m;
		this.view = v;
	}

	public AddSquareBumperListener(Model m) {
		this.m = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int x = (int) (e.getX() -130);
		int y = (int) (e.getY());

		IGizmo square = new SquareBumper(x, y, Integer.toString(x + y), m);
		m.addGizmo(square);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}