package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;

public class RemoveGizmoListener implements MouseListener {
	
	private Model model;
	
	public RemoveGizmoListener(Model m) {
		this.model = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		
		model.removeGizmo(x, y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
