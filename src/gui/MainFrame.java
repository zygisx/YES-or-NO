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
	private int playerCaseValue = 0;
	private int move = 0;
	private boolean firstMove = true;
	private boolean gameEnd = false;
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
		super("Yes or No");
		
		/* set up game */
		bank = new Bank();
		offerStep = new ArrayList<Integer>();
		for (Integer elem : GameUtil.OFFER_STEPS) {
			offerStep.add(elem);
		}
		
		/* set up frame */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 374);
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
			if (gameEnd) return;	// if game ended already
			int i = 0;
			while (event.getSource() != buttons.get(i)) i++;
			
			buttonOff(i);
			move++;
			
			if (firstMove) {	// if it's a first move
				firstMove = false;
				move--;		// because first move is not move, player just choose his case.
				topPanel.setInfo("Now choose " + offerStep.get(0) + " cases, until you get bank offer." );
				playerCaseValue = bank.getValue(i);
			}
			else {	
				int index = GameUtil.getIndexOfValue(bank.getValue(i));
				if (index < LeftPanel.NUMBER_OF_LABELS) {
					leftPanel.labelOff(index);
				}
				else {
					rightPanel.labelOff(index-LeftPanel.NUMBER_OF_LABELS);
				}
				
				bank.removeCase(i);
			}
			
			if (offerStep.get(0) == move) {
				offerStep.remove(0);
				move = 0;
				
				/* left only firstly chosen case */
				if (bank.casesLeft() == 1) {
					topPanel.setInfo("Congrats! You don't sell your case for whole game. You have won " + playerCaseValue +"$.");
					gameEnd = true;
					return;
				}
				
				int option = JOptionPane.showConfirmDialog(
					centerPanel,	// to place dialog frame on center of screen.
					"Bank offer: " + bank.getOffer() + "$\n" +
					"Do you accept the bank offer?",
					"Yes or No?",
					JOptionPane.YES_NO_OPTION);
				
				topPanel.setInfo("Choose " + offerStep.get(0) + " cases, to get next bank offer.");
				
				if (option == JOptionPane.YES_OPTION) {
					topPanel.setInfo("Game over. You have won: " + bank.getOffer() + "$." +
						" Your case holds " + playerCaseValue + "$");
					gameEnd = true;
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
