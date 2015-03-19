package controller;

import java.util.ArrayList;


import model.Flipper;
import model.IGizmo;
import model.Model;


public class AddRightFlipperListener {

	private ArrayList<IGizmo> rightflipper;
	private Model model;
	private Flipper rf;
	
	
	public AddRightFlipperListener(Model m) {
		rightflipper = new ArrayList<IGizmo>();
		model = m;
	}
	
	public void addGizmo(){
		model.addGizmo(rf = new Flipper(350, 200, "test1", model));
	}
	
	
}
