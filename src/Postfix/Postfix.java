package Postfix;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Postfix {
	
	public Postfix() {
		super();
	}

	//public static void main(String[] args) throws StackUnderflow, StackOverflow{
		// TODO Auto-generated method stub
		//Postfix p = new Postfix();
		/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Infix: " );
			String ix = reader.readLine();
			p.getValueFromConsole(ix);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		//int f = p.evaluate("4567+*");
		//System.out.println(f); 
	//} 
	
	public int getValueFromConsole(String ix) {
	
				String ixPx = null;
				try {
					ixPx = infixToPostfix(ix);
				} catch (StackOverflow | StackUnderflow e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int inputResult = 0;
				try {
					inputResult = evaluate(ixPx);
				} catch (StackUnderflow | StackOverflow e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The value of this expression is: " + inputResult);
				return inputResult;
		}
	
	public int evaluate (String pfx) throws StackUnderflow, StackOverflow{
		StackAsList<Integer> stack = new StackAsList<Integer>();

		char[] chars = pfx.toCharArray();
		
		for (char element : chars) {
			if (Character.isDigit(element)) {
				stack.push(Character.getNumericValue(element));
			} else {
				int lhs = stack.pop();
				int rhs = stack.pop();
				
				switch (element) {
				case '+':
					stack.push(lhs + rhs);
					break;
				case '-':
					stack.push(lhs - rhs);
					break;
				case '*':
					stack.push(lhs * rhs);
					break;
				case '/':
					stack.push(lhs / rhs);
					break;
				case '^':
					stack.push((int)(Math.pow(lhs, rhs)));
					break;
				}
			}
		}
		return stack.pop();
	}
	
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
	
	public boolean isOperator(char operator) {
		switch (operator) {
		case '+':
			return true;
		case '-':
			return true;
		case '*':
			return true;
		case '/':
			return true;
		case '^':
			return true;
		default:
			return false;
		}
	}
	
	public boolean isOperand(char opperand) {
		return Character.isDigit(opperand);
	} 
	
	public String infixToPostfix(String infix) throws StackOverflow, StackUnderflow {
		StackAsList<Character> stack = new StackAsList<Character>();
		char[] chars = infix.toCharArray();
		String result = "";
		for (char element : chars) {
			if (element != ' ') {
				if (isOperand(element)) {
					result += element;
				} else if (element == '(') {
					stack.push(element);
				} else if (element == ')') {
					while (!(stack.top() == '(')) {
						result += stack.pop();
					}
					stack.pop();
				} else if (isOperator(element)) {
					while (!stack.isEmpty() && precedence(stack.top()) >= precedence(element)) {
						result += stack.pop();
					}
					stack.push(element);
				}
			}
		}
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
			}
}