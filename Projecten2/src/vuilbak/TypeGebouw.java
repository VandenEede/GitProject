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
public class TypeGebouw extends JFrame
{
    private JTextArea info;
    private Inhoud inhoud;
    
    public TypeGebouw(Inhoud inhoud)
    {
        this.inhoud = inhoud;
        
        JLabel titel = new JLabel();
        titel.setText("TypeGebouw");
        titel.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        info = new JTextArea();
        info.setFont(new Font("Tahoma", Font.BOLD, 14));
        info.setText(inhoud.getTypeGebouw());
        
        JButton terug = new JButton("terug");
        terug.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TypeGebouw.this.inhoud.setTypeGebouw(info.getText());
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
