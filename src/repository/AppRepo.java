package repository;

import interfaces.CrudRepository;
import model.*;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;

public class AppRepo implements CrudRepository<Application> {

    @Override
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
                st.setString(5, ((EasyApp) app).getSite());
                st.setInt(6, 0);
            } else {
                st.setString(5, "");
                st.setInt(6, ((HardApp) app).getStages());
            }

            st.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Application> getAll() {
        ArrayList<Application> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.connect();
            String sql = "SELECT * FROM applications JOIN companies ON applications.company_id = companies.id";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Company comp = new Company(
                        rs.getInt("company_id"),
                        rs.getString("name"),
                        rs.getString("industry")
                );

                String type = rs.getString("type");
                if (type.equals("EASY")) {
                    list.add(new EasyApp(
                            rs.getInt("id"),
                            rs.getString("job_title"),
                            comp,
                            rs.getString("status"),
                            rs.getString("platform")
                    ));
                } else {
                    list.add(new HardApp(
                            rs.getInt("id"),
                            rs.getString("job_title"),
                            comp,
                            rs.getString("status"),
                            rs.getInt("stages")
                    ));
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Application getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement st = conn.prepareStatement("DELETE FROM applications WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}