package LAB_6;
                                                // Simple Calculator app
import javax.swing.*;                           // ver 1.0
import java.awt.*;                              // Credits to Mateusz Warzecha
import java.util.Objects;                       // github:
                                                // https://github.com/Kurczaczek21/
public class Calculator {

    static double int_1 = Double.NaN;           // value of first variable
    static double int_2 = Double.NaN;           // value of second variable
    static double total = Double.NaN;           // value of result

    static boolean lastInputWasEqual = false;   // last key pressed: "="
    static boolean lastInputWasAction = true;   // last key pressed: "+", "-", "*", "/"
    static boolean dividingByZero = false;      // dividing by zero ERROR
    static boolean hasBeenSolved = true;        // was "=" pressed AFTER inputing: "int_1" , "action" , "int_2"
//                                                 and BEFORE pressing another new NUM key
//                                                 ex:
//                                                 1 + 2 - 6 = 3 - 6 =  -6 like on normal calculator
//                                                 There is NO NEED to press "=" after every math operation

    static String action = "none";              // current action: "none", "+", "-", "*", "/"
    static String answer;                       // String value of total ( unnecessary, but I want it )

    public static void createAndShowGUI() {

        // DISPLAY PANEL
        GridBagConstraints gbc = new GridBagConstraints();           // Creates a GridBagConstraint object
        gbc.gridwidth = GridBagConstraints.REMAINDER;                // Specifies that this component is the last component in its column or row.
        JTextField field = new JTextField(12);               // Creates JTextField for 12 long characters
        field.setFont(new Font("Arial", Font.BOLD, 24));  // Font settings
        field.setHorizontalAlignment(JTextField.RIGHT);              // Set text adjust to right side of screen
        field.setEditable(false);                                 // Disabling Input from Keyboard
        field.setText("0");                                         // Setting text on screen


        // BUTTON PANEL
        JPanel panel = new JPanel();                                    // Creates new JPanel
        panel.setPreferredSize(new Dimension(300, 150));     // Set Panel size
        panel.setBackground(Color.lightGray);                           // Set background colour
        panel.setLayout(new GridLayout(4, 4, 6, 6));  // Set mesh layout for buttons on panel


        // BUTTON SETTINGS
        JButton button1 = new JButton("1");                     // creating numeric Buttons
        numKeyAction(field, button1);                               // adding Button functionality via method

        JButton button2 = new JButton("2");
        numKeyAction(field, button2);

        JButton button3 = new JButton("3");
        numKeyAction(field, button3);

        JButton button4 = new JButton("4");
        numKeyAction(field, button4);

        JButton button5 = new JButton("5");
        numKeyAction(field, button5);

        JButton button6 = new JButton("6");
        numKeyAction(field, button6);

        JButton button7 = new JButton("7");
        numKeyAction(field, button7);

        JButton button8 = new JButton("8");
        numKeyAction(field, button8);

        JButton button9 = new JButton("9");
        numKeyAction(field, button9);

        JButton buttonZero = new JButton("0");
        buttonZero.addActionListener(e -> {
            if (lastInputWasAction) {                     // check if it's used after action Button
                field.setText("");
            }
            if (lastInputWasEqual) {                      // check if it's used after "="
                field.setText("");
                int_1 = Double.NaN;                     // setting default value of int_1
                int_2 = Double.NaN;                     // setting default value of int_2
                action = "none";                        // setting default value of action
                hasBeenSolved = true;                   // setting default value of hasBeenSolved
            }
            if (!field.getText().startsWith("0")) {      // if statement to PREVENT spamming zeros before int value
                field.setText(field.getText().concat(buttonZero.getText()));
            }
            lastInputWasAction = false;                 // last input was number -> NOT action -> false
            lastInputWasEqual = false;                  // last input was number -> NOT equal -> false
        });
        buttonZero.setFocusable(false);                 // removing this weird frame after button click
        buttonZero.setFont(new Font("Calabi", Font.PLAIN, 23));


        // EQUATION BUTTON
        JButton buttonEquals = new JButton("=");            // creating new Object
        buttonEquals.addActionListener(e -> {                   // overriding method
            if (lastInputWasEqual) {                            // Checking if "=" was used again to repeat last
                int_1 = Double.parseDouble(field.getText());    // action and setting output as int_1
            } else {
                int_2 = Double.parseDouble(field.getText());
            }

            switch (action) {                                   // choosing right math operation
                case "+" -> total = int_1 + int_2;
                case "-" -> total = int_1 - int_2;
                case "*" -> total = int_1 * int_2;
                case "/" -> {
                    if (int_2 != 0) {                           // dividing by zero check
                        total = int_1 / int_2;
                    } else {
                        dividingByZero = true;
                    }
                }
                case "none" -> total = Double.parseDouble(field.getText());     // No action sign - just spamming "="
            }                                                                   // button with 1 inputted value
            if ((total % 1) == 0) {                             // removing .0 ending from Double if possible
                answer = String.valueOf((int) total);
            } else {
                answer = String.valueOf(total);
            }
            if (!dividingByZero) {                              // dividing by zero error
                field.setText(answer);
            } else {
                field.setText("ERROR");
                dividingByZero = false;
            }
            lastInputWasEqual = true;                           // last input was "=" -> equal -> true
            lastInputWasAction = false;                         // last input was "=" -> NOT action -> false
            hasBeenSolved = true;                               // last input was number -> task solved -> true
        });
        buttonEquals.setFocusable(false);                       // removing this weird frame after button click
        buttonEquals.setFont(new Font("Calabi", Font.PLAIN, 23));


        JButton buttonClear = new JButton("C");
        buttonClear.addActionListener(e -> {
            int_1 = Double.NaN;                                 // setting default value of int_1
            int_2 = Double.NaN;                                 // setting default value of int_2
            field.setText("0");                                 // setting default value of display
            action = "none";                                    // setting default value of action
            hasBeenSolved = true;                               // setting default value of hasBeenSolved
        });
        buttonClear.setFocusable(false);                        // removing this weird frame after button click
        buttonClear.setFont(new Font("Calabi", Font.BOLD, 23));

        // MATH OPERATION BUTTONS

        JButton buttonAdd = new JButton("+");               // Creating Math operation Buttons
        mathKeyAction(field, buttonEquals, buttonAdd);           // adding Button functionality via method

        JButton buttonSubtract = new JButton("-");
        mathKeyAction(field, buttonEquals, buttonSubtract);

        JButton buttonMultiplicative = new JButton("*");
        mathKeyAction(field, buttonEquals, buttonMultiplicative);

        JButton buttonDivision = new JButton("/");
        mathKeyAction(field, buttonEquals, buttonDivision);

        // adding buttons to Panel Via weird InteliJ solution XD
        buttonToPanel(panel, button1, button2, button3, button4, button5, button6, buttonAdd, buttonSubtract);
        buttonToPanel(panel, button7, button8, button9, buttonZero, buttonEquals, buttonClear, buttonMultiplicative, buttonDivision);

        // MAIN FRAME
        JFrame frame = new JFrame(" Calculator kurczaka");      // setting name
        ImageIcon image = new ImageIcon("kalkulator.png");  // upload icon
        frame.setIconImage(image.getImage());                       // set icon
        frame.setVisible(true);                                     // set visability of frame
        frame.setSize(350, 255);                        // set size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       // closing frame will cause end of the program
        frame.setResizable(false);                                  // cant resize window -> const size
        frame.getContentPane().setBackground(Color.DARK_GRAY);      // set background colour
        frame.setLayout(new FlowLayout());                          // set layout
        frame.setLocationRelativeTo(null);                          // Display on center of the screen
        frame.add(field, gbc);                                      // add text field
        frame.add(panel);                                           // add button panel
    }

    private static void numKeyAction(JTextField field, JButton button) {
        button.addActionListener(evt -> {
            if (lastInputWasAction) {                   // check if last input was action to clear
                field.setText("");                      // text field before new input
            }
            if (lastInputWasEqual) {                    // check if last input was "=" to set default settings
                field.setText("");                      // alternative:
                int_1 = Double.NaN;                     // buttonZero.doClick but this looks better
                int_2 = Double.NaN;
                action = "none";
                hasBeenSolved = true;
            }
            if (field.getText().equals("0")) {          // deleting 0 from beginning of number
                field.setText("");                      // instead 04 -> 4
            }
            field.setText(field.getText().concat(button.getText()));    // insert your input at the end of text field
            lastInputWasAction = false;                 // last input was number -> NOT action -> false
            lastInputWasEqual = false;                  // last input was number -> NOT equal -> false
        });
        button.setFocusable(false);                     // removing this weird frame after button click
        button.setFont(new Font("Calabi", Font.PLAIN, 23));
    }

    private static void mathKeyAction(JTextField field, JButton buttonEquals, JButton button) {
        button.addActionListener(e -> {
            if (Objects.equals(action, button.getText()) && lastInputWasAction) {
                return;                                         // check if same action button was pressed again
            }                                                   // if TRUE do nothing -> return
            if (!hasBeenSolved && !lastInputWasAction) {        // check if its situation 12 + 4 <CURRENTLY PRESSED BUTTON>
                buttonEquals.doClick();                         // if TRUE do "=" task to get result and do another operation
                hasBeenSolved = true;                           // previous task solved -> true
            }
            int_1 = Double.parseDouble(field.getText());        // set variable
            action = button.getText();                       // set current operation
            if (!lastInputWasAction) {                          // check if last button pressed was operator
                hasBeenSolved = false;                          // if FALSE task is NOT solved -> operator OVERRIDE
            }
            lastInputWasEqual = false;                          // last input was action -> NOT equal -> false
            lastInputWasAction = true;                          // last input was action -> action -> true
        });
        button.setFocusable(false);                          // removing this weird frame after button click
        button.setFont(new Font("Calabi", Font.PLAIN, 23));
    }


    private static void buttonToPanel(JPanel panel, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton button6, JButton buttonAdd, JButton buttonSubtract) {
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonAdd);                                   // inteliJ solution - idk if its worth bcs it looks UGLY!
        panel.add(button4);                                     // and benefit is code shorter by a few lines
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonSubtract);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();                             // RUN calculator
            }
        });
    }
}
