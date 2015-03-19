package controller;

import java.util.ArrayList;

import model.IGizmo;
import model.Model;
import model.SquareBumper;

public class AddSquareBumperListener {

	private ArrayList<IGizmo> square;
	private Model model;
	private SquareBumper sq;
	
	
	public AddSquareBumperListener(Model m) {
		square = new ArrayList<IGizmo>();
		model = m;
	}
	
	public void addGizmo(){
		model.addGizmo(sq = new SquareBumper(250, 250, "test1", model));
	}
	
	
}
