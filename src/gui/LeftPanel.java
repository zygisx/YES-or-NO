package gui;

import java.awt.Component;

import javax.swing.BoxLayout;

import util.GameUtil;

public class LeftPanel extends LabelsBlock {
	
	public final static int NUMBER_OF_LABELS 	= 13;
	
	private final int LABEL_LENGTH 		= 15;

	/**
	 * Create the panel.
	 */
	public LeftPanel() {
		
		super.setAlignmentX(Component.LEFT_ALIGNMENT);
		super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < NUMBER_OF_LABELS; i++) {
			labels.add(initLabel(GameUtil.CASES[i], LABEL_LENGTH));
		}
	}

}
