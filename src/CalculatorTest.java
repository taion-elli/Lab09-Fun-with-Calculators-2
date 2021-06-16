import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	private StringUserInterface ui;
	private CalcEngineString eng;
	
	@BeforeEach
	void setUp() {
		eng = new CalcEngineString();
		ui = new StringUserInterface(eng);
	}
	
	@AfterEach
	void delete() {}

	@Test
	void test() throws StackUnderflow {
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
	
	@Test
	void test1() throws StackUnderflow{
		eng.numberPressed("372427");
		eng.numberPressed("42441");
		eng.applyOperator("+");
		eng.applyOperator("*");
		eng.applyOperator("/");
		
		try {
			eng.equals();
		} catch (StackOverflow | StackUnderflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("3", eng.getDisplayString());
	}
	
	@Test
	void test2() throws StackUnderflow{
		eng.numberPressed("53");
		eng.applyOperator("+");
		eng.numberPressed("62");
		eng.applyOperator("/");
		eng.applyOperator("*");
		eng.numberPressed("35");
		eng.applyOperator("*");
		eng.applyOperator("+");
		
		try {
			eng.equals();
		} catch (StackOverflow | StackUnderflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("8", eng.getDisplayString());
	}
	
	@Test
	void test3() throws StackUnderflow{
		eng.numberPressed("874");
		eng.applyOperator("+");
		eng.applyOperator("*");
		eng.numberPressed("42451");
		eng.applyOperator("/");
		eng.numberPressed("49473");
		eng.applyOperator("-");
		eng.numberPressed("2521525");
		eng.applyOperator("*");
		eng.applyOperator("+");
		eng.applyOperator("/");
		try {
			eng.equals();
		} catch (StackOverflow | StackUnderflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("7", eng.getDisplayString());
	}
	
	
}
