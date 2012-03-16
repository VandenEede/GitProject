package vuilbak;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import viewPanelen.Thumbnail;

@SuppressWarnings("serial")
public class PicturePanel2 extends JPanel implements MouseListener
{
    private BufferedImage image;
    private ArrayList<BufferedImage> imageDisplay;
    private static final int IMG_WIDTH = 200;
    private static final int IMG_HEIGHT = 200;
    
    public PicturePanel2()
    {  
        imageDisplay = new ArrayList<BufferedImage>();
        this.setBackground(new Color(58,58,58));
    }

    public void laadThumbnails()
    {
        removeAll();
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        
        Iterator<BufferedImage> i = imageDisplay.iterator();
        while(i.hasNext())
        {
            if(c.gridx <= 3)
                c.gridx ++;
            else
            {
                c.gridx = 0;
                c.gridy ++;
            }
            c.insets = new Insets(10, 10, 30, 10);
            c.fill = GridBagConstraints.BOTH;
            
            Thumbnail temp = new Thumbnail(null, null);
            temp.setBackground(Color.RED);
            temp.setPreferredSize(new Dimension(200, 200));
            add(temp, c);
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

    @Override
    public void mouseClicked(MouseEvent e)
    {
     // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }
}
