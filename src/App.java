import java.util.*;

import entidades.*;
import persistencia.*;

public class App {
    public static void main(String[] args) throws Exception {
        CasaDAO cd =new CasaDAO();
        Casa casa = new Casa();
        casa.setCiudad("test");
        casa.setCalle("test");
        cd.guardarCasa(casa);
        
    }
}
