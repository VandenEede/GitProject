package model;

import java.io.File;
import java.util.*;


public class Inhoud
{
    private int id;
    private String titel;
    private String naamUploader;
    private String datumToevoegen;
    private Date datumLaatsBewerkt;
    private File image;
    private Boolean status;
    private String locatie;
    private String typeGebouw;
    private String historiek;
    private String naam;
    private String topografie;
    private String deelgemeente;
    
    public Inhoud()
    {
        setStatus(false);
    }

    
    public int getId()
    {
        return id;
    }
    public String getTitel()
    {
        return titel;
    }
    public String getNaamUploader()
    {
        return naamUploader;
    }
    public String getDatumToevoegen()
    {
        return datumToevoegen;
    }
    public Date getDatumLaatsBewerkt()
    {
        return datumLaatsBewerkt;
    }
    public File getImage()
    {
        return image;
    }
    public Boolean getStatus()
    {
        return status;
    }
    public String getLocatie()
    {
        return locatie;
    }
    public String getTypeGebouw()
    {
        return typeGebouw;
    }
    public String getHistoriek()
    {
        return historiek;
    }
    public String getNaam()
    {
        return naam;
    }
    public String getTopografie()
    {
        return topografie;
    }
    public String getDeelgemeente()
    {
        return deelgemeente;
    }

    
    public void setId(int id)
    {
        this.id = id;
    }
    public void setTitel(String titel)
    {
        this.titel = titel;
    }
    public void setNaamUploader(String naamUploader)
    {
        this.naamUploader = naamUploader;
    }
    public void setDatumToevoegen(String datumToevoegen)
    {
        this.datumToevoegen = datumToevoegen;
    }
    public void setDatumLaatsBewerkt(Date datumLaatsBewerkt)
    {
        this.datumLaatsBewerkt = datumLaatsBewerkt;
    }
    public void setImage(File image)
    {
        this.image = image;
    }
    public void setStatus(Boolean status)
    {
        this.status = status;
    }
    public void setLocatie(String locatie)
    {
        this.locatie = locatie;
    }
    public void setTypeGebouw(String typeGebouw)
    {
        this.typeGebouw = typeGebouw;
    }
    public void setHistoriek(String historiek)
    {
        this.historiek = historiek;
    }
    public void setNaam(String naam)
    {
        this.naam = naam;
    }
    public void setTopografie(String topografie)
    {
        this.topografie = topografie;
    }
    public void setDeelgemeente(String deelgemeente)
    {
        this.deelgemeente = deelgemeente;
    }
}
