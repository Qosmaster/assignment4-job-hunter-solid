package repository;

import model.*;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;

public class AppRepo {

    public void add(Application app) {
        try {
            Connection conn = DatabaseConnection.connect();
            String sql = "INSERT INTO applications (job_title, company_id, status, type, platform, stages) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, app.getName());
            st.setInt(2, app.getCompany().getId());
            st.setString(3, app.getStatus());
            st.setString(4, app.getType());

            if (app instanceof EasyApp) {
                EasyApp e = (EasyApp) app;
                st.setString(5, e.getSite());
                st.setInt(6, 0);
            } else {
                HardApp h = (HardApp) app;
                st.setString(5, "");
                st.setInt(6, h.getRoundCount());
            }

            st.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Application> getAll() {
        ArrayList<Application> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.connect();
            String sql = "SELECT * FROM applications JOIN companies ON applications.company_id = companies.id";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int cId = rs.getInt("company_id");
                String cName = rs.getString("name"); // имя компании
                String cInd = rs.getString("industry");
                Company comp = new Company(cId, cName, cInd);

                String type = rs.getString("type");

                if (type.equals("EASY")) {
                    EasyApp a = new EasyApp(
                            rs.getInt("id"),
                            rs.getString("job_title"),
                            comp,
                            rs.getString("status"),
                            rs.getString("platform")
                    );
                    list.add(a);
                } else {
                    HardApp a = new HardApp(
                            rs.getInt("id"),
                            rs.getString("job_title"),
                            comp,
                            rs.getString("status"),
                            rs.getInt("stages")
                    );
                    list.add(a);
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteById(int id) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement st = conn.prepareStatement("DELETE FROM applications WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}