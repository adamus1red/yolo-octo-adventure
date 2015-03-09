package view;

import javax.swing.JOptionPane;

import model.Model;

public class GetInput {

	String input;
	
	public GetInput() {
		
	}
	
	public String showPopup(String message, Model m) {
		//buildPopup();
		input =JOptionPane.showInputDialog(message);
		return input;
		
	}
}
