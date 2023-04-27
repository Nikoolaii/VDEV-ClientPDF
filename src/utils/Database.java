package utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class Database {

  public static Connection connect() {
    Connection connexion = null;

    try {
      // Chargement du driver
      Class.forName("com.mysql.cj.jdbc.Driver");

        // Connexion à la base de données
      String url = "jdbc:mysql://localhost:8889/vdev";
      String user = "root";
      String password = "root";
      connexion = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      // Renvoie l'erreur si la connexion échoue
      System.out.println("Connexion failed : " + e.getMessage());
      e.printStackTrace();
    }
    return connexion;
  }

}