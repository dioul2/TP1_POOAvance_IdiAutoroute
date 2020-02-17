package voitures;

import autoroutes.Autoroute;
import java.text.DecimalFormat;

public class Voiture {

    private Integer idVoiture;
    private Double vitesse;
    private Integer reservoir;
    private Integer consommation;
    private String idVoiedEntree;
    private Double positionVoiture=0.0;
    private Double positionVoieEntree;
    private Autoroute autoroute=null;
    private Integer numVoieEntreeAutoroute;
    private DecimalFormat dfVoiture=new DecimalFormat("0.00");

   public Voiture(Integer idVoiture, Double vitesse, Integer reservoir, Integer consommation, Autoroute autoroute, Integer numVoieEntreeAutoroute ){
           this.idVoiture=idVoiture;
           this.vitesse=vitesse;
           this.reservoir=reservoir;
           this.consommation=consommation;
           this.numVoieEntreeAutoroute=numVoieEntreeAutoroute;
           this.positionVoiture+=autoroute.getListVoieDelAutoroute().get(this.numVoieEntreeAutoroute-1).getPositionVoie();
           this.positionVoieEntree=autoroute.getListVoieDelAutoroute().get(this.numVoieEntreeAutoroute-1).getPositionVoie();
           this.autoroute=autoroute;
           autoroute.addVoitureSurAutoroute(this);
           this.idVoiedEntree=autoroute.getListVoieDelAutoroute().get(this.numVoieEntreeAutoroute-1).getIdVoie();
    }

    public String getIdVoiedEntree(){
       return this.idVoiedEntree;
    }

    public Double getPositionVoieEntree(){
       return this.positionVoieEntree;
    }



    public void setNumVoieEntreeAutoroute(Integer numVoie){
       this.numVoieEntreeAutoroute=numVoie;
    }



    public Integer getIdVoiture() {
        return idVoiture;
    }

    public Double getVitesse() {
        return vitesse;
    }

    public Double getPositionVoiture() {
        return positionVoiture;
    }

    public void arreterVoiturePourCarburant(){
       this.reservoir=0;
       this.vitesse=0.0;
    }

    public void arreterVoiturePourAccident(){
        this.vitesse=0.0;
    }
    public void setPositionVoiture(){
        this.positionVoiture+=this.getVitesse();
    }

    public void setPositionVoiture(Double positionVoieEntree){
       this.positionVoiture=positionVoieEntree;
    }
    public void setVitesse(Double indiceDefrottement){
       this.vitesse=this.vitesse*indiceDefrottement;
    }



    public Integer getReservoir() {
        return reservoir;
    }

    public void setReservoir() {
        this.reservoir =this.reservoir-this.getConsommation();
    }

    private void setAutoroute(Autoroute autoroute){
        this.autoroute=autoroute;
    }

    public Integer getConsommation() {
        return consommation;
    }





    public Boolean doitChangerAutoroute(Voiture voiture){

        if((this.positionVoiture >=voiture.positionVoiture) && this.positionVoiture+this.getVitesse()<=voiture.positionVoiture+voiture.getVitesse()){
            return true;
        }
        return false;
    }

    public void infosVoitures(){
        System.out.println("----------------------VOITURE:  "+this.getIdVoiture()+"----------------------");
        System.out.println("                          VOIE D'ACCES: "+this.getIdVoiedEntree());
        System.out.println("                               VITESSE: "+this.getVitesse());
        System.out.println("                      STATUS RESERVOIR: "+this.reservoir);
        System.out.println("  POSITION VOITURE SUR CETTE AUTOROUTE: "+this.dfVoiture.format(this.getPositionVoiture())+"\n");
    }

}
