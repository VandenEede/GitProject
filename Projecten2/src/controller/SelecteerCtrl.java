package controller;

import model.BufferModel;
import model.Inhoud;

public class SelecteerCtrl
{
    private BufferModel model;
    private Inhoud inhoud;
    
    public SelecteerCtrl(Inhoud i, BufferModel modl)
    {
        inhoud = i;
        model = modl;
        
        model.setGeselecteerd(inhoud);
    }

}
