package routes;

import voitures.Voiture;

import java.util.ArrayList;


public final class IdiAutoroute {

    private String nomIdiAutoroute;
    private Integer nombreAutorouteSurIdiAutoroute;
    private ArrayList<Autoroute> listAutoroute = new ArrayList<Autoroute>();


    public IdiAutoroute(String nomIdiAutoroute, Integer nombreAutorouteSurIdiAutoroute) {

        this.nomIdiAutoroute = nomIdiAutoroute;
        this.nombreAutorouteSurIdiAutoroute = nombreAutorouteSurIdiAutoroute;
    }


    private final String getNomIdiAutoroute() {
        return this.nomIdiAutoroute;
    }

    public final void addAutorouteSurIdiAutoroute(Autoroute autoroute) {
        listAutoroute.add(autoroute);
    }

    private final ArrayList<Autoroute> getListAutoroute() {
        return listAutoroute;
    }

    //Methode qui affiche les infos d'une idiAutoroute c'est à dire tout son contenu autoroutes et voitures
    private final void getInfosIdiAutoroute() {
        this.getListAutoroute().forEach(autoroute -> {
            System.out.println("                AUTOROUTE: " + autoroute.getIdAutoroute() + " ----------------------" + " FROTTEMENT: " + autoroute.getIndiceDeFrottement() + "\n");
            if (autoroute.getListVoitureDelAutoroute().size() <= 0) {
                System.out.println("CETTE AUTOROUTE N'A AUCUNE VOITURE\n");
            } else {
                autoroute.getInfosAutoroutes();
            }
        });
    }


    //Methode qui cherche la position de la voie d'accès la plus proche de la position de la voiture qui doit changer  de voie
    private final Integer voiePlusProche(Double positionVoiture, Autoroute autoroute) {
        Integer i = 0;
        while (positionVoiture <= autoroute.getListVoieDelAutoroute().get(i).getPositionVoie()) {
            if (i >= autoroute.getListVoieDelAutoroute().size()) {
                return 0;
            }
            i++;
        }
        return i;
    }

    // Methode qui determine si une voiture a fait un tour complet c'est à dire si elle a parcourue 2*Math.PI*Rayon
    private final Boolean tourComplet(Voiture voiture, Autoroute autoroute) {
        return voiture.getPositionVoiture() >= voiture.getPositionVoieEntree() + autoroute.getCirconferenceAutoroute();
    }

    //Méthode qui permet à une voiture de changer de voie si y'a un risque d'accident ou si une voiture a fait un tour complet sur la meme autoroute
    private final void changeAutoroute() {
        Integer numVoieEntree;

        Voiture voiture1, voiture2, voiturek;

        for (int i = 0; i < this.listAutoroute.size() - 2; i++) {

            if (this.listAutoroute.get(i).getListVoitureDelAutoroute().size() > 1) {

                for (int j = 0; j < this.listAutoroute.get(i).getListVoitureDelAutoroute().size() - 1; j++) {
                    voiture1 = this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j);
                    for (int k = 0; k < this.listAutoroute.get(i).getListVoitureDelAutoroute().size(); k++) {
                        voiturek = this.listAutoroute.get(i).getListVoitureDelAutoroute().get(k);
                        if (voiture1.doitChangerAutoroute(voiturek) || this.tourComplet(voiturek, this.listAutoroute.get(i))) {

                            numVoieEntree = voiePlusProche(voiture1.getPositionVoiture(), this.listAutoroute.get(i));
                            voiture1.setNumVoieEntreeAutoroute(numVoieEntree);
                            voiture1.setVitesse(this.listAutoroute.get(i + 1).getIndiceDeFrottement());
                            voiture1.setPositionVoiture(this.listAutoroute.get(i).getListVoieDelAutoroute().get(numVoieEntree).getPositionVoie());
                            this.listAutoroute.get(i + 1).getListVoitureDelAutoroute().add(voiture1);
                            this.listAutoroute.get(i).getListVoitureDelAutoroute().remove(voiture1);

                        }

                    }
                }

            } else {
                voiture2 = this.listAutoroute.get(i).getListVoitureDelAutoroute().get(i);
                voiture2.setPositionVoiture();

            }
        }
    }

    // Methode qui determine la cause de l'arret du programme c'est dire s'il y'a eu accident ou panne carburant
    private final void infosSurArretProgramme() {
        try {
            Voiture voiture = null;
            Autoroute autoroute = null;
            if (this.panneCarburant()) {
                for (int i = 0; i < this.listAutoroute.size(); i++) {
                    for (int j = 0; j < this.listAutoroute.get(i).getListVoitureDelAutoroute().size(); j++) {
                        this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).setReservoir();
                        if (this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).getReservoir() < 0) {
                            this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).arreterVoiturePourCarburant();
                            autoroute = this.listAutoroute.get(i);
                            voiture = this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j);
                        }
                    }
                }

                System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                System.out.println("║                                            ----------Panne de Carburant ----------                                                 ║ ");
                System.out.println("║                                                                                                                                    ║ ");
                System.out.println("║       de La voiture: " + voiture.getIdVoiture() + " sur l'autoute:  " + autoroute.getIdAutoroute() + " à " + voiture.getPositionVoiture() + " km                                                                                ║ ");
                System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            } else {
                System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                System.out.println("║                                            ----------Accident ----------                                                           ║ ");
                System.out.println("║                                                                                                                                    ║ ");
                System.out.println("║               La voiture: " +  " sur l'autoute:  "  + " à   km      ║ ");
                System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

            }
        }catch (SecurityException e){
            e.getMessage();
        }
    }

    //Methode qui verifie si le reservoir d'une voiture va etre inférieur ou égal au prochain tour
    private final Boolean panneCarburant() {
        try {
            Boolean resultat = false;
            for (int i = 0; i < this.listAutoroute.size(); i++) {
                for (int j = 0; j < this.listAutoroute.get(i).getListVoitureDelAutoroute().size(); j++) {
                    this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).setReservoir();
                    if (this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).getReservoir() < 0) {
                        this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).arreterVoiturePourCarburant();
                        resultat = true;
                        return resultat;
                    }
                }
            }
            return resultat;
        } catch (SecurityException e){
            e.getMessage();
            return false;
        }
    }

    // Methode qui determine si y'a eu accident ou pas
    private final Boolean accident() {
       try {
           Boolean resultat = false;
           for (int i = 0; i < this.listAutoroute.size() - 1; i++) {
               for (int j = 0; j < this.listAutoroute.get(i).getListVoitureDelAutoroute().size() - 1; j++) {
                   this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).setPositionVoiture();
                   this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j + 1).setPositionVoiture();
                   if (this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).getVitesse() == 0.0) {
                       this.listAutoroute.get(i).getListVoitureDelAutoroute().get(j).arreterVoiturePourAccident();
                       resultat = true;
                       return resultat;
                   }
               }
           }
           return resultat;
       }catch (SecurityException e){
           e.getMessage();
           return false;
       }
    }


    //Méthode qui lance le scenario d'exécution
    public final void lance() {

            int i = 0;
            System.out.println("-------------------------IDIAUTOROUTE: " + this.getNomIdiAutoroute() + "-------------------------\n");
            do {
                System.out.println("---------------Tour: " + (++i) + "-----------------------\n");
                this.getInfosIdiAutoroute();
                this.changeAutoroute();


            } while ((!this.panneCarburant()) && (!this.accident()));
            if (this.panneCarburant()) {
                this.infosSurArretProgramme();
            } else {
                this.infosSurArretProgramme();
            }
    }


}




