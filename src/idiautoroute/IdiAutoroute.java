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

    public void addAutorouteSurIdiAutoroute(Autoroute autoroute){
        listAutoroute.add(autoroute);
    }

    public ArrayList<Autoroute> getListAutoroute(){
        return listAutoroute;
    }
}
