package utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;


public class PDF {

  private PDDocument document;

  public PDF(String nomDocument) {
    document = new PDDocument();
    PDPage page = new PDPage();
    document.addPage(page);

    try {
      document.save(nomDocument);
      document.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void ecrireTexte(String texte) {
    try {
      PDPageContentStream contentStream = new PDPageContentStream(document, document.getPage(0));

      contentStream.setFont(PDType1Font.COURIER, 12);
      contentStream.beginText();
      contentStream.newLineAtOffset(25, 500);
      contentStream.showText(texte);
      contentStream.endText();
      contentStream.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
