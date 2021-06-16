/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Calculator
{
    private CalcEngineString engine;
    private UserInterface gui;
    
    public static void main(String[] args) {
    	Calculator c = new Calculator();
    }

    /**
     * Create a new calculator and show it.
     */
    public Calculator()
    {
        engine = new CalcEngineString();
        gui = new StringUserInterface(engine);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    }
}
