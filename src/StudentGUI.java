import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentGUI extends JFrame {
    
    private StudentManager manager = new StudentManager();
    JTextField idField, nameField, ageField, emailField, courseField;
    JButton addButton, searchButton, viewButton, updateButton, deleteButton, clearButton;
    JTable table;
    DefaultTableModel model;

    public StudentGUI() {

        setTitle("Student Management System");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 8, 8));

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Course:"));
        courseField = new JTextField();
        inputPanel.add(courseField);

        addButton = new JButton("Add Student");
        searchButton = new JButton("Search Student");
        viewButton = new JButton("View Students");
        updateButton = new JButton("Update Student");
        deleteButton = new JButton("Delete Student");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 8, 8));
        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        JPanel topPanel = new JPanel(new BorderLayout(8, 8));
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        String[] columnNames = {"ID", "Name", "Age", "Email", "Course"};

        model = new DefaultTableModel(columnNames, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        clearButton = new JButton("Clear Fields");

        setLayout(new BorderLayout(12, 12));

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(clearButton, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String id = idField.getText();
                String name = nameField.getText();
                String age = ageField.getText();
                String email = emailField.getText();
                String course = courseField.getText();

                if (id.isEmpty() || name.isEmpty() ||
                    age.isEmpty() || course.isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Please fill all fields.");
                    }
                    else {
                        Student student = new Student(Integer.parseInt(id), name, email, Integer.parseInt(age), course);
                        manager.addStudent(student);
                        model.addRow(new Object[] {student.getId(), student.getName(), student.getAge(), student.getEmail(), student.getCourse()});
                        JOptionPane.showMessageDialog(null, "Student added successfully!");
                        clearFields();
                    }
                }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table.getSelectedRow();

                if (selectedRow >= 0) {
                    int id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                    if (manager.deleteStudent(id)) {
                        model.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Student deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found in manager.");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Select a row first");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idText = idField.getText();
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter an ID to search.");
                    return;
                }
                try {
                    int id = Integer.parseInt(idText);
                    Student student = manager.searchStudent(id);
                    if (student != null) {
                        nameField.setText(student.getName());
                        ageField.setText(String.valueOf(student.getAge()));
                        emailField.setText(student.getEmail());
                        courseField.setText(student.getCourse());
                        JOptionPane.showMessageDialog(null, "Student found. Fields populated.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID must be a valid number.");
                }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idText = idField.getText();
                String name = nameField.getText();
                String ageText = ageField.getText();
                String email = emailField.getText();
                String course = courseField.getText();

                if (idText.isEmpty() || name.isEmpty() || ageText.isEmpty() || course.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields before updating.");
                    return;
                }
                try {
                    int id = Integer.parseInt(idText);
                    int age = Integer.parseInt(ageText);
                    boolean updated = manager.updateStudent(id, name, email, age, course);
                    if (updated) {
                        refreshTable();
                        JOptionPane.showMessageDialog(null, "Student updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID and age must be valid numbers.");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        setVisible(true);
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (Student student : manager.getStudents()) {
            model.addRow(new Object[] {
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail(),
                student.getCourse()
            });
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        emailField.setText("");
        courseField.setText("");
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}