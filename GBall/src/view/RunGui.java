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

public class RunGui implements GBallGui {

	private Model model;
	private JFrame frame;
	private ActionListener listener;
	private RunBoard board;
	JPanel buttons;
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;
	private Font gf = new Font("Arial", Font.BOLD, 12);

	public RunGui(Model m) {
		model = m;
		board = new RunBoard(500, 500, model);
		buttons = new JPanel();
		listener = new RunListener(m);
		frame = new JFrame("Gizmobaw");
	}

	public void createAndShowGUI() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		Container cp = frame.getContentPane();

		buttons.setLayout(new GridLayout(6, 3));
		
		createButtons();
		createMenu();

		cp.add(buttons, BorderLayout.LINE_START);
		cp.add(board, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void createButtons() {
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

		JButton button4 = new JButton("Build Mode");
		button4.setFont(gf);
		button4.addActionListener(listener);
		button4.setMaximumSize(new Dimension(100, 100));
		buttons.add(button4);

		JButton button3 = new JButton("Quit");
		button3.setFont(gf);
		button3.addActionListener(listener);
		button3.setMaximumSize(new Dimension(100, 100));
		buttons.add(button3);

	}

	@Override
	public void createMenu() {
		JMenuBar menu = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		JMenuItem load = new JMenuItem("Load", 'L');
		load.setToolTipText("Load a level");
		load.addActionListener(listener);
		fileMenu.add(load);
		
		JMenuItem save = new JMenuItem("Save", 'S');
		save.setToolTipText("Save Game");
		save.addActionListener(listener);
		fileMenu.add(save);
		
		JMenuItem quit = new JMenuItem("Quit", 'Q');
		quit.setToolTipText("Quit Game");
		quit.addActionListener(listener);
		fileMenu.add(quit);
		
		menu.add(fileMenu);
		frame.setJMenuBar(menu);
	}

}
