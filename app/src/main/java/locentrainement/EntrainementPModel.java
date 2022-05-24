package locentrainement;

public class EntrainementPModel {
    public int IdEntrainement;
    public String DateEvent;
    public String TitreEvent;
    public String NomRealisateur;
    public int imgEntrainement;

    public EntrainementPModel(){

    }
    public int getIdEntrainement(){ return IdEntrainement;}
    public void setIdEntrainement(int IdEntrainement){this.IdEntrainement = IdEntrainement;}

    public int getImgEntrainement(){return imgEntrainement;}
    public void setImgEntrainement(int imgEntrainement){this.imgEntrainement = imgEntrainement;}

    public String getTitreEvent(){return TitreEvent;}
    public void setTitreEvent(String TitreEvent){this.TitreEvent = TitreEvent;}

    public String getNomRealisateur(){return NomRealisateur;}
    public void setNomRealisateur(String NomRealisateur){this.NomRealisateur = NomRealisateur;}

    public String getDateEvent(){return DateEvent;}
    public void setDateEvent(String DateEvent){this.DateEvent = DateEvent;}
}
