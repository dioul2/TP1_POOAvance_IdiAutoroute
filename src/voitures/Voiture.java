package voitures;

import routes.Autoroute;
import java.text.DecimalFormat;

public final class Voiture {

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


    private final String  getIdVoiedEntree(){
       return this.idVoiedEntree;
    }
    public    final Double getPositionVoieEntree(){
       return this.positionVoieEntree;
    }
    public  final void setNumVoieEntreeAutoroute(Integer numVoie){
       this.numVoieEntreeAutoroute=numVoie;
    }
    public  final Integer getIdVoiture() {
        return idVoiture;
    }
    public  final Double getVitesse() {
        return vitesse;
    }
    public final void setReservoir(){this.reservoir=this.reservoir-this.getConsommation();}
    public final Integer getReservoir(){return this.reservoir;}
    public  final Double getPositionVoiture() {
        return positionVoiture;
    }

    //methode qui modifie la position de la voiture à chaque tour si elle n'a pas changé d'autoroute
    public  final void setPositionVoiture(){
        this.positionVoiture+=this.getVitesse();
    }

    //methode qui modifie la position de la voiture si elle change d'autoroute
    public  final void setPositionVoiture(Double positionVoieEntree){
        this.positionVoiture=positionVoieEntree;
    }

    //methode qui modifie la vitesse de la voiture à chaque changement d'autoroute
    public  final void setVitesse(Double indiceDefrottement){
        this.vitesse=this.vitesse*indiceDefrottement;
    }

    public  final Integer getConsommation() { return consommation; }

    //methode qui qui arrete la voiture en cas de panne de carburant
    public  final void arreterVoiturePourCarburant(){
       this.reservoir=0;
       this.vitesse=0.0;
    }

    //methode qui arrete la voiture en cas de'accident
    public  final void arreterVoiturePourAccident(){
        this.vitesse=0.0;
    }

    //methode qui determine si la voiture doit changer d'autoroute à la prochaine voie d'accès
    // c'est à dire si la elle est devant et elle roule très lentement par rapport à la voiture qui est derrière elle
    public  final Boolean doitChangerAutoroute(Voiture voiture){

        try{
            if((this.positionVoiture >=voiture.positionVoiture) && this.positionVoiture+this.getVitesse()<=voiture.positionVoiture+voiture.getVitesse()){
                return true;
            }
            return false;
        }catch (SecurityException e){
            e.getMessage();
            return false;
        }
    }


    //Methode qui affiche les infos d'une voiture
    public  final void infosVoitures(){
            System.out.println("----------------------VOITURE:  "+this.getIdVoiture()+"----------------------");
            System.out.println("                          VOIE D'ACCES: "+this.getIdVoiedEntree());
            System.out.println("                               VITESSE: "+this.getVitesse());
            System.out.println("                      STATUS RESERVOIR: "+this.reservoir);
            System.out.println("  POSITION VOITURE SUR CETTE AUTOROUTE: "+this.dfVoiture.format(this.getPositionVoiture())+"\n");
    }

}
