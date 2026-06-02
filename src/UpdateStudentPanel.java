import javax.swing.*;
import java.awt.*;

public class UpdateStudentPanel extends JPanel {

    public UpdateStudentPanel(MainFrame frame) {
        setLayout(new BorderLayout(10,10));
        JPanel form = new JPanel(new GridLayout(6,2,10,10));
        form.setBorder(BorderFactory.createEmptyBorder(24,24,24,24));

        form.add(new JLabel("Student ID to update:"));
        JTextField idField = new JTextField();
        form.add(idField);

        form.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        form.add(nameField);

        form.add(new JLabel("Age:"));
        JTextField ageField = new JTextField();
        form.add(ageField);

        form.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        form.add(emailField);

        form.add(new JLabel("Course:"));
        JTextField courseField = new JTextField();
        form.add(courseField);

        JButton loadBtn = new JButton("Load");
        JButton updateBtn = new JButton("Update");
        JButton backBtn = new JButton("Back");

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottom.add(loadBtn);
        bottom.add(updateBtn);
        bottom.add(backBtn);

        add(form, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);

        loadBtn.addActionListener(e -> {
            String text = idField.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an ID to load.", "Input Required", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                int id = Integer.parseInt(text);
                Student s = frame.getManager().searchStudent(id);
                if (s != null) {
                    nameField.setText(s.getName());
                    ageField.setText(String.valueOf(s.getAge()));
                    emailField.setText(s.getEmail());
                    courseField.setText(s.getCourse());
                } else {
                    JOptionPane.showMessageDialog(this, "No student found with ID " + id);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        updateBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                String course = courseField.getText().trim();

                boolean updated = frame.getManager().updateStudent(id, name, email, age, course);
                if (updated) {
                    JOptionPane.showMessageDialog(this, "Student updated successfully.");
                    // refresh view panel if present
                    for (Component c : frame.getMainContainer().getComponents()) {
                        if (c instanceof ViewStudentPanel) {
                            ((ViewStudentPanel) c).loadStudents(frame);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No student found with ID " + id, "Update Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for ID and Age.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backBtn.addActionListener(e -> {
            frame.showPage("DASHBOARD");
        });
    }
}
