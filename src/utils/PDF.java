package utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class PDF {

  final String CHEMIN_PDF = Paths.get("./pdf").toAbsolutePath().toString();

  private PDDocument document;

  private String nomDocument;

  private PDPageContentStream contents;

  private float yOffset = 0;

  public PDF(String nomDocument) {
    document = new PDDocument();
    PDPage page = new PDPage();

    document.addPage(page);
    this.nomDocument = nomDocument;
  }

  private void parseIndividualLines(String wholeLetter, List<String> lines, float fontSize, PDFont pdfFont, float width) throws IOException {
    String[] paragraphs = wholeLetter.split(System.getProperty("line.separator"));

    for (int i = 0; i < paragraphs.length; i++) {
      int lastSpace = -1;
      lines.add(" ");

      while (paragraphs[i].length() > 0) {
        int spaceIndex = paragraphs[i].indexOf(' ', lastSpace + 1);

        if (spaceIndex < 0) {
          spaceIndex = paragraphs[i].length();
        }

        String subString = paragraphs[i].substring(0, spaceIndex);
        float size = fontSize * pdfFont.getStringWidth(subString) / 1000;

        if (size > width) {
          if (lastSpace < 0) {
            lastSpace = spaceIndex;
          }

          subString = paragraphs[i].substring(0, lastSpace);
          lines.add(subString);

          paragraphs[i] = paragraphs[i].substring(lastSpace).trim();
          lastSpace = -1;
        } else if (spaceIndex == paragraphs[i].length()) {
          lines.add(paragraphs[i]);
          paragraphs[i] = "";
        } else {
          lastSpace = spaceIndex;
        }
      }
    }
  }

  public void chargerImage(String cheminImage) throws IOException {
    PDPage page = document.getPage(document.getNumberOfPages() - 1);

    contents = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);

    PDRectangle mediabox = page.getMediaBox();
    float margin = 75;
    float width = mediabox.getWidth() - 2 * margin;
    float startX = mediabox.getLowerLeftX() + margin;
    float startY = mediabox.getUpperRightY() - margin;
    if (yOffset == 0) yOffset = startY;
    float scale = 1f;

    PDImageXObject pdImage = PDImageXObject.createFromFile(Paths.get(String.format("./images/%s", cheminImage)).toAbsolutePath().toString(), document);
    scale = width / pdImage.getWidth();
    yOffset -= (pdImage.getHeight() * scale);
    if (yOffset <= 0) {
      try {
        contents.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

      page = new PDPage();
      document.addPage(page);

      contents = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
      yOffset = startY - (pdImage.getHeight() * scale);
    }

    contents.drawImage(pdImage, startX, yOffset, width, pdImage.getHeight() * scale);
    contents.close();
  }

  public void ecrireTexte(String texte) throws IOException {
    PDPage page = document.getPage(document.getNumberOfPages() - 1);

    float fontSize = 12;
    PDRectangle mediabox = page.getMediaBox();
    float margin = 75;
    float width = mediabox.getWidth() - 2 * margin;
    float startX = mediabox.getLowerLeftX() + margin;
    float startY = mediabox.getUpperRightY() - margin;
    if (yOffset == 0) yOffset = startY;
    PDFont font = PDType1Font.COURIER;

    contents = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
    contents.beginText();
    contents.setFont(font, fontSize);
    contents.newLineAtOffset(startX, yOffset);

    List<String> lines = new ArrayList<>();
    parseIndividualLines(texte, lines, fontSize, font, width);

    for (String line : lines) {
      contents.showText(line);
      contents.newLineAtOffset(0, -fontSize);
      yOffset -= fontSize;

      if (yOffset <= 0) {
        contents.endText();
        try {
          contents.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

        page = new PDPage();
        document.addPage(page);
        contents = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
        contents.beginText();
        contents.setFont(font, fontSize);
        yOffset = startY;
        contents.newLineAtOffset(startX, startY);
      }
    }

    contents.endText();
    contents.close();
  }

  public void fermer() throws IOException {
    document.save(String.format("%s/%s.pdf", CHEMIN_PDF, nomDocument));
    document.close();
  }

}
