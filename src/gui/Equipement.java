package gui;

import controllers.BateauController;
import controllers.BateauEquipementController;
import controllers.EquipementController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Equipement {
    // Création des éléments de la fenêtre
    public JPanel mainPanel;
    private JButton validerButton;
    private JTextField newEquipementText;
    private JList listBateaux;
    private JList listEquipement;
    private JButton supprimerButton;
    private JButton ajouterButton;
    private JLabel addEquipText;
    private JButton supprimerLÉquipementButton;

    // Constructeur de la fenêtre
    public Equipement() throws SQLException {
        try {
            setEquipementList();
            setBateauList();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        // Création d'un nouvel équipement avec le bouton valider
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewEquipement();
            }
        });

        //Création d'un nouvel équipement avec la touche entrée
        newEquipementText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    NewEquipement();
                }
            }
        });

        // Ajout d'un équipement à un bateau
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bateau.Equipement unEquipement = (bateau.Equipement) listEquipement.getSelectedValue();
                bateau.Bateau unBateau = (bateau.Bateau) listBateaux.getSelectedValue();
                String idEquipement = unEquipement.getIdEquip();
                int idBateau = unBateau.getIdBat();
                BateauEquipementController.create(idEquipement, idBateau);

            }
        });

        // Suppression d'un équipement d'un bateau
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bateau.Equipement unEquipement = (bateau.Equipement) listEquipement.getSelectedValue();
                bateau.Bateau unBateau = (bateau.Bateau) listBateaux.getSelectedValue();
                String idEquipement = unEquipement.getIdEquip();
                int idBateau = unBateau.getIdBat();
                BateauEquipementController.delete(idBateau, idEquipement);
            }
        });

        // Suppression d'un équipement
        supprimerLÉquipementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bateau.Equipement unEquipement = (bateau.Equipement) listEquipement.getSelectedValue();
                String idEquipement = unEquipement.getIdEquip();
                EquipementController.delete(Integer.parseInt(idEquipement));
                try {
                    setEquipementList();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    // Fonction pour afficher la liste des équipements
    public void setEquipementList() throws SQLException {
        ResultSet result = EquipementController.findAll();
        DefaultListModel listModel = new DefaultListModel();
        while (result.next()) {
            bateau.Equipement equipement = new bateau.Equipement(result.getString("id"), result.getString("nom"));
            listModel.addElement(equipement);
        }
        listEquipement.setModel(listModel);
    }

    // Fonction pour afficher la liste des bateaux
    public void setBateauList() throws SQLException {
        ResultSet result = BateauController.findAll();
        DefaultListModel listModel = new DefaultListModel();
        while (result.next()) {
            bateau.Bateau bateau = new bateau.Bateau(result.getInt("id"), result.getFloat("largeur"), result.getFloat("longueur"), result.getString("nom"), result.getFloat("vitesse"));
            listModel.addElement(bateau);
        }
        listBateaux.setModel(listModel);
    }

    // Fonction pour créer un nouvel équipement
    public void NewEquipement(){
        if (newEquipementText.getText().length() > 0) {
            EquipementController.create(newEquipementText.getText());
            newEquipementText.setText("");
            try {
                setEquipementList();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
