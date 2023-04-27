package bateau;

public class BateauFret extends Bateau {

  private int poidsMaxBatFret;

  public BateauFret(int id, float largeur, float longueur, String nom, int poidsMaxBatFret, float vitesse) {
    super(id, largeur, longueur, nom, vitesse);
    this.poidsMaxBatFret = poidsMaxBatFret;
  }

  public int getPoidsMaxBatFret() {
    return poidsMaxBatFret;
  }

  public void setPoidsMaxBatFret(int poidsMaxBatFret) {
    this.poidsMaxBatFret = poidsMaxBatFret;
  }

}
