package controller;

import java.util.ArrayList;

import model.*;

/**
 * Parser for Gizmo Ball project.
 * 
 * @author Adam McGhie
 *
 */
public class Parser {
	private IGizmo g;

	public Parser() {
	}

	/**
	 * Generates a IGizmo implimentable objects based on an input string
	 * 
	 * @param Input
	 *            String
	 * @param Model
	 * @return IGizmo interface complient Gizmo
	 * @throws Exception
	 */
	public IGizmo parseIn(String st, Model m) throws Exception {
		Model model = m;
		String[] s = st.split("\\s");
		
		if (s[0] != null) {
			if (s[0].toUpperCase().matches(
					"^CIRCLE|TRIANGLE|SQUARE|(RIGHT|LEFT)FLIPPER")) {
				if (s[0].toUpperCase().equals("CIRCLE")) {
					if (checkName(s[1])) {
<<<<<<< HEAD
						g = new CircleBumper(Integer.parseInt(s[2]) * 25,
								Integer.parseInt(s[3]) * 25, s[1], model);
=======
						g = new CircleBumper(Integer.parseInt(s[2])*25,
								Integer.parseInt(s[3])*25, s[1], model);
>>>>>>> origin/master
					} else {
						throw new Exception("Bad name");
					}
				} else if (s[0].toUpperCase().equals("TRIANGLE")) {
					if (checkName(s[1])) {
<<<<<<< HEAD
						g = new TriangleBumper(Integer.parseInt(s[2]) * 25,
								Integer.parseInt(s[3]) * 25, s[1], model);
=======
						g = new TriangleBumper(Integer.parseInt(s[2])*25,
								Integer.parseInt(s[3])*25, s[1], model);
>>>>>>> origin/master
					} else {
						throw new Exception("Bad name");
					}
				} else if (s[0].toUpperCase().equals("SQUARE")) {
					if (checkName(s[1])) {
<<<<<<< HEAD
						g = new SquareBumper(Integer.parseInt(s[2]) * 25,
								Integer.parseInt(s[3]) * 25, s[1], model);
=======
						g = new SquareBumper(Integer.parseInt(s[2])*25,
								Integer.parseInt(s[3])*25, s[1], model);
>>>>>>> origin/master
					} else {
						throw new Exception("Bad name");
					}
				} else if (s[0].toUpperCase().contains("FLIPPER")) {
					if (checkName(s[1])) {
<<<<<<< HEAD
						g = new Flipper(Integer.parseInt(s[2]) * 25,
								Integer.parseInt(s[3]) * 25, s[1], model);
=======
						g = new Flipper(Integer.parseInt(s[2])*25,
								Integer.parseInt(s[3])*25, s[1], model);
>>>>>>> origin/master
					} else {
						throw new Exception("Bad name");
					}
				}
			} else if (s[0].toUpperCase().equals("BALL")) {
				if (checkName(s[1])) { // Check name matches expected format
					g = new Ball(Double.parseDouble(s[2]),
							Double.parseDouble(s[3]), Double.parseDouble(s[4]),
							Double.parseDouble(s[5]), s[1]);
				} else {
					throw new Exception("Bad name");
				}
			} else if (s[0].toUpperCase().equals("ABSORBER")) {
				if (checkName(s[1])) { // Check name matches expected format
<<<<<<< HEAD
					int x = Integer.parseInt(s[2]) * 25;
					int y = Integer.parseInt(s[3]) * 25;
					int w = x + Integer.parseInt(s[4]) * 25;
					int v = y + Integer.parseInt(s[5]) * 25;
=======
					int x = Integer.parseInt(s[2])*25;
					int y = Integer.parseInt(s[3])*25;
					int w = x + Integer.parseInt(s[4])*25;
					int v = y + Integer.parseInt(s[5])*25;
>>>>>>> origin/master
					g = new Absorber(x, y, w, v, s[1], model);
				} else {
					throw new Exception("Bad name");
				}
			} else if (s[0].toUpperCase().equals("GRAVITY")) {
				model.setGravity(Float.parseFloat(s[1]));
			} else if (s[0].toUpperCase().equals("FRICTION")) {
				model.setFriction(Float.parseFloat(s[1]));
			} else if (s[0].toUpperCase().equals("ROTATE") && checkName(s[1])) {
				ArrayList<IGizmo> gl = model.getGizmos();
				for (int i = 0; i < gl.size(); i++) {
					IGizmo gi = gl.get(i);
					if (gi.getName() == s[1]) {
						gi.setRotation(gi.getRotation() + 90);
					}
				}
			} else if (s[0].toUpperCase().equals("DELETE") && checkName(s[1])) {
				ArrayList<IGizmo> gl = model.getGizmos();
				for (int i = 0; i < gl.size(); i++) {
					IGizmo gi = gl.get(i);
					if (gi.getName() == s[1]) {
						gl.remove(i);
					}
				}
				model.setGizmo(gl);
			} else if (s[0] == null) {
				// blank line
			} else {
				System.out.println(st);
				throw new Exception("Corrupt input");
			}
		} else {
			return null;
		}
		return g;
	}

	/**
	 * Takes a Gizmo object and parses it into the equivalent String for saving
	 * to the file system
	 * 
	 * @param iGizmo
	 * @return String
	 * @throws Exception
	 */
	public String parseOut(IGizmo iGizmo) throws Exception {
		if (checkName(iGizmo.getName())) {
			String r = null;
			if (iGizmo.getType().toUpperCase().equals("ABSORBER")) {
				r = "" + iGizmo.getType() + " " + iGizmo.getName() + " "
						+ iGizmo.getXPos()/25 + " " + iGizmo.getYPos()/25 + " "
						+ iGizmo.getWidth() + " " + iGizmo.getHeight();
			} else {
				r = "" + iGizmo.getType() + " " + iGizmo.getName() + " "
						+ iGizmo.getXPos()/25 + " " + iGizmo.getYPos()/25;
			}
			System.out.println(r);
			return r;
		} else {
			throw new Exception("Bad Name");
		}

	}

	/**
	 * Checks to see if the name of an object is valid in the scope of the
	 * Formal Syntax e.g. Any letter, upper and lower case, and any number 0-9
	 * will be accepted except when it is OuterWalls Since that's reserved for a
	 * special case
	 * 
	 * @param String
	 * @return boolean
	 */
	private boolean checkName(String s) {
		if (s.matches("^[a-zA-Z0-9]+")) {
			if (s.matches("!OuterWalls")) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks to see if a value is a whole or real number. True means it is a
	 * whole number, False means it's a real number
	 * 
	 * @param float
	 * @return boolean
	 */
	private boolean isInt(float f) {
		if (f % 1 == 0) {
			return true;
		} else {
			return false;
		}
	}
}