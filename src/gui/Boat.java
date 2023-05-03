package gui;

import controllers.BateauController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Boat {

    public JPanel mainPanel;

    private JList listeboat;

    private JButton supprimerButton;

    private JTextField vitesseField;

    private JButton modifierButton;

    private JTextField nomField;

    private JTextField longueurField;

    private JTextField largeurField;

    public Boat() throws SQLException {
        try {
            setBoatList();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        listeboat.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (listeboat.getSelectedValue() != null) {
                    //Définir les champs de texte par rapport au caractéristiques des bateaux
                    if (listeboat.getSelectedValue().toString().equals("Ajouter un élément")) {
                        nomField.setText("");
                        largeurField.setText("");
                        longueurField.setText("");
                        vitesseField.setText("");
                        modifierButton.setText("Ajouter");
                        supprimerButton.setEnabled(false);
                    } else {
                        bateau.Bateau unBateau = (bateau.Bateau) listeboat.getSelectedValue();
                        nomField.setText(unBateau.getNomBat());
                        largeurField.setText(String.valueOf(unBateau.getLargeurBat()));
                        longueurField.setText(String.valueOf(unBateau.getLongueurBat()));
                        vitesseField.setText(String.valueOf(unBateau.getVitesseBat()));
                        modifierButton.setText("Modifier");
                        supprimerButton.setEnabled(true);
                    }
                }
            }
        });

        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nomField.getText() != "" && largeurField.getText() != null && longueurField.getText() != null && vitesseField.getText() != null) {
                    if (listeboat.getSelectedValue().toString().equals("Ajouter un élément")) {
                        try {
                            BateauController.create(nomField.getText(), "Voyageur", Float.parseFloat(largeurField.getText()), Float.parseFloat(longueurField.getText()), Float.parseFloat(vitesseField.getText()), 1);
                            setBoatList();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        try {
                            bateau.Bateau unBateau = (bateau.Bateau) listeboat.getSelectedValue();
                            BateauController.update(unBateau.getIdBat(), nomField.getText(), "Voyageur", Float.parseFloat(largeurField.getText()), Float.parseFloat(longueurField.getText()), Float.parseFloat(vitesseField.getText()), 1);
                            setBoatList();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
                }
            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listeboat.getSelectedValue() != null) {
                    if (!listeboat.getSelectedValue().toString().equals("Ajouter un élément")) {
                        try {
                            bateau.Bateau unBateau = (bateau.Bateau) listeboat.getSelectedValue();
                            BateauController.delete(unBateau.getIdBat());
                            setBoatList();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
    }

    private void setBoatList() throws SQLException {
        ResultSet result = BateauController.findAll();
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement(new bateau.Bateau(0, 0, 0, "Ajouter un élément", 0));
        while (result.next()) {
            bateau.Bateau bateau = new bateau.Bateau(result.getInt("id"), result.getFloat("largeur"), result.getFloat("longueur"), result.getString("nom"), result.getFloat("vitesse"));
            listModel.addElement(bateau);
        }
        listeboat.setModel(listModel);
        listeboat.setSelectedIndex(0);
        supprimerButton.setEnabled(false);
    }

}


