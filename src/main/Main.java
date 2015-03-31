package main;

import javax.swing.UIManager;

import model.Model;
import view.BuildGui;
import view.RunGui;

public class Main {

	public static void main(String[] args) {
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model model = new Model();
		model.startLoad("LevelMurray.txt");
		
		// originally set at (200, 200)
		model.setBallSpeed(200, 200);

		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
