package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;


public class TopPanel extends JPanel {

	private JLabel lbl;
	private JLabel lblMsg;
	/**
	 * Create the panel.
	 */
	public TopPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblYesOrNo = new JLabel("YES or NO");
		lblYesOrNo.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 20));
		add(lblYesOrNo, BorderLayout.NORTH);
		lblYesOrNo.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbl = new JLabel("Please choose your main case.");
		lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbl.setVerticalAlignment(SwingConstants.TOP);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl, BorderLayout.CENTER);
		
		lblMsg = new JLabel(" ");
		lblMsg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMsg.setVerticalAlignment(SwingConstants.TOP);
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblMsg, BorderLayout.SOUTH);
		
	}

	public void setInfo(String text) {
		lbl.setText(text);
	}
	
	public void setMessage(String text) {
		lblMsg.setText(text);
	}
}
