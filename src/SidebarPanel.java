import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class SidebarPanel extends JPanel {

    public SidebarPanel(MainFrame frame) {

        setPreferredSize(new Dimension(250,0));
        setBackground(new Color(2,32,71));
        setLayout(new GridLayout(8,1,5,5));

        add(createBtn("Dashboard", e -> {
            frame.setSidebarVisible(true);
            showPanel(frame, "DASHBOARD", DashboardPanel.class, DashboardPanel::new);
        }));
        add(createBtn("Add Student", e -> {
            frame.setSidebarVisible(false);
            showPanel(frame, "ADD", AddStudentPanel.class, () -> new AddStudentPanel(frame));
        }));
        add(createBtn("View Students", e -> showPanel(frame, "VIEW", ViewStudentPanel.class, () -> new ViewStudentPanel(frame))));
        add(createBtn("Search Student", e -> showPanel(frame, "SEARCH", SearchStudentPanel.class, () -> new SearchStudentPanel(frame))));
        add(createBtn("Update Student", e -> showPanel(frame, "UPDATE", UpdateStudentPanel.class, () -> new UpdateStudentPanel(frame))));
        add(createBtn("Delete Student", e -> showPanel(frame, "DELETE", DeleteStudentPanel.class, () -> new DeleteStudentPanel(frame))));
        add(createBtn("Logout", e -> {
            frame.setSidebarVisible(false);
            frame.showPage("LOGIN");
        }));
    }

    private JButton createBtn(String text, ActionListener action) {
        JButton btn = new JButton(text);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(2,32,71));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.addActionListener(action);
        return btn;
    }

    private <T extends JPanel> void showPanel(MainFrame frame, String cardName, Class<T> panelClass, Supplier<T> panelSupplier) {
        for (Component c : frame.getContentPanel().getComponents()) {
            if (panelClass.isInstance(c)) {
                frame.showPage(cardName);
                return;
            }
        }
        frame.getContentPanel().add(panelSupplier.get(), cardName);
        frame.showPage(cardName);
    }
}
