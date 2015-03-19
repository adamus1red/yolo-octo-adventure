package controller;

import java.util.ArrayList;

import model.Absorber;
import model.IGizmo;
import model.Model;
import model.CircleBumper;

public class AddAbsorberListener {

	private ArrayList<IGizmo> absorber;
	private Model model;
	private Absorber a;
	
	
	public AddAbsorberListener(Model m) {
		absorber = new ArrayList<IGizmo>();
		model = m;
	}
	
	public void addGizmo(){
		model.addGizmo(a = new Absorber(0, 450, 500, 50, "test1", model));
	}
	
	
}
