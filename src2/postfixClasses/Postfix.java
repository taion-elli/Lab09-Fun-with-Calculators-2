package postfixClasses;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Postfix {
	
	static boolean falseChars;
	
	public Postfix() {
		super();
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Postfix p = new Postfix();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Infix: " );
			String ix = reader.readLine();
			
				String ixPx = p.infixToPostfix(ix);
				
				int inputResult = p.evaluate(ixPx);
				System.out.println("The value of this expression is: " + inputResult);
			}
							
					
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		/*String s = p.infixToPostfix("1+2*3");
		System.out.println(s);
		int f = p.evaluate("123*+");
		System.out.println(f);*/
	}
	
	public int evaluate (String pfx) throws IOException{
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
	
	public String infixToPostfix(String infix) throws IOException {
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