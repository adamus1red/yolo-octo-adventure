package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;

public class RotateGizmoListener implements MouseListener {
	
	private Model model;
	
	public RotateGizmoListener(Model m) {
		this.model = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int x = e.getX()-25;
		int y = e.getY()-25;
		System.out.println("OMG IT WORKED!!!!!" + x + ' ' + y);
		model.rotateGizmo(x, y);
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

}