package viewPanelen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BufferModel;
import extra.PdfCreator;

@SuppressWarnings("serial")
public class ZoekPaneel extends JPanel
{
    private BufferModel model;
    private JTextField zoekenTxt;
    private Font fontKnoppenNormaal = new Font("Tahoma", Font.PLAIN, 16);
    
    public ZoekPaneel(BufferModel modl)
    {
        model = modl;
        setBackground(new Color(200, 200, 200));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        zoekenTxt = new JTextField(10);
        zoekenTxt.setText("zoeken...");
        zoekenTxt.setPreferredSize(new Dimension(128, 30));
        zoekenTxt.addFocusListener(new FocusListener()
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                if(zoekenTxt.getText().isEmpty())
                {
                    zoekenTxt.setText("zoeken...");
                }
                else
                {
                    
                }
            }
            @Override
            public void focusGained(FocusEvent arg0)
            {
                if(zoekenTxt.getText().equals("zoeken..."))
                {
                    zoekenTxt.setText("");
                }
            }
        });
        c.gridx = 0;
        c.gridy = 0;
        add(zoekenTxt, c);
        
        
        JLabel zoekLbl = new JLabel();
        zoekLbl.setIcon(new ImageIcon(getClass().getResource("/img/labelzoekenApartVergrootglas.png")));
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        add(zoekLbl, c);

        JButton overzichtDownloaden = new JButton("PDF");
        overzichtDownloaden.setBackground(new Color(28,72,161));
        overzichtDownloaden.setForeground(new Color(255, 255, 255));
        overzichtDownloaden.setFont(fontKnoppenNormaal);
        overzichtDownloaden.setPreferredSize(new Dimension(128, 30));
        overzichtDownloaden.addActionListener(new ActionListener()
        {
            @SuppressWarnings("unused")
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFileChooser laden = new JFileChooser();
                int keuze = laden.showSaveDialog(null);
                
                if(keuze == JFileChooser.APPROVE_OPTION)
                {
                    PdfCreator pdfCreator = new PdfCreator(model.getGeselecteerd(), laden.getSelectedFile().getPath());
                }
            }
        });
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 0, 0, 0);
        add(overzichtDownloaden, c);
    
    }
}
