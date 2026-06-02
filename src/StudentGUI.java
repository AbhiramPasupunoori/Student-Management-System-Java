import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentGUI extends JFrame {
    
    private StudentManager manager = new StudentManager();
    JTextField idField, nameField, ageField, emailField, courseField;
    JButton addButton, searchButton, viewButton, updateButton, deleteButton, clearButton, exitButton;
    JTable table;
    DefaultTableModel model;

    public StudentGUI() {

        setTitle("Student Management System");
        setSize(1100,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.BOTH;

        // Create labels and fields
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel courseLabel = new JLabel("Course:");
        courseField = new JTextField();

        // Top row: ID (left), Name (right)
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 1; gbc.weightx = 0.4;
        inputPanel.add(idLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 2; gbc.weightx = 0.6;
        inputPanel.add(idField, gbc);

        gbc.gridx = 3; gbc.gridy = 0; gbc.gridwidth = 1; gbc.weightx = 0.4;
        inputPanel.add(nameLabel, gbc);
        gbc.gridx = 4; gbc.gridy = 0; gbc.gridwidth = 2; gbc.weightx = 0.6;
        inputPanel.add(nameField, gbc);

        // Middle row: Age centered
        gbc.gridx = 2; gbc.gridy = 1; gbc.gridwidth = 2; gbc.weightx = 1.0;
        inputPanel.add(ageLabel, gbc);
        gbc.gridx = 2; gbc.gridy = 2; gbc.gridwidth = 2; gbc.weightx = 1.0;
        inputPanel.add(ageField, gbc);

        // Bottom row: Email (left), Course (right)
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.weightx = 0.5;
        inputPanel.add(emailLabel, gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.weightx = 0.5;
        inputPanel.add(emailField, gbc);

        gbc.gridx = 3; gbc.gridy = 3; gbc.gridwidth = 2; gbc.weightx = 0.5;
        inputPanel.add(courseLabel, gbc);
        gbc.gridx = 3; gbc.gridy = 4; gbc.gridwidth = 2; gbc.weightx = 0.5;
        inputPanel.add(courseField, gbc);

        addButton = new JButton("Add Student");
        searchButton = new JButton("Search Student");
        viewButton = new JButton("View Students");
        updateButton = new JButton("Update Student");
        deleteButton = new JButton("Delete Student");
        clearButton = new JButton("Clear Fields");
        exitButton = new JButton("Exit");

        Font titleFont = new Font("Segoe UI", Font.BOLD, 28);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 15);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
        Font tableFont = new Font("Segoe UI", Font.PLAIN, 13);
        Font tableHeaderFont = new Font("Segoe UI", Font.BOLD, 14);

        Color backgroundColor = new Color(225, 235, 245);
        Color panelColor = new Color(241, 248, 255);
        Color fieldBackground = Color.WHITE;
        Color fieldForeground = new Color(34, 34, 34);
        Color labelColor = new Color(33, 37, 41);
        Color primaryButton = new Color(52, 152, 219);
        Color successButton = new Color(46, 204, 113);
        Color infoButton = new Color(241, 196, 15);
        Color accentButton = new Color(155, 89, 182);
        Color dangerButton = new Color(231, 76, 60);
        Color neutralButton = new Color(108, 117, 125);

        inputPanel.setBackground(new Color(250, 252, 254));
        inputPanel.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
            )
        );

        // Constrain width so the form appears centered in a wrapper
        inputPanel.setPreferredSize(new Dimension(760, 260));

        for (Component comp : inputPanel.getComponents()) {
            if (comp instanceof JLabel) {
                JLabel lbl = (JLabel) comp;
                lbl.setFont(labelFont);
                lbl.setForeground(labelColor);
                lbl.setHorizontalAlignment(SwingConstants.LEFT);
                String txt = lbl.getText();
                // Mark required fields with a red asterisk
                if (txt.equals("ID:") || txt.equals("Name:") || txt.equals("Age:") || txt.equals("Course:")) {
                    lbl.setText("<html>" + txt + " <span style='color:#d9534f'>*</span></html>");
                }
            }
        }

        idField.setFont(fieldFont);
        nameField.setFont(fieldFont);
        ageField.setFont(fieldFont);
        emailField.setFont(fieldFont);
        courseField.setFont(fieldFont);

        idField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        nameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        ageField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        emailField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        courseField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        idField.setBackground(fieldBackground);
        nameField.setBackground(fieldBackground);
        ageField.setBackground(fieldBackground);
        emailField.setBackground(fieldBackground);
        courseField.setBackground(fieldBackground);

        idField.setForeground(fieldForeground);
        nameField.setForeground(fieldForeground);
        ageField.setForeground(fieldForeground);
        emailField.setForeground(fieldForeground);
        courseField.setForeground(fieldForeground);

        addButton.setFont(buttonFont);
        searchButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
        clearButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        Color primary = new Color(59, 130, 246);      // Blue
        Color success = new Color(16, 185, 129);      // Green
        Color warning = new Color(245, 158, 11);      // Orange
        Color danger = new Color(239, 68, 68);        // Red
        Color secondary = new Color(99, 102, 241);    // Indigo
        Color dark = new Color(31, 41, 55);           // Dark Gray
        Color background = new Color(248, 250, 252);  // Light Gray

        addButton.setForeground(Color.WHITE);
        searchButton.setForeground(Color.WHITE);
        viewButton.setForeground(Color.WHITE);
        updateButton.setForeground(Color.WHITE);
        deleteButton.setForeground(Color.WHITE);
        clearButton.setForeground(Color.WHITE);
        exitButton.setForeground(Color.WHITE);

        for (JButton button : new JButton[]{addButton, searchButton, viewButton, updateButton, deleteButton, clearButton, exitButton}) {
            button.setFont(buttonFont);
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.setPreferredSize(new Dimension(160, 40));
            button.setOpaque(true);
            button.setContentAreaFilled(true);
        }

        // Use darker, more visible colors for buttons
        addButton.setBackground(primary);
        searchButton.setBackground(success);
        viewButton.setBackground(warning);
        updateButton.setBackground(secondary);
        deleteButton.setBackground(danger);
        clearButton.setBackground(dark);
        exitButton.setBackground(dark);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(backgroundColor);
        GridBagConstraints bgc = new GridBagConstraints();
        bgc.insets = new Insets(8, 8, 8, 8);
        bgc.fill = GridBagConstraints.BOTH;
        bgc.weightx = 1.0;

        // Top row: 3 primary buttons
        bgc.gridx = 0; bgc.gridy = 0; bgc.gridwidth = 1;
        buttonPanel.add(addButton, bgc);
        bgc.gridx = 1; buttonPanel.add(searchButton, bgc);
        bgc.gridx = 2; buttonPanel.add(viewButton, bgc);

        // Second row: centered two buttons (update, delete)
        bgc.gridy = 1; bgc.gridx = 0; bgc.gridwidth = 3;
        JPanel mid = new JPanel(new GridLayout(1,3,8,8));
        mid.setOpaque(false);
        mid.add(updateButton);
        mid.add(deleteButton);
        mid.add(new JLabel()); // spacer to keep centered
        buttonPanel.add(mid, bgc);

        JLabel titleLabel = new JLabel("Student Management System", SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(15,23,42));

        // Wrap the input form so it stays centered within the top area
        JPanel formWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        formWrapper.setBackground(backgroundColor);
        formWrapper.add(inputPanel);

        JPanel topPanel = new JPanel(new BorderLayout(8, 8));
        topPanel.setBackground(backgroundColor);
        topPanel.add(formWrapper, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(backgroundColor);
        northPanel.add(titleLabel, BorderLayout.NORTH);
        northPanel.add(topPanel, BorderLayout.CENTER);

        String[] columnNames = {"ID", "Name", "Age", "Email", "Course"};

        model = new DefaultTableModel(columnNames, 0);

        table = new JTable(model);
        table.setFont(tableFont);
        table.setRowHeight(28);
        table.setGridColor(new Color(220, 227, 233));
        table.setSelectionBackground(primaryButton);
        table.setSelectionForeground(Color.WHITE);
        table.setForeground(fieldForeground);
        table.setBackground(Color.WHITE);
        table.setFillsViewportHeight(true);
        table.setIntercellSpacing(new Dimension(0, 1));
        table.setShowGrid(false);
        table.setAutoCreateRowSorter(true);

        table.getTableHeader().setFont(tableHeaderFont);
        table.getTableHeader().setBackground(new Color(30, 41, 59));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setOpaque(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
        bottomPanel.setBackground(backgroundColor);
        bottomPanel.add(clearButton);
        bottomPanel.add(exitButton);

        setLayout(new BorderLayout(12, 12));
        getContentPane().setBackground(backgroundColor);

        add(northPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

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
        
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentGUI();
            }
        });
    }
}