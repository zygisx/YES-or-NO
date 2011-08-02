package util;

public class GameUtil {

	public static final int NUM_OF_CASES	= 26;
	public static final String[] CASES 		=  
		{ 
			"1", "3", "5", "10", "25", "50","75", "100", "200", "300", "400", "500", "750",
			"1000", "2500", "5000", "10000", "20000", "30000", "40000", "50000","100000", "200000", "300000", "400000", "500000"
		};
	public static final int[] VALUES		=
		{
			1, 3, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 
			1000, 2500, 5000, 10000, 20000, 30000, 40000, 50000, 100000, 200000, 300000, 400000, 500000
			
		};
	public static final int[] OFFER_STEPS	=
		{
			5, 5, 4, 3, 2, 1, 1, 1, 1 
		};
	
	
	public static boolean isValidCaseValue (int value) {
		for (int elem : VALUES) {
			if (value == elem)
				return true;
		}
		return false;
	}
	
	public static int getIndexOfValue (int value) {
		for (int i = 0; i < NUM_OF_CASES;  i++) {
			if (value == VALUES[i]) 
				return i;
		}
		return -1;
	}
}