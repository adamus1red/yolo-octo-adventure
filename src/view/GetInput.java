package view;

<<<<<<< HEAD
import java.io.File;

import javax.swing.JFileChooser;
=======
import javax.swing.JOptionPane;
>>>>>>> origin/master

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