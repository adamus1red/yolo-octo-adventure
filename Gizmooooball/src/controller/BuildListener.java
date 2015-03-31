package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class BuildListener implements ActionListener {

	private Model model;
	private GBallGui runGui;
	private JFrame frame;
	private AddGizmoListener agl;
	private RemoveGizmoListener rgl;
	private RotateGizmoListener rotate;
	private Timer timer;
	private BuildBoard b;

	public BuildListener(Model m, JFrame frame, BuildBoard b) {
		model = m;
		this.b = b;
		this.frame = frame;
		this.timer = new Timer(50, this);
		agl = new AddGizmoListener(m);
		rgl = new RemoveGizmoListener(m);
		rotate = new RotateGizmoListener(m);
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
			case "Remove Gizmo":
				b.removeMouseListener(rotate);
				b.removeMouseListener(agl);
				b.addMouseListener(rgl);
				break;
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
				break;
			}

		}
	}
}
