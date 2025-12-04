package cafe2;

import javax.swing.JOptionPane;
import model.AdminReyven;

public class ForgotFrame extends javax.swing.JFrame {

    AdminReyven sea = new AdminReyven();

    public ForgotFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jTextUser = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabelQuestion = new javax.swing.JLabel();
        jTextQuestion = new javax.swing.JTextField();
        jLabelAnswer = new javax.swing.JLabel();
        jTextAnswer = new javax.swing.JTextField();
        jLabelNewPass = new javax.swing.JLabel();
        jPasswordFieldNew = new javax.swing.JPasswordField();
        jButtonReset = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.setBackground(new java.awt.Color(75, 56, 50));

        jLabelClose.setText("X");
        jLabelClose.setFont(new java.awt.Font("Segoe UI", 1, 28));
        jLabelClose.setForeground(java.awt.Color.WHITE);
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        jPanel1.add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 40, -1));

        jLabelTitle.setFont(new java.awt.Font("Times New Roman", 1, 28));
        jLabelTitle.setForeground(java.awt.Color.WHITE);
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Recover Password");
        jPanel1.add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 240, -1));

        jLabelUser.setFont(new java.awt.Font("Times New Roman", 1, 16));
        jLabelUser.setForeground(java.awt.Color.WHITE);
        jLabelUser.setText("Username:");
        jPanel1.add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jTextUser.setFont(new java.awt.Font("Times New Roman", 0, 16));
        jPanel1.add(jTextUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 280, 32));

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(evt -> searchUser());
        jPanel1.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 280, 32));

        jLabelQuestion.setFont(new java.awt.Font("Times New Roman", 1, 16));
        jLabelQuestion.setForeground(java.awt.Color.WHITE);
        jLabelQuestion.setText("Security Question:");
        jPanel1.add(jLabelQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jTextQuestion.setFont(new java.awt.Font("Times New Roman", 0, 16));
        jTextQuestion.setEditable(false);
        jPanel1.add(jTextQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 280, 32));

        jLabelAnswer.setFont(new java.awt.Font("Times New Roman", 1, 16));
        jLabelAnswer.setForeground(java.awt.Color.WHITE);
        jLabelAnswer.setText("Answer:");
        jPanel1.add(jLabelAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jTextAnswer.setFont(new java.awt.Font("Times New Roman", 0, 16));
        jPanel1.add(jTextAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 280, 32));

        jLabelNewPass.setFont(new java.awt.Font("Times New Roman", 1, 16));
        jLabelNewPass.setForeground(java.awt.Color.WHITE);
        jLabelNewPass.setText("New Password:");
        jPanel1.add(jLabelNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jPasswordFieldNew.setFont(new java.awt.Font("Times New Roman", 0, 16));
        jPanel1.add(jPasswordFieldNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 280, 32));

        jButtonReset.setText("Reset Password");
        jButtonReset.addActionListener(evt -> resetPassword());
        jPanel1.add(jButtonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 280, 35));

        jButtonBack.setText("Back");
        jButtonBack.addActionListener(evt -> {
            new LoginFrame().setVisible(true);
            setVisible(false);
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 100, 32));

        add(jPanel1);
        pack();
        setLocationRelativeTo(null);
    }

    private void searchUser() {
        String user = jTextUser.getText().trim();

        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter username.");
            return;
        }

        if (!sea.isAdminNameExist(user)) {
            JOptionPane.showMessageDialog(this, "User not found.");
            return;
        }

        String question = sea.getSecurityQuestion(user);
        if (question != null) {
            jTextQuestion.setText(question);
        }
    }

    private void resetPassword() {
        String user = jTextUser.getText().trim();
        String q = jTextQuestion.getText().trim();
        String ans = jTextAnswer.getText().trim();
        String newPass = String.valueOf(jPasswordFieldNew.getPassword()).trim();

        if (user.isEmpty() || q.isEmpty() || ans.isEmpty() || newPass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete all fields.");
            return;
        }

        if (!sea.verifySecurity(user, q, ans)) {
            JOptionPane.showMessageDialog(this, "Incorrect answer.");
            return;
        }

        if (sea.updatePassword(user, newPass)) {
            JOptionPane.showMessageDialog(this, "Password updated successfully!");
            new LoginFrame().setVisible(true);
            this.setVisible(false);
        }
    }
    // dragging window

    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JLabel jLabelAnswer;
    private javax.swing.JLabel jLabelNewPass;
    private javax.swing.JTextField jTextUser;
    private javax.swing.JTextField jTextQuestion;
    private javax.swing.JTextField jTextAnswer;
    private javax.swing.JPasswordField jPasswordFieldNew;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonBack;
}
