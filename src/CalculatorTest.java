import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	private StringUserInterface ui;
	private CalcEngineString eng;

	@Test
	void test() throws StackUnderflow {
		eng = new CalcEngineString();
		ui = new StringUserInterface(eng);
		
		eng.numberPressed("123");
		eng.applyOperator("+");
		eng.applyOperator("*");
		try {
			eng.equals();
		} catch (StackOverflow | StackUnderflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("7", eng.getDisplayString());
	}
}
