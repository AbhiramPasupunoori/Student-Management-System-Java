import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;
    private SidebarPanel sidebar;

    private StudentManager manager;

    public MainFrame() {

        manager = new StudentManager();

        setTitle("Student Management System");
        setSize(1200,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        sidebar = new SidebarPanel(this);
        DashboardPanel dashboard = new DashboardPanel();

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        LoginPanel loginPanel = new LoginPanel(this);
        contentPanel.add(loginPanel, "LOGIN");
        contentPanel.add(dashboard, "DASHBOARD");

        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        sidebar.setVisible(false);

        setVisible(true);
    }

    public void showPage(String pageName) {
        cardLayout.show(contentPanel, pageName);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void setSidebarVisible(boolean visible) {
        sidebar.setVisible(visible);
        revalidate();
        repaint();
    }

    public StudentManager getManager() {
        return manager;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
