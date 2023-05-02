package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;


public class mainMenu {

  public JPanel mainPanel;

  // Création des éléments de la fenêtre
  private JButton créationDuPDFButton;

  private JButton modifierLesÉquipementsButton;

  private JButton editBoat;

  public mainMenu() {
    // Ouverture de la fenêtre de modification des équipements
    modifierLesÉquipementsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame equipement = new JFrame("Equipement");
        try {
          equipement.setContentPane(new Equipement().mainPanel);
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
        equipement.setDefaultCloseOperation(equipement.HIDE_ON_CLOSE);
        equipement.pack();
        equipement.setVisible(true);
      }
    });

    // Création du PDF avec ouverture
    créationDuPDFButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          utils.GeneratePDF.generatePDF();
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
    editBoat.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame boat = new JFrame("Bateau");
        try {
          boat.setContentPane(new Boat().mainPanel);
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
        boat.setDefaultCloseOperation(boat.HIDE_ON_CLOSE);
        boat.pack();
        boat.setVisible(true);
      }
    });
  }

}
