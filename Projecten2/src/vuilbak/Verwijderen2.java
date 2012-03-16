package vuilbak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Verwijderen2 extends JFrame
{
    private PicturePanel picture;
    public Verwijderen2()
    {
        super("Verwijderen");

        picture = new PicturePanel();
        picture.setSize(700, 700);
        
        JButton verwijderenBtn = new JButton("Verwijderen");
        verwijderenBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                
            }
        });
        
        JButton terugBtn = new JButton("Terug");
        terugBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                dispose();
            }
        });
        
        JLabel locatieLbl = new JLabel("Locatie");
        JLabel topografieLbl = new JLabel("Topografische gegevens");
        JLabel deelgemeenteLbl = new JLabel("Deelgemeente");
        JLabel historiekLbl = new JLabel("Historiek");
        JLabel typeGebouwLbl = new JLabel("Type Gebouw");
        JLabel statusLbl = new JLabel("Status");
        
        JTextField locatieTxt = new JTextField();
        JTextField topografieTxt = new JTextField();
        JTextField deelgemeenteTxt = new JTextField();
        JTextField historiekTxt = new JTextField();
        JTextField typeGebouwTxt = new JTextField();
        JCheckBox statusChB = new JCheckBox("Goedgekeurd");
        
        locatieTxt.setEditable(false);
        topografieTxt.setEditable(false);
        deelgemeenteTxt.setEditable(false);
        historiekTxt.setEditable(false);
        typeGebouwTxt.setEditable(false);
        
        JPanel description = new JPanel();
       
        description.setBackground(Color.LIGHT_GRAY);
        description.setSize(350,700);
        
        description.setLayout(new GridLayout(15,1));
        description.add(locatieLbl);
        description.add(locatieTxt);
        description.add(topografieLbl);
        description.add(topografieTxt);
        description.add(deelgemeenteLbl);
        description.add(deelgemeenteTxt);
        description.add(historiekLbl);
        description.add(historiekTxt);
        description.add(typeGebouwLbl);
        description.add(typeGebouwTxt);
        description.add(statusLbl);
        description.add(statusChB);
        description.add(verwijderenBtn);
        description.add(terugBtn);
        
        setLayout(new BorderLayout());
        add(picture, BorderLayout.CENTER);
        add(description, BorderLayout.EAST);
        
        pack();
    }
}
