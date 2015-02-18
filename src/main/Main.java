package main;

import javax.swing.UIManager;

import model.HorizontalLine;
import model.Model;
import model.VerticalLine;
import view.RunGui;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Main {

	public static void main(String[] args) {
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model model = new Model();

		model.setBallSpeed(300, 200);

		// Vertical line at (100,100), width 300
		model.addLine(new VerticalLine(00, 00, 00, 00));
		
		model.addLine(new VerticalLine(100,100,1, 300));
	//	model.addLine(new HorizontalLine(100,100,300,1));
		

		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
