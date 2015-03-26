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
	private GetInput gi;
	private GBallGui runGui;
	private JFrame frame;
	private IGizmo gz;
	private AddGizmoListener agl;

	public BuildListener(Model m, JFrame frame) {
		model = m;
		gz = new Gizmo();
		gi = new GetInput();
		this.frame = frame;
		agl = new AddGizmoListener(model);
		frame.getContentPane().addMouseListener(agl);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {
		
		agl.setType(e.getActionCommand());

		switch (e.getActionCommand()) {
		case "Switch Mode":
			frame.setVisible(false);
			frame.dispose();
			runGui = new RunGui(model = new Model());
			model.setBallSpeed(200, 200);
			model.startLoad("LevelMurray.txt");
			runGui.createAndShowGUI();
			break;

		case "Quit":
			System.exit(0);
			break;
		}

	}
}
