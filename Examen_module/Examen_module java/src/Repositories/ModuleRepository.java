package Repositories;

import Entities.Module;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModuleRepository {

    public void insert(Module module) {
        String query = "INSERT INTO module (nom) VALUES (?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_module"
                    , "root", "");
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, module.getNom());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    module.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Module> selectAll() {
        List<Module> modules = new ArrayList<>();
        String query = "SELECT * FROM module";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_module"
                    , "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Module module = new Module();
                module.setId(rs.getInt("id"));
                module.setNom(rs.getString("nom"));
                modules.add(module);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modules;
    }
}
