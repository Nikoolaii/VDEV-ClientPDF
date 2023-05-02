package bateau;

/**
 * Classe Equipement
 */
public class Equipement {

  /**
   * Identifiant de l'équipement
   */
  private String idEquip;

  /**
   * Libellé de l'équipement
   */
  private String libEquip;

  /**
   * Constructeur de la classe Equipement
   *
   * @param idEquip  identifiant de l'équipement
   * @param libEquip libellé de l'équipement
   */
  public Equipement(String idEquip, String libEquip) {
    this.idEquip = idEquip;
    this.libEquip = libEquip;
  }

  /**
   * Retourne l'identifiant de l'équipement
   *
   * @return l'identifiant de l'équipement
   */
  public String getIdEquip() {
    return idEquip;
  }

  /**
   * Modifie l'identifiant de l'équipement
   *
   * @param idEquip l'identifiant de l'équipement
   */
  public void setIdEquip(String idEquip) {
    this.idEquip = idEquip;
  }

  /**
   * Retourne le libellé de l'équipement
   *
   * @return le libellé de l'équipement
   */
  public String getLibEquip() {
    return libEquip;
  }

  /**
   * Modifie le libellé de l'équipement
   *
   * @param libEquip le libellé de l'équipement
   */
  public void setLibEquip(String libEquip) {
    this.libEquip = libEquip;
  }

  /**
   * Retourne le libellé de l'équipement
   *
   * @return le libellé de l'équipement
   */
  @Override
  public String toString() {
    return libEquip;
  }

}
