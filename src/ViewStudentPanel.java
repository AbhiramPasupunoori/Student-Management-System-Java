import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewStudentPanel extends JPanel {

    private DefaultTableModel model;
    private JTable table;

    public ViewStudentPanel(MainFrame frame) {

        setLayout(new BorderLayout());

        String[] cols = {"ID", "Name", "Age", "Email", "Course"};
        model = new DefaultTableModel(cols, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        JButton backBtn = new JButton("Back");

        add(scrollPane, BorderLayout.CENTER);
        add(backBtn, BorderLayout.SOUTH);

        backBtn.addActionListener(e -> {
            frame.showPage("DASHBOARD");
        });

        // initial load
        loadStudents(frame);
    }

    public void loadStudents(MainFrame frame) {
        // clear existing rows
        model.setRowCount(0);
        ArrayList<Student> students = frame.getManager().getStudents();
        for (Student s : students) {
            model.addRow(new Object[]{s.getId(), s.getName(), s.getAge(), s.getEmail(), s.getCourse()});
        }
    }

}
