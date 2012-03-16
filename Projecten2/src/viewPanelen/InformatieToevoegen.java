package viewPanelen;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Inhoud;

@SuppressWarnings("serial")
public class InformatieToevoegen extends JPanel
{
    private JTextArea locatieTxt, topografieTxt, deelgemeenteTxt, historiekTxt, typeGebouwTxt;
    private Inhoud inhoud;
    
    public InformatieToevoegen(Inhoud inhoud)
    {
        this.inhoud = inhoud;
        setBackground(new Color(200, 200, 200));
        setPreferredSize(new Dimension(740, 410));
        
        locatieTxt = new JTextArea();
        locatieTxt.setPreferredSize(new Dimension(600, 300));
        locatieTxt.setText(inhoud.getLocatie());
        topografieTxt = new JTextArea();
        topografieTxt.setPreferredSize(new Dimension(600, 300));
        topografieTxt.setText(inhoud.getTopografie());
        deelgemeenteTxt = new JTextArea();
        deelgemeenteTxt.setPreferredSize(new Dimension(600, 300));
        deelgemeenteTxt.setText(inhoud.getDeelgemeente());
        historiekTxt = new JTextArea();
        historiekTxt.setPreferredSize(new Dimension(600, 300));
        historiekTxt.setText(inhoud.getHistoriek());
        typeGebouwTxt = new JTextArea();
        typeGebouwTxt.setPreferredSize(new Dimension(600, 300));
        typeGebouwTxt.setText(inhoud.getTypeGebouw());
        setAllVisibleFalse();
        
        add(locatieTxt);
        add(topografieTxt);
        add(deelgemeenteTxt);
        add(historiekTxt);
        add(typeGebouwTxt);        
    }
    
    public void setOneVisibleTrue(String match)
    {
        setAllVisibleFalse();
        
        if(match.equals("locatie")){
            locatieTxt.setVisible(true);
        }
        else if (match.equals("topografie")) {
            topografieTxt.setVisible(true);
        }
        else if (match.equals("deelgemeente")) {
            deelgemeenteTxt.setVisible(true);
        }
        else if (match.equals("historiek")) {
            historiekTxt.setVisible(true);
        }
        else if (match.equals("typeGebouw")) {
            typeGebouwTxt.setVisible(true);
        }
    }
    
    public void setAllVisibleFalse()
    {
        locatieTxt.setVisible(false);
        topografieTxt.setVisible(false);
        deelgemeenteTxt.setVisible(false);
        historiekTxt.setVisible(false);
        typeGebouwTxt.setVisible(false);
        
        inhoud.setLocatie(locatieTxt.getText());
        inhoud.setTopografie(topografieTxt.getText());
        inhoud.setDeelgemeente(deelgemeenteTxt.getText());
        inhoud.setHistoriek(historiekTxt.getText());
        inhoud.setTypeGebouw(typeGebouwTxt.getText());
    }
}
