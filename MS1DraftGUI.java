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

        // ================= ANIMATION VARIABLES =================
        final int[] x = {0};     // moves → right
        final int[] x2 = {300};  // moves ← left

        // ================= RIGHT PANEL =================
        JPanel rightPanel = new JPanel() {

        @Override
        protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // smooth rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        // ================= GRADIENT BACKGROUND =================
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(30, 58, 138),
                getWidth(), getHeight(), new Color(15, 25, 80)
        );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // ================= FLOATING CIRCLES =================

        // Circle 1 (right →)
        g2d.setColor(new Color(255, 255, 255, 30));
        g2d.fillOval(x[0], 220, 150, 150);

        // Circle 2 (mirrored movement)
        g2d.fillOval(getWidth() - x[0] - 200, 80, 100, 100);

        // Circle 3 (left ←)
        g2d.setColor(new Color(255, 255, 255, 20)); // more subtle
        g2d.fillOval(x2[0], 320, 120, 120);
        }
    };

    rightPanel.setLayout(null);
    rightPanel.setOpaque(false);

    // ================= ANIMATION TIMER =================
    Timer animation = new Timer(30, e -> {

    // move right
    x[0] += 1;
    // move left
    x2[0] -= 1;

    // reset when off screen
    if (x[0] > rightPanel.getWidth()) {
        x[0] = -150;
    }

    if (x2[0] < -150) {
        x2[0] = rightPanel.getWidth();
    }

    rightPanel.repaint();
    });

    animation.start();

    rightPanel.setLayout(null);
    rightPanel.setOpaque(false);

    // ================= TITLE =================
JLabel systemName = new JLabel("MotorPH");
systemName.setForeground(Color.WHITE);
systemName.setFont(new Font("Segoe UI", Font.BOLD, 42));
systemName.setBounds(120, 100, 300, 50); // centered better
rightPanel.add(systemName);

// ================= SUBTITLE =================
JLabel systemSub = new JLabel("Payroll System");
systemSub.setForeground(new Color(200, 200, 200));
systemSub.setFont(new Font("Segoe UI", Font.PLAIN, 18));
systemSub.setBounds(150, 150, 300, 30);
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

// ================= HELP BUTTON =================
JButton helpBtn = new JButton("?");

// style
helpBtn.setFocusPainted(false);
helpBtn.setBorderPainted(false);
helpBtn.setForeground(Color.WHITE);
helpBtn.setBackground(new Color(255, 255, 255, 40));
helpBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
helpBtn.setContentAreaFilled(false);
helpBtn.setOpaque(true);

int btnSize = 50;

// hover effect
helpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        helpBtn.setBackground(new Color(255, 255, 255, 80));
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent evt) {
        helpBtn.setBackground(new Color(255, 255, 255, 40));
    }
});

// action
helpBtn.addActionListener(e -> {
    JOptionPane.showMessageDialog(
        null,
        "Need help?\n\nEmail: corporate@motorph.com\nPhone: (028) 911-5071",
        "Support",
        JOptionPane.INFORMATION_MESSAGE
    );
});

// initial temporary placement (won’t matter after resize event)
helpBtn.setBounds(0, 0, btnSize, btnSize);

rightPanel.add(helpBtn);

// FIX POSITION AFTER PANEL IS RENDERED + ON RESIZE
frame.addComponentListener(new java.awt.event.ComponentAdapter() {
    @Override
    public void componentResized(java.awt.event.ComponentEvent evt) {

        int x = rightPanel.getWidth() - btnSize - 20;
        int y = rightPanel.getHeight() - btnSize - 20;

        helpBtn.setBounds(x, y, btnSize, btnSize);
    }
});
       

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
