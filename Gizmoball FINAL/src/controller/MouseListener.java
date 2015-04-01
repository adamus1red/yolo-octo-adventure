package controller;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class MouseListener implements MouseInputListener {

	private MouseInputListener ml;
	
	public MouseListener(MouseInputListener ml) {
		this.ml = ml;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ml.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ml.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ml.mouseReleased(e);
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
