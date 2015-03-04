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

		// 1L = 25
		
		// originally set at (200, 200)
		model.setBallSpeed(200, 200);
		
		// add square
		model.addGizmo(new SquareBumper(100,100,100,100,model));
		model.addGizmo(new SquareBumper(100,200,100,100,model));
		model.addGizmo(new SquareBumper(100,300,100,100,model));
		model.addGizmo(new SquareBumper(200,400,100,100,model));
		model.addGizmo(new SquareBumper(400,200,50,50,model));
		
		//add triangle
		model.addGizmo(new TriangleBumper(250, 200, 30, 30, model));
		model.addGizmo(new TriangleBumper(325, 325, 30, 30, model));
		model.addGizmo(new TriangleBumper(150, 420, 30, 30, model));
		model.addGizmo(new TriangleBumper(325, 125, 30, 30, model));
		model.addGizmo(new TriangleBumper(50, 75, 30, 30, model));
		model.addGizmo(new TriangleBumper(125, 40, 30, 30, model));
		
		
		
	
		// add absorder
		//model.addGizmo(new Absorber(0, 475, 500, model));
		//model.addGizmo(new Absorber(100, 100, 300, model));
		//model.addGizmo(new Absorber(200, 150, 300, model));
		
		// add flipper
		//model.addGizmo(new Flipper(100, 300, model));
		//model.addGizmo(new Flipper(200, 300, model));
		
		// add circle bumper
		model.addGizmo(new CircleBumper(260, 25, model));
		model.addGizmo(new CircleBumper(250, 250, model));
		model.addGizmo(new CircleBumper(370, 25, model));
		model.addGizmo(new CircleBumper(400, 250, model));
		model.addGizmo(new CircleBumper(50, 250, model));

		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
