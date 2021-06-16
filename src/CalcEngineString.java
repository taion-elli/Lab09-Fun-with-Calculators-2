
public class CalcEngineString extends CalcEngine {
	
	String displayString = "";
	Postfix p;

	public CalcEngineString() {
		super();
		p = new Postfix();
	}
	
	/**
	 * Reset the display when the "del" button is pressed
	 */
	public void clear() {
		displayString = "";
	}
	
	/**
	 * This method returns the String that represents the current value of the display
	 * @return the value supposed to be currently displayed
	 */
	public String getDisplayString() {
		return displayString;
	}
	
	public void applyOperator(String operator) {
		displayString = displayString + operator;
	}
	
	
	public void numberPressed(String num) {
		displayString = displayString + num; 
	}
	
	@Override
	public void equals() throws StackOverflow, StackUnderflow  {
		if(displayString != null) {
			String postfix = p.infixToPostfix(displayString);
			displayString = ""+p.evaluate(postfix);
	}
		}
	}
	
	



