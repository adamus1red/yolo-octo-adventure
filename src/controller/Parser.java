package controller;

import java.util.StringTokenizer;

import model.Gizmo;

public class Parser {
	private Gizmo g;

	public Parser() {
		g = new Gizmo();
	}

	public Gizmo parse(String s) throws Exception {

		String[] st = s.split("\\s");
		if (st[0] != null) {
			checkType(st[0]); 
		} else {
			return null;
		}
		return g;
	}

	/*
	 * <gizmoOp> <name> <int-pair> | Absorber <name> <int-pair> <int-pair> |
	 * Ball <name> <float-pair> <float-pair> | Rotate <name> | Delete <name> |
	 * Move <name> <number-pair> | Connect <name> <name> | KeyConnect <keyid>
	 * <name> | 
	 * <gizmoOp> ::= Square | Circle | Triangle | RightFlipper |
	 * LeftFlipper
	 */

	private String getGizmoType(String s) {
		if (checkType(s) != null) {
			g.setType(checkType(s));
		} else {

		}
		return s;
	}

	private String checkType(String string) {
		if (string.toUpperCase().equals("CIRCLE")) {
			return "Circle";
		} else if (string.toUpperCase().equals("TRIANGLE")) {
			return "Triangle";
		} else if (string.toUpperCase().equals("SQUARE")) {
			return "Square";
		} else if (string.toUpperCase().equals("LEFTFLIPPER")) {
			return "Flipper";
		} else if (string.toUpperCase().equals("RIGHTFLIPPER")) {
			return "Flipper";
		} else {
			return null;
		}
	}
}