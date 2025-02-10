package servicios;

import java.util.ArrayList;
import java.util.List;

import entidades.Familias;
import persistencia.FamiliasDAO;
public  class FamiliaServicio {

private static FamiliasDAO fd= new FamiliasDAO();
    
public  void mostrarFamiliasConTresHijos() throws Exception{
    List<Familias> familiasCompleto = fd.listaFamilias();
   // List<Familias> familiasFlitrado = new ArrayList<>();
    for (Familias f : familiasCompleto) {
        if(f.getNum_hijos()>=3 && f.getEdad_maxima()<10){
          //  familiasFlitrado.add(f);
            System.out.println(f.toString());
        }
    }
}

public void mostrarFamiliasConHotmail() throws Exception{
    List<Familias> familiasCompleto = fd.listaFamilias();
    for (Familias f : familiasCompleto) {
        if(f.getEmail().contains("hotmail")){
            System.out.println(f.toString());
        }
    }
}

}
