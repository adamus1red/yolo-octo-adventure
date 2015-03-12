package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import model.Model;
import controller.RunListener;
import controller.SetKeyBoardListener;


public class RunGui {

	private Model model;
	private JFrame frame;
	private ActionListener listener;
	private RunBoard board;
	private SetKeyBoardListener KBListener;
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;

	public RunGui(Model m) {
		model = m;

		// RunListener catches all GUI events. In reality might have many listeners.
		listener = new RunListener(m);
		//KBListener =  new SetKeyBoardListener(m);
	}

	public void createAndShowGUI() {

		frame = new JFrame("Gizmobaw");
		//frame.addKeyListener(KBListener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		//added so that the frame size cant be adjusted

		// Board is passed the Model so it can act as Observer
		board = new RunBoard(500, 500, model);
		menuBar = new JMenuBar();

		Container cp = frame.getContentPane();

		Font gf = new Font("Arial", Font.BOLD, 12);
		
		menu = new JMenu("Gizmo's");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);
		
		menu = new JMenu("Another Menu");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
		        "This menu does nothing");
		menuBar.add(menu);


		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(6, 3));

		JButton button1 = new JButton("Start");
		button1.setFont(gf);
		button1.addActionListener(listener);
		button1.setMaximumSize(new Dimension(100, 100));
		buttons.add(button1);

		JButton button2 = new JButton("Stop");
		button2.setFont(gf);
		button2.addActionListener(listener);
		button2.setMaximumSize(new Dimension(100, 100));
		buttons.add(button2);
		
		JButton button5 = new JButton("Load");
		button5.setFont(gf);
		button5.addActionListener(listener);
		button5.setMaximumSize(new Dimension(100, 100));
		buttons.add(button5);
		
		JButton button6 = new JButton("Save");
		button6.setFont(gf);
		button6.addActionListener(listener);
		button6.setMaximumSize(new Dimension(100, 100));
		buttons.add(button6);

		JButton button4 = new JButton("Change Mode");
		button4.setFont(gf);
		button4.addActionListener(listener);
		button4.setMaximumSize(new Dimension(100, 100));
		buttons.add(button4);
		
		JButton button3 = new JButton("Quit");
		button3.setFont(gf);
		button3.addActionListener(listener);
		button3.setMaximumSize(new Dimension(100, 100));
		buttons.add(button3);

		cp.add(buttons, BorderLayout.LINE_START);
		cp.add(board, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
