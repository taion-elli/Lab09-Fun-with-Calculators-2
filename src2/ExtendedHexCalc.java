import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExtendedHexCalc extends Calculator {
    
    Mode mode;

    public ExtendedHexCalc() {
        super();
        this.mode = Mode.DECIMAL;
        makeHexaPanel();
        changeButtonAction();
    }
    public static void main(String[] args) {
        ExtendedHexCalc c = new ExtendedHexCalc();
        c.show();
    }
    public void makeHexaPanel() {
        JPanel hexaButtonPanel = new JPanel(new GridLayout(4, 2));

        addHexaButtons(hexaButtonPanel, new String[] { "A", "B", "C", "D", "E", "F" });
        addModeOptions(hexaButtonPanel);

        gui.frame.add(hexaButtonPanel, BorderLayout.WEST);
        gui.frame.setSize(600, 300);

    }
    public void addHexaButtons(Container ctn, String[] buttons) {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExtendedHexCalc.this.numberPressed(e.getActionCommand());
                ExtendedHexCalc.this.redisplay();
            }
        };

        for (String caption : buttons) {
            JButton button = new JButton(caption);
            button.addActionListener(action);
            button.setEnabled(this.mode.equals(Mode.HEXA));
            ctn.add(button);
        }
    }
    public void addModeOptions(Container panel) {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();

                if (cmd.equals(Mode.DECIMAL.toString())) {
                    ExtendedHexCalc.this.mode = Mode.DECIMAL;
                } else if (cmd.equals(Mode.HEXA.toString())) {
                    ExtendedHexCalc.this.mode = Mode.HEXA;
                }

                ExtendedHexCalc.this.setHexaButtonsEnabled();
                ExtendedHexCalc.this.setDecimalButtonsEnabled();
                ExtendedHexCalc.this.redisplay();

            }
        };
        ButtonGroup g1 = new ButtonGroup();

        JRadioButton decimal = new JRadioButton(Mode.DECIMAL.toString(), true);
        decimal.addActionListener(action);

        JRadioButton hexa = new JRadioButton(Mode.HEXA.toString(), false);
        hexa.addActionListener(action);

        panel.add(decimal);
        panel.add(hexa);

        g1.add(hexa);
        g1.add(decimal);
    }
    public boolean isDecimalNumber(String command) {
        if (command.equals("0") || command.equals("1") || command.equals("2") || command.equals("3")
                || command.equals("4") || command.equals("5") || command.equals("6") || command.equals("7")
                || command.equals("8") || command.equals("9") || command.equals("+") || command.equals("-") 
                || command.equals("*") || command.equals("/") || command.equals("^")) {
            return true;
        }
        return false;
    }
    public void changeButtonAction() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                if (isDecimalNumber(command)) {
                    ExtendedHexCalc.this.numberPressed(command);
//                } else if (command.equals("+")) {
//                    ExtendedHexCalc.this.engine.plus();
//                } else if (command.equals("-")) {
//                    ExtendedHexCalc.this.engine.minus();
                } else if (command.equals("=")) {
                    ExtendedHexCalc.this.engine.equals();
                } else if (command.equals("C")) {
                    ExtendedHexCalc.this.engine.clear();
//                } else if (command.equals("*")) {
//                    ExtendedHexCalc.this.engine.multiply();
//                } else if (command.equals("/")) {
//                    ExtendedHexCalc.this.engine.devide();
                }
                ExtendedHexCalc.this.redisplay();
            }
        };
        JPanel contentPane = (JPanel) gui.frame.getContentPane();
        JPanel c = (JPanel) contentPane.getComponent(1);
        for (Component button : c.getComponents()) {
            if (button instanceof JButton) {
                ActionListener[] al = ((JButton) button).getActionListeners();
                ((JButton) button).removeActionListener(al[0]);
                ((JButton) button).addActionListener(action);
            }
        }
    }
    public void setDecimalButtonsEnabled() {
        JPanel contentPane = (JPanel) gui.frame.getContentPane();
        JPanel c = (JPanel) contentPane.getComponent(1);
        for (int i = 0; i < c.getComponentCount(); i++) {
            JButton jb = (JButton) c.getComponent(i);
            if (isDecimalNumber(jb.getText())) {
                    jb.setEnabled(true);
                }
            }
    }
    public void setHexaButtonsEnabled() {
        JPanel contentPane = (JPanel) gui.frame.getContentPane();
        JPanel c = (JPanel) contentPane.getComponent(3);
        for (Component button : c.getComponents()) {
            if (button instanceof JButton) {
                button.setEnabled(this.mode.equals(Mode.HEXA));
            }
        }
    }
    public int hexaToDecimal(String hexa) {
        return Integer.parseInt(hexa, 16);
    }
    public String decimalToHexa(String string) {
        return (string);
    }
    public void numberPressed(String command) {
        switch (this.mode) {
        case DECIMAL:
            this.engine.numberPressedStringBuilder((command));
            break;
        case HEXA:
            if (engine.buildingDisplayValue) {
                String combinedHexa = decimalToHexa(engine.getDisplayValue()) + command;
                engine.displayValue = hexaToDecimal(combinedHexa);
            } else {
                engine.displayValue = hexaToDecimal(command);
                engine.buildingDisplayValue = true;
            }
            break;
        default:
            break;
        }
    }
    public void redisplay() {
        switch (this.mode) {
        case DECIMAL:
            gui.display.setText("" + this.engine.getDisplayValue());
            break;
        case HEXA:
            gui.display.setText("" + decimalToHexa(this.engine.getDisplayValue()).toUpperCase());
            break;
        default:
            break;

        }
    }
}
