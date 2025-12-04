package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminReyven {

    private final Connection con = MyConnection.getConnection();

    // CHECK USERNAME
    public boolean checkUsername(String username) {
        String sql = "SELECT * FROM admin WHERE username = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // GET SECURITY QUESTION
    public String getSecurityQuestion(String username) {
        String sql = "SELECT ques FROM admin WHERE username = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("ques");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // VERIFY SECURITY ANSWER
    public boolean verifyAnswer(String username, String ans) {
        String sql = "SELECT ans FROM admin WHERE username = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("ans").equals(ans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // UPDATE PASSWORD
    public void updatePassword(String username, String newPass) {
        String sql = "UPDATE admin SET password = ? WHERE username = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newPass);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
