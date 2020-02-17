import routes.Autoroute;
import routes.IdiAutoroute;
import voitures.Voiture;


public class Main {

    public static void main(String[] args) {
        IdiAutoroute idiAutoroute=new IdiAutoroute("IdiAutoroute1",5);


       Autoroute autoroute1=new Autoroute(1,50.0,0.5,4);
        Autoroute autoroute2=new Autoroute(2,40.0,0.75,6);
        Autoroute autoroute3=new Autoroute(3,30.0,1.0,4);
        Autoroute autoroute4=new Autoroute(4,20.0,200.0,6);
        Autoroute autoroute5=new Autoroute(5,10.0,100.0,4);



        Voiture voiture1 = new Voiture(1,80.0,60,5,autoroute1,2);
        Voiture voiture2 = new Voiture(2,97.0,70,2,autoroute1,1);
        Voiture voiture3 = new Voiture(3,100.0,70,2,autoroute1,3);
        Voiture voiture4=new Voiture(4,80.0,40,2,autoroute1,4);
        idiAutoroute.addAutorouteSurIdiAutoroute(autoroute1);
        idiAutoroute.addAutorouteSurIdiAutoroute(autoroute2);
        idiAutoroute.addAutorouteSurIdiAutoroute(autoroute3);

        idiAutoroute.lance();


    }
}
