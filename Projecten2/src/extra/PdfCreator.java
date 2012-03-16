package extra;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import model.Inhoud;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class PdfCreator
{
    private Font titelFont = new Font(FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
    private Font basisTekstFont = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
    
    @SuppressWarnings("unused")
    public PdfCreator(Inhoud inhoud, String bestandsLocatie)
    {
        Document document = new Document(PageSize.A4, 50, 50, 50,50);
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(bestandsLocatie));
            document.open();
            
            Paragraph titel = new Paragraph(inhoud.getTitel(), FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLD));
            
            Paragraph afbeelding = new Paragraph();
            Image image = Image.getInstance(inhoud.getImage().getPath());
            double scale;
            BufferedImage afb = ImageIO.read(inhoud.getImage());
            if(afb.getHeight(null) < afb.getWidth(null))
            {
                scale = (double) 128 / (double) afb.getWidth(null);
            }
            else
            {
                scale = (double) 128 / (double) afb.getHeight(null);
            }
            image.scalePercent((float) scale);
            afbeelding.add(image);
            
            Paragraph auteurTtl = new Paragraph("Auteur: ", titelFont);
            Paragraph auteur = new Paragraph(inhoud.getNaamUploader(), basisTekstFont);
            
            Paragraph locatieTtl = new Paragraph("Locatie: ", titelFont);
            Paragraph locatie = new Paragraph(inhoud.getLocatie(), basisTekstFont);
            
            Paragraph topografieTtl = new Paragraph("Topografie: ", titelFont);
            Paragraph topografie = new Paragraph(inhoud.getTopografie(), basisTekstFont);
            
            Paragraph deelgemeenteTtl = new Paragraph("Deelgemeente: ", titelFont);
            Paragraph deelgemeente = new Paragraph(inhoud.getDeelgemeente(), basisTekstFont);
            
            Paragraph historiekTtl = new Paragraph("Historiek: ", titelFont);
            Paragraph historiek = new Paragraph(inhoud.getHistoriek(), basisTekstFont);
            
            Paragraph typeGebouwTtl = new Paragraph("Type Gebouw: ", titelFont);
            Paragraph typeGebouw = new Paragraph(inhoud.getTypeGebouw(), basisTekstFont);
            
            
            document.add(titel);
            document.add(afbeelding);
            document.add(auteurTtl);
            document.add(auteur);
            document.add(locatieTtl);
            document.add(locatie);
            document.add(topografieTtl);
            document.add(topografie);
            document.add(deelgemeenteTtl);
            document.add(deelgemeente);
            document.add(historiekTtl);
            document.add(historiek);
            document.add(typeGebouwTtl); 
            document.add(typeGebouw);
            
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (DocumentException e)
        {
            e.printStackTrace();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            document.close();
        }
    }
}
