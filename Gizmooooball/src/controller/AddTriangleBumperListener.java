package controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import view.GBallGui;
import model.IGizmo;
import model.Model;
import model.TriangleBumper;

public class AddTriangleBumperListener implements MouseInputListener {

	private Model m;
	private GBallGui view;

	public AddTriangleBumperListener(Model m, GBallGui v) {
		this.m = m;
		this.view = v;
	}

	public AddTriangleBumperListener(Model m) {
		this.m = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int x = (int) (e.getX() - 105);
		int y = (int) (e.getY() + 9);

		IGizmo triangle = new TriangleBumper(x, y, Integer.toString(x + y), m);
		m.addGizmo(triangle);
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