import bateau.BateauVoyageur;
import utils.PDF;

import java.io.IOException;


public class Main {

  public static void main(String[] args) throws IOException {
    BateauVoyageur bateauVoyageur = new BateauVoyageur("1", 100, 200, "Mon Bateau", "image", 10);

    PDF pdf = new PDF("FirstPDF");
    pdf.ecrireTexte(bateauVoyageur.toString());
    pdf.chargerImage("bateau.jpg");
    pdf.ecrireTexte(bateauVoyageur.toString());
    pdf.ecrireTexte(bateauVoyageur.toString());
    pdf.ecrireTexte(bateauVoyageur.toString());
    pdf.ecrireTexte(bateauVoyageur.toString());
    pdf.fermer();
  }

}