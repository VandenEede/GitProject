package vuilbak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfDemo
{
    public PdfDemo()
    {
        Document document = new Document(PageSize.A4, 50, 50, 50,50);
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Documents and Settings\\Administrator\\Mijn documenten\\testPDF.pdf"));
            document.open();
            
            document.add(new Paragraph("EMS", FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.BOLDITALIC)));
            document.add(new Paragraph("A BeeFive production, Maar toch vooral van Thomas D'Hauwe"));
            document.close();
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print("File not found");
        }
        catch (DocumentException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new PdfDemo();
    }

}
