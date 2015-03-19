package controller;

import java.util.ArrayList;


import model.Flipper;
import model.IGizmo;
import model.Model;


public class AddLeftFlipperListener {

	private ArrayList<IGizmo> leftflipper;
	private Model model;
	private Flipper lf;
	
	
	public AddLeftFlipperListener(Model m) {
		leftflipper = new ArrayList<IGizmo>();
		model = m;
	}
	
	public void addGizmo(){
		model.addGizmo(lf = new Flipper(300, 350, "test1", model));
	}
	
	
}
