package controller;

import java.util.ArrayList;

import model.IGizmo;
import model.Model;
import model.SquareBumper;

public class RemoveGizmoListener {

	private ArrayList<IGizmo> gizmos;
	private Model model;
	private SquareBumper sq;
	private SquareBumper sq1;
	
	
	public RemoveGizmoListener(Model m) {
		gizmos = new ArrayList<IGizmo>();
		model = m;
	}
	
	public void removeGizmo(){
		model.addGizmo(sq1 = new SquareBumper(240,240,"6test3",model));
		for (IGizmo gz : model.getGizmos()) {
			if (gz.getType().equals("Square")) {
		model.removeGizmo(gz);
	}
		}
	}
	
	
	
}
