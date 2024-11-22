package student.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentInfoFrame extends JFrame {

    private JTextField rollNumberField;
    private JTextField nameField;
    private JButton submitButton;

    public StudentInfoFrame() {
        // Set up the frame
        setTitle("Enter Student Information");
        setSize(400, 300);
        setLayout(new GridLayout(3, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Roll number and name fields
        rollNumberField = new JTextField(20);
        nameField = new JTextField(20);
        submitButton = new JButton("Submit");

        // Add components to the frame
        add(new JLabel("Roll Number:"));
        add(rollNumberField);
        add(new JLabel("Name:"));
        add(nameField);
        add(submitButton);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String rollNumber = rollNumberField.getText();
                String name = nameField.getText();
                if (!rollNumber.isEmpty() && !name.isEmpty()) {
                    // On submit, show the student details frame
                    setVisible(false);
                    new StudentDetailsFrame(rollNumber, name).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(StudentInfoFrame.this, "Please fill in all fields!");
                }
            }
        });
    }
}
