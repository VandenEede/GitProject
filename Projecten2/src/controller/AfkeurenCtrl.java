package controller;

import model.BufferModel;

public class AfkeurenCtrl
{
private BufferModel model;
    
    public AfkeurenCtrl(BufferModel mod)
    {
        model = mod;
        model.getGeselecteerd().setStatus(false);
    }
}
