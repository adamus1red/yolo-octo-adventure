package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Absorber;
import model.CircleBumper;
import model.Flipper;
import model.IGizmo;
import model.Model;
import model.SquareBumper;
import model.TriangleBumper;

public class AddGizmoListener implements MouseListener {

	String type;
	Model model;
	IGizmo gizmo;

	public AddGizmoListener(Model model) {
		this.model = model;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int x = (int) (e.getX());
		int y = (int) (e.getY());

		switch (this.type) {
		case "addSquare":
			gizmo = new SquareBumper(x - 134, y - 2, Integer.toString(x + y),
					model);
			model.addGizmo(gizmo);
			break;
		case "addCircle":
			gizmo = new CircleBumper(x - 123, y + 9, Integer.toString(x + y),
					model);
			model.addGizmo(gizmo);
			break;
		case "addTriangle":
			gizmo = new TriangleBumper(x - 135, y - 2, Integer.toString(x + y),
					model);
			model.addGizmo(gizmo);
			break;
		case "addAbsorber":
			gizmo = new Absorber(x - 135, y - 3, 500, 25, Integer.toString(x
					+ y), model);
			model.addGizmo(gizmo);
			break;
		case "addLeftFlipper":
			gizmo = new Flipper(x - 103, y + 4, Integer.toString(x + y), model);
			model.addGizmo(gizmo);
			break;
		case "addRightFlipper":
			gizmo = new Flipper(x - 103, y + 4, Integer.toString(x + y), model);
			model.addGizmo(gizmo);
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}