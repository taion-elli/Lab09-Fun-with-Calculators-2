import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class calcTest {
	
	private UserInterface ui;
	private CalcEngine eng;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

        eng = new CalcEngine();
        ui = new UserInterface(eng);
	}

	@Test
	void test() {

	        eng.numberPressedStringBuilder("34");
	        eng.numberPressedStringBuilder("*");
	        eng.numberPressedStringBuilder("5");
	        eng.numberPressedStringBuilder("6");
	        eng.numberPressedStringBuilder("+");
	        eng.equals();

	        assertEquals("34", eng.getDisplayValue());
	    }	
	@Test
	void test1() {

	        eng.numberPressedStringBuilder("34");
	        eng.numberPressedStringBuilder("+");
	        eng.numberPressedStringBuilder("5");
	        eng.numberPressedStringBuilder("6");
	        eng.numberPressedStringBuilder("*");
	        eng.equals();

	        assertEquals("34", eng.getDisplayValue());
	    }
	@Test 
	void test2() {
    
		eng.numberPressedStringBuilder("39");
		eng.numberPressedStringBuilder("+");
        eng.numberPressedStringBuilder("6");
        eng.numberPressedStringBuilder("*");
		eng.equals();

		assertEquals("57", eng.getDisplayValue());
	}
	@Test 
	void test3() {
    
		eng.numberPressedStringBuilder("123456");
		eng.numberPressedStringBuilder("*");
        eng.numberPressedStringBuilder("+");
        eng.numberPressedStringBuilder("2223");
		eng.equals();

		assertEquals("5", eng.getDisplayValue());
	}
	@Test 
	void test4() {
		
		eng.numberPressedStringBuilder("*");
		assertEquals(2, eng.precedence('*'));
	}
	@Test 
	void test5() {
		
		eng.numberPressedStringBuilder("+");
		assertEquals(1, eng.precedence('+'));
	}
	@Test 
	void test6() {
	    
		eng.numberPressedStringBuilder("12");
		eng.numberPressedStringBuilder("+");
		eng.numberPressedStringBuilder("7");
		eng.numberPressedStringBuilder("*");
	    eng.numberPressedStringBuilder("3");
		eng.numberPressedStringBuilder("*");
		eng.numberPressedStringBuilder("6");
		eng.numberPressedStringBuilder("+");
	    eng.numberPressedStringBuilder("2");
		eng.equals();

		assertEquals("130", eng.getDisplayValue());
	}	
	@Test 
	void test7() {
	    
		eng.numberPressedStringBuilder("12");
		eng.numberPressedStringBuilder("+");
		eng.numberPressedStringBuilder("7");
		eng.numberPressedStringBuilder("*");
		eng.numberPressedStringBuilder("(");
	    eng.numberPressedStringBuilder("3");
		eng.numberPressedStringBuilder("+");
		eng.numberPressedStringBuilder("6");
		eng.numberPressedStringBuilder(")");
		eng.numberPressedStringBuilder("+");
	    eng.numberPressedStringBuilder("2");
		eng.equals();

		assertEquals("67", eng.getDisplayValue());
	}
}


