package controllers;

import utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Classe EquipementController
 */
public class EquipementController {

  /**
   * Trouve tous les équipements
   *
   * @param nom nom de l'équipement
   */
  public static void create(String nom) {
    Connection connexion = Database.connect();

    try {
      PreparedStatement statement = connexion.prepareStatement("INSERT INTO equipement (nom) VALUES (?)");
      statement.setString(1, nom);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Met à jour un équipement
   *
   * @param id  identifiant de l'équipement
   * @param nom nom de l'équipement
   */
  public static void update(int id, String nom) {
    Connection connexion = Database.connect();

    try {
      PreparedStatement statement = connexion.prepareStatement("UPDATE equipement SET nom = ? WHERE id = ?");
      statement.setString(1, nom);
      statement.setInt(2, id);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Supprime un équipement
   *
   * @param id identifiant de l'équipement
   */
  public static void delete(int id) {
    Connection connexion = Database.connect();

    try {
      PreparedStatement statement = connexion.prepareStatement("DELETE FROM equipement WHERE id = ?");
      statement.setInt(1, id);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Trouve un équipement
   *
   * @param id identifiant de l'équipement
   *
   * @return ResultSet
   */
  public static ResultSet findOne(int id) {
    Connection connexion = Database.connect();

    ResultSet result = null;

    try {
      PreparedStatement statement = connexion.prepareStatement("SELECT * FROM vdev.equipement WHERE id = ?");
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      resultSet.next();

      result = resultSet;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

  /**
   * Trouve tous les équipements
   *
   * @return ResultSet
   */
  public static ResultSet findAll() {
    Connection connexion = Database.connect();

    ResultSet result = null;

    try {
      PreparedStatement statement = connexion.prepareStatement("SELECT * FROM vdev.equipement");
      result = statement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

}
