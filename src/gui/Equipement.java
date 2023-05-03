package gui;

import controllers.BateauController;
import controllers.BateauEquipementController;
import controllers.EquipementController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.JOptionPane.showMessageDialog;


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
                try {
                    newEquipement();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Création d'un nouvel équipement avec la touche entrée
        newEquipementText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        newEquipement();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        // Ajout d'un équipement à un bateau
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listEquipement.getSelectedValue() == null) {
                    showMessageDialog(null, "❌Veuillez sélectionner un équipement");
                } else if (listBateaux.getSelectedValue() == null) {
                    showMessageDialog(null, "❌Veuillez sélectionner un bateau");
                } else {
                    bateau.Equipement unEquipement = (bateau.Equipement) listEquipement.getSelectedValue();
                    bateau.Bateau unBateau = (bateau.Bateau) listBateaux.getSelectedValue();
                    String idEquipement = unEquipement.getIdEquip();
                    int idBateau = unBateau.getIdBat();
                    BateauEquipementController.create(idEquipement, idBateau);
                    showMessageDialog(null, "✅Équipement ajouté au bateau");
                }
            }
        });

        // Suppression d'un équipement d'un bateau
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listEquipement.getSelectedValue() == null) {
                    showMessageDialog(null, "❌Veuillez sélectionner un équipement");
                } else if (listBateaux.getSelectedValue() == null) {
                    showMessageDialog(null, "❌Veuillez sélectionner un bateau");
                } else {
                    // Suppression d'un équipement d'un bateau (avec la fonction delete de BateauEquipementController
                    bateau.Equipement unEquipement = (bateau.Equipement) listEquipement.getSelectedValue();
                    bateau.Bateau unBateau = (bateau.Bateau) listBateaux.getSelectedValue();
                    String idEquipement = unEquipement.getIdEquip();
                    int idBateau = unBateau.getIdBat();
                    BateauEquipementController.delete(idEquipement, idBateau);
                    showMessageDialog(null, "✅Équipement supprimé du bateau");
                }
            }
        });

        // Suppression d'un équipement
        supprimerLÉquipementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bateau.Equipement unEquipement = (bateau.Equipement) listEquipement.getSelectedValue();
                String idEquipement = unEquipement.getIdEquip();
                EquipementController.delete(Integer.parseInt(idEquipement));
                showMessageDialog(null, "✅Équipement supprimé");
                try {
                    setEquipementList();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        listEquipement.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (listEquipement.getSelectedValue() != null) {
                    if (listEquipement.getSelectedValue().toString().equals("Ajouter un équipement")) {
                        newEquipementText.setText("");
                        validerButton.setText("Ajouter");
                        ajouterButton.setEnabled(false);
                        supprimerButton.setEnabled(false);
                        supprimerLÉquipementButton.setEnabled(false);
                    } else {
                        bateau.Equipement unEquipement = (bateau.Equipement) listEquipement.getSelectedValue();
                        newEquipementText.setText(unEquipement.getLibEquip());
                        validerButton.setText("Modifier");
                        ajouterButton.setEnabled(true);
                        supprimerButton.setEnabled(true);
                        supprimerLÉquipementButton.setEnabled(true);
                    }
                }
            }
        });
    }

    // Fonction pour afficher la liste des équipements
    public void setEquipementList() throws SQLException {
        ResultSet result = EquipementController.findAll();
        DefaultListModel listModel = new DefaultListModel();
        listModel.add(0, "Ajouter un équipement");
        while (result.next()) {
            bateau.Equipement equipement = new bateau.Equipement(result.getString("id"), result.getString("nom"));
            listModel.addElement(equipement);
        }
        listEquipement.setModel(listModel);
        listEquipement.setSelectedIndex(0);
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
    public void newEquipement() throws SQLException {
        if (newEquipementText.getText().length() > 0) {
            if (listEquipement.getSelectedValue().equals("Ajouter un équipement")) {
                EquipementController.create(newEquipementText.getText());
                newEquipementText.setText("");
                showMessageDialog(null, "✅Équipement ajouté");
                setEquipementList();
            } else if (listEquipement.getSelectedValue() != null) {
                int selectIndex = listEquipement.getSelectedIndex();
                bateau.Equipement unEquipement = (bateau.Equipement) listEquipement.getSelectedValue();
                String idEquipement = unEquipement.getIdEquip();
                EquipementController.update(Integer.parseInt(idEquipement), newEquipementText.getText());
                setEquipementList();
                listEquipement.setSelectedIndex(selectIndex);
            }
        }
    }

}
