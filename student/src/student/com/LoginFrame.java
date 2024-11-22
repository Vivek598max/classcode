package student.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private static LoginFrame loginFrame;

    public LoginFrame() {
        // Set up the frame
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Load the background image
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\rajku\\eclipse-workspace5\\student\\src\\student\\com\\1069102.jpg")); // Replace with your image path
        background.setLayout(new GridBagLayout()); // Use GridBagLayout for centering components
        add(background);

        // Create a panel for form fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setOpaque(false); // Make the panel transparent

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between components

        // Username label and field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameLabel.setForeground(Color.WHITE); // White text for better contrast

        usernameField = new JTextField(15); // Reduce the size
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);

        // Password label and field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.WHITE);

        passwordField = new JPasswordField(15); // Reduce the size
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(loginButton, gbc);

        // Add formPanel to the background label
        background.add(formPanel);

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (DatabaseHelper.validateLogin(username, password)) {
                    // On successful login, open the student info frame and close the login frame
                    setVisible(false);
                    new StudentInfoFrame().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid Username or Password!");
                }
            }
        });
    }

    public static void main(String[] args) {
        loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}
