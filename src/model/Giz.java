/**
 * 
 */
package model;

/**
 * @author rjb12180
 *
 */
public class Giz implements Gizmo {
	private int xCoord;
	private int yCoord;
	private String type;
	private String name;
	
	public void setType(String s){
		type = s;
	}
	public String getType() {
		return type;
	}
	public int getXCoordinate() {
		return xCoord;
	}
	public int getYCoordinate(){
		return yCoord;
	}
	
	public void setXCoordinate(int x){
		if(x <=20 && x >0){
			xCoord = x;
		}
	}
	
	
}
