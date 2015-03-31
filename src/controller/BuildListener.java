package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD

import javax.swing.JFrame;
import javax.swing.Timer;

import view.BuildBoard;
import view.GBallGui;
import view.GetInput;
import view.RunGui;
import model.Ball;
import model.Model;
=======
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.event.MouseInputListener;
import javax.xml.bind.Marshaller.Listener;

import physics.Circle;
import view.BuildBoard;
import view.BuildGui;
import view.GBallGui;
import view.GetInput;
import view.RunGui;
import model.CircleBumper;
import model.Gizmo;
import model.IGizmo;
import model.Model;
import model.SquareBumper;
>>>>>>> origin/master

public class BuildListener implements ActionListener {

	private Model model;
	private GBallGui runGui;
	private JFrame frame;
	private AddGizmoListener agl;
	private RemoveGizmoListener rgl;
<<<<<<< HEAD
	private Timer timer;
	private GetInput gi;
=======
	private RotateGizmoListener rotate;
	private Timer timer;
>>>>>>> origin/master
	private BuildBoard b;

	public BuildListener(Model m, JFrame frame, BuildBoard b) {
		model = m;
		this.b = b;
		this.frame = frame;
<<<<<<< HEAD
		gi = new GetInput();
		this.timer = new Timer(50, this);
		agl = new AddGizmoListener(model);
		rgl = new RemoveGizmoListener(model);
=======
		this.timer = new Timer(50, this);
		agl = new AddGizmoListener(m);
		rgl = new RemoveGizmoListener(m);
		rotate = new RotateGizmoListener(m);
>>>>>>> origin/master
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {
		if (e.getSource() == timer) {
<<<<<<< HEAD
			for (int i=0; i<model.getBalls().size();i++){
				Ball ball = model.getBalls().get(i);
					model.moveBalls(ball);
				}
=======
			model.moveBall();
>>>>>>> origin/master
		} else {

			switch (e.getActionCommand()) {
			case "Start":
				timer.start();
				break;
			case "Remove Gizmo":
<<<<<<< HEAD
				b.removeMouseListener(agl);
				b.addMouseListener(rgl);
				break;
			case "Load":
				String in = gi.showOpenPopup(
						"Please enter the path to the correct level to load",
						model);
				model.startLoad(in);
				model.hasChanged();
				break;
			case "Save":
				String out = gi.showSavePopup(
						"Please enter the path to save the level to", model);
				model.startSave(out);
				model.hasChanged();
				break;
=======
				b.removeMouseListener(rotate);
				b.removeMouseListener(agl);
				b.addMouseListener(rgl);
				break;
>>>>>>> origin/master
			case "Switch Mode":
				timer.stop();
				frame.setVisible(false);
				frame.dispose();
				runGui = new RunGui(model = new Model());
				model.setBallSpeed(200, 200);
				model.startLoad("LevelMurray.txt");
				runGui.createAndShowGUI();
				break;
			case "Clear Board":
				model.clearBoard();
				break;
			case "Quit":
				System.exit(0);
				break;
<<<<<<< HEAD
			default :
				b.removeMouseListener(rgl);
				agl.setType(e.getActionCommand());
				b.addMouseListener(agl);
=======
			case "Rotate Gizmo":
				System.err.println("FUCKING WORK");
				b.removeMouseListener(agl);
				b.removeMouseListener(rgl);
				b.addMouseListener(rotate);
				System.err.println("Something fucking worked");
			default:
				b.removeMouseListener(rgl);
				b.removeMouseListener(rotate);
				b.addMouseListener(agl);
				agl.setType(e.getActionCommand());
>>>>>>> origin/master
				break;
			}

		}
	}
}
