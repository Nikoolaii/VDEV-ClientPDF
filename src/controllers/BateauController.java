package controllers;

import utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Classe BateauController
 */
public class BateauController {

  /**
   * Crée un bateau dans la base de données
   *
   * @param nom      nom du bateau
   * @param type     type du bateau
   * @param longueur longueur du bateau
   * @param largeur  largeur du bateau
   * @param vitesse  vitesse du bateau
   * @param poidsMax poids maximum du bateau
   */
  public static void create(String nom, String type, float longueur, float largeur, float vitesse, float poidsMax) {
    Connection connexion = Database.connect();

    try {
      PreparedStatement statement = connexion.prepareStatement("INSERT INTO bateau (nom, type, longueur, largeur, vitesse, poids_max) VALUES (?, ?, ?, ?, ?, ?)");
      statement.setString(1, nom);
      statement.setString(2, type);
      statement.setFloat(3, longueur);
      statement.setFloat(4, largeur);
      statement.setFloat(5, vitesse);
      statement.setFloat(6, poidsMax);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Met à jour un bateau dans la base de données
   *
   * @param id       identifiant du bateau
   * @param nom      nom du bateau
   * @param type     type du bateau
   * @param longueur longueur du bateau
   * @param largeur  largeur du bateau
   * @param vitesse  vitesse du bateau
   * @param poidsMax poids maximum du bateau
   */
  public static void update(int id, String nom, String type, float longueur, float largeur, float vitesse, float poidsMax) {
    Connection connexion = Database.connect();

    try {
      PreparedStatement statement = connexion.prepareStatement("UPDATE bateau SET nom = ?, type = ?, longueur = ?, largeur = ?, vitesse = ?, poids_max = ? WHERE id = ?");
      statement.setString(1, nom);
      statement.setString(2, type);
      statement.setFloat(3, longueur);
      statement.setFloat(4, largeur);
      statement.setFloat(5, vitesse);
      statement.setFloat(6, poidsMax);
      statement.setInt(7, id);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Supprime un bateau de la base de données
   *
   * @param id identifiant du bateau
   */
  public static void delete(int id) {
    Connection connexion = Database.connect();

    try {
      PreparedStatement statement = connexion.prepareStatement("DELETE FROM bateau WHERE id = ?");
      statement.setInt(1, id);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Retourne un bateau de la base de données
   *
   * @param id identifiant du bateau
   *
   * @return un bateau de la base de données
   */
  public static ResultSet findOne(int id) {
    Connection connexion = Database.connect();

    ResultSet result = null;

    try {
      PreparedStatement statement = connexion.prepareStatement("SELECT * FROM vdev.bateau WHERE id = ?");
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
   * Retourne tous les bateaux de la base de données
   *
   * @return tous les bateaux de la base de données
   */
  public static ResultSet findAll() {
    Connection connexion = Database.connect();

    ResultSet result = null;

    try {
      PreparedStatement statement = connexion.prepareStatement("SELECT * FROM vdev.bateau");

      result = statement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

}
