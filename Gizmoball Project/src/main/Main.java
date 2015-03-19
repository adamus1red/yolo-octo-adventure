package main;

import javax.swing.UIManager;

import model.Absorber;
import model.CircleBumper;
import model.Flipper;
import model.Model;
import model.SquareBumper;
import model.TriangleBumper;
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
		model.startLoad("level1.txt");

		// 1L = 25
		
		// originally set at (200, 200)
		model.setBallSpeed(200, 200);
//		
//		// add square
//		model.addGizmo(new SquareBumper(100,100, "s1",model));
//		
//		//add triangle
//		model.addGizmo(new TriangleBumper(350, 350, "t1", model));
		
//		// add absorder
//		model.addGizmo(new Absorber(0, 475, 500, 25, "ab1", model));
//		model.addGizmo(new Absorber(100, 100, 300, model));
//		model.addGizmo(new Absorber(200, 150, 300, model));
//		
//		// add flipper
//		model.addGizmo(new Flipper(100, 300, "f1", model));
//		model.addGizmo(new Flipper(200, 300, "f2", model));
//		
//		// add circle bumper
//		model.addGizmo(new CircleBumper(260, 25, "c1",model));
//		model.addGizmo(new CircleBumper(250, 250, "c2",model));

		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
