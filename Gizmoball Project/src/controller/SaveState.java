package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import model.IGizmo;
import model.Model;

public class SaveState {

	private Parser parser;
	private ArrayList<IGizmo> fWrite;
	private Model model;

	public SaveState(Model m) {
		parser = new Parser();
		model = m;
		fWrite = model.getGizmos();
	}

	public void save(String savePath) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(savePath));
		for (int i = 0; i < fWrite.size(); i++) {
			bw.write(parser.parseOut(fWrite.get(i))  + "\n");
		}
		bw.close();
		System.out.println(fWrite);
	}

}
