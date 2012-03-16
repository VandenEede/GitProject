package model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BufferModel
{
    private transient ArrayList<ChangeListener> listeners;
    private ArrayList<Inhoud> buffer;
    private Inhoud geselecteerd;
    
    
    public BufferModel()
    {
        listeners = new ArrayList<ChangeListener>();
        buffer = new ArrayList<Inhoud>();
        geselecteerd = new Inhoud();
    }
    
    public ArrayList<Inhoud> getTijdelijkeOpslagLijst()
    {
        return buffer;
    }
    public Iterator<Inhoud> getTijdelijkeOpslagInhoud()
    {
        return buffer.iterator();
    }
    public Inhoud getGeselecteerd()
    {
        return geselecteerd;
    }

    public void addItem(Inhoud item)
    {
        buffer.add(item);
        notifyChangeListeners();
    }
    public void removeItem(Inhoud inhoud)
    {
        buffer.remove(inhoud);
        notifyChangeListeners();
    }

    public void setGeselecteerd(Inhoud geselecteerd)
    {
        this.geselecteerd = geselecteerd;
    }
    
    
    public void subscribe(ChangeListener l) 
    {
        listeners.add(l);
    }   
    public void unsubscribe(ChangeListener l) 
    {
        listeners.remove(l);
    }
    public void notifyChangeListeners() 
    {
        ChangeEvent e = new ChangeEvent(this);
        for (ChangeListener l : listeners)
            l.stateChanged(e);
    }
}
