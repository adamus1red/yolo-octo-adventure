package main;

import javax.swing.UIManager;

import physics.Angle;
import physics.Circle;
import physics.LineSegment;
import physics.Vect;
import model.Absorber;
import model.Model;
import model.VerticalLine;
import view.RunGui;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model model = new Model();

		// originally set at (200, 200)
		model.setBallSpeed(175, 175);
		model.addGizmo(new Absorber(0, 470, 500, model));
//		model.addLine(new VerticalLine(100, 370, 300));

		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
