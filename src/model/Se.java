package model;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Se {

    private final Connection con = MyConnection.getConnection();

    // RESIZE IMAGE
    private ImageIcon resize(byte[] imgBytes) {
        if (imgBytes == null) return null;

        ImageIcon original = new ImageIcon(imgBytes);
        Image img = original.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    // LOAD ALL PRODUCTS INTO TABLE
    public void getAllProduct(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String sql = "SELECT id, name, price, image FROM product";   // FIXED

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                byte[] imgBytes = rs.getBytes("image");

                ImageIcon icon = resize(imgBytes);

                model.addRow(new Object[]{id, name, price, icon});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INSERT PRODUCT
    public boolean insertProduct(Product p) {

        String sql = "INSERT INTO product (name, price, image) VALUES (?, ?, ?)";  // FIXED

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setBytes(3, p.getImage());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
            return false;
        }
    }

    // UPDATE PRODUCT WITHOUT IMAGE
    public boolean update(Product p) {

        String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?"; // FIXED

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
            return false;
        }
    }

    // UPDATE PRODUCT WITH IMAGE
    public boolean updateWithImage(Product p) {

        String sql = "UPDATE product SET name = ?, price = ?, image = ? WHERE id = ?"; // FIXED

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setBytes(3, p.getImage());
            ps.setInt(4, p.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Update image error: " + e.getMessage());
            return false;
        }
    }

    // DELETE PRODUCT
    public boolean delete(Product p) {

        String sql = "DELETE FROM product WHERE id = ?"; // FIXED

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
            return false;
        }
    }

    // FORGOT PASSWORD: CHECK USERNAME EXISTS
    public boolean isAdminNameExist(String username) {

        String sql = "SELECT username FROM admin WHERE username = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // FORGOT PASSWORD: CHECK SECURITY QUESTION + ANSWER
    public boolean isSecurityValid(String username, String ques, String ans) {

        String sql = "SELECT * FROM admin WHERE username = ? AND ques = ? AND ans = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, ques);
            ps.setString(3, ans);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // FORGOT PASSWORD: UPDATE PASSWORD
    public boolean updatePassword(String username, String newPass) {

        String sql = "UPDATE admin SET password = ? WHERE username = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newPass);
            ps.setString(2, username);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
