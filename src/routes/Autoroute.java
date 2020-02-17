package routes;

import voitures.Voiture;
import java.util.ArrayList;

public final class Autoroute{

    private Integer idAutoroute;
    private  Double rayon;
    private Double indiceDeFrottement;
    private Integer nombreVoie;
    private ArrayList<Voie> listVoieDelAutoroute=new ArrayList<Voie>();
    private ArrayList<Voiture> listVoitureDelAutoroute=new ArrayList<Voiture>();

    public Autoroute( Integer idAutoroute, Double rayon, Double indiceDeFrottement, Integer nombreVoie) {

        this.idAutoroute=idAutoroute;
        setRayon(rayon);
        setIndiceDeFrottement(indiceDeFrottement);
        setNombreVoie(nombreVoie);
        distributionVoiesSurAutoroute(this);
        this.listVoieDelAutoroute=getListVoieDelAutoroute();
    }

    //Méthode qui distribue les voies à positon egale sur l'autoroute par exemple si on une autoroute qui a n voies
    // d'accès la positon de chaque voie sera [1..n]*2*Math.PI*Rayon
    protected final void distributionVoiesSurAutoroute(Autoroute autoroute){
        for (Integer i=1; i<=nombreVoie; i++){
            Voie voie=new Voie(autoroute,autoroute.getDistanceEntreVoie(),i);
            autoroute.listVoieDelAutoroute.add(voie);
        }
    }


    protected    final Integer getIdAutoroute() {
        return idAutoroute;
    }


    private   final void setRayon(Double rayon) {
        this.rayon = rayon;
    }

    protected    final Double getIndiceDeFrottement() {
        return indiceDeFrottement;
    }

    private   final void setIndiceDeFrottement(Double indiceDeFrottement) {
        this.indiceDeFrottement = indiceDeFrottement;
    }


    private final void setNombreVoie(Integer nombreVoie) {
        this.nombreVoie = nombreVoie;
    }

    //Méthode qui calcule la circonférence de l'autoroute
    protected   final Double getCirconferenceAutoroute(){
        return 2*Math.PI*this.rayon;
    }

    // Méthode qui calcule la distance entre deux voie de l'autoroute qui sera toujours une constante vu qu'on distribue
    //les voies à part égales
    private   final Double getDistanceEntreVoie(){
        Double circonference=(2*Math.PI*rayon)/this.nombreVoie;
       return circonference;
    }

    public  final void addVoitureSurAutoroute(Voiture voiture){
        listVoitureDelAutoroute.add(voiture);
    }



    public    final ArrayList<Voie> getListVoieDelAutoroute() {
        return listVoieDelAutoroute;
    }
    public    final ArrayList<Voiture> getListVoitureDelAutoroute(){
        return listVoitureDelAutoroute;
    }

    //Méthode qui affiche les informations d'une autoroute
    protected    final void getInfosAutoroutes(){
        //System.out.println("                AUTOROUTE: "+this.getIdAutoroute()+"\n");
        getListVoitureDelAutoroute().forEach((v)->v.infosVoitures());

    }


}
