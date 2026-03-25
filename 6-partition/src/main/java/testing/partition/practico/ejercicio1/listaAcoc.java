package testing.partition.practico.ejercicio1;

import java.util.ArrayList;

public class listaAcoc {
    
    // Una lista ordenada ascendte y descendentemente con 2 bloques: V y F
    // tiene 4 casos para ver:

    //primer caso: ordenascendente=V y ordenDescendente=V
    public boolean  primerCaso(ArrayList<Integer> list){
        if(list == null){
            return false;
        }
        boolean valid = true;
        for(int i = 0; i < list.size();i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(i) == list.get(j)){
                    valid = true;
                }else{
                    valid = false;
                }
                
            }
        }
        return valid;

    }


    //segundo caso: ordenascendente=V y ordenDescendente=f
    public boolean  segundoCaso(ArrayList<Integer> list){
        if(list == null){
            return false;
        }
        boolean valid = true;
        for(int i = 0; i < list.size();i++){
            for(int j = 0; j < list.size(); j++){
                valid = list.get(i) <= list.get(j);
                
            }
        }
        return valid;

    }

    //tercer caso: ordenascendente=F y ordenDescendente=F
    public boolean  tercerCaso(ArrayList<Integer> list){
        if(list == null){
            return false;
        }
        boolean valid = true;
        for(int i = 0; i < list.size();i++){
            for(int j = 0; j < list.size(); j++){
                if((list.get(i) >= list.get(j))){
                    valid = false;
                }else{
                    valid = true;
                }
                
            }
        }
        return valid;
    }

    //cuarto caso: ordenascendente=F y ordenDescendente=v
    public boolean  cuartoCaso(ArrayList<Integer> list){
        if(list == null){
            return false;
        }
        boolean valid = true;
        for(int i = 0; i < list.size();i++){
            for(int j = 0; j < list.size(); j++){
                if((list.get(i) >= list.get(j))){
                    valid = false;
                }else{
                    valid = true;
                }
                
            }
        }
        return valid;
    }
}
