package controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public abstract class Scale
{
    public static ImageIcon scale(Image src, double scale)
    {
       int w = (int)(scale*src.getWidth(null));
       int h = (int)(scale*src.getHeight(null));
       int type = BufferedImage.TYPE_INT_RGB;
       BufferedImage dst = new BufferedImage(w, h, type);
       Graphics2D g2 = dst.createGraphics();
       g2.drawImage(src, 0, 0, w, h, null);
       g2.dispose();
       return new ImageIcon(dst);
   }
}
