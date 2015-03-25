package controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import physics.Circle;
import view.GBallGui;
import model.Absorber;
import model.CircleBumper;
import model.Flipper;
import model.IGizmo;
import model.Model;

public class AddAbsorberListener implements MouseInputListener {

	private Model m;
	private GBallGui view;

	public AddAbsorberListener(Model m, GBallGui v) {
		this.m = m;
		this.view = v;
	}

	public AddAbsorberListener(Model m) {
		this.m = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int x = (int) (e.getX() - 105);
		int y = (int) (e.getY());

		IGizmo absorber = new Absorber(x, y, 40, 500, Integer.toString(x + y), m);
		m.addGizmo(absorber);
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
