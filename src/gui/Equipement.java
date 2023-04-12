package gui;

import utils.BddConnexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Equipement {
    private JTextField inputEquipement;
    private JLabel validationText;
    private JButton validerButton;

    public Equipement() {
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BddConnexion.addEquipement("Test");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
