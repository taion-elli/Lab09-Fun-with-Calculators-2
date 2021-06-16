import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StringUserInterface extends UserInterface {
	
	private static CalcEngineString eng;
	
	private JPanel contentPane;
	
	public StringUserInterface(CalcEngineString engine) {
		super(eng);
		eng = engine;
		makeFrame();
		frame.setVisible(true);
	}
	
	

	@Override 
	protected void makeFrame() {
		frame = new JFrame();
		
		contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);

		JPanel buttonPanel = getButtonPanel();
		
		contentPane.add(buttonPanel, BorderLayout.CENTER);

		frame.pack();
	}

	private JPanel getButtonPanel() {
		JPanel buttonPanel;
		buttonPanel = new JPanel(new GridLayout(5, 4));
		addButton(buttonPanel, "7");
		addButton(buttonPanel, "8");
		addButton(buttonPanel, "9");
		addButton(buttonPanel, "del");

		addButton(buttonPanel, "4");
		addButton(buttonPanel, "5");
		addButton(buttonPanel, "6");
		addButton(buttonPanel, "/");

		addButton(buttonPanel, "1");
		addButton(buttonPanel, "2");
		addButton(buttonPanel, "3");
		addButton(buttonPanel, "*");

		addButton(buttonPanel, "+");
		addButton(buttonPanel, "0");
		addButton(buttonPanel, "-");
		addButton(buttonPanel, "=");
		
		return buttonPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

        if(command.equals("0") ||
           command.equals("1") ||
           command.equals("2") ||
           command.equals("3") ||
           command.equals("4") ||
           command.equals("5") ||
           command.equals("6") ||
           command.equals("7") ||
           command.equals("8") ||
           command.equals("9")) {
           
            eng.numberPressed(command);
        }
        
        else if(command.equals("=")) {
            try {
				eng.equals();
			} catch (StackOverflow | StackUnderflow e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else if(command.equals("del")) {
            eng.clear();
        }
        else if(command.equals("?")) {
            showInfo();
        }
        else {
        	eng.applyOperator(command);
        }
        
        redisplay();
	}
	
	@Override
	protected void redisplay() {
		display.setText("" + eng.getDisplayString());
	}

}
