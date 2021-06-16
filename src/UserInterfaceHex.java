
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * A user interface for the calculator. It can display Hexadecimal numbers.
 * 
 * @author Elisa and Alexander
 * @version 31/05/2021
 */

public class UserInterfaceHex extends UserInterface {

	private boolean hex;
	private JPanel contentPane;
	private CalcEngine calc2;

	public UserInterfaceHex(CalcEngine engineHex, CalcEngine engineDec) {
		super(engineHex); 
		calc2 = engineDec;
	}
	
	/**
	 * Make a frame that displays the numbers from 0 to F in Hexadecimal and the
	 * same operators from its superclass method
	 * 
	 * @author Elisa and Alexander
	 */
	@Override
	protected void makeFrame() {

		hex = true;
		frame = new JFrame(eng.getTitle());

		contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);

		JPanel buttonPanel = getButtonPenel();
		
		contentPane.add(buttonPanel, BorderLayout.CENTER);

		frame.pack();
	}

	/**
	 * Returns a panel of buttons depending on the status of hex.
	 * 
	 * @author Elisa and Alexander
	 */
	private JPanel getButtonPenel() {
		JPanel buttonPanel;
		if (hex) {
			buttonPanel = new JPanel(new GridLayout(6, 4));
			addButton(buttonPanel, "D");
			addButton(buttonPanel, "E");
			addButton(buttonPanel, "F");
			addButton(buttonPanel, "DEL");

			addButton(buttonPanel, "A");
			addButton(buttonPanel, "B");
			addButton(buttonPanel, "C");
			addButton(buttonPanel, "DEC");

			addButton(buttonPanel, "7");
			addButton(buttonPanel, "8");
			addButton(buttonPanel, "9");
			addButton(buttonPanel, "%");

			addButton(buttonPanel, "4");
			addButton(buttonPanel, "5");
			addButton(buttonPanel, "6");
			addButton(buttonPanel, ":");

			addButton(buttonPanel, "1");
			addButton(buttonPanel, "2");
			addButton(buttonPanel, "3");
			addButton(buttonPanel, "x");

			addButton(buttonPanel, "+");
			addButton(buttonPanel, "0");
			addButton(buttonPanel, "-");
			addButton(buttonPanel, "=");
		} else {	
			buttonPanel = new JPanel(new GridLayout(5, 4));
			addButton(buttonPanel, "7");
			addButton(buttonPanel, "8");
			addButton(buttonPanel, "9");
			addButton(buttonPanel, "%");

			addButton(buttonPanel, "4");
			addButton(buttonPanel, "5");
			addButton(buttonPanel, "6");
			addButton(buttonPanel, ":");

			addButton(buttonPanel, "1");
			addButton(buttonPanel, "2");
			addButton(buttonPanel, "3");
			// add button for *,/,% -Elisa
			addButton(buttonPanel, "x");

			addButton(buttonPanel, "+");
			addButton(buttonPanel, "0");
			addButton(buttonPanel, "-");
			addButton(buttonPanel, "=");

			addButton(buttonPanel, "DEL");
			addButton(buttonPanel, "HEX");
		}
		return buttonPanel;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (hex) {
			if (command.equals("0") || 
				command.equals("1") || 
				command.equals("2") || 
				command.equals("3") || 
				command.equals("4") || 
				command.equals("5") || 
				command.equals("6") || 
				command.equals("7") || 
				command.equals("8") || 
				command.equals("9") || 
				command.equals("A") || 
				command.equals("B") || 
				command.equals("C") || 
				command.equals("D") || 
				command.equals("E") || 
				command.equals("F"))
			{
				// the 16 here makes the method parseInt convert the command from hex -> dec
				int number = Integer.parseInt(command, 16);
				eng.numberPressed(number);
			} 
			else if (command.equals("+")) {
				eng.plus();
			} 
			else if (command.equals("-")) {
				eng.minus();
			}
			// check if * was pressed -Elisa
			else if (command.equals("x")) {
				eng.multiply();
			}
			// check if / was pressed -Elisa
			else if (command.equals(":")) {
				eng.divide();
			}
			// check if % was pressed -Elisa
			else if (command.equals("%")) {
				eng.modulo();
			} 
			else if (command.equals("=")) {
				try {
					eng.equals();
				} catch (StackOverflow | StackUnderflow e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			else if (command.equals("DEL")) {
				eng.clear();
			} 
			else if (command.equals("DEC")) {
				switchSystem();
			}

		} else {
			// super.actionPerformed(event);
			if (command.equals("0") || 
				command.equals("1") || 
				command.equals("2") || 
				command.equals("3") || 
				command.equals("4") || 
				command.equals("5") || 
				command.equals("6") || 
				command.equals("7") || 
				command.equals("8") ||
				command.equals("9")) 
			{
				int number = Integer.parseInt(command);
				calc2.numberPressed(number);
			} 
			else if (command.equals("+")) {
				calc2.plus();
			} else if (command.equals("-")) {
				calc2.minus();
			}
			// check if * was pressed -Elisa
			else if (command.equals("x")) {
				calc2.multiply();
			}
			// check if / was pressed -Elisa
			else if (command.equals(":")) {
				calc2.divide();
			}
			// check if % was pressed -Elisa
			else if (command.equals("%")) {
				calc2.modulo();
			} 
			else if (command.equals("=")) {
				try {
					calc2.equals();
				} catch (StackOverflow | StackUnderflow e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			else if (command.equals("DEL")) {
				calc2.clear();
			}
			else if (command.equals("HEX")) {
				switchSystem();
			}

		}

		redisplay();
	}

	/*
	 * Changes output according to the numeric system.
	 */
	@Override
	protected void redisplay() {
		if (hex) {
			int hexInput = eng.getDisplayValue();
			display.setText("" + Integer.toString(hexInput, 16).toUpperCase());
		} else {
			display.setText("" + calc2.getDisplayValue());
		}
	}

	/**
	 * Switch between the decimal and hexadecimal system.
	 * And change buttons accordingly.
	 * 
	 * @author Elisa and Alexander
	 */
	private void switchSystem() {
		if (hex) {
			contentPane.remove(1);
			hex = false;
			JPanel buttonPanel = getButtonPenel();
			contentPane.add(buttonPanel, BorderLayout.CENTER);
		}	
		else {
			contentPane.remove(1);
			hex = true;
			JPanel buttonPanel = getButtonPenel();
			contentPane.add(buttonPanel, BorderLayout.CENTER);
		}
		contentPane.revalidate();
		contentPane.repaint();
	}

}