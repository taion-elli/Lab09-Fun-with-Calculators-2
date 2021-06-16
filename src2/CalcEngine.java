import java.io.IOException;

import postfixClasses.Postfix;
public class CalcEngine {
	// The calculator's state is maintained in three fields:
    //     buildingDisplayValue, haveLeftOperand, and lastOperator.
    
    // Are we already building a value in the display, or will the
    // next digit be the first of a new one?
	protected boolean buildingDisplayValue;
    // Has a left operand already been entered (or calculated)?
	protected boolean haveLeftOperand;
    // The most recent operator that was entered.
	protected char lastOperator;

    // The current value (to be) shown in the display.
	protected int displayValue;
    // The value of an existing left operand.
	protected int leftOperand;

	protected StringBuilder stringBuilder;
	protected Postfix postfix;
    /**
     * Create a CalcEngine.
     */
    public CalcEngine()
    {
    	stringBuilder = new StringBuilder();
    	postfix = new Postfix();
        clear();
    }
    public void numberPressedStringBuilder(String number) {
    	stringBuilder.append(number);
    	//return stringBuilder;
    }
    
    public void equals() {
    	String postf = null;
    	try {
			postf = postfix.infixToPostfix(getDisplayValue());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			clear();
		}
    	clear();
    	try {
			stringBuilder.append(postfix.evaluate(postf));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			clear();
		}
    }
    
    public void clear() {
    	stringBuilder.delete(0, stringBuilder.length());
    }
    
    public String getDisplayValue() {
    	return stringBuilder.toString();
    }
    
    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "Java Calculator";
    }

    /**
     * @return The author of this engine.
     */
    public String getAuthor()
    {
        return "David J. Barnes and Michael Kolling";
    }

    /**
     * @return The version number of this engine.
     */
    public String getVersion()
    {
       return "Version 1.0";
    }
   
    /**
     * precedence of operators applied
     */
    public int precedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
		return 1;
		case '*':
		case '/':
		return 2;
		case '^':
		return 3;
		default:
		return -1;
		}	
    }
}
    

