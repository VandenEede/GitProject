package viewPanelen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Scale;

import model.Inhoud;

@SuppressWarnings("serial")
public class AfbeeldingToevoegenPaneel extends JPanel
{
    private Inhoud inhoud;
    private JLabel thumbnailLbl;
    private JTextField auteurTxt;
    
    public AfbeeldingToevoegenPaneel(Inhoud inh)
    {
        this.inhoud = inh;
        setBackground(new Color(200, 200, 200));
        setLayout(new GridBagLayout());
        
        thumbnailLbl = new JLabel();
        thumbnailLbl.setPreferredSize(new Dimension(128,128));
        if(inhoud.getImage() != null)
        {
            try
            {
                thumbnailLbl.setIcon(new ImageIcon(ImageIO.read(inhoud.getImage())));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            thumbnailLbl.setIcon(new ImageIcon(getClass().getResource("/img/afbeeldingToevoegen.png")));
        }
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        add(thumbnailLbl, c);
        
        
        JButton wijzigAfbeeldingBtn = new JButton("Afbeelding wijzigen");
        wijzigAfbeeldingBtn.setPreferredSize(new Dimension(128, 30));
        wijzigAfbeeldingBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFileChooser laden = new JFileChooser();
                int keuze = laden.showOpenDialog(null);
                
                if(keuze == JFileChooser.APPROVE_OPTION)
                {
                    inhoud.setImage(laden.getSelectedFile());
                    try
                    {
                        Image afb = ImageIO.read(inhoud.getImage());

                        if(afb.getHeight(null) < afb.getWidth(null))
                        {
                             thumbnailLbl.setIcon(Scale.scale(afb, (double) 128 / (double) afb.getWidth(null)));
                        }
                        else
                        {
                            thumbnailLbl.setIcon(Scale.scale(afb, (double) 128 / (double) afb.getHeight(null)));
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 0, 0, 0);
        add(wijzigAfbeeldingBtn, c);
        
        auteurTxt = new JTextField("Naam auteur...");
        auteurTxt.addFocusListener(new FocusListener()
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                if(auteurTxt.getText().isEmpty())
                {
                    auteurTxt.setText("Naam auteur...");
                }
                else
                {
                    inhoud.setNaamUploader(auteurTxt.getText());
                }
            }
            
            @Override
            public void focusGained(FocusEvent arg0)
            {
                if(auteurTxt.getText().equals("Naam auteur..."))
                {
                    auteurTxt.setText("");
                }
            }
        });
        auteurTxt.setPreferredSize(new Dimension(128, 30));
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 0, 0, 0);
        add(auteurTxt, c);
    }
}
