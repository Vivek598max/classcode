package student.com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.awt.*;
import java.util.Vector;

public class StudentDetailsFrame extends JFrame {

    private JTable studentDetailsTable;
    private JScrollPane scrollPane;

    public StudentDetailsFrame(String rollNumber, String name) {
        // Set up the frame
        setTitle("Student Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Define table columns
        String[] columns = {"Roll Number", "Name", "Hobbies", "Favourite Subject", "Grades", "Future Goals"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        studentDetailsTable = new JTable(tableModel);
        scrollPane = new JScrollPane(studentDetailsTable);

        // Sample data (in a real application, you may collect this dynamically or from a database)
        String hobbies = "Reading, Traveling";
        String favouriteSubject = "Mathematics";
        String grades = "A";
        String futureGoals = "Software Engineer";

        // Add the data as a row to the table
        Object[] row = {rollNumber, name, hobbies, favouriteSubject, grades, futureGoals};
        tableModel.addRow(row);

        // Add the table to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Save details to a text file
        saveToFile(rollNumber, name, hobbies, favouriteSubject, grades, futureGoals);
    }

    // Method to save student details to a text file
    private void saveToFile(String rollNumber, String name, String hobbies, String favouriteSubject, String grades, String futureGoals) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_details.txt", true))) {
            writer.write("Roll Number: " + rollNumber);
            writer.newLine();
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Hobbies: " + hobbies);
            writer.newLine();
            writer.write("Favourite Subject: " + favouriteSubject);
            writer.newLine();
            writer.write("Grades: " + grades);
            writer.newLine();
            writer.write("Future Goals: " + futureGoals);
            writer.newLine();
            writer.write("-------------------------------------------------");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}