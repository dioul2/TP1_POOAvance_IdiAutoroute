package voitures;

import autoroutes.Autoroute;
import autoroutes.Voie;
import idiautoroute.IdiAutoroute;

import java.util.ArrayList;

public class Voiture {
    private Integer idVoiture;
    private Double vitesse;
    private Integer reservoir;
    private Integer consommation;
    private String idVoiedEntree;
    private Double distanceParcourueSurCetteAutoroute;
    private Boolean toujoursSurMemeAutoroute=true;
    private Autoroute autoroute=null;

   public Voiture(Integer idVoiture, Double vitesse, Integer reservoir, Integer consommation, Autoroute autoroute, Integer numVoieAutoroute ){
           this.idVoiture=idVoiture;
           this.vitesse=vitesse;
           this.reservoir=reservoir;
           this.consommation=consommation;
           this.autoroute=autoroute;
           autoroute.addVoitureSurAutoroute(this);
           this.idVoiedEntree=autoroute.getListVoieDelAutoroute().get(numVoieAutoroute-1).getIdVoie();
           this.distanceParcourueSurCetteAutoroute=autoroute.getListVoieDelAutoroute().get(numVoieAutoroute-1).getPositionVoie();
    }
    public String getIdVoiedEntree(){
       return this.idVoiedEntree;
    }
    public Double getDistanceParcourueSurUneAutoroute(){
        return this.distanceParcourueSurCetteAutoroute;
    }



    public Integer getIdVoiture() {
        return idVoiture;
    }

    public Double getVitesse() {
        return vitesse;
    }

    private void setVitesse(Double indiceDefrottement){
       this.vitesse=this.vitesse*indiceDefrottement;
    }



    public Integer getReservoir() {
        return reservoir;
    }

    public void setReservoir() {
        this.reservoir -=this.getConsommation();
    }

    private void setAutoroute(Autoroute autoroute){
        this.autoroute=autoroute;
    }

    public Integer getConsommation() {
        return consommation;
    }


    public void changerAutorouteVersCentre(Autoroute autoroute1, Autoroute autoroute2){
       //Condition d'accès à faire
        this.setVitesse(autoroute2.getIndiceDeFrottement());
        autoroute2.addVoitureSurAutoroute(this);
        autoroute1.supVoitureSurAutoroute(this);
    }

    public void infosVoitures(){
        System.out.println("----------------------VOITURE:  "+this.getIdVoiture()+"----------------------");
        System.out.println("                          VOIE D'ACCES: "+this.getIdVoiedEntree());
        System.out.println("                               VITESSE: "+this.getVitesse());
        System.out.println("                      STATUS RESERVOIR: "+this.reservoir);
        System.out.println("DISTANCE PARCOURUE SUR CETTE AUTOROUTE: "+this.getDistanceParcourueSurUneAutoroute()+"\n");
    }

    public String VoiePlusProche(Double position, Autoroute a1, Autoroute a2 ){
       String tmp1=this.idVoiedEntree;
       Integer n;
       Double distanceParcourue=this.distanceParcourueSurCetteAutoroute;
       ArrayList<Voie> listVoie=a1.getListVoieDelAutoroute();
       for (int i =0; i<listVoie.size(); i++){
           if(listVoie.get(i).getIdVoie().equals(tmp1)){
               distanceParcourue+=listVoie.get(i).getPositionVoie();
           }
       }






       return null;
    }
}
