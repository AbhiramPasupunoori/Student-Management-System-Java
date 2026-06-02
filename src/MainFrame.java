import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    CardLayout cardLayout;
    JPanel container;

    StudentManager manager;

    public MainFrame() {

        manager = new StudentManager();

        setTitle("Student Management System");
        setSize(1100,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        LoginPanel loginPanel = new LoginPanel(this);
        container.add(loginPanel,"LOGIN");

        add(container);

        setVisible(true);
    }

    public void showPage(String pageName) {
        cardLayout.show(container, pageName);
    }

    public JPanel getMainContainer() {
        return container;
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
