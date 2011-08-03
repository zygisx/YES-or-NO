package util;

import java.util.ArrayList;
import java.util.Random;


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
		caseList = shuffleCases();
		totalCases = GameUtil.NUM_OF_CASES;
		
	}
	
	/**
	 * In testing stage there is no need to shuffle.
	 */
	public ArrayList<Case> shuffleCases () {
		ArrayList<Case> newList = new ArrayList<Case>();
		Random rand = new Random();
		
		for (int i = GameUtil.VALUES.length; i > 0; i-- ) {
			newList.add(caseList.remove(rand.nextInt(i)));
		}
		return newList;
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
