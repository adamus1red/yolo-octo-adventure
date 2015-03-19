package controller;

import java.util.ArrayList;

import model.IGizmo;
import model.Model;
import model.TriangleBumper;

public class AddTriangleBumperListener {

	private ArrayList<IGizmo> triangle;
	private Model model;
	private TriangleBumper tb;
	
	
	public AddTriangleBumperListener(Model m) {
		triangle = new ArrayList<IGizmo>();
		model = m;
	}
	
	public void addGizmo(){
		model.addGizmo(tb = new TriangleBumper(225, 225, "test1", model));
	}
	
	
}
