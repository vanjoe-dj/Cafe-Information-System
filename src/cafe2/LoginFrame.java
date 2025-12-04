package cafe2;

import javax.swing.JOptionPane;
import model.AdminReyven;

public class LoginFrame extends javax.swing.JFrame {

    AdminReyven sea = new AdminReyven();
    int xx, xy;

    public LoginFrame() {
        initComponents();
        jLabelHintHide.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelPass = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();
        jButtonLogin = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextFieldUser = new javax.swing.JTextField();
        jLabelSignText = new javax.swing.JLabel();
        jLabelSignUp = new javax.swing.JLabel();
        jLabelForgot = new javax.swing.JLabel();
        jLabelHintShow = new javax.swing.JLabel();
        jLabelHintHide = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(135, 206, 235, 180));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabelClose.setFont(new java.awt.Font("Segoe UI", 1, 35));
        jLabelClose.setForeground(java.awt.Color.BLACK);
        jLabelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        jPanel1.add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 6, 31, -1));

        jLabelTitle.setFont(new java.awt.Font("Times New Roman", 1, 28));
        jLabelTitle.setForeground(java.awt.Color.BLACK);
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Bembol Cafe");
        jPanel1.add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 230, -1));

        jLabelUser.setFont(new java.awt.Font("Times New Roman", 1, 16));
        jLabelUser.setForeground(java.awt.Color.BLACK);
        jLabelUser.setText("Username:");
        jPanel1.add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 107, -1, -1));

        jLabelPass.setFont(new java.awt.Font("Times New Roman", 1, 16));
        jLabelPass.setForeground(java.awt.Color.BLACK);
        jLabelPass.setText("Password:");
        jPanel1.add(jLabelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jButtonLogin.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(evt -> login());
        jPanel1.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 110, 33));

        jButtonCancel.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(evt -> System.exit(0));
        jPanel1.add(jButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 109, 33));

        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 0, 16));
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 294, 32));

        jLabelHintShow.setText("SHOW");
        jLabelHintShow.setForeground(java.awt.Color.BLACK);
        jLabelHintShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHintShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPassword();
            }
        });
        jPanel1.add(jLabelHintShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 50, 32));

        jLabelHintHide.setText("HIDE");
        jLabelHintHide.setForeground(java.awt.Color.BLACK);
        jLabelHintHide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHintHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidePassword();
            }
        });
        jPanel1.add(jLabelHintHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 50, 32));

        jTextFieldUser.setFont(new java.awt.Font("Times New Roman", 0, 16));
        jPanel1.add(jTextFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 294, 30));

        jLabelSignText.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jLabelSignText.setForeground(java.awt.Color.BLACK);
        jLabelSignText.setText("Don't have an account?");
        jPanel1.add(jLabelSignText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 140, -1));

        jLabelSignUp.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jLabelSignUp.setForeground(java.awt.Color.BLACK);
        jLabelSignUp.setText("Sign UP");
        jLabelSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new Signn().setVisible(true);
                setVisible(false);
            }
        });
        jPanel1.add(jLabelSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 70, -1));

        jLabelForgot.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabelForgot.setForeground(java.awt.Color.BLACK);
        jLabelForgot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelForgot.setText("Forgot Password");
        jLabelForgot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabelForgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, -1, -1));

        // ⭐ FIXED FORGOT PASSWORD CLICK ⭐
        jLabelForgot.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new ForgotPasswordFrame().setVisible(true);
                dispose();
            }
        });

        getContentPane().add(jPanel1);
        pack();
        setLocationRelativeTo(null);
    }

    private void login() {
        if (isEmpty()) return;

        String username = jTextFieldUser.getText().trim();
        String password = String.valueOf(jPasswordField1.getPassword()).trim();

        if (sea.getMaxRowAdminTable() > 0) {

            if (sea.login(username, password)) {
                JOptionPane.showMessageDialog(this, "Login Success!!");
                new HomeFrame().setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Incorrect username or password.",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this,
                    "No admin found. Sign up first!",
                    "Login Failed",
                    JOptionPane.WARNING_MESSAGE);

            new Signn().setVisible(true);
            this.setVisible(false);
        }
    }

    private void showPassword() {
        jPasswordField1.setEchoChar((char) 0);
        jLabelHintShow.setVisible(false);
        jLabelHintHide.setVisible(true);
    }

    private void hidePassword() {
        jPasswordField1.setEchoChar('*');
        jLabelHintShow.setVisible(true);
        jLabelHintHide.setVisible(false);
    }

    public boolean isEmpty() {
        if (jTextFieldUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username is required", "Warning", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        if (String.valueOf(jPasswordField1.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password is required", "Warning", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        return false;
    }

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {
        xx = evt.getX();
        xy = evt.getY();
    }

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
    }

    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelForgot;
    private javax.swing.JLabel jLabelHintHide;
    private javax.swing.JLabel jLabelHintShow;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelSignText;
    private javax.swing.JLabel jLabelSignUp;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldUser;
}
