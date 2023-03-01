package bateau;

/**
 * Classe Bateau
 */
public class Bateau {

  private String idBat, nomBat;

  private double largeurBat, longueurBat;

  /**
   * Constructeur de la classe Bateau
   *
   * @param idBat       identifiant du bateau
   * @param largeurBat  largeur du bateau
   * @param longueurBat longueur du bateau
   * @param nomBat      nom du bateau
   */
  public Bateau(String idBat, double largeurBat, double longueurBat, String nomBat) {
    this.idBat = idBat;
    this.largeurBat = largeurBat;
    this.longueurBat = longueurBat;
    this.nomBat = nomBat;

  }

  /**
   * Retourne l'identifiant du bateau
   *
   * @return l'identifiant du bateau
   */
  public String getIdBat() {
    return idBat;
  }

  /**
   * Modifie l'identifiant du bateau
   *
   * @param idBat l'identifiant du bateau
   */
  public void setIdBat(String idBat) {
    this.idBat = idBat;
  }

  /**
   * Retourne la largeur du bateau
   *
   * @return la largeur du bateau
   */
  public double getLargeurBat() {
    return largeurBat;
  }

  /**
   * Modifie la largeur du bateau
   *
   * @param largeurBat la largeur du bateau
   */
  public void setLargeurBat(double largeurBat) {
    this.largeurBat = largeurBat;
  }

  /**
   * Retourne la longueur du bateau
   *
   * @return la longueur du bateau
   */
  public double getLongueurBat() {
    return longueurBat;
  }

  /**
   * Modifie la longueur du bateau
   *
   * @param longueurBat la longueur du bateau
   */
  public void setLongueurBat(double longueurBat) {
    this.longueurBat = longueurBat;
  }

  /**
   * Retourne le nom du bateau
   *
   * @return le nom du bateau
   */
  public String getNomBat() {
    return nomBat;
  }

  /**
   * Modifie le nom du bateau
   *
   * @param nomBat le nom du bateau
   */
  public void setNomBat(String nomBat) {
    this.nomBat = nomBat;
  }

  /**
   * Retourne une chaîne de caractères contenant les informations du bateau
   *
   * @return une chaîne de caractères contenant les informations du bateau
   */
  @Override
  public String toString() {
    return String.format("Nom du bateau : %s\nLongueur : %f mètres \nLargeur : %f mètres", this.nomBat, this.longueurBat, this.largeurBat);
  }

}
