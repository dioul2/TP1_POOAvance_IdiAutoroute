import autoroutes.Autoroute;
import autoroutes.Voie;
import idiautoroute.IdiAutoroute;
import voitures.Voiture;

public class Main {

    public static void main(String[] args) {
        IdiAutoroute idiAutoroute=new IdiAutoroute("IdiAutoroute1",5);


        Autoroute autoroute1=new Autoroute(1,500.0,0.5,4);
        Autoroute autoroute2=new Autoroute(2,400.0,0.75,4);
        Autoroute autoroute3=new Autoroute(3,300.0,1.0,4);
        //Autoroute autoroute4=new Autoroute(idiAutoroute,1,200.0,1.25,4);
        //Autoroute autoroute5=new Autoroute(idiAutoroute,1,100.0,1.50,4);




        Voiture voiture1=new Voiture(1,60.0,60,5,autoroute1,1);
        Voiture voiture2=new Voiture(2,70.0,70,7,autoroute1,2);
        idiAutoroute.addAutorouteSurIdiAutoroute(autoroute1);
        idiAutoroute.addAutorouteSurIdiAutoroute(autoroute2);
        idiAutoroute.addAutorouteSurIdiAutoroute(autoroute3);
        voiture2.changerAutorouteVersCentre(autoroute1, autoroute2);
        //voiture2.changerAutorouteVersCentre(autoroute2, autoroute3);
        idiAutoroute.getInfosIdiAutoroute();
        //System.out.println(idiAutoroute.getListAutoroute().size());
        //Voiture voiture3=new Voiture(3,3,80.0,60,10);
        //autoroute1.addVoitureSurAutoroute(voiture1);
        //autoroute1.addVoitureSurAutoroute(voiture2);
        //autoroute1.addVoitureSurAutoroute(voiture3);
        //voiture2.changerAutorouteVersCentre(autoroute1, autoroute2)
        //autoroute1.getInfosAutoroutes();
        //idiAutoroute.getInfosIdiAutoroute();

        /*System.out.println(autoroute1.getListVoitureDelAutoroute().size());
        //System.out.println(autoroute2.getListVoitureDelAutoroute().size());
        //System.out.println(autoroute1.getListVoitureDelAutoroute().get(0).getReservoir());
        System.out.println(voiture1.getIdVoiedEntree());
        System.out.println(voiture1.getDistanceParcourueSurUneAutoroute());
        System.out.println(autoroute1.getListVoitureDelAutoroute().size());
        autoroute1.getInfosAutoroutes();
        //voiture1.infosVoitures();*/



    }
}
