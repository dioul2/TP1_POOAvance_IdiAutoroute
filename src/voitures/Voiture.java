package voitures;

import autoroutes.Autoroute;
import idiautoroute.IdiAutoroute;

import java.util.ArrayList;

public class Voiture {
    private Integer idVoiture;
    private Double vitesse;
    private Integer reservoir;
    private Integer consommation;

   public Voiture(Integer idVoiture, Double vitesse, Integer reservoir, Integer consommation){
           this.idVoiture=idVoiture;
           this.vitesse=vitesse;
           this.reservoir=reservoir;
           this.consommation=consommation;
    }

    public void addVoitureSurAutoroute(Autoroute autoroute){
       autoroute.addVoitureSurAutoroute(this);

    }

    public void supVoitureSurAutoroute(Autoroute autoroute){
        autoroute.supVoitureSurAutoroute(this);
    }
    public Integer getIdVoiture() {
        return idVoiture;
    }

    public Double getVitesse() {
        return vitesse;
    }

    public void setVitesse(Double vitesse) {
        this.vitesse = vitesse;
    }

    public Integer getReservoir() {
        return reservoir;
    }

    public void setReservoir(Integer reservoir) {
        this.reservoir = reservoir;
    }

    public Integer getConsommation() {
        return consommation;
    }

    public void setConsommation(Integer consommation) {
        this.consommation = consommation;
    }


    public void changerAutorouteVersCentre(){
       //Condition d'accès à faire




    }
}
