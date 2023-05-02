package bateau;

/**
 * Classe BateauFret
 */
public class BateauFret extends Bateau {

  /**
   * Poids maximum du bateau
   */
  private int poidsMaxBatFret;

  /**
   * Constructeur de la classe BateauFret
   *
   * @param id              identifiant du bateau
   * @param largeur         largeur du bateau
   * @param longueur        longueur du bateau
   * @param nom             nom du bateau
   * @param poidsMaxBatFret poids maximum du bateau
   * @param vitesse         vitesse du bateau
   */
  public BateauFret(int id, float largeur, float longueur, String nom, int poidsMaxBatFret, float vitesse) {
    super(id, largeur, longueur, nom, vitesse);
    this.poidsMaxBatFret = poidsMaxBatFret;
  }

  /**
   * Retourne le poids maximum du bateau
   *
   * @return le poids maximum du bateau
   */
  public int getPoidsMaxBatFret() {
    return poidsMaxBatFret;
  }

  /**
   * Modifie le poids maximum du bateau
   *
   * @param poidsMaxBatFret le poids maximum du bateau
   */
  public void setPoidsMaxBatFret(int poidsMaxBatFret) {
    this.poidsMaxBatFret = poidsMaxBatFret;
  }

}
