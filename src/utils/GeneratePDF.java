package utils;

import com.mysql.cj.protocol.Resultset;
import controllers.BateauController;
import controllers.EquipementController;

import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneratePDF {
    public static void generatePDF() throws IOException, SQLException {
        // Instruction de génération du PDF
        PDF unPDF = new PDF("Brochure");
        unPDF.ecrireTexte("Brochure des bateaux et de leurs équipements");
        unPDF.sautDeLigne();

        ResultSet result = BateauController.findAll();
        DefaultListModel listModel = new DefaultListModel();
        while (result.next()) {
            bateau.Bateau bateau = new bateau.Bateau(result.getInt("id"), result.getFloat("largeur"), result.getFloat("longueur"), result.getString("nom"), result.getFloat("vitesse"));
            unPDF.ecrireTexte(bateau.getNomBat());
            unPDF.ecrireTexte("Largeur: " + bateau.getLargeurBat());
            unPDF.ecrireTexte("Longueur: " + bateau.getLongueurBat());
            unPDF.ecrireTexte("Vitesse: " + bateau.getVitesseBat());
            unPDF.ecrireTexte("Equipements: ");
            ResultSet resultEquipement = controllers.BateauEquipementController.findAllBoatEquipement(String.valueOf(bateau.getIdBat()));
            while (resultEquipement.next()) {
                ResultSet resultEquipement2 = EquipementController.findOne(resultEquipement.getInt("equipement_id"));
                System.out.println(resultEquipement2.getInt("id"));
                bateau.Equipement equipement = new bateau.Equipement(resultEquipement2.getString("id"), resultEquipement2.getString("nom"));
                unPDF.ecrireTexte("    " + equipement.getLibEquip());
            }
            unPDF.sautDeLigne();
        }
        unPDF.fermer();
        unPDF.ouvrirPDFmacEtWindows();
    }
}
