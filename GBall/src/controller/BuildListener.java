package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.frame = frame;
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

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
	}
}
