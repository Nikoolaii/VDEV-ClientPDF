import gui.mainMenu;

import javax.swing.*;


public class Main {

  /**
   * Méthode main du programme.
   *
   * @param args Arguments de la ligne de commande.
   */
  public static void main(String[] args) {
    JFrame menuPrincipal = new JFrame("mainMenu");
    menuPrincipal.setContentPane(new mainMenu().mainPanel);
    menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menuPrincipal.pack();
    menuPrincipal.setVisible(true);
  }

}