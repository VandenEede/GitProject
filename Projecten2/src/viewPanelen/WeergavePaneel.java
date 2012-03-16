package viewPanelen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Inhoud;
import model.BufferModel;

@SuppressWarnings("serial")
public class WeergavePaneel extends JPanel implements ChangeListener
{
    private BufferModel model;
    
    
    public WeergavePaneel(BufferModel model)
    {
        this.model = model;
        this.model.subscribe(this);
        setBackground(new Color(200, 200, 200));
        setPreferredSize(new Dimension(740, 410));
        setLayout(new GridLayout(2,4));
        refresh(model);
    }
    
    
    public void refresh(BufferModel model)
    {
        setVisible(false);
        removeAll();
        GridBagConstraints c = new GridBagConstraints();
        
        int x = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 5, 10, 5);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        Iterator<Inhoud> i = model.getTijdelijkeOpslagInhoud();
        while(i.hasNext())
        {
            if(x < 4)
            {
                c.gridx = x;
                Thumbnail thumb = new Thumbnail(i.next(), model);
                add(thumb, c);
                x++;
            }
            else 
            {
                x = 0;
                c.gridx = x;
                c.gridy = 1;
                Thumbnail thumb = new Thumbnail(i.next(), model);
                add(thumb, c);
                x++;
            }
        }
        setVisible(true);
    }


    @Override
    public void stateChanged(ChangeEvent e)
    {
        //refresh(model);
        //repaint();
    }
}
