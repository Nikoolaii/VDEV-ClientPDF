package controllers;

import utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Classe BateauEquipementController
 */
public class BateauEquipementController {

  /**
   * Crée un lien entre un bateau et un équipement dans la base de données
   *
   * @param idEquipement identifiant de l'équipement
   * @param idBateau     identifiant du bateau
   */
  public static void create(String idEquipement, int idBateau) {
    Connection connexion = Database.connect();

    try {
      PreparedStatement statement = connexion.prepareStatement("INSERT INTO bateau_voyageur_equipement (equipement_id, bateau_voyageur_id) VALUES (?, ?)");
      statement.setString(1, idEquipement);
      statement.setInt(2, idBateau);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Supprime un lien entre un bateau et un équipement dans la base de données
   *
   * @param idEquipement identifiant de l'équipement
   * @param idBateau     identifiant du bateau
   */
  public static void delete(Integer idEquipement, String idBateau) {
    Connection connexion = Database.connect();

    try {
      PreparedStatement statement = connexion.prepareStatement("DELETE FROM bateau_voyageur_equipement WHERE equipement_id = ? AND bateau_voyageur_id = ?");
      statement.setInt(1, idEquipement);
      statement.setString(2, idBateau);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Trouve tous les équipements d'un bateau
   *
   * @param idBateau identifiant du bateau
   *
   * @return ResultSet
   */
  public static ResultSet findAllBoatEquipement(String idBateau) {
    Connection connexion = Database.connect();

    ResultSet result = null;

    try {
      PreparedStatement statement = connexion.prepareStatement("SELECT equipement_id FROM vdev.bateau_voyageur_equipement WHERE bateau_voyageur_id = ?");
      statement.setString(1, idBateau);
      result = statement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

}
