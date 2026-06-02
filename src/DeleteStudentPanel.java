import javax.swing.*;
import java.awt.*;

public class DeleteStudentPanel extends JPanel {

	public DeleteStudentPanel(MainFrame frame) {
		setLayout(new BorderLayout(10,10));
		JPanel form = new JPanel(new GridLayout(2,2,10,10));
		form.setBorder(BorderFactory.createEmptyBorder(24,24,24,24));

		form.add(new JLabel("Student ID to delete:"));
		JTextField idField = new JTextField();
		form.add(idField);

		JButton deleteBtn = new JButton("Delete");
		JButton backBtn = new JButton("Back");

		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		bottom.add(deleteBtn);
		bottom.add(backBtn);

		add(form, BorderLayout.NORTH);
		add(bottom, BorderLayout.SOUTH);

		deleteBtn.addActionListener(e -> {
			String text = idField.getText().trim();
			if (text.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please enter an ID to delete.", "Input Required", JOptionPane.WARNING_MESSAGE);
				return;
			}
			try {
				int id = Integer.parseInt(text);
				boolean deleted = frame.getManager().deleteStudent(id);
				if (deleted) {
					JOptionPane.showMessageDialog(this, "Student deleted successfully.");
					// refresh view panel if present
					for (Component c : frame.getMainContainer().getComponents()) {
						if (c instanceof ViewStudentPanel) {
							((ViewStudentPanel) c).loadStudents(frame);
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "No student found with ID " + id, "Delete Failed", JOptionPane.ERROR_MESSAGE);
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
