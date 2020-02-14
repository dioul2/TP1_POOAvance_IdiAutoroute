package idiautoroute;

import autoroutes.Autoroute;

import java.util.ArrayList;

public class IdiAutoroute {
    private String nomIdiAutoroute;
    private Integer nombreAutorouteSurIdiAutoroute;
     ArrayList<Autoroute> listAutoroute=new ArrayList<>();
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
        System.out.println("-------------------------IDIAUTOROUTE: "+this.getNomIdiAutoroute()+"-------------------------\n");
        this.getListAutoroute().forEach(autoroute->{
            System.out.println("                AUTOROUTE: "+autoroute.getIdAutoroute()+" ----------------------"+" FROTTEMENT: "+autoroute.getIndiceDeFrottement()+"\n");
            if (autoroute.getListVoitureDelAutoroute().size()<=0){
                System.out.println("CETTE AUTOROUTE N'A AUCUNE VOITURE");
            }else{
                autoroute.getInfosAutoroutes();
            }
        });
    }
}


