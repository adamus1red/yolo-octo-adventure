package controller;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

import model.IGizmo;
import model.Model;

public class LoadState {

	private ArrayList<IGizmo> fRead;
	private Parser parser;
	private Model model;
	
	
	public LoadState(Model m) {
		fRead = new ArrayList<IGizmo>();
		parser = new Parser();
		model = m;
	}

	public ArrayList<IGizmo> load(String savePath) {
		if (checkReadable(savePath)) {
			readFile(savePath);
		}
		return fRead;
	}

	private void readFile(String savePath) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {

			String currentLine;

			br = new BufferedReader(new FileReader(savePath));

			while ((currentLine = br.readLine()) != null) {
				fRead.add(parser.parseIn(currentLine, model));
				System.out.println(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * Check to see if the file given is readable to the program.
	 * 
	 * @param savePath
	 * @return boolean
	 */
	private boolean checkReadable(String savePath) {
		File fCheck = new File(savePath);
		return fCheck.canRead();
	}

	public ArrayList<IGizmo> getfRead() {
		return fRead;
	}

	public void setfRead(ArrayList<IGizmo> fRead) {
		this.fRead = fRead;
	}
}
