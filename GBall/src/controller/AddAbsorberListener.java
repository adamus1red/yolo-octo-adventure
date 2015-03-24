<<<<<<< HEAD
package controller;

import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.event.MouseInputListener;

import view.GBallGui;
import model.Model;

public class AddAbsorberListener implements MouseInputListener {

	private Model model;
	private GBallGui view;

	public AddAbsorberListener(Model m, GBallGui v) {
		model = m;
		view = v;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
=======
package controller;

import java.util.ArrayList;

import model.Absorber;
import model.IGizmo;
import model.Model;
import model.CircleBumper;

public class AddAbsorberListener {

	private ArrayList<IGizmo> absorber;
	private Model model;
	private Absorber a;
	
	
	public AddAbsorberListener(Model m) {
		absorber = new ArrayList<IGizmo>();
		model = m;
	}
	
	public void addGizmo(){
		model.addGizmo(a = new Absorber(0, 450, 500, 50, "test1", model));
	}
	
	
}
>>>>>>> origin/master
