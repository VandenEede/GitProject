package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.AfkeurenCtrl;
import controller.GoedkeurenCtrl;
import controller.VerwijderenCtrl;
import viewPanelen.AchtergrondImagePaneel;
import viewPanelen.WeergavePaneel;
import viewPanelen.ZoekPaneel;
import model.BufferModel;

@SuppressWarnings("serial")
public class Home extends JFrame implements ChangeListener
{   
    private BufferModel model;
    private AchtergrondImagePaneel achtergrondImgPaneel;
    private WeergavePaneel weergavePaneel;
    private Font fontKnoppenNormaal = new Font("Tahoma", Font.PLAIN, 16);
    
    
    public Home(BufferModel bufferModel)
    {
        super("EMS");
        setBufferModel(bufferModel);
        achtergrondImgPaneel = new AchtergrondImagePaneel();
        model.subscribe(this);
        GridBagConstraints c = new GridBagConstraints();
        
        
        //Rij 0
        JLabel welkomLbl = new JLabel("Welkom, Gebruiker");
        welkomLbl.setForeground(new Color(255, 255, 255));
        c.insets = new Insets(10, 20, 5, 0);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(welkomLbl, c);
        
        
        //Rij 1
        JLabel toevoegenBtn = new JLabel();
        toevoegenBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseReleased(MouseEvent arg0){}
            @Override
            public void mousePressed(MouseEvent arg0){}
            @Override
            public void mouseExited(MouseEvent arg0){}
            @Override
            public void mouseEntered(MouseEvent arg0){}
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                Toevoegen toevoegen = new Toevoegen(getBufferModel());
                toevoegen.setVisible(true);
                toevoegen.setSize(1050,700);
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension scrnsize = toolkit.getScreenSize();
                toevoegen.setLocation((int)(scrnsize.getWidth()/2-toevoegen.getWidth()/2),(int)(scrnsize.getHeight()/2-toevoegen.getHeight()/2));
                setVisible(false);
            }
        });
        toevoegenBtn.setIcon(new ImageIcon(getClass().getResource("/img/knoptoevoegen.png")));
        c.insets = new Insets(0, 20, 10, 10);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(toevoegenBtn, c);
        
        JLabel verwijderenBtn = new JLabel();
        verwijderenBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseReleased(MouseEvent arg0){}
            @Override
            public void mousePressed(MouseEvent arg0){}
            @Override
            public void mouseExited(MouseEvent arg0){}
            @Override
            public void mouseEntered(MouseEvent arg0){}
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                new VerwijderenCtrl(model);
                //weergavePaneel.refresh();
            }
        });
        verwijderenBtn.setIcon(new ImageIcon(getClass().getResource("/img/knopverwijderen.png")));
        c.insets = new Insets(0, 0, 10, 10);
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(verwijderenBtn, c);
        
        JLabel goedKeurenBtn = new JLabel();
        goedKeurenBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseReleased(MouseEvent arg0){}
            @Override
            public void mousePressed(MouseEvent arg0){}
            @Override
            public void mouseExited(MouseEvent arg0){}
            @Override
            public void mouseEntered(MouseEvent arg0){}
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                new GoedkeurenCtrl(model);
                //weergavePaneel.refresh();
            }
        });
        goedKeurenBtn.setIcon(new ImageIcon(getClass().getResource("/img/knopGoedkeuren.png")));
        c.insets = new Insets(0, 0, 10, 10);
        c.gridx = 2;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(goedKeurenBtn, c);
        
        JLabel afkeurenBtn = new JLabel();
        afkeurenBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseReleased(MouseEvent arg0){}
            @Override
            public void mousePressed(MouseEvent arg0){}
            @Override
            public void mouseExited(MouseEvent arg0){}
            @Override
            public void mouseEntered(MouseEvent arg0){}
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                new AfkeurenCtrl(model);
                //weergavePaneel.refresh();
            }
        });
        afkeurenBtn.setIcon(new ImageIcon(getClass().getResource("/img/knopAfkeuren.png")));
        c.insets = new Insets(0, 0, 10, 10);
        c.gridx = 3;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(afkeurenBtn, c);
        
        JLabel afmeldenBtn = new JLabel();
        afmeldenBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseReleased(MouseEvent arg0){}
            @Override
            public void mousePressed(MouseEvent arg0){}
            @Override
            public void mouseExited(MouseEvent arg0){}
            @Override
            public void mouseEntered(MouseEvent arg0){}
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                Login login = new Login();
                login.setSize(1000, 700);
                login.setVisible(true);
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension scrnsize = toolkit.getScreenSize();
                login.setLocation((int)(scrnsize.getWidth()/2-login.getWidth()/2),(int)(scrnsize.getHeight()/2-login.getHeight()/2));
                dispose();
            }
        });
        afmeldenBtn.setIcon(new ImageIcon(getClass().getResource("/img/knopafmelden.png")));
        c.insets = new Insets(0, 95, 10, 20);
        c.gridx = 7;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        achtergrondImgPaneel.add(afmeldenBtn, c);
        
        
        //Rij 2
        //Tekst op deze knop moet nog afhankelijk worden van het aantal nieuwe items.
        JButton nieuwBtn = new JButton("Nieuw (0)");
        nieuwBtn.setBackground(new Color(28, 72, 161));
        nieuwBtn.setForeground(new Color(255, 255, 255));
        nieuwBtn.setFont(fontKnoppenNormaal);
        nieuwBtn.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // TODO Auto-generated method stub
                
            }
        });
        c.insets = new Insets(10, 20, 0, 0);
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(nieuwBtn, c);
        
        //Bevat de afgekeurde inzendingen
        JButton archiefBtn = new JButton("Archief");
        archiefBtn.setBackground(new Color(28,72,161));
        archiefBtn.setForeground(new Color(255, 255, 255));
        archiefBtn.setFont(fontKnoppenNormaal);
        archiefBtn.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // TODO Auto-generated method stub
                
            }
        });
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(archiefBtn, c);
        
        //De nog goed te keuren lijst
        JButton wachtrijBtn = new JButton("Wachtrij");
        wachtrijBtn.setBackground(new Color(28,72,161));
        wachtrijBtn.setForeground(new Color(255, 255, 255));
        wachtrijBtn.setFont(fontKnoppenNormaal);
        wachtrijBtn.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // TODO Auto-generated method stub
                
            }
        });
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(wachtrijBtn, c);
        
        JButton allesBtn = new JButton("Alles (000)");
        allesBtn.setBackground(new Color(28,72,161));
        allesBtn.setForeground(new Color(255, 255, 255));
        allesBtn.setFont(fontKnoppenNormaal);
        allesBtn.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                //weergavePaneel.refresh();
            }
        });
        c.insets = new Insets(10, 0, 0, 210);
        c.gridx = 3;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(allesBtn, c);
        
        // Keuze in de weergave. Tegels = thumbnails | Lijst = JList
        JLabel tegelsBtn = new JLabel();
        tegelsBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseReleased(MouseEvent arg0){}
            @Override
            public void mousePressed(MouseEvent arg0){}
            @Override
            public void mouseExited(MouseEvent arg0){}
            @Override
            public void mouseEntered(MouseEvent arg0){}
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                // TODO Auto-generated method stub
                
            }
        });
        tegelsBtn.setIcon(new ImageIcon(getClass().getResource("/img/weergaveApartBlokjes.png")));
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 4;
        c.gridy = 2;
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(tegelsBtn, c);
        
        JLabel lijstBtn = new JLabel();
        lijstBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseReleased(MouseEvent arg0){}
            @Override
            public void mousePressed(MouseEvent arg0){}
            @Override
            public void mouseExited(MouseEvent arg0){}
            @Override
            public void mouseEntered(MouseEvent arg0){}
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                // TODO Auto-generated method stub
                
            }
        });
        lijstBtn.setIcon(new ImageIcon(getClass().getResource("/img/weergaveApartLijntjes.png")));
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 5;
        c.gridy = 2;
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(lijstBtn, c);
        
        
        //Rij 3      
        weergavePaneel = new WeergavePaneel(getBufferModel());
        c.insets = new Insets(0, 20, 5, 0);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 6;
        c.gridheight = 2;
        c.weighty = 0.90;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(weergavePaneel, c);
        
        ZoekPaneel zoekPaneel = new ZoekPaneel(model);
        c.insets = new Insets(0, 30, 5, 20);
        c.gridx = 6;
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(zoekPaneel, c);
        
        
        //Rij 4
        JPanel logoPaneel = new JPanel();
        logoPaneel.setBackground(new Color(200, 200, 200));
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/img/inlogBeeFiveLogo.png")));
        logoPaneel.add(logo);
        c.insets = new Insets(0, 30, 5, 20);
        c.gridx = 6;
        c.gridy = 4;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(logoPaneel, c);
        
    
        // Rij 5
        JPanel navigatiePaneel = new JPanel();
        navigatiePaneel.setBackground(new Color(249, 249, 249));
        
        JLabel vorigeBtn = new JLabel();
        vorigeBtn.setIcon(new ImageIcon(getClass().getResource("/img/pijl-links.png")));
        navigatiePaneel.add(vorigeBtn);
        
        JLabel volgendeBtn = new JLabel();
        volgendeBtn.setIcon(new ImageIcon(getClass().getResource("/img/pijl-rechts.png")));
        navigatiePaneel.add(volgendeBtn);
        
        c.insets = new Insets(20, 20, 20, 20);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 7;
        c.gridheight = 1;
        c.weightx = 1.00;
        c.weighty = 0.01;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(navigatiePaneel, c);
        
        
        add(achtergrondImgPaneel);
    }

    
    public BufferModel getBufferModel()
    {
        return model;
    }
    public void setBufferModel(BufferModel bufferModel)
    {
        this.model = bufferModel;
    }


    @Override
    public void stateChanged(ChangeEvent e)
    {
        weergavePaneel.refresh(getBufferModel());
    }
}