package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminReyven {

    private final Connection con = MyConnection.getConnection();

    // CHECK IF USERNAME EXISTS
    public boolean isAdminNameExist(String username) {
        String sql = "SELECT username FROM admin WHERE username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error checking username: " + e.getMessage());
        }
        return false;
    }

    // INSERT NEW ADMIN
    public boolean insert(Admin ad) {
        String sql = "INSERT INTO admin(username, password, ques, ans) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ad.getUsername());
            ps.setString(2, ad.getPassword());
            ps.setString(3, ad.getQues());
            ps.setString(4, ad.getAns());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting admin: " + e.getMessage());
        }
        return false;
    }

    // GET MAX ID
    public int getMaxRowAdminTable() {
        int row = 0;
        String sql = "SELECT MAX(id) FROM admin";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) row = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error getting max ID: " + e.getMessage());
        }
        return row;
    }

    // LOGIN
    public boolean login(String username, String password) {
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error login: " + e.getMessage());
        }
        return false;
    }

    // GET SECURITY QUESTION FOR USER
    public String getSecurityQuestion(String username) {
        String sql = "SELECT ques FROM admin WHERE username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("ques");
        } catch (SQLException e) {
            System.out.println("Error fetching question: " + e.getMessage());
        }
        return null;
    }

    // VERIFY SECURITY QUESTION + ANSWER
    public boolean verifySecurity(String username, String question, String answer) {
        String sql = "SELECT * FROM admin WHERE username = ? AND ques = ? AND ans = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, question);
            ps.setString(3, answer);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error verifying security: " + e.getMessage());
        }
        return false;
    }

    // UPDATE PASSWORD
    public boolean updatePassword(String username, String newPass) {
        String sql = "UPDATE admin SET password = ? WHERE username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newPass);
            ps.setString(2, username);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating password: " + e.getMessage());
        }
        return false;
    }
}
