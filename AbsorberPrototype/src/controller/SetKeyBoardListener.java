package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.Model;

public class SetKeyBoardListener implements KeyListener {
	
	private Model m;
	
	public SetKeyBoardListener(Model m){
		this.m = m;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE){
			m.moveBall();
		}else if (key == KeyEvent.VK_R){
//			AffineTransform af = new 
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
