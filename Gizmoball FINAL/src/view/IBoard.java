package view;

import java.awt.Dimension;
import java.awt.Graphics;

public interface IBoard {

	void paintComponent(Graphics g);
	
	Dimension getPreferredSize();
}
