package repository;

import model.Company;
import utils.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

public class CompanyRepo {

    public void add(Company c) {
        try {
            Connection conn = DatabaseConnection.connect();
            String sql = "INSERT INTO companies (name, industry) VALUES (?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getIndustry());
            st.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Company> getAll() {
        ArrayList<Company> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM companies");
            while (rs.next()) {
                list.add(new Company(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("industry")
                ));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Company getById(int id) {
        Company c = null;
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM companies WHERE id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                c = new Company(rs.getInt("id"), rs.getString("name"), rs.getString("industry"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}