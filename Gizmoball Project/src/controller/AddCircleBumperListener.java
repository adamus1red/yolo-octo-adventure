package controller;

import java.util.ArrayList;

import model.IGizmo;
import model.Model;
import model.CircleBumper;

public class AddCircleBumperListener {

	private ArrayList<IGizmo> circle;
	private Model model;
	private  CircleBumper cb;
	
	
	public AddCircleBumperListener(Model m) {
		circle = new ArrayList<IGizmo>();
		model = m;
	}
	
	public void addGizmo(){
		model.addGizmo(cb = new CircleBumper(100, 100, "test1", model));
		cb.getColor();
	}
	
	
}
