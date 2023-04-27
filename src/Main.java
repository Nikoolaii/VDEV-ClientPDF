import gui.mainMenu;
import utils.PDF;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;


public class Main {

  public static void main(String[] args) throws SQLException, IOException {
    // Création de la GUI principale et ouverture.
    JFrame menuPrincipal = new JFrame("mainMenu");
    menuPrincipal.setContentPane(new mainMenu().mainPanel);
    menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menuPrincipal.pack();
    menuPrincipal.setVisible(true);
  }

}