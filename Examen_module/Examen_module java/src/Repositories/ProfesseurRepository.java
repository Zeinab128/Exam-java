package Repositories;
import Entities.Professeur;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ProfesseurRepository {

    public List<Professeur> selectAll() {
        List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM professeur";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_module"
                    , "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Professeur prof = new Professeur();
                prof.setId(rs.getInt("id"));
                prof.setNom(rs.getString("nom"));
                prof.setPrenom(rs.getString("prenom"));
                prof.setTel(rs.getString("tel"));
                professeurs.add(prof);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professeurs;
    }
}
