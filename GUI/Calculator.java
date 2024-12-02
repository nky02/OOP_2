import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorWithInstruct {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Register and Calculator");
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel container = new JPanel(cardLayout);

        JPanel registerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel instructLabel = new JLabel("Register to Access Calculator", SwingConstants.CENTER);
        instructLabel.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        registerPanel.add(instructLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        JLabel usernameLabel = new JLabel("Username: ");
        gbc.gridx = 0;
        registerPanel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(15);
        gbc.gridx = 1;
        registerPanel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password: ");
        gbc.gridx = 0;
        gbc.gridy++;
        registerPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        registerPanel.add(passwordField, gbc);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password: ");
        gbc.gridx = 0;
        gbc.gridy++;
        registerPanel.add(confirmPasswordLabel, gbc);

        JPasswordField confirmPasswordField = new JPasswordField(15);
        gbc.gridx = 1;
        registerPanel.add(confirmPasswordField, gbc);

        JButton registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        registerPanel.add(registerButton, gbc);

        JPanel calculatorPanel = new JPanel(new BorderLayout());

        JLabel welcomeLabel = new JLabel("", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        calculatorPanel.add(welcomeLabel, BorderLayout.NORTH);

        JTextField display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setPreferredSize(new Dimension(0, 60));
        calculatorPanel.add(display, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+" };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.setPreferredSize(new Dimension(60, 60));
            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    if (command.matches("\\d")) {
                        display.setText(display.getText() + command);
                    } else if (command.equals("C")) {
                        display.setText("");
                    } else if (command.equals("=")) {
                        try {
                            double result = evaluateExpression(display.getText());
                            display.setText(String.valueOf(result));
                        } catch (Exception ex) {
                            display.setText("Error");
                        }
                    } else {
                        display.setText(display.getText() + " " + command + " ");
                    }
                }
            });
        }

        calculatorPanel.add(buttonPanel, BorderLayout.SOUTH);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled.");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Registration successful!");
                    welcomeLabel.setText("Welcome, " + username + "!");
                    cardLayout.show(container, "Calculator");
                }
            }
        });

        container.add(registerPanel, "Register");
        container.add(calculatorPanel, "Calculator");

        frame.add(container);
        frame.setVisible(true);
    }

    private static double evaluateExpression(String expression) {
        String[] tokens = expression.split(" ");
        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result /= operand;
                    break;
            }
        }
        return result;
    }
}
