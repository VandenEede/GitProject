package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import viewPanelen.AchtergrondImagePaneel;
import viewPanelen.AfbeeldingToevoegenPaneel;
import viewPanelen.InformatieToevoegen;

import model.Inhoud;
import model.BufferModel;

@SuppressWarnings("serial")
public class Toevoegen extends JFrame
{   
    private BufferModel bufferModel;
    private Inhoud inhoud;
    private AchtergrondImagePaneel achtergrondImgPaneel;
    private InformatieToevoegen informatiePaneel;
    private Font fontKnoppenNormaal = new Font("Tahoma", Font.PLAIN, 16);
    private JTextField titelTxt;
    
    
    public Toevoegen(BufferModel bufferModel)
    {
        super("EMS");
        setTijdelijkeOpslagModel(bufferModel);
        inhoud = new Inhoud();
        achtergrondImgPaneel = new AchtergrondImagePaneel();        
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
        
        
        //Rij 1(c.gridy = 1)
        JLabel startpaginaBtn = new JLabel();
        startpaginaBtn.addMouseListener(new MouseListener()
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
                Home home = new Home(getTijdelijkeOpslagModel());
                home.setVisible(true);
                home.setSize(1050,700);
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension scrnsize = toolkit.getScreenSize();
                home.setLocation((int)(scrnsize.getWidth()/2-home.getWidth()/2),(int)(scrnsize.getHeight()/2-home.getHeight()/2));
                dispose();
            }
        });
        startpaginaBtn.setIcon(new ImageIcon(getClass().getResource("/img/StartPaginaKnop.png")));
        c.insets = new Insets(0, 20, 10, 10);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(startpaginaBtn, c);
        
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
                
            }
        });
        verwijderenBtn.setIcon(new ImageIcon(getClass().getResource("/img/knopverwijderen.png")));
        c.insets = new Insets(0, 0, 10, 10);
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(verwijderenBtn, c);
        
        JLabel goedkeurenBtn = new JLabel();
        goedkeurenBtn.addMouseListener(new MouseListener()
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
                
            }
        });
        goedkeurenBtn.setIcon(new ImageIcon(getClass().getResource("/img/knopGoedkeuren.png")));
        c.insets = new Insets(0, 0, 10, 10);
        c.gridx = 2;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(goedkeurenBtn, c);
        
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
                
            }
        });
        afkeurenBtn.setIcon(new ImageIcon(getClass().getResource("/img/knopAfkeuren.png")));
        c.insets = new Insets(0, 0, 10, 10);
        c.gridx = 3;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(afkeurenBtn, c);
        
        JLabel afsluitenBtn = new JLabel();
        afsluitenBtn.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseReleased(MouseEvent arg0){}
            @Override
            public void mousePressed(MouseEvent arg0){}
            @Override
            public void mouseExited(MouseEvent arg0){}
            @Override
            public void mouseEntered(MouseEvent arg0)
            {}
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
        afsluitenBtn.setIcon(new ImageIcon(getClass().getResource("/img/knopafmelden.png")));
        c.insets = new Insets(0, 90, 10, 20);
        c.gridx = 6;
        c.anchor = GridBagConstraints.EAST;
        achtergrondImgPaneel.add(afsluitenBtn, c);
        
        
        //Rij 2
        titelTxt = new JTextField("Geef hier de titel...");
        titelTxt.addFocusListener(new FocusListener()
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                if(titelTxt.getText().isEmpty())
                {
                    titelTxt.setText("Geef hier de titel...");
                }
                else
                {
                    inhoud.setTitel(titelTxt.getText());
                }
            }
            @Override
            public void focusGained(FocusEvent arg0)
            {
                if(titelTxt.getText().equals("Geef hier de titel..."))
                {
                    titelTxt.setText("");
                }
            }
        });
        c.insets = new Insets(0, 20, 5, 0);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 5;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(titelTxt, c);
        
        
        //Rij 3 (c.gridy = 3)
        JButton locatieBtn = new JButton("Locatie");
        locatieBtn.setBackground(new Color(28, 72, 161));
        locatieBtn.setForeground(new Color(255, 255, 255));
        locatieBtn.setFont(fontKnoppenNormaal);
        locatieBtn.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                informatiePaneel.setOneVisibleTrue("locatie");
            }
        });
        c.insets = new Insets(10, 20, 0, 0);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(locatieBtn, c);
        
        JButton topografieBtn = new JButton("Topografie");
        topografieBtn.setBackground(new Color(28,72,161));
        topografieBtn.setForeground(new Color(255, 255, 255));
        topografieBtn.setFont(fontKnoppenNormaal);
        topografieBtn.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                informatiePaneel.setOneVisibleTrue("topografie");
            }
        });
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(topografieBtn, c);
        
        JButton deelgemeenteBtn = new JButton("Deelgemeente");
        deelgemeenteBtn.setBackground(new Color(28,72,161));
        deelgemeenteBtn.setForeground(new Color(255, 255, 255));
        deelgemeenteBtn.setFont(fontKnoppenNormaal);
        deelgemeenteBtn.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                informatiePaneel.setOneVisibleTrue("deelgemeente");
            }
        });
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 2;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(deelgemeenteBtn, c);
        
        JButton historiekBtn = new JButton("Historiek");
        historiekBtn.setBackground(new Color(28,72,161));
        historiekBtn.setForeground(new Color(255, 255, 255));
        historiekBtn.setFont(fontKnoppenNormaal);
        historiekBtn.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                informatiePaneel.setOneVisibleTrue("historiek");
            }
        });
        c.insets = new Insets(10, 0, 0, 0);
        c.gridx = 3;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(historiekBtn, c);
        
        JButton typeGebouwBtn = new JButton("Type Gebouw");
        typeGebouwBtn.setBackground(new Color(28,72,161));
        typeGebouwBtn.setForeground(new Color(255, 255, 255));
        typeGebouwBtn.setFont(fontKnoppenNormaal);
        typeGebouwBtn.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                informatiePaneel.setOneVisibleTrue("typeGebouw"); 
            }
        });
        c.insets = new Insets(10, 0, 0, 100);
        c.gridx = 4;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(typeGebouwBtn, c);
        
        
        //Rij 4      
        informatiePaneel = new InformatieToevoegen(inhoud);
        c.insets = new Insets(0, 20, 5, 0);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 5;
        c.gridheight = 2;
        c.weighty = 0.99;
        achtergrondImgPaneel.add(informatiePaneel, c);
        
        AfbeeldingToevoegenPaneel afbeeldingToevoegenPaneel = new AfbeeldingToevoegenPaneel(inhoud);
        c.insets = new Insets(0, 70, 5, 20);
        c.gridx = 5;
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 3;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(afbeeldingToevoegenPaneel, c);
        
        
        //Rij 5
        JPanel logoPaneel = new JPanel();
        logoPaneel.setBackground(new Color(200, 200, 200));
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/img/inlogBeeFiveLogo.png")));
        logoPaneel.add(logo);
        c.insets = new Insets(0, 70, 5, 20);
        c.gridx = 5;
        c.gridy = 5;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(logoPaneel, c);
        
    
        // Rij 6
        JPanel navigatiePaneel = new JPanel();
        navigatiePaneel.setBackground(new Color(249, 249, 249));
        
        JButton opslaanBtn = new JButton("Opslaan");
        opslaanBtn.setBackground(new Color(28,72,161));
        opslaanBtn.setForeground(new Color(255, 255, 255));
        opslaanBtn.setFont(fontKnoppenNormaal);
        opslaanBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                inhoud.setDatumToevoegen(sdf.format(cal.getTime()));
                Toevoegen.this.bufferModel.addItem(inhoud);
            }
        });
        navigatiePaneel.add(opslaanBtn);
        
        c.insets = new Insets(20, 20, 20, 20);
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 6;
        c.gridheight = 1;
        c.weightx = 1.00;
        c.weighty = 0.01;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(navigatiePaneel, c);
        
        
        add(achtergrondImgPaneel);
    }

    
    public BufferModel getTijdelijkeOpslagModel()
    {
        return bufferModel;
    }
    public void setTijdelijkeOpslagModel(BufferModel bufferModel)
    {
        this.bufferModel = bufferModel;
    }
}