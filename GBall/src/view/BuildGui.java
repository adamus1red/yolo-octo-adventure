package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import model.Model;

public class BuildGui implements GBallGui {

	private JFrame frame;
	private ActionListener listener;
	private BuildBoard board;
	private Model model;
	private final Font font = new Font("Arial", Font.BOLD, 12);
	JMenuBar menuBar;
	JPanel leftPanel;
	JPanel rightPanel;
	JMenu menu;
	JMenuItem menuItem;

	public BuildGui(Model m) {
		this.model = m;
		board = new BuildBoard(500, 500, model);
		leftPanel = new JPanel();
		frame = new JFrame("Build Mode");
		 menu = new JMenu("Portfolio");
	}

	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		Container cp = frame.getContentPane();

		leftPanel.setLayout(new GridLayout(6, 3));

		createButtons();
		createMenu();
		createJPanels();

		cp.add(leftPanel, BorderLayout.LINE_START);
		// cp.add(board, BorderLayout.CENTER);

//		 frame.pack();
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void createButtons() {
		JButton addGizmo = new JButton("addGizmo");
		addGizmo.setFont(font);
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
	}

	@Override
	public void createMenu() {
		
		JMenuBar menu = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		JMenuItem load = new JMenuItem("Load", 'L');
		load.setToolTipText("Load a level");
//		load.addActionListener();
		fileMenu.add(load);
		
		JMenuItem save = new JMenuItem("Save", 'S');
		save.setToolTipText("Save Game");
//		save.addActionListener();
		fileMenu.add(save);
		
		menu.add(fileMenu);
		frame.setJMenuBar(menu);
		
	}

	private void createJPanels() {
		JPanel panel = new JPanel(new GridLayout(20, 20, -1, -1));
		panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

		for (int i = 0; i < (20 * 20); i++) {
			final JPanel jp = new JPanel();
			jp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			panel.add(jp);
			frame.add(panel);
		}
	}

}
