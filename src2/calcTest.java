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
	}

	@Test
	void test() {

	        eng = new CalcEngine();
	        ui = new UserInterface(eng);

	        eng.numberPressedStringBuilder("34");
	        eng.numberPressedStringBuilder("*");
	        eng.numberPressedStringBuilder("5");
	        eng.numberPressedStringBuilder("+");
	        eng.equals();

	        assertEquals("23", eng.getDisplayValue());
	    }
	
	void test2() {

		eng = new CalcEngine();
		ui = new UserInterface(eng);
    
		eng.numberPressedStringBuilder("39");
		eng.numberPressedStringBuilder("+");
        eng.numberPressedStringBuilder("6");
        eng.numberPressedStringBuilder("*");
		eng.equals();

		assertEquals("57", eng.getDisplayValue());
	}
	
	void test3() {

		eng = new CalcEngine();
		ui = new UserInterface(eng);
    
		eng.numberPressedStringBuilder("123456");
		eng.numberPressedStringBuilder("*");
        eng.numberPressedStringBuilder("+");
        eng.numberPressedStringBuilder("2223");
		eng.equals();

		assertEquals("5", eng.getDisplayValue());
	}
	
	void test4() throws IOException {

		eng = new CalcEngine();
		ui = new UserInterface(eng);
		String e = "only enter valid numbers and operators!";
		eng.numberPressedStringBuilder("hallo");
		eng.numberPressedStringBuilder("*");
        eng.numberPressedStringBuilder("du");
        eng.numberPressedStringBuilder("+");
		eng.equals();
		
		assertEquals("5", eng.getDisplayValue());
	}
	
}


