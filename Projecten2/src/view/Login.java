package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.BufferModel;

@SuppressWarnings("serial")
public class Login extends JFrame
{   
    private BufferModel bufferModel;
    private JPanel achtergrondImgPaneel;
    private Font fontKnoppenNormaal = new Font("Tahoma", Font.PLAIN, 16);
    
    
    public Login()
    {
        super("Inloggen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setTijdelijkeOpslagModel(new BufferModel());
         
        achtergrondImgPaneel = new JPanel(new GridBagLayout())
        {
            public void paintComponent(Graphics g) 
            {
                Image img = new ImageIcon(getClass().getResource("/img/GUI-InlogAchtergrond.png")).getImage();
                Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(null);
                g.drawImage(img, 0, 0, null);
            }
        };
        GridBagConstraints c = new GridBagConstraints();
        
        JLabel login = new JLabel();
        login.setIcon(new ImageIcon(getClass().getResource("/img/loginTitel.png")));
        c.insets = new Insets(-300, 500, 50, 450);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 0;
        c.gridheight = 0;
        c.fill = GridBagConstraints.NONE;
        achtergrondImgPaneel.add(login, c);
        
        JLabel gebruikersnaamLbl = new JLabel("Gebruikersnaam");
        gebruikersnaamLbl.setFont(fontKnoppenNormaal);
        c.insets = new Insets(-165, 420, 0, 450);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(gebruikersnaamLbl, c);
        
        JTextField gebruikersnaamTxt = new JTextField(65);
        c.insets = new Insets(-70, 420, 35, 400);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 5;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(gebruikersnaamTxt, c);
        
        JLabel paswoordLbl = new JLabel("Wachtwoord");
        paswoordLbl.setFont(fontKnoppenNormaal);
        c.insets = new Insets(-30, 420, 0, 450);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(paswoordLbl, c);
        
        JPasswordField paswoordTxt = new JPasswordField(65);
        c.insets = new Insets(0, 420, -35, 400);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 5;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(paswoordTxt, c);
        
        JLabel vergetenLbl = new JLabel("Wachtwoord vergeten?");
        c.insets = new Insets(45, 420, 0, 400);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(vergetenLbl, c);
        
        JButton loginBtn = new JButton("Inloggen");
        loginBtn.setBackground(new Color(28, 72, 161));
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setFont(fontKnoppenNormaal);
        loginBtn.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent e)
			{
                Home home =  new Home(new BufferModel());
                home.setVisible(true);
                home.setSize(1000,700);
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension scrnsize = toolkit.getScreenSize();
                home.setLocation((int)(scrnsize.getWidth()/2-home.getWidth()/2),(int)(scrnsize.getHeight()/2-home.getHeight()/2));  
                dispose();
			}            
        });
        c.insets = new Insets(45, 600, 0, 269);
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(loginBtn, c);
        
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/img/inlogBeeFiveLogo.png")));
        c.insets = new Insets(-100, 500, -375, 450);
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 4;
        c.gridheight = 5;
        c.fill = GridBagConstraints.BOTH;
        achtergrondImgPaneel.add(logo, c);

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
