package test;

import org.junit.Test;
import utils.PDF;

import java.io.File;
import java.io.IOException;

public class unitTest {
    @Test
    public void testCreationPDF() throws IOException {
        boolean fileExist = false;
        PDF unPDF = new PDF("unitTest");
        unPDF.ecrireTexte("test");
        unPDF.fermer();
        // Vérifier si le fichier à bien était créer dans le dossier pdd
        File f = new File("./pdf/unitTest.pdf");
        if(f.exists() && !f.isDirectory())
        {
            fileExist = true;
        }
        assert fileExist;
        f.delete();
    }

}
