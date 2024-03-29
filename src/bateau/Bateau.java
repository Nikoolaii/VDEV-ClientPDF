package bateau;

/**
 * Classe Bateau
 */
public class Bateau {

  private final float vitesseBat;

  /**
   * Identifiant du bateau
   */
  private int idBat;

  /**
   * Nom du bateau
   */
  private String nomBat;

  /**
   * Largeur du bateau
   */
  private float largeurBat;

  /**
   * Longueur du bateau
   */
  private float longueurBat;

  /**
   * Constructeur de la classe Bateau
   *
   * @param idBat       identifiant du bateau
   * @param largeurBat  largeur du bateau
   * @param longueurBat longueur du bateau
   * @param nomBat      nom du bateau
   * @param vitesseBat  vitesse du bateau
   */
  public Bateau(int idBat, float largeurBat, float longueurBat, String nomBat, float vitesseBat) {
    this.idBat = idBat;
    this.largeurBat = largeurBat;
    this.longueurBat = longueurBat;
    this.nomBat = nomBat;
    this.vitesseBat = vitesseBat;

  }

  /**
   * Retourne l'identifiant du bateau
   *
   * @return l'identifiant du bateau
   */
  public int getIdBat() {
    return idBat;
  }

  /**
   * Modifie l'identifiant du bateau
   *
   * @param idBat l'identifiant du bateau
   */
  public void setIdBat(int idBat) {
    this.idBat = idBat;
  }

  /**
   * Retourne la largeur du bateau
   *
   * @return la largeur du bateau
   */
  public float getLargeurBat() {
    return largeurBat;
  }

  /**
   * Modifie la largeur du bateau
   *
   * @param largeurBat la largeur du bateau
   */
  public void setLargeurBat(float largeurBat) {
    this.largeurBat = largeurBat;
  }

  /**
   * Retourne la longueur du bateau
   *
   * @return la longueur du bateau
   */
  public float getLongueurBat() {
    return longueurBat;
  }

  /**
   * Modifie la longueur du bateau
   *
   * @param longueurBat la longueur du bateau
   */
  public void setLongueurBat(float longueurBat) {
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
    return this.nomBat;
  }

  public Float getVitesseBat() {
    return this.vitesseBat;
  }

}
