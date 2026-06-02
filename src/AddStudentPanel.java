import javax.swing.*;
import java.awt.*;

public class AddStudentPanel extends JPanel {
    
    JTextField idField;
    JTextField nameField;
    JTextField ageField;
    JTextField emailField;
    JTextField courseField;

    public AddStudentPanel(MainFrame frame) {

        setLayout(new BorderLayout(5,10));
        JPanel form = new JPanel(new GridLayout(5,10,2,2));
        form.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        form.add(new JLabel("ID:"));
        idField = new JTextField();
        form.add(idField);

        form.add(new JLabel("Name:"));
        nameField = new JTextField();
        form.add(nameField);

        form.add(new JLabel("Age:"));
        ageField = new JTextField();
        form.add(ageField);

        form.add(new JLabel("Email:"));
        emailField = new JTextField();
        form.add(emailField);

        form.add(new JLabel("Course:"));
        courseField = new JTextField();
        form.add(courseField);

        JButton saveBtn = new JButton("Save");
        JButton backBtn = new JButton("Back");
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(saveBtn);
        buttonPanel.add(backBtn);
        
        add(form, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        saveBtn.addActionListener(e -> {
            try {
                Student student = new Student(
                        Integer.parseInt(idField.getText().trim()),
                        nameField.getText().trim(),
                        emailField.getText().trim(),
                        Integer.parseInt(ageField.getText().trim()),
                        courseField.getText().trim()
                );

                frame.getManager().addStudent(student);

                JOptionPane.showMessageDialog(null, "Student Added");
                // clear fields after save
                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                emailField.setText("");
                courseField.setText("");
                // If ViewStudentPanel is present, refresh its data
                for (Component c : frame.getMainContainer().getComponents()) {
                    if (c instanceof ViewStudentPanel) {
                        ((ViewStudentPanel) c).loadStudents(frame);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for ID and Age.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        backBtn.addActionListener(e -> {
            frame.showPage("DASHBOARD");
        });
    }
    
}
