package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import util.Bank;
import util.GameUtil;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private CenterPanel centerPanel;
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	private Bank bank;
	private TopPanel topPanel;
	private int move = 0;
	private boolean firstMove = true;
	private ArrayList<Integer> offerStep;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// create game main window.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		/* set up game */
		bank = new Bank();
		offerStep = new ArrayList<Integer>();
		for (Integer elem : GameUtil.OFFER_STEPS) {
			offerStep.add(elem);
		}
		
		/* set up frame */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		leftPanel = new LeftPanel();
		contentPane.add(leftPanel, BorderLayout.WEST);
		
		rightPanel = new RightPanel();
		contentPane.add(rightPanel, BorderLayout.EAST);
		
		centerPanel = new CenterPanel();
		FlowLayout flowLayout = (FlowLayout) centerPanel.getLayout();
		flowLayout.setVgap(10);
		centerPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		topPanel = new TopPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		
	}
	
	class CenterPanel extends JPanel implements ActionListener {

		private final int NUM_OF_BUTTONS = 26;
		MainFrame m;
		private ArrayList<JButton> buttons = new  ArrayList<JButton>();
		
		/**
		 * Create the panel.
		 */
		public CenterPanel() {
			FlowLayout flowLayout = (FlowLayout) getLayout();
			flowLayout.setHgap(10);
			
			for (int i = 0; i < NUM_OF_BUTTONS; i++ ) {
				buttons.add( initButton(Integer.toString(i+1)) );
			}
		}
		
		public void buttonOff (int num) {
			buttons.get(num).setEnabled(false);
		}
		
		public void actionPerformed(ActionEvent event) {
			int i = 0;
			while (event.getSource() != buttons.get(i)) i++;
			
			/* Gui things */
			buttonOff(i);
			if (i < 13) {
				leftPanel.labelOff(i);
			}
			else {
				rightPanel.labelOff(i-13);
			}
			
			move++;
			bank.removeCase(i);
			
			//System.out.println (offerStep.get(0));
			if (firstMove) {
				firstMove = false;
				System.out.println("first");
			}
			else if (offerStep.get(0) == move) {
				offerStep.remove(0);
				move = 0;
				int option = JOptionPane.showConfirmDialog(
					null,	// to place dialog frame on center of screen.
					"Bank offer: " + bank.getOffer() + "$\n" +
					"Do you accept the bank offer?",
					"Yes or No?",
					JOptionPane.YES_NO_OPTION);
			
				if (option == JOptionPane.YES_OPTION) {
					topPanel.setInfo("Game over. You have won: " + bank.getOffer() + "$");
					/* 
					 * Not yet implemented.
					 * need to be endGame;
					 */
				}
			}
		}
		
		private JButton initButton (String txt) {
			JButton btn = new JButton(txt);
			btn.addActionListener((ActionListener) this);
			add(btn);
			return btn;
		}

	}	// end inner class
	
}	// end MainFrame class
