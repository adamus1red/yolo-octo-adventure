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
	private RotateGizmoListener rotate;

	public BuildListener(Model m, JFrame frame, BuildBoard b) {
		model = m;
		this.b = b;
		this.frame = frame;
		gi = new GetInput();
		this.timer = new Timer(50, this);
		agl = new AddGizmoListener(model);
		rgl = new RemoveGizmoListener(model);
		rotate = new RotateGizmoListener(model);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {
		if (e.getSource() == timer) {
			for (int i=0; i<model.getBalls().size();i++){
				Ball ball = model.getBalls().get(i);
					model.moveBalls(ball);
				}
		} else {
			String tmp = e.getActionCommand();
			if (tmp == "Start") {
				timer.start();
			} else if (tmp == "Remove Gizmo") {
				removeListeners();
				b.addMouseListener(rgl);
			}else if (tmp == "Load") {
				String in = gi.showOpenPopup(
						"Please enter the path to the correct level to load",
						model);
				model.startLoad(in);
				model.hasChanged();
			}else if (tmp == "Save") {
				String out = gi.showSavePopup(
						"Please enter the path to save the level to", model);
				model.startSave(out);
				model.hasChanged();
			} else if (tmp == "Switch Mode") {
				timer.stop();
				frame.setVisible(false);
				frame.dispose();
				runGui = new RunGui(model = new Model());
				model.setBallSpeed(200, 200);
				model.startLoad("LevelMurray.txt");
				runGui.createAndShowGUI();
			}else if (tmp == "Clear Board"){
				model.clearBoard();
			}else if (tmp == "Quit"){
				System.exit(0);
			}else if (tmp == "Rotate Gizmo"){
				System.err.println("FUCKING WORK");
				removeListeners();
				b.addMouseListener(rotate);
				System.err.println("Something fucking worked");
			}else if (tmp.matches("^add(Ball|Absorber|(Left|Right)Flipper|Circle|Square|Triangle)")) {
				removeListeners();
				agl.setType(e.getActionCommand());
				b.addMouseListener(agl);
			}
		}
	}
	private void removeListeners() {
		b.removeMouseListener(rgl);
		b.removeMouseListener(rotate);
		b.removeMouseListener(agl);
	}
}
