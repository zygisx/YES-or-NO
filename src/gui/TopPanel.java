package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;


public class TopPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TopPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblYesOrNo = new JLabel("YES or NO");
		lblYesOrNo.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 20));
		add(lblYesOrNo, BorderLayout.NORTH);
		lblYesOrNo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl = new JLabel("Please choose one case.");
		lbl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbl.setVerticalAlignment(SwingConstants.TOP);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl, BorderLayout.CENTER);
	}

	public void setInfo(String text) {
		
	}
}
