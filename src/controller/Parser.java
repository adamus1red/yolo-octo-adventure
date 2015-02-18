package controller;

import model.Giz;

public class Parser {
	private Giz g;
	public Parser() {
		g = new Giz();
	}

	public Giz parse(String s) throws Exception {
		
		String[] sSplit = s.split("\\s+");
		if (sSplit[0] != "\\n" && s != null) {
			
		} else {
			return null;
		}
		return g;
	}
	/*
	 * <gizmoOp> <name> <int-pair> |
	 * Absorber <name> <int-pair> <int-pair> |
	 * Ball <name> <float-pair> <float-pair> |
	 * Rotate <name> |
	 * Delete <name> |
	 * Move <name> <number-pair> |
	 * Connect <name> <name> |
	 * KeyConnect <keyid> <name> |
	 * 	<gizmoOp> ::= Square | Circle | Triangle | RightFlipper | LeftFlipper
	 */

	private int getXCooord(String s) {
		// TODO Auto-generated method stub
		return Integer.parseInt(s);
	}
	private int getYCooord(String s) {
		// TODO Auto-generated method stub
		return Integer.parseInt(s);
	}

	private String getGizmoType(String s) {
		if(checkType(s) != null){
			return checkType(s); 
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
			return "Squrare";
		} else if (string.toUpperCase().equals("LEFTFLIPPER")) {
			return "Flipper";
		} else if (string.toUpperCase().equals("RIGHTFLIPPER")) {
			return "Flipper";
		} else {
			return null;
		}
	}
}
