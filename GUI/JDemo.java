import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GFG Website Click");
        frame.setSize(250, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        JLabel username = new JLabel("Username: ", SwingConstants.CENTER);
        JTextField user = new JTextField(10);
        frame.add(username);
        frame.add(user);

        JLabel email = new JLabel("Email: ", SwingConstants.CENTER);
        JTextField emailAdress = new JTextField(10);
        frame.add(email);
        frame.add(emailAdress);

        JTextArea welcome = new JTextArea(2, 20);
        welcome.setEditable(false);
        frame.add(welcome);

        JButton register = new JButton("Log in");
        register.setBounds(100, 50, 50, 50);

        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                welcome.setText("Welcome!\nLet us get you started.");
            }
        });

        frame.add(register);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(100, 101, 50, 50);
        frame.add(cancel);

        JLabel language = new JLabel("Select preferred language: ");
        language.setBounds(100, 150, 50, 50);
        frame.add(language);

        JCheckBox usEnglish = new JCheckBox("US English");
        language.setBounds(100, 150, 50, 50);
        frame.add(usEnglish);

        JCheckBox ukEnglish = new JCheckBox("UK English");
        language.setBounds(100, 150, 50, 50);
        frame.add(ukEnglish);

        JCheckBox mandarin = new JCheckBox("Mandarin");
        language.setBounds(100, 150, 50, 50);
        frame.add(mandarin);

        JCheckBox hindi = new JCheckBox("Hindi");
        language.setBounds(100, 150, 50, 50);
        frame.add(hindi);

        frame.setVisible(true);

    }
}