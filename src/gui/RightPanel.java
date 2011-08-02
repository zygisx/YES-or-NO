package gui;

import java.awt.Component;

import javax.swing.BoxLayout;

import util.GameUtil;

public class RightPanel extends LabelsBlock {
	
	private final int NUMBER_OF_LABELS 	= 13;
	private final int LABEL_LENGTH 		= 15;
	
	public RightPanel () {
		super.setAlignmentX(Component.LEFT_ALIGNMENT);
		super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < NUMBER_OF_LABELS; i++) {
			labels.add(initLabel(GameUtil.CASES[i+NUMBER_OF_LABELS], LABEL_LENGTH));
		}
	}		
		
}
