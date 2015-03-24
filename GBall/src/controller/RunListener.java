package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import physics.Circle;
import view.BuildGui;
import view.RunGui;
import view.GetInput;
import model.Model;
import model.SquareBumper;

public class RunListener implements ActionListener {

	private Timer timer;
	private Model model;
	GBallGui bg;
	private GetInput gi;
<<<<<<< HEAD
	private JFrame frame;

=======
	private AddSquareBumperListener sb;
	private AddTriangleBumperListener tb;
	private AddCircleBumperListener cb;
	private AddAbsorberListener a;
	private AddLeftFlipperListener lf;
	private AddRightFlipperListener rf;
	private RemoveGizmoListener rg;
	private RemoveGizmoListener sq;
	private JFrame frame;

	
>>>>>>> origin/master
	public RunListener(Model m, JFrame frame) {
		model = m;
		timer = new Timer(50, this);
		gi = new GetInput();
<<<<<<< HEAD
=======
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
				String in = gi.showPopup(
						"Please enter the path to the correct level to load",
						model);
				model.startLoad(in);
				model.hasChanged();
				break;
			case "Save":
				String out = gi.showPopup(
						"Please enter the path to save the level to", model);
				model.startSave(out);
				model.hasChanged();
				break;
			case "Switch Mode":
<<<<<<< HEAD
				frame.setVisible(false);
				frame.dispose();
				bg = new BuildGui(model = new Model());
				bg.createAndShowGUI();
=======
				BuildGui bg = new BuildGui(model);
		        bg.createAndShowGUI();
		        frame.setVisible(false);
>>>>>>> origin/master
				break;
			case "Quit":
				System.exit(0);
				break;
			}
		}
	}
}
