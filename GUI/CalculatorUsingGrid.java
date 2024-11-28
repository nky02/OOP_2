import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorUsingGrid {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login with Calculator");
        frame.setSize(350, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(usernameLabel, gbc);
        gbc.gridx = 1;
        frame.add(usernameField, gbc);

        JLabel emailLabel = new JLabel("Email: ");
        JTextField emailField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(emailLabel, gbc);
        gbc.gridx = 1;
        frame.add(emailField, gbc);

        JTextArea messageArea = new JTextArea(2, 20);
        messageArea.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(messageArea, gbc);

        JButton loginButton = new JButton("Log in");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        frame.add(loginButton, gbc);

        // Calculator Section (Initially hidden)
        JLabel calcLabel = new JLabel("Simple Calculator");
        calcLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame.add(calcLabel, gbc);

        JTextField num1Field = new JTextField(5);
        num1Field.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        frame.add(num1Field, gbc);

        String[] operations = { "+", "-", "*", "/" };
        JComboBox<String> operatorDropdown = new JComboBox<>(operations);
        operatorDropdown.setVisible(false);
        gbc.gridx = 1;
        frame.add(operatorDropdown, gbc);

        JTextField num2Field = new JTextField(5);
        num2Field.setVisible(false);
        gbc.gridx = 2;
        frame.add(num2Field, gbc);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setVisible(false);
        gbc.gridx = 1;
        gbc.gridy = 6;
        frame.add(calculateButton, gbc);

        JTextArea calcResult = new JTextArea(1, 15);
        calcResult.setEditable(false);
        calcResult.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        frame.add(calcResult, gbc);

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