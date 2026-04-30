package javaapplication28;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MotorPHLogin {
    
    public static void main(String[] args) {

        // FRAME
        JFrame frame = new JFrame("MotorPH Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setMinimumSize(new Dimension(900, 500));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(1, 2));
        frame.setResizable(true);
        
        // ================= LEFT PANEL =================
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(null);

        // LOGO (FIXED)
        ImageIcon originalIcon = new ImageIcon(
        MotorPHLogin.class.getResource("/javaapplication28/myLogo.png")
        );

        // Logo Scaling
        Image scaledImage = originalIcon.getImage().getScaledInstance(
            80, 80, Image.SCALE_SMOOTH
        );

        ImageIcon logoIcon = new ImageIcon(scaledImage);

        JLabel logo = new JLabel(logoIcon);
        logo.setBounds(40, 20, 80, 80);

        leftPanel.add(logo);

        // TITLE
        JLabel title = new JLabel("Welcome back");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setBounds(40, 100, 300, 30);
        leftPanel.add(title);

        JLabel subtitle = new JLabel("Please enter your details");
        subtitle.setForeground(Color.GRAY);
        subtitle.setBounds(40, 130, 300, 20);
        leftPanel.add(subtitle);

        // USERNAME
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(40, 170, 100, 20);
        leftPanel.add(userLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(40, 195, 300, 35);
        leftPanel.add(usernameField);

        // PASSWORD
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(40, 240, 100, 20);
        leftPanel.add(passLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(40, 265, 300, 35);
        leftPanel.add(passwordField);

        // LOGIN BUTTON
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(40, 320, 300, 40);
        loginBtn.setBackground(new Color(30, 58, 138));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        leftPanel.add(loginBtn);

        // EXIT BUTTON
        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(40, 370, 300, 40);
        leftPanel.add(exitBtn);    
        
        // ================= RIGHT PANEL =================
       JPanel rightPanel = new JPanel() {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(30, 58, 138),
                getWidth(), getHeight(), new Color(15, 25, 80)
        );

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
};

rightPanel.setLayout(null);
rightPanel.setOpaque(false); 

// ================= TITLE =================
JLabel systemName = new JLabel("MotorPH");
systemName.setForeground(Color.WHITE);
systemName.setFont(new Font("Segoe UI", Font.BOLD, 40));
systemName.setBounds(130, 110, 300, 50); // moved slightly higher
rightPanel.add(systemName);

// ================= SUBTITLE =================
JLabel systemSub = new JLabel("Payroll System");
systemSub.setForeground(new Color(220, 220, 220));
systemSub.setFont(new Font("Segoe UI", Font.PLAIN, 18));
systemSub.setBounds(160, 160, 300, 30); // spacing under title
rightPanel.add(systemSub);

// ================= IMAGE =================
ImageIcon original = new ImageIcon(
    MotorPHLogin.class.getResource("/javaapplication28/icon.png")
);

Image scaled = original.getImage().getScaledInstance(
    160, 160, Image.SCALE_SMOOTH
);

JLabel imageLabel = new JLabel(new ImageIcon(scaled));
imageLabel.setBounds(140, 210, 160, 160);

rightPanel.add(imageLabel);
       

        // ADD PANELS
        frame.add(leftPanel);
        frame.add(rightPanel);
        
        

        // ================= LOGIN LOGIC =================
        String validUsername1 = "employee";
        String validUsername2 = "payroll_staff";
        String validPassword = "12345";

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if ((username.equals(validUsername1) || username.equals(validUsername2))
                        && password.equals(validPassword)) {

                    JOptionPane.showMessageDialog(frame, "Login Successful!");

                    // NEXT: open main menu
                    // frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password");
                }
            }
        });

        exitBtn.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
