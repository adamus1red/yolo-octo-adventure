package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.event.MouseInputListener;
import javax.xml.bind.Marshaller.Listener;

import physics.Circle;
import view.BuildGui;
import view.GBallGui;
import view.GetInput;
import view.RunGui;
import model.CircleBumper;
import model.IGizmo;
import model.Model;
import model.SquareBumper;

public class BuildListener implements ActionListener, MouseInputListener{

	private Model model;
	private GetInput gi;
	private GBallGui runGui;
	private JFrame frame;
	private MouseInputListener mouseListener;

	public BuildListener(Model m, JFrame frame) {
		model = m;
		gi = new GetInput();
=======

import javax.swing.JFrame;
import javax.swing.Timer;

import view.BuildGui;
import view.GetInput;
import view.RunGui;
import model.Model;
import model.SquareBumper;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class BuildListener implements ActionListener {


	private Model model;
	private GetInput gi;
	private AddSquareBumperListener sb;
	private AddTriangleBumperListener tb;
	private AddCircleBumperListener cb;
	private AddAbsorberListener a;
	private AddLeftFlipperListener lf;
	private AddRightFlipperListener rf;
	private RemoveGizmoListener rg;
	private RemoveGizmoListener sq;
	private JFrame frame;

	
	public BuildListener(Model m, JFrame frame) {
		model = m;
		gi = new GetInput();
		sb = new AddSquareBumperListener(m);
		tb = new AddTriangleBumperListener(m);
		cb = new AddCircleBumperListener(m);
		a = new AddAbsorberListener(m);
		lf = new AddLeftFlipperListener(m);
		rf = new AddRightFlipperListener(m);
		//rg = new RemoveGizmoListener(m);
		//sq = new RemoveGizmoListener(m);
>>>>>>> origin/master
		this.frame = frame;
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

<<<<<<< HEAD
		switch (e.getActionCommand()) {
		case "addGizmo":
			frame.getContentPane().addMouseListener(new AddCircleBumperListener(model));
			break;
		case "removeGizmo":
			break;
		case "addBall":
			break;
		case "Switch Mode":
			frame.setVisible(false);
			frame.dispose();
			runGui = new RunGui(model = new Model());
			model.setBallSpeed(200, 200);
			model.startLoad("Level1.txt");
			runGui.createAndShowGUI();
			break;

		case "Quit":
			System.exit(0);
			break;
		}

	}
	public void setMouseListener(MouseInputListener ml){
		mouseListener = ml;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseListener.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseListener.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseListener.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseListener.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseListener.mouseExited(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseListener.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseListener.mouseMoved(e);
=======
			switch (e.getActionCommand()) {
			case "addGizmo":
				sb.addGizmo();
				tb.addGizmo();
				cb.addGizmo();
				a.addGizmo();
				lf.addGizmo();
				rf.addGizmo();
				break;
			case "removeGizmo":
				//rg.removeGizmo(new SquareBumper(250, 250, "test1", model));
				//sq.removeGizmo(new SquareBumper(250, 250, "test1", model));
				break;
			case "addBall":
				break;
			case "Switch Mode":
			   RunGui gui = new RunGui(model);
		        gui.createAndShowGUI();
		        frame.setVisible(false);
		        break;
			
			case "Quit":
				System.exit(0);
				break;
			
		}
>>>>>>> origin/master
	}
}
