import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    public LoginPanel(MainFrame frame) {
        setLayout(new GridBagLayout());
        setBackground(new Color(248, 250, 252));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel title = new JLabel("Welcome");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        JTextField usernameField = new JTextField(15);
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loginBtn = new JButton("Login");
        loginBtn.setPreferredSize(new Dimension(120, 36));
        add(loginBtn, gbc);

        loginBtn.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("admin123")) {
                // create and add dashboard if not already present
                try {
                    Component[] comps = frame.getMainContainer().getComponents();
                    boolean hasDashboard = false;
                    for (Component c : comps) {
                        if (c instanceof DashboardPanel) { hasDashboard = true; break; }
                    }
                    if (!hasDashboard) {
                        DashboardPanel dashboard = new DashboardPanel(frame);
                        frame.getMainContainer().add(dashboard, "DASHBOARD");
                    }
                    frame.showPage("DASHBOARD");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Unable to open dashboard: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

