import javax.swing.*;
import java.awt.*;

public class SearchStudentPanel extends JPanel {

    public SearchStudentPanel(MainFrame frame) {
        setLayout(new BorderLayout(10,10));
        JPanel form = new JPanel(new GridLayout(2,2,10,10));
        form.setBorder(BorderFactory.createEmptyBorder(24,24,24,24));

        form.add(new JLabel("Enter Student ID:"));
        JTextField idField = new JTextField();
        form.add(idField);

        JButton searchBtn = new JButton("Search");
        JButton backBtn = new JButton("Back");

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottom.add(searchBtn);
        bottom.add(backBtn);

        JTextArea resultArea = new JTextArea(6,40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(resultArea);

        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        searchBtn.addActionListener(e -> {
            String text = idField.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an ID to search.", "Input Required", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                int id = Integer.parseInt(text);
                Student student = frame.getManager().searchStudent(id);
                if (student != null) {
                    resultArea.setText("ID: " + student.getId() + "\n" +
                            "Name: " + student.getName() + "\n" +
                            "Age: " + student.getAge() + "\n" +
                            "Email: " + student.getEmail() + "\n" +
                            "Course: " + student.getCourse());
                } else {
                    resultArea.setText("No student found with ID " + id);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backBtn.addActionListener(e -> {
            frame.showPage("DASHBOARD");
        });
    }
}
