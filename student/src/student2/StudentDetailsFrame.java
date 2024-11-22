
package student2;

import javax.swing.*;
import java.awt.*;

public class StudentDetailsFrame extends JFrame {

    private JTable studentDetailsTable;
    private JScrollPane scrollPane;

    public StudentDetailsFrame(String loanType, String loanAmount, String loanTenure, String interestRate) {
        // Set up the frame
        setTitle("Loan Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Define table columns
        String[] columns = {"Loan Type", "Loan Amount", "Loan Tenure", "Interest Rate"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        studentDetailsTable = new JTable(tableModel);
        scrollPane = new JScrollPane(studentDetailsTable);

        // Add the loan data as a row to the table
        Object[] row = {loanType, loanAmount, loanTenure, interestRate};
        tableModel.addRow(row);

        // Add the table to the frame
        add(scrollPane, BorderLayout.CENTER);
    }
}
