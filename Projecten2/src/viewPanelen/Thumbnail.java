package viewPanelen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Scale;
import controller.SelecteerCtrl;
import model.Inhoud;
import model.BufferModel;

@SuppressWarnings("serial")
public class Thumbnail extends JPanel implements MouseListener
{
    private Inhoud inhoud;
    private BufferModel model;
    
    public Thumbnail(Inhoud inh, BufferModel modl)
    {
        inhoud = inh;
        model = modl;
        setPreferredSize(new Dimension(175, 175));
        setBackground(new Color(200, 200, 200));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        //Abdeelding Thumbnail
        JLabel imgLbl = new JLabel();
        imgLbl.setPreferredSize(new Dimension(175, 120));
        if (inhoud.getImage() != null)
        {
            try
            {
                Image afb = ImageIO.read(inhoud.getImage());
                if(afb.getHeight(null) < afb.getWidth(null))
                {
                    imgLbl.setIcon(Scale.scale(afb, (double) 175 / (double) afb.getWidth(null)));
                }
                else
                {
                    imgLbl.setIcon(Scale.scale(afb, (double) 120 / (double) afb.getHeight(null)));
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            imgLbl.setIcon(new ImageIcon(getClass().getResource("/img/FotoNietBeschikbaar.png")));
        }
        
        JPanel beschrijving = new JPanel(new GridBagLayout());
        beschrijving.setBackground(new Color(28, 72, 161));
        beschrijving.setForeground(new Color(255, 255, 255));
        GridBagConstraints c1 = new GridBagConstraints();
        
        JLabel titel = new JLabel("Titel: " + inh.getTitel());
        titel.setForeground(new Color(255, 255, 255));
        JLabel uploader = new JLabel("Door: " + inhoud.getNaamUploader());
        uploader.setForeground(new Color(255, 255, 255));
        JLabel datum = new JLabel("Datum: " + inhoud.getDatumToevoegen());
        datum.setForeground(new Color(255, 255, 255));
        JLabel status = new JLabel();
        
        if(inhoud.getStatus())
            status.setIcon(new ImageIcon(getClass().getResource("/img/Bolletje-Groen.png")));
        else
            status.setIcon(new ImageIcon(getClass().getResource("/img/Bolletje-Rood.png")));
        c1.gridx = 0;
        c1.gridy = 0;
        beschrijving.add(titel, c1);
        c1.gridy = 1;
        beschrijving.add(uploader, c1);
        c1.gridy = 2;
        beschrijving.add(datum, c1);
        c1.gridy = 3;
        beschrijving.add(status, c1);
        
        
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,5,5,5);
        add(imgLbl, c);
        
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        add(beschrijving, c);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e)
    {
        new SelecteerCtrl(inhoud, model);
        setBackground(new Color(100, 100, 100));
    }
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e){}
    @Override
    public void mouseExited(java.awt.event.MouseEvent e){}
    @Override
    public void mousePressed(java.awt.event.MouseEvent e){}
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e){}
}