package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
=======
>>>>>>> origin/master

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.event.MouseInputListener;

import controller.AddCircleBumperListener;
import controller.BuildListener;
import model.CircleBumper;
import model.IGizmo;
=======

import controller.BuildListener;
>>>>>>> origin/master
import model.Model;

public class BuildGui implements GBallGui {

	private JFrame frame;
	private ActionListener listener;
	private BuildBoard board;
	private Model model;
	private final Font font = new Font("Arial", Font.BOLD, 12);
	JMenuBar menuBar;
	JPanel leftPanel;
<<<<<<< HEAD

	BuildListener bl;
=======
	JPanel rightPanel;
	JMenu menu;
	JMenuItem menuItem;
	private BuildListener bl;
>>>>>>> origin/master

	public BuildGui(Model m) {
		this.model = m;
		board = new BuildBoard(500, 500, model);
		frame = new JFrame("Build Mode");
<<<<<<< HEAD
		leftPanel = new JPanel();
		listener = new BuildListener(m, frame);
=======
		 menu = new JMenu("Portfolio");
		 bl = new BuildListener(m, frame);
>>>>>>> origin/master
	}

	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		Container cp = frame.getContentPane();

		leftPanel.setLayout(new GridLayout(10, 10));

		createButtons();
		createMenu();

		cp.add(leftPanel, BorderLayout.LINE_START);
<<<<<<< HEAD
		cp.add(board, BorderLayout.CENTER);

		frame.pack();
=======
		//cp.add(board, BorderLayout.CENTER);


		//frame.pack();
		frame.setSize(600, 500);
>>>>>>> origin/master
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void createButtons() {

		JButton addGizmo = new JButton("addGizmo");
		addGizmo.setFont(font);
		addGizmo.addActionListener(listener);
		addGizmo.setMaximumSize(new Dimension(100, 100));
				
		leftPanel.add(addGizmo);

		JButton addball = new JButton("addBall");
		addball.setFont(font);
		addball.addActionListener(listener);
		addball.setMaximumSize(new Dimension(100, 100));
		leftPanel.add(addball);

		JButton addBumper = new JButton("addBumper");
		addBumper.setFont(font);
		addBumper.addActionListener(listener);
		addBumper.setMaximumSize(new Dimension(100, 100));
		leftPanel.add(addBumper);
<<<<<<< HEAD

		JButton switchMode = new JButton("Switch Mode");
		switchMode.setFont(font);
		switchMode.addActionListener(listener);
		switchMode.setMaximumSize(new Dimension(100, 100));
		leftPanel.add(switchMode);
	}
=======
	
	
	JButton switchMode = new JButton("Switch Mode");
	switchMode.setFont(font);
	switchMode.addActionListener(bl);
	switchMode.setMaximumSize(new Dimension(100, 100));
	leftPanel.add(switchMode);
}
>>>>>>> origin/master

	@Override
	public void createMenu() {

		JMenuBar menu = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		JMenuItem load = new JMenuItem("Load", 'L');
		load.setToolTipText("Load a level");
		// load.addActionListener();
		fileMenu.add(load);

		JMenuItem save = new JMenuItem("Save", 'S');
		save.setToolTipText("Save Game");
		// save.addActionListener();
		fileMenu.add(save);
<<<<<<< HEAD

		JMenuItem quit = new JMenuItem("Quit", 'Q');
		quit.setToolTipText("Quit Game");
		// save.addActionListener();
		fileMenu.add(quit);

=======
		
		JMenuItem quit = new JMenuItem("Quit", 'Q');
		quit.setToolTipText("Quit Game");
//		save.addActionListener();
		fileMenu.add(quit);
		
>>>>>>> origin/master
		menu.add(fileMenu);
		frame.setJMenuBar(menu);

	}
}
