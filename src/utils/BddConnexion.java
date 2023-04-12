package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BddConnexion {

    public static void addEquipement(String nomEquipement) throws SQLException {
        Connection connexion = connexion();
        boolean resultSet = true;
        try {
            String query = "INSERT INTO equipement(nom) VALUES (?);";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, nomEquipement);
            statement.execute();

        } catch (SQLException e) {
            resultSet = false;
            throw new RuntimeException(e);
        }
        connexion.close();
    }

    private static Connection connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Créer une connexion à la base de données
            String url = "jdbc:mysql://localhost:8889/vdev?useLegacyAuth=true";
            String user = "userJava";
            String password = "aaa";
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            System.out.println("Connexion failed : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
