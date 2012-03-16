package vuilbak;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AfbeeldingsPaneelOrigineel extends JPanel
{
    private BufferedImage image;
    
    
    public AfbeeldingsPaneelOrigineel()
    {
        setBackground(new Color(58,58,58));
    }
    
    public void setImage(BufferedImage image)
    {
        this.image = image;
    }

    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        g2.drawImage(image, 5, 5, null);
    }
}
