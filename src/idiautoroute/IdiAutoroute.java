package idiautoroute;

import autoroutes.Autoroute;
import voitures.Voiture;
import java.util.ArrayList;


public class IdiAutoroute {

    private String nomIdiAutoroute;
    private Integer nombreAutorouteSurIdiAutoroute;
    private ArrayList<Autoroute> listAutoroute=new ArrayList<>();



    public IdiAutoroute(String nomIdiAutoroute, Integer nombreAutorouteSurIdiAutoroute){

        this.nomIdiAutoroute=nomIdiAutoroute;
        this.nombreAutorouteSurIdiAutoroute=nombreAutorouteSurIdiAutoroute;
    }


    public String getNomIdiAutoroute(){
        return this.nomIdiAutoroute;
    }

    public void addAutorouteSurIdiAutoroute(Autoroute autoroute){
        listAutoroute.add(autoroute);
    }

    public ArrayList<Autoroute> getListAutoroute(){
        return listAutoroute;
    }


    public void getInfosIdiAutoroute(){
        this.getListAutoroute().forEach(autoroute->{
            System.out.println("                AUTOROUTE: "+autoroute.getIdAutoroute()+" ----------------------"+" FROTTEMENT: "+autoroute.getIndiceDeFrottement()+"\n");
            if (autoroute.getListVoitureDelAutoroute().size()<=0){
                System.out.println("CETTE AUTOROUTE N'A AUCUNE VOITURE\n");
            }else{
                autoroute.getInfosAutoroutes();
            }
        });
    }


    public Integer voiePlusProche(Double positionVoiture, Autoroute autoroute){
        Integer i=0;
        while (positionVoiture <=autoroute.getListVoieDelAutoroute().get(i).getPositionVoie()){
            if (i>=autoroute.getListVoieDelAutoroute().size()){
                return 0;
            }
            i++;
        }
        return i;
    }

    public Boolean tourComplet(Voiture voiture, Autoroute autoroute){
       if(voiture.getPositionVoiture()>=voiture.getPositionVoieEntree()+autoroute.getCirconferenceAutoroute()){
           return true;
       }
       return false;
    }

    public void changeAutoroute(){
        Integer numVoieEntree;

        Voiture voiture1, voiture2, voiturek;

       for (int i=0; i<this.listAutoroute.size()-2; i++){

            if (this.listAutoroute.get(i).getListVoitureDelAutoroute().size()>1){

               for (int j=0; j<this.listAutoroute.get(i).getListVoitureDelAutoroute().size()-1; j++){
                   voiture1=this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j);
                   for (int k=0; k<this.listAutoroute.get(i).getListVoitureDelAutoroute().size(); k++){
                       voiturek=this.listAutoroute.get(i).getListVoitureDelAutoroute().get(k);
                       if(voiture1.doitChangerAutoroute(voiturek) || this.tourComplet(voiturek, this.listAutoroute.get(i))){

                           numVoieEntree=voiePlusProche(voiture1.getPositionVoiture(),this.listAutoroute.get(i));
                           voiture1.setNumVoieEntreeAutoroute(numVoieEntree);
                           voiture1.setVitesse(this.listAutoroute.get(i+1).getIndiceDeFrottement());
                           voiture1.setPositionVoiture(this.listAutoroute.get(i).getListVoieDelAutoroute().get(numVoieEntree).getPositionVoie());
                           this.listAutoroute.get(i+1).getListVoitureDelAutoroute().add(voiture1);
                           this.listAutoroute.get(i).getListVoitureDelAutoroute().remove(voiture1);

                       }

                   }
               }

            }else{
                voiture2=this.listAutoroute.get(i).getListVoitureDelAutoroute().get(i);
                voiture2.setPositionVoiture();

            }
        }
    }

    public void infosSurArretProgramme(){
        Voiture voiture=null;
        Autoroute autoroute=null;
        if(this.panneCarburant()){
            for (int i = 0; i < this.listAutoroute.size(); i++) {
                for (int j = 0; j < this.listAutoroute.get(i).getListVoitureDelAutoroute().size(); j++) {
                    this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).setReservoir();
                    if (this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).getReservoir() <0) {
                        this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).arreterVoiturePourCarburant();
                        autoroute=this.listAutoroute.get(i);
                        voiture= this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j);
                    }
                }
            }

            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                            ----------Panne de Carburant ----------                                                 ║ ");
            System.out.println("║                                                                                                                                    ║ ");
            System.out.println("║       de La voiture: "+voiture.getIdVoiture()+" sur l'autoute:  "+autoroute.getIdAutoroute()+" à "+voiture.getPositionVoiture()+" km                                                                                ║ ");
            System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        }else {
            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                            ----------Accident ----------                                                           ║ ");
            System.out.println("║                                                                                                                                    ║ ");
            System.out.println("║               La voiture: "+voiture.getIdVoiture()+" sur l'autoute:  "+autoroute.getIdAutoroute()+" à "+voiture.getPositionVoiture()+" km      ║ ");
            System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

        }
    }

    public Boolean panneCarburant() {
        Boolean resultat = false;
        for (int i = 0; i < this.listAutoroute.size(); i++) {
            for (int j = 0; j < this.listAutoroute.get(i).getListVoitureDelAutoroute().size(); j++) {
                this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).setReservoir();
                if (this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).getReservoir() <0) {
                    this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).arreterVoiturePourCarburant();
                    resultat = true;
                    return resultat;
                }
            }
        }
        return resultat;
    }

    public Boolean accident() {
        Boolean resultat = false;
        for (int i = 0; i < this.listAutoroute.size()-1; i++) {
            for (int j = 0; j < this.listAutoroute.get(i).getListVoitureDelAutoroute().size()-1; j++) {
                this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).setPositionVoiture();
                this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j+1).setPositionVoiture();
                if (this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).getVitesse()==0.0) {
                    this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).arreterVoiturePourAccident();
                    resultat = true;
                    return resultat;
                }
            }
        }
        return resultat;
    }


    public void lance(){
        int i=0;
        System.out.println("-------------------------IDIAUTOROUTE: "+this.getNomIdiAutoroute()+"-------------------------\n");
        do{
            System.out.println("---------------Tour: "+(++i)+"-----------------------\n");
            this.getInfosIdiAutoroute();
            this.changeAutoroute();


            }while ((!this.panneCarburant()) && (!this.accident()));
        if (this.panneCarburant()){
            this.infosSurArretProgramme();
        }else{
            this.infosSurArretProgramme();
        }
        }


}


