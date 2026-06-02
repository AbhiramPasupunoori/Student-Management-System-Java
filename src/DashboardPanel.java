import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {

        setBackground(
                new Color(
                        245,247,250));

        JLabel title =
                new JLabel(
                        "Dashboard");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30));

        add(title);
    }
}