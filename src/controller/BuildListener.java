package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import view.BuildBoard;
import view.GBallGui;
import view.GetInput;
import view.RunGui;
import model.Ball;
import model.Model;

public class BuildListener implements ActionListener {

	private Model model;
	private GBallGui runGui;
	private JFrame frame;
	private AddGizmoListener agl;
	private RemoveGizmoListener rgl;
	private Timer timer;
	private GetInput gi;
	private BuildBoard b;

	public BuildListener(Model m, JFrame frame, BuildBoard b) {
		model = m;
		this.b = b;
		this.frame = frame;
		gi = new GetInput();
		this.timer = new Timer(50, this);
		agl = new AddGizmoListener(model);
		rgl = new RemoveGizmoListener(model);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {
		if (e.getSource() == timer) {
			for (int i=0; i<model.getBalls().size();i++){
				Ball ball = model.getBalls().get(i);
					model.moveBalls(ball);
				}
		} else {

			switch (e.getActionCommand()) {
			case "Start":
				timer.start();
				break;
			case "Remove Gizmo":
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
			default :
				b.removeMouseListener(rgl);
				agl.setType(e.getActionCommand());
				b.addMouseListener(agl);
				break;
			}

		}
	}
}
