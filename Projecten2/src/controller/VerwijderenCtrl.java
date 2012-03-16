package controller;

import javax.swing.JOptionPane;

import model.BufferModel;

public class VerwijderenCtrl
{
    private BufferModel model;
    
    public VerwijderenCtrl(BufferModel mod)
    {
        model = mod;
        JOptionPane.showConfirmDialog(null, "Bent u zeker dat u \n\t" + model.getGeselecteerd().getTitel() 
                + "\n door: \n\t" + model.getGeselecteerd().getNaamUploader() 
                + "\nwilt verwijderen", "Bevestig verwijderen", JOptionPane.YES_NO_OPTION);
        model.removeItem(model.getGeselecteerd());
    }
}
