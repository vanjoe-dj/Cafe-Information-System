package cafe2;

import javax.swing.*;
import java.awt.*;

public class Signn extends javax.swing.JFrame {

    int xx, xy;

    public Signn() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelPass = new javax.swing.JLabel();
        jLabelSecQ = new javax.swing.JLabel();
        jLabelSecA = new javax.swing.JLabel();

        jTextFieldID = new javax.swing.JTextField();
        jTextFieldUser = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jComboSecQ = new javax.swing.JComboBox<>();
        jTextFieldSecA = new javax.swing.JTextField();

        jButtonSave = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        // MAIN PANEL
        jPanel1.setBackground(new java.awt.Color(75, 56, 50));  // brown background
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // DRAG WINDOW
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();
                setLocation(x - xx, y - xy);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xx = evt.getX();
                xy = evt.getY();
            }
        });

        // CLOSE BUTTON
        jLabelClose.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabelClose.setForeground(Color.WHITE);
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        jPanel1.add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 40, 40));

        // TITLE
        jLabelTitle.setFont(new java.awt.Font("Times New Roman", 1, 32));
        jLabelTitle.setForeground(Color.WHITE);
        jLabelTitle.setText("Sign up");
        jPanel1.add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        // LABELS
        jLabelID.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabelID.setForeground(Color.WHITE);
        jLabelID.setText("ID:");
        jPanel1.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLabelUser.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabelUser.setForeground(Color.WHITE);
        jLabelUser.setText("Username:");
        jPanel1.add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabelPass.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabelPass.setForeground(Color.WHITE);
        jLabelPass.setText("Password:");
        jPanel1.add(jLabelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabelSecQ.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabelSecQ.setForeground(Color.WHITE);
        jLabelSecQ.setText("Security Option:");
        jPanel1.add(jLabelSecQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabelSecA.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabelSecA.setForeground(Color.WHITE);
        jLabelSecA.setText("Answer:");
        jPanel1.add(jLabelSecA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        // INPUT FIELDS
        jPanel1.add(jTextFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 125, 210, 32));
        jPanel1.add(jTextFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 185, 210, 32));
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 245, 210, 32));

        // COMBO SECURITY QUESTION
        jComboSecQ.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"Your favorite color?", "Your birth city?", "Your pet’s name?"}
        ));
        jPanel1.add(jComboSecQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 305, 210, 32));

        jPanel1.add(jTextFieldSecA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 365, 210, 32));

        // SAVE BUTTON
        jButtonSave.setBackground(new java.awt.Color(237, 226, 219));
        jButtonSave.setFont(new java.awt.Font("Times New Roman", 1, 16));
        jButtonSave.setText("Save");
        jPanel1.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 120, 40));

        // BACK BUTTON
        jButtonBack.setBackground(new java.awt.Color(237, 226, 219));
        jButtonBack.setFont(new java.awt.Font("Times New Roman", 1, 16));
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(evt -> {
            new LoginFrame().setVisible(true);
            this.setVisible(false);
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 120, 40));

        // SIZE
        getContentPane().add(jPanel1);
        setSize(480, 520);
        setLocationRelativeTo(null);
    }

    // VARIABLES
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelSecQ;
    private javax.swing.JLabel jLabelSecA;

    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldUser;
    private javax.swing.JTextField jTextFieldSecA;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JComboBox<String> jComboSecQ;

    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonBack;
}
