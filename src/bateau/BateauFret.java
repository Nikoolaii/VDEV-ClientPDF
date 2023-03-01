package bateau;

public class BateauFret extends Bateau {

  private int poidsMaxBatFret;

  public BateauFret(String id, double largeur, double longueur, String nom, int poidsMaxBatFret) {
    super(id, largeur, longueur, nom);
    this.poidsMaxBatFret = poidsMaxBatFret;
  }

  public int getPoidsMaxBatFret() {
    return poidsMaxBatFret;
  }

  public void setPoidsMaxBatFret(int poidsMaxBatFret) {
    this.poidsMaxBatFret = poidsMaxBatFret;
  }

}
