package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Absorber;
import model.Ball;
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

	public void addGizmo(int x, int y) {
		switch (this.type) {
		case "addSquare":
			gizmo = new SquareBumper(x - 1, y - 3, "S" + Integer.toString(x)
					+ Integer.toString(y), model);
			break;
		case "addCircle":
			gizmo = new CircleBumper(x + 11, y + 9, "C" + Integer.toString(x)
					+ Integer.toString(y), model);
			break;
		case "addBall":
			model.addBall(new Ball((double) x, (double) y, 200, 200, "b1"));
			break;
		case "addTriangle":
			gizmo = new TriangleBumper(x, y - 3, "T" + Integer.toString(x)
					+ Integer.toString(y), model);
			break;
		case "addAbsorber":
			gizmo = new Absorber(x - 1, y - 3, 500, 25, "A"
					+ Integer.toString(x) + Integer.toString(y), model);
			break;
		case "addLeftFlipper":
			gizmo = new Flipper(x, y + 5, "LF" + Integer.toString(x)
					+ Integer.toString(y), model);
			break;
		case "addRightFlipper":
			gizmo = new Flipper(x + 8, y + 5, "RF" + Integer.toString(x)
					+ Integer.toString(y), model);
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		addGizmo(x, y);
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
