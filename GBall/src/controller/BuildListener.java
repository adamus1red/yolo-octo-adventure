package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		this.frame = frame;
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

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
	}
}
