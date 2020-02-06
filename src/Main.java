import autoroutes.Autoroute;
import autoroutes.Voie;
import idiautoroute.IdiAutoroute;
import voitures.Voiture;

public class Main {

    public static void main(String[] args) {
        IdiAutoroute idiAutoroute=new IdiAutoroute("IdiAutoroute1",5);
        Autoroute autoroute1=new Autoroute(idiAutoroute,1,500.0,0.5,4);
        Autoroute autoroute2=new Autoroute(idiAutoroute,1,400.0,0.75,4);
        Autoroute autoroute3=new Autoroute(idiAutoroute,1,300.0,1.0,4);
        Autoroute autoroute4=new Autoroute(idiAutoroute,1,200.0,1.25,4);
        Autoroute autoroute5=new Autoroute(idiAutoroute,1,100.0,1.50,4);

        Voiture voiture1=new Voiture(1,60.0,60,10);
        Voiture voiture2=new Voiture(2,70.0,60,10);
        Voiture voiture3=new Voiture(3,80.0,60,10);

        autoroute1.addVoitureSurAutoroute(voiture1);
        autoroute1.addVoitureSurAutoroute(voiture2);
        autoroute1.addVoitureSurAutoroute(voiture3);

        System.out.println(autoroute1.getListVoitureDelAutoroute().size());
        System.out.println(autoroute2.getListVoitureDelAutoroute().size());
        System.out.println(autoroute1.getListVoitureDelAutoroute().get(0).getReservoir());



    }
}
