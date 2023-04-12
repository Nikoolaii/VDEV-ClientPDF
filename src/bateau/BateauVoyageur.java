package bateau;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe BateauVoyageur
 */
public class BateauVoyageur extends Bateau {

  private double vitesseBatVoy;

  private String imageBatVoy;

  private List<Equipement> lesEquipements = new ArrayList<>();

  /**
   * Constructeur de la classe BateauVoyageur
   *
   * @param id            identifiant du bateau
   * @param largeur       largeur du bateau
   * @param longueur      longueur du bateau
   * @param nom           nom du bateau
   * @param imageBatVoy   image du bateau
   * @param vitesseBatVoy vitesse du bateau
   */
  public BateauVoyageur(int id, float largeur, float longueur, String nom, String imageBatVoy, double vitesseBatVoy) {
    super(id, largeur, longueur, nom);
    this.imageBatVoy = imageBatVoy;
    this.vitesseBatVoy = vitesseBatVoy;
  }

  /**
   * Retourne l'image du bateau
   *
   * @return l'image du bateau
   */
  public String getImageBatVoy() {
    return imageBatVoy;
  }

  /**
   * Modifie l'image du bateau
   *
   * @param imageBatVoy l'image du bateau
   */
  public void setImageBatVoy(String imageBatVoy) {
    this.imageBatVoy = imageBatVoy;
  }

  /**
   * Retourne la vitesse du bateau
   *
   * @return la vitesse du bateau
   */
  public double getVitesseBatVoy() {
    return vitesseBatVoy;
  }

  /**
   * Modifie la vitesse du bateau
   *
   * @param vitesseBatVoy la vitesse du bateau
   */
  public void setVitesseBatVoy(double vitesseBatVoy) {
    this.vitesseBatVoy = vitesseBatVoy;
  }

  /**
   * Retourne la liste des équipements du bateau
   *
   * @return la liste des équipements du bateau
   */
  public List<Equipement> getLesEquipements() {
    return lesEquipements;
  }

  /**
   * Modifie la liste des équipements du bateau
   *
   * @param lesEquipements la liste des équipements du bateau
   */
  public void setLesEquipements(List<Equipement> lesEquipements) {
    this.lesEquipements = lesEquipements;
  }

  /**
   * Retourne une chaîne de caractères contenant les informations du bateau de voyageur
   *
   * @return une chaîne de caractères contenant les informations du bateau de voyageur
   */
  @Override
  public String toString() {
    StringBuilder equipements = new StringBuilder();

    if (this.lesEquipements.size() > 0) {
      for (Equipement equipement : this.lesEquipements) {
        equipements.append("\n -").append(equipement);
      }
    } else {
      equipements.append("\nAucun équipement");
    }

    return String.format("%s\nVitesse : %s\nListe des équipements :%s", super.toString(), this.vitesseBatVoy, equipements);
  }

}
