import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Login with Calculator");
        frame.setSize(350, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        
        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField(10);
        frame.add(usernameLabel);
        frame.add(usernameField);

        JLabel emailLabel = new JLabel("Email: ");
        JTextField emailField = new JTextField(10);
        frame.add(emailLabel);
        frame.add(emailField);

        JTextArea messageArea = new JTextArea(2, 20);
        messageArea.setEditable(false);
        frame.add(messageArea);

        JButton loginButton = new JButton("Log in");
        frame.add(loginButton);

        // Calculator Section (Initially hidden)
        JLabel calcLabel = new JLabel("Simple Calculator");
        calcLabel.setVisible(false);
        frame.add(calcLabel);

        JTextField num1Field = new JTextField(5);
        num1Field.setVisible(false);
        frame.add(num1Field);

        String[] operations = { "+", "-", "*", "/" };
        JComboBox<String> operatorDropdown = new JComboBox<>(operations);
        operatorDropdown.setVisible(false);
        frame.add(operatorDropdown);

        JTextField num2Field = new JTextField(5);
        num2Field.setVisible(false);
        frame.add(num2Field);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setVisible(false);
        frame.add(calculateButton);

        JTextArea calcResult = new JTextArea(1, 15);
        calcResult.setEditable(false);
        calcResult.setVisible(false);
        frame.add(calcResult);

        // Login Button Action
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String email = emailField.getText().trim();

                if (!username.isEmpty() && !email.isEmpty()) {
                    messageArea.setText("Login Successful! Welcome, " + username + ".");
                    // Show calculator components
                    calcLabel.setVisible(true);
                    num1Field.setVisible(true);
                    operatorDropdown.setVisible(true);
                    num2Field.setVisible(true);
                    calculateButton.setVisible(true);
                    calcResult.setVisible(true);
                } else {
                    messageArea.setText("Login Failed. Please enter valid details.");
                }
            }
        });

        // Calculator Button Action
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText().trim());
                    double num2 = Double.parseDouble(num2Field.getText().trim());
                    String operation = (String) operatorDropdown.getSelectedItem();
                    double result;

                    // Perform the selected operation
                    switch (operation) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 == 0) {
                                calcResult.setText("Error: Division by zero");
                                return;
                            }
                            result = num1 / num2;
                            break;
                        default:
                            calcResult.setText("Invalid Operation");
                            return;
                    }
                    calcResult.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    calcResult.setText("Invalid Input!");
                }
            }
        });

        frame.setVisible(true);
    }
}
