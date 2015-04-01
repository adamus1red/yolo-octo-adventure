package view;

import java.io.File;

import javax.swing.JFileChooser;

import model.Model;

public class GetInput {

	String input;
	JFileChooser fc;

	public GetInput() {
		fc = new JFileChooser();
	}

	public String showSavePopup(String message, Model m) {
		fc.showSaveDialog(null);
		File file = fc.getSelectedFile();
		// This is where a real application would open the file.
		input = file.getPath();
		// input =JOptionPane.showInputDialog(message);
		return input;

	}
	
	public String showOpenPopup(String message, Model m) {
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();
		// This is where a real application would open the file.
		input = file.getPath();
		// input =JOptionPane.showInputDialog(message);
		return input;

	}
}