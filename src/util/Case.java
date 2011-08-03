package util;

public class Case {

	
	private int value;
	
	public Case () {
		// not yet implemented;
	}
	
	public Case(int value) {
		if (GameUtil.isValidCaseValue(value))
			this.value = value;
	}
	
	public Case (String value) {
		if (GameUtil.isValidCaseValue(new Integer(value))) {
			this.value = new Integer(value);
		}
	}
	
	public int getValue () {
		return value;
	}
	
	public boolean setValue (int value) {
		if (GameUtil.isValidCaseValue(value)) {
			this.value = value;
			return true;
		}
		else return false;
	}
	
	public boolean setValue(String value) {
		if (GameUtil.isValidCaseValue(new Integer(value))) {
			this.value = new Integer(value);
			return true;
		}
		else return false;
	}
	
}
