package main;

import javax.swing.UIManager;

import model.Absorber;
import model.Flipper;
import model.Model;
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

		// 1L = 25
		
		// originally set at (200, 200)
		model.setBallSpeed(175, 175);
		
		// add absorder
		model.addGizmo(new Absorber(0, 475, 500, model));
		model.addGizmo(new Absorber(100, 100, 300, model));
		
		// add flipper
		model.addGizmo(new Flipper(100, 300, 15, model));
		model.addGizmo(new Flipper(300, 300, 15, model));

		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}