package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import view.GetInput;
import model.Model;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunListener implements ActionListener {

	private Timer timer;
	private Model model;
	private GetInput gi;
	private AddSquareBumperListener sb;
	private AddTriangleBumperListener tb;
	private AddCircleBumperListener cb;
	private AddAbsorberListener a;
	private AddLeftFlipperListener lf;
	private AddRightFlipperListener rf;
	private RemoveGizmoListener rg;

	
	public RunListener(Model m) {
		model = m;
		timer = new Timer(50, this);
		gi = new GetInput();
		sb = new AddSquareBumperListener(m);
		tb = new AddTriangleBumperListener(m);
		cb = new AddCircleBumperListener(m);
		a = new AddAbsorberListener(m);
		lf = new AddLeftFlipperListener(m);
		rf = new AddRightFlipperListener(m);
		rg = new RemoveGizmoListener(m);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

		if (e.getSource() == timer) {
			model.moveBall();
		} else {
			switch (e.getActionCommand()) {
			case "Start":
				timer.start();
				break;
			case "Stop":
				timer.stop();
				break;
			case "Tick":
				model.moveBall();
				break;
			case "Load":
				String in = gi.showPopup("Please enter the path to the correct level to load", model);
				model.startLoad(in);
				model.hasChanged();
				break;
			case "Save":
				String out = gi.showPopup("Please enter the path to save the level to", model);
				model.startSave(out);
				model.hasChanged();
				break;
			case "Add eh Gizmos":
				sb.addGizmo();
				tb.addGizmo();
				cb.addGizmo();
				a.addGizmo();
				lf.addGizmo();
				rf.addGizmo();
				break;
			case "Remove Bastard Gizmos":
				rg.removeGizmo();
				
				break;
			case "Quit":
				System.exit(0);
				break;
			}
		}
	}
}
