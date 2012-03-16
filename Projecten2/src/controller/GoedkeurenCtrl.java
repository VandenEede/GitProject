package controller;

import model.BufferModel;

public class GoedkeurenCtrl
{
    private BufferModel model;
    
    public GoedkeurenCtrl(BufferModel mod)
    {
        model = mod;
        model.getGeselecteerd().setStatus(true);
    }
}
