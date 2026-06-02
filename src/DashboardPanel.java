import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel(MainFrame frame) {

        setLayout(new BorderLayout());

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(6, 1, 10, 10));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        sidebar.setBackground(new Color(230, 238, 255));

        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Students");
        JButton searchBtn = new JButton("Search Student");
        JButton updateBtn = new JButton("Update Student");
        JButton deleteBtn = new JButton("Delete Student");
        JButton logoutBtn = new JButton("Logout");

        sidebar.add(addBtn);
        sidebar.add(viewBtn);
        sidebar.add(searchBtn);
        sidebar.add(updateBtn);
        sidebar.add(deleteBtn);
        sidebar.add(logoutBtn);

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.WHITE);
        content.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        JLabel title = new JLabel("Dashboard", SwingConstants.CENTER);

        JLabel welcome = new JLabel("Welcome to the Student Management System", SwingConstants.CENTER);
        welcome.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        welcome.setForeground(new Color(60, 70, 90));

        content.add(title, BorderLayout.NORTH);
        content.add(welcome, BorderLayout.CENTER);

        add(sidebar, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);

        addBtn.addActionListener(e -> {
            AddStudentPanel panel = new AddStudentPanel(frame);
            frame.getMainContainer().add(panel, "ADD");
            frame.showPage("ADD");
        });
        viewBtn.addActionListener(e -> {
            ViewStudentPanel panel = new ViewStudentPanel(frame);
            frame.getMainContainer().add(panel, "VIEW");
            frame.showPage("VIEW");
        });
        searchBtn.addActionListener(e -> {
            SearchStudentPanel panel = new SearchStudentPanel(frame);
            frame.getMainContainer().add(panel, "SEARCH");
            frame.showPage("SEARCH");
        });
        updateBtn.addActionListener(e -> {
            UpdateStudentPanel panel = new UpdateStudentPanel(frame);
            frame.getMainContainer().add(panel, "UPDATE");
            frame.showPage("UPDATE");
        });
        deleteBtn.addActionListener(e -> {
            DeleteStudentPanel panel = new DeleteStudentPanel(frame);
            frame.getMainContainer().add(panel, "DELETE");
            frame.showPage("DELETE");
        });
        logoutBtn.addActionListener(e -> {
            frame.showPage("LOGIN");
        });

    }
}