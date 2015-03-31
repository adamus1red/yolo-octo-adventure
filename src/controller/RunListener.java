package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import view.BuildGui;
import view.GBallGui;
import view.GetInput;
import model.Ball;
import model.Model;

public class RunListener implements ActionListener {

	private Timer timer;
	private Model model;
	GBallGui bg;
	private GetInput gi;
	private JFrame frame;

	public RunListener(Model m, JFrame frame) {
		model = m;
		timer = new Timer(50, this);
		gi = new GetInput();
		this.frame = frame;
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
			case "Stop":
				timer.stop();
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
				bg = new BuildGui(model = new Model());
				model.setBallSpeed(200, 200);
				bg.createAndShowGUI();
				break;
			case "Quit":
				System.exit(0);
				break;
			}
		}
	}
}
