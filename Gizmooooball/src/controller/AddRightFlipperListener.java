package controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import physics.Circle;
import view.GBallGui;
import model.CircleBumper;
import model.Flipper;
import model.IGizmo;
import model.Model;

public class AddRightFlipperListener implements MouseInputListener {

	private Model m;
	private GBallGui view;

	public AddRightFlipperListener(Model m, GBallGui v) {
		this.m = m;
		this.view = v;
	}

	public AddRightFlipperListener(Model m) {
		this.m = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int x = (int) (e.getX() - 105);
		int y = (int) (e.getY());

		IGizmo rightFlipper = new Flipper(x, y, Integer.toString(x + y), m);
		m.addGizmo(rightFlipper);
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
