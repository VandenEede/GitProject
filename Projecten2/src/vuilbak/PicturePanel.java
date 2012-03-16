package vuilbak;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PicturePanel extends JPanel
{
    private BufferedImage image;
    private ArrayList<BufferedImage> imageDisplay;
    private static final int IMG_WIDTH = 200;
    private static final int IMG_HEIGHT = 200;
    
    public PicturePanel()
    {  
        imageDisplay = new ArrayList<BufferedImage>();
        this.setBackground(new Color(58,58,58));
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Iterator<BufferedImage> i = imageDisplay.iterator();
        int x = 10;
        int y = 10;
        
        while(i.hasNext())
        {        
            BufferedImage temp = i.next();
            
            if(x + 220 >= 700)
            {
                x = 10;
                y += 300;
                g2.drawImage(temp, x, y, null);
                x += 220;
            }
            else
            {
                g2.drawImage(temp, x, y, null);
                x += 220;
            }
        }
    }


    public BufferedImage getImage()
    {
        return image;
    }

    public void setImage(File image)
    {
        try
        {
            BufferedImage originalImage = ImageIO.read(image);
            int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
            imageDisplay.add(resizeImageWithHint(originalImage, type));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "De afbeelding kon niet worden ingeladen. Probeer opnieuw");
        }
        catch (NullPointerException e)
        {
            JOptionPane.showMessageDialog(this, "Dit is geen geldig type. Probeer opnieuw");
        }
    }
    
    /*
     * Om alle afbeeldingen met dezelfde groote te krijgen
     * http://www.mkyong.com/java/how-to-resize-an-image-in-java/
     */
    
    private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type)
    {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();    
        g.setComposite(AlphaComposite.Src);
     
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
     
        return resizedImage;
    }

    public ArrayList<BufferedImage> getImageList()
    {
        return imageDisplay;
        
    }
}
