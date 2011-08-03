package util;

import java.util.ArrayList;



public class Bank {
	
	
	private int totalCases = 0;
	private int totalSum = 0;
	private boolean empty = false;
	private ArrayList<Case> caseList;
	
	public Bank () {
		
		caseList = new ArrayList<Case>();
		
		for ( int elem : GameUtil.VALUES ) {
			caseList.add(new Case(elem));
			totalSum += elem;
		}
		
		totalCases = GameUtil.NUM_OF_CASES;
	}
	
	/**
	 * In testing stage there is no need to shuffle.
	 */
	public void shuffleCases () {
		// not yet implemented
	}
	
	public int removeCase (int index) {
		totalCases--;
		if (totalCases == 0) empty = true;
		Case oldCase = caseList.set(index, null);
		totalSum -= oldCase.getValue();
		return oldCase.getValue();
		
	}
	
	/**
	 * Just for now.
	 * In future offer has to be more reasonable.
	 */
	public int getOffer () {
		if (! empty)
			return totalSum / totalCases;
		else 
			return totalSum;
	}
	
	public int getValue (int i) {
		return caseList.get(i).getValue();
	}
	
	public boolean isEmpty () {
		return empty;
	}
	
	public int casesLeft () {
		return totalCases;
	}
}
