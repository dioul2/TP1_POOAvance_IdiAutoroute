package routes;

 public final class Voie {
    private String idVoie;
    private Autoroute autoroute;
    private Double positionVoie;



    public Voie(Autoroute autoroute, Double positionVoie, Integer numVoie){
        this.idVoie="AU"+ autoroute.getIdAutoroute()+"-VO"+numVoie;
        this.positionVoie=positionVoie*(numVoie-1);
    }

    public final String getIdVoie() {
        return idVoie;
    }

    public     final Double getPositionVoie() {
        return positionVoie;
    }

    //Méthode fournis les infos d'une voie
    private   final String infosVoie(){
        String infos="La voie d'accès: "+this.idVoie+" se trouve sur l'autoroute: "+autoroute.getIdAutoroute()+" et à: "+this.positionVoie+" Km de l'entrée principale";
        return infos;

    }
}
