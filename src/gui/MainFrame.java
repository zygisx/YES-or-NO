package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private CenterPanel centerPanel;
	private LeftPanel leftPanel;
	private RightPanel rightPanel;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// create game window.
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 334);
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
			buttons.get(num).setVisible(false);
		}
		
		public void actionPerformed(ActionEvent event) {
			int i = 0;
			while (event.getSource() != buttons.get(i)) i++;
			buttonOff(i);
			if (i < 13) {
				leftPanel.labelOff(i);
			}
			else {
				rightPanel.labelOff(i-13);
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
