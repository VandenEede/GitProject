package vuilbak;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import model.Inhoud;

@SuppressWarnings("serial")
public class Topografie extends JFrame
{
    private JTextArea info;
    private Inhoud inhoud;
    
    public Topografie(Inhoud inhoud)
    {
        this.inhoud = inhoud;
    
        JLabel titel = new JLabel();
        titel.setText("Topografie");
        titel.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        info = new JTextArea();
        info.setFont(new Font("Tahoma", Font.BOLD, 14));
        info.setText(inhoud.getTopografie());
        
        JButton terug = new JButton("terug");
        terug.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Topografie.this.inhoud.setTopografie(info.getText());
                setVisible(false);
            }
        });
        
        setLayout(new BorderLayout());
        add(titel, BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);
        add(terug, BorderLayout.SOUTH);
        
        pack();
    }
}
