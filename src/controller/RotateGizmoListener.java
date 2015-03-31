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
		
		int x = e.getX();
		int y = e.getY();
		System.out.println("OMG IT WORKED!!!!!" + x + ' ' + y);
		model.rotateGizmo(x, y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("OMG IT WORKED!!!!!" + x + ' ' + y);
		model.rotateGizmo(x, y);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("OMG IT WORKED!!!!!" + x + ' ' + y);
		model.rotateGizmo(x, y);
		
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
