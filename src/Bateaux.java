import controllers.BateauController;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Bateaux extends JDialog {

  private JList bateauxList;

  private JPanel panel;

  public Bateaux(JFrame parent) throws SQLException {
    super(parent);
    setTitle("Bateaux");
    setContentPane(panel);
    setMinimumSize(new Dimension(400, 400));
    setModal(true);
    setLocationRelativeTo(parent);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    ResultSet result = BateauController.findAll();
    result.last();
    String[] bateaux = new String[result.getRow()];
    result.beforeFirst();
    int i = 0;

    while (result.next()) {
      bateaux[i] = result.getString("nom");
      i++;
    }

    bateauxList = new JList<>(bateaux);

    setVisible(true);
  }

}
