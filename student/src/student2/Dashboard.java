package student2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {

    private JFrame frame;
    private JTextField textFieldLoanType;
    private JTextField textFieldLoanAmount;
    private JTextField textFieldLoanTenure;
    private JTextField textFieldInterestRate;
    private JTextField textFieldUID; // Added UID TextField

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Dashboard window = new Dashboard("username123"); // Example username, replace with real username
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Dashboard(String username) {
        initialize(username); // Pass username to initialize
    }

    private void initialize(String username) {
        frame = new JFrame();
        frame.setBounds(100, 100, 920, 671);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("LOAN PAGE");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTitle.setBounds(386, 49, 111, 43);
        frame.getContentPane().add(lblTitle);

        // Loan Fields
        JLabel lblLoanType = new JLabel("LOAN TYPE:");
        lblLoanType.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblLoanType.setBounds(272, 150, 111, 43);
        frame.getContentPane().add(lblLoanType);

        textFieldLoanType = new JTextField();
        textFieldLoanType.setColumns(10);
        textFieldLoanType.setBounds(422, 157, 170, 33);
        frame.getContentPane().add(textFieldLoanType);

        JLabel lblLoanAmount = new JLabel("LOAN AMOUNT:");
        lblLoanAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblLoanAmount.setBounds(272, 222, 140, 43);
        frame.getContentPane().add(lblLoanAmount);

        textFieldLoanAmount = new JTextField();
        textFieldLoanAmount.setColumns(10);
        textFieldLoanAmount.setBounds(422, 229, 170, 33);
        frame.getContentPane().add(textFieldLoanAmount);

        JLabel lblLoanTenure = new JLabel("LOAN TENURE:");
        lblLoanTenure.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblLoanTenure.setBounds(272, 308, 140, 43);
        frame.getContentPane().add(lblLoanTenure);

        textFieldLoanTenure = new JTextField();
        textFieldLoanTenure.setColumns(10);
        textFieldLoanTenure.setBounds(422, 318, 170, 33);
        frame.getContentPane().add(textFieldLoanTenure);

        JLabel lblInterestRate = new JLabel("INTEREST RATE:");
        lblInterestRate.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblInterestRate.setBounds(272, 383, 140, 43);
        frame.getContentPane().add(lblInterestRate);

        textFieldInterestRate = new JTextField();
        textFieldInterestRate.setColumns(10);
        textFieldInterestRate.setBounds(422, 390, 170, 33);
        frame.getContentPane().add(textFieldInterestRate);

        // Adding UID text field
        JLabel lblUID = new JLabel("UID:");
        lblUID.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUID.setBounds(717, 49, 111, 30);
        frame.getContentPane().add(lblUID);

        textFieldUID = new JTextField();
        textFieldUID.setEditable(false); // Make the UID field read-only
        textFieldUID.setBounds(717, 80, 111, 30);
        frame.getContentPane().add(textFieldUID);

        // Set the UID field to the passed username
        textFieldUID.setText(username);

        JButton btnApply = new JButton("APPLY");
        btnApply.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnApply.setBounds(425, 481, 122, 33);
        btnApply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String loanType = textFieldLoanType.getText();
                String loanAmount = textFieldLoanAmount.getText();
                String loanTenure = textFieldLoanTenure.getText();
                String interestRate = textFieldInterestRate.getText();

                // Handle form submission
                if (loanType.isEmpty() || loanAmount.isEmpty() || loanTenure.isEmpty() || interestRate.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Save data to DB and File, then open StudentDetailsFrame
                    DatabaseUtil.saveLoanData(loanType, loanAmount, loanTenure, interestRate, username);
                    FileUtil.saveToFile(loanType, loanAmount, loanTenure, interestRate, username);
                    openStudentDetailsFrame(loanType, loanAmount, loanTenure, interestRate);
                }
            }
        });
        frame.getContentPane().add(btnApply);
    }

    // Open the StudentDetailsFrame with loan data
    private void openStudentDetailsFrame(String loanType, String loanAmount, String loanTenure, String interestRate) {
        StudentDetailsFrame detailsFrame = new StudentDetailsFrame(loanType, loanAmount, loanTenure, interestRate);
        detailsFrame.setVisible(true);
        frame.dispose(); // Close the current frame
    }

    // Get the frame of this application
    public JFrame getFrame() {
        return frame;
    }
}
