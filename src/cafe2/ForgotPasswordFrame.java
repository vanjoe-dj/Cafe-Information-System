package cafe2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import model.MyConnection;

public class ForgotPasswordFrame extends javax.swing.JFrame {

    private Connection con;

    // Components
    private JPanel jPanel1;
    private JLabel jLabelClose, jLabelTitle, jLabelUser, jLabelAns, jLabelNewPass;
    private JTextField txtUser, txtAns;
    private JPasswordField txtNewPass;
    private JButton btnVerify, btnReset, btnCancel;

    public ForgotPasswordFrame() {
        initComponents();
        con = MyConnection.getConnection();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel1.setBackground(new Color(173, 216, 230)); // same as login
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // CLOSE BUTTON (X)
        jLabelClose = new JLabel("X");
        jLabelClose.setFont(new Font("Times New Roman", Font.BOLD, 36));
        jLabelClose.setForeground(Color.BLACK);
        jLabelClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                dispose();
            }
        });
        jPanel1.add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 40, 40));

        // TITLE
        jLabelTitle = new JLabel("Forgot Password");
        jLabelTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
        jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel1.add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 250, 40));

        // USERNAME LABEL
        jLabelUser = new JLabel("Username:");
        jLabelUser.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jPanel1.add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 100, 30));

        // USERNAME FIELD
        txtUser = new JTextField();
        txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 200, 30));

        // SECURITY ANSWER LABEL
        jLabelAns = new JLabel("Security Answer:");
        jLabelAns.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jPanel1.add(jLabelAns, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 120, 30));

        // SECURITY ANSWER FIELD
        txtAns = new JTextField();
        txtAns.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jPanel1.add(txtAns, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 200, 30));

        // NEW PASSWORD LABEL
        jLabelNewPass = new JLabel("New Password:");
        jLabelNewPass.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jLabelNewPass.setEnabled(false);
        jPanel1.add(jLabelNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 120, 30));

        // NEW PASSWORD FIELD
        txtNewPass = new JPasswordField();
        txtNewPass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtNewPass.setEnabled(false);
        jPanel1.add(txtNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 200, 30));

        // VERIFY BUTTON
        btnVerify = new JButton("Verify");
        btnVerify.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jPanel1.add(btnVerify, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 120, 40));

        // RESET BUTTON
        btnReset = new JButton("Reset");
        btnReset.setEnabled(false);
        btnReset.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 120, 40));

        // CANCEL BUTTON
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCancel.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            dispose();
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 330, 120, 40));

        // WINDOW SETTINGS
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(400, 400);
        setLocationRelativeTo(null);
        add(jPanel1);

        // VERIFY BUTTON ACTION
        btnVerify.addActionListener(e -> verifyUser());

        // RESET BUTTON ACTION
        btnReset.addActionListener(e -> resetPassword());
    }

    // VERIFY METHOD
    private void verifyUser() {
        try {
            String user = txtUser.getText();
            String ans = txtAns.getText();

            String sql = "SELECT * FROM admin WHERE username=? AND ans=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, ans);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Verified! Enter your new password.");
                txtNewPass.setEnabled(true);
                btnReset.setEnabled(true);
                jLabelNewPass.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Wrong username or answer!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // RESET PASSWORD METHOD
    private void resetPassword() {
        try {
            String user = txtUser.getText();
            String newPass = new String(txtNewPass.getPassword());

            String sql = "UPDATE admin SET password=? WHERE username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newPass);
            ps.setString(2, user);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Password successfully reset!");
                new LoginFrame().setVisible(true);
                dispose();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
