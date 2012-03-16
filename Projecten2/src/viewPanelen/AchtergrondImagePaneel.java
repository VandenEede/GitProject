package viewPanelen;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AchtergrondImagePaneel extends JPanel
{
    public AchtergrondImagePaneel()
    {
        setLayout(new GridBagLayout());
    }
    
    public void paintComponent(Graphics g) 
    {
        Image img = new ImageIcon(getClass().getResource("/img/GUIachtergrond.png")).getImage();
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        g.drawImage(img, 0, 0, null);
    }
}
