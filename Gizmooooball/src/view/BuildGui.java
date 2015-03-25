package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import controller.AddCircleBumperListener;
import controller.BuildListener;
import model.CircleBumper;
import model.IGizmo;
import model.Model;

public class BuildGui implements GBallGui {

	private JFrame frame;
	private ActionListener listener;
	private BuildBoard board;
	private Model model;
	private final Font font = new Font("Arial", Font.BOLD, 12);
	JMenuBar menuBar;
	JPanel leftPanel;

	BuildListener bl;

	public BuildGui(Model m) {
		this.model = m;
		board = new BuildBoard(500, 500, model);
		frame = new JFrame("Gizmoball Build Mode");
		leftPanel = new JPanel();
		listener = new BuildListener(m, frame);
	}

	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		Container cp = frame.getContentPane();

		leftPanel.setLayout(new GridLayout(10, 10));

		createButtons();
		createMenu();

		cp.add(leftPanel, BorderLayout.LINE_START);
		cp.add(board, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void createButtons() {

		JButton addCircle = new JButton("addCircle");
		addCircle.setFont(font);
		addCircle.addActionListener(listener);
		addCircle.setMaximumSize(new Dimension(100, 100));	
		leftPanel.add(addCircle);
		
		JButton addSquare = new JButton("addSquare");
		addSquare.setFont(font);
		addSquare.addActionListener(listener);
		addSquare.setMaximumSize(new Dimension(100, 100));
		leftPanel.add(addSquare);
		
		JButton addTriangle = new JButton("addTriangle");
		addTriangle.setFont(font);
		addTriangle.addActionListener(listener);
		addTriangle.setMaximumSize(new Dimension(100, 100));
		leftPanel.add(addTriangle);
		
		
		JButton addball = new JButton("addBall");
		addball.setFont(font);
		addball.addActionListener(listener);
		addball.setMaximumSize(new Dimension(100, 100));
		leftPanel.add(addball);

		JButton addAbsorber = new JButton("addAbsorber");
		addAbsorber.setFont(font);
		addAbsorber.addActionListener(listener);
		addAbsorber.setMaximumSize(new Dimension(100, 100));
		leftPanel.add(addAbsorber);
		
		JButton addLeftFlipper = new JButton("addLeftFlipper");
		addLeftFlipper.setFont(font);
		addLeftFlipper.addActionListener(listener);
		addLeftFlipper.setMaximumSize(new Dimension(100, 100));
		leftPanel.add(addLeftFlipper);
		
		JButton addRightFlipper = new JButton("addRightFlipper");
		addRightFlipper.setFont(font);
		addRightFlipper.addActionListener(listener);
		addRightFlipper.setMaximumSize(new Dimension(100, 100));
		leftPanel.add(addRightFlipper);

		JButton switchMode = new JButton("Switch Mode");
		switchMode.setFont(font);
		switchMode.addActionListener(listener);
		switchMode.setMaximumSize(new Dimension(100, 100));
		leftPanel.add(switchMode);
	}

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

		JMenuItem quit = new JMenuItem("Quit", 'Q');
		quit.setToolTipText("Quit Game");
		// save.addActionListener();
		fileMenu.add(quit);

		menu.add(fileMenu);
		frame.setJMenuBar(menu);

	}
}
