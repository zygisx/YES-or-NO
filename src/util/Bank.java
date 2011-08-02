package util;

import java.util.ArrayList;



public class Bank {
	
	
	private int totalCases = 0;
	private int totalSum = 0;
	private ArrayList<Case> caseList;
	
	public Bank () {
		
		caseList = new ArrayList<Case>();
		
		for ( int elem : GameUtil.VALUES ) {
			caseList.add(new Case(elem));
			totalSum += elem;
		}
		
		totalCases = GameUtil.NUM_OF_CASES;
		System.out.println(GameUtil.NUM_OF_CASES);
	}
	
	/**
	 * In testing stage there is no need to shuffle.
	 */
	public void shuffleCases () {
		// not yet implemented
	}
	
	public int removeCase (int index) {
		totalCases = totalCases - 1;
		Case oldCase = caseList.set(index, null);
		totalSum -= oldCase.getValue();
		System.out.println( (totalCases + " ") + totalSum);
		return oldCase.getValue();
		
	}
	
	/**
	 * Just for now.
	 * In future offer has to be more reasonable.
	 */
	public int getOffer () {
		return totalSum / totalCases;
	}
	
	
}
