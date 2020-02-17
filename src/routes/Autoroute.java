package autoroutes;

import voitures.Voiture;
import java.util.ArrayList;

public class Autoroute{

    private Integer idAutoroute;
    private  Double rayon;
    private Double indiceDeFrottement;
    private Integer nombreVoie;
    private ArrayList<Voie> listVoieDelAutoroute=new ArrayList<Voie>();
    private ArrayList<Voiture> listVoitureDelAutoroute=new ArrayList<Voiture>();

    public Autoroute( Integer idAutoroute, Double rayon, Double indiceDeFrottement, Integer nombreVoie) {

        this.idAutoroute=idAutoroute;
        this.rayon = rayon;
        this.indiceDeFrottement = indiceDeFrottement;
        this.nombreVoie=nombreVoie;
        distributionVoiesSurAutoroute(this);
        this.listVoieDelAutoroute=getListVoieDelAutoroute();
    }

    public void distributionVoiesSurAutoroute(Autoroute autoroute){
        for (Integer i=1; i<=nombreVoie; i++){
            Voie voie=new Voie(autoroute,autoroute.getDistanceEntreVoie(),i);
            autoroute.listVoieDelAutoroute.add(voie);
        }
    }


    public Integer getIdAutoroute() {
        return idAutoroute;
    }


    public Double getRayon() {
        return rayon;
    }

    public void setRayon(Double rayon) {
        this.rayon = rayon;
    }

    public Double getIndiceDeFrottement() {
        return indiceDeFrottement;
    }

    public void setIndiceDeFrottement(Double indiceDeFrottement) {
        this.indiceDeFrottement = indiceDeFrottement;
    }

    public Integer getNombreVoie() {
        return nombreVoie;
    }

    public void setNombreVoie(Integer nombreVoie) {
        this.nombreVoie = nombreVoie;
    }

    public Double getCirconferenceAutoroute(){
        return 2*Math.PI*this.rayon;
    }

    public Double getDistanceEntreVoie(){
        Double circonference=(2*Math.PI*rayon)/this.nombreVoie;
       return circonference;
    }

    public void addVoitureSurAutoroute(Voiture voiture){
        listVoitureDelAutoroute.add(voiture);
    }

    public void supVoitureSurAutoroute(Voiture voiture){
        listVoitureDelAutoroute.remove(voiture);
    }

    public ArrayList<Voie> getListVoieDelAutoroute() {
        return listVoieDelAutoroute;
    }
    public ArrayList<Voiture> getListVoitureDelAutoroute(){
        return listVoitureDelAutoroute;
    }
    public Autoroute getAutoroute(){
        return this;
    }

    public void adVoieSurAutoroute(Voie voie){
        listVoieDelAutoroute.add(voie);
    }

    public void getInfosAutoroutes(){
        //System.out.println("                AUTOROUTE: "+this.getIdAutoroute()+"\n");
        getListVoitureDelAutoroute().forEach((v)->v.infosVoitures());

    }


}
