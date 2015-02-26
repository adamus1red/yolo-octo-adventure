package main;

import model.Box;
import javax.swing.UIManager;



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
		Box box = new Box(100,100,100,100);
		
		model.setBallSpeed(300, 200);

		// Vertical line at (100,100), width 300
		model.addLine(new VerticalLine(00, 00, 00, 00));
		
		model.addLine(box.getBottomLine());
		model.addLine(box.getTopLine());
		model.addLine(box.getRightLine());
		model.addLine(box.getLeftLine());
		model.addBox(100,100,100,100);
		
		
		

		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
