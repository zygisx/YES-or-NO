package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public abstract class LabelsBlock extends JPanel {
	
	
	protected  ArrayList<JLabel> labels = new ArrayList<JLabel>();
	
	public void labelOff (int num) {
		labels.get(num).setBackground(Color.GRAY);
	}
	
	protected JLabel initLabel (String text, int length) {
		
		JLabel label = new JLabel(formatLabelText(text, length)); 
		label.setBorder((Border) new LineBorder(Color.LIGHT_GRAY, 1, true));
		label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		label.setBackground(Color.GREEN);
		label.setOpaque(true);
		add(label);
		return label;
	}
	
	/**
	 *  returns string for label text. Code looks fuzzy, but it is for better label looking. 
	 */
	protected String formatLabelText (String text, int length) {
		
		
		return (String.format("%10s", text) +  "                ".substring(0, length - 5 - text.length()));
		
	}
}
