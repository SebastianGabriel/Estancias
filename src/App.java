import java.util.*;

import entidades.*;
import persistencia.*;
import servicio.*;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static FamiliaServicio fs = new FamiliaServicio();

    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() throws Exception {
        System.out.println("");
        int op;
        do {
            System.out.println("""
            Ingrese una opcion :
            0.Salir 
            1.Listar Familias con tres hijos
            2.
            3.
            4.
            5.
            6.
            7.
            8.
            9.
            10.
            """);
            op = sc.nextInt();
            switch (op) {

                case 1:
                    fs.mostrarFamiliasConTresHijos();

                    break;

                default:
                    break;
            }

        } while (op != 0);
    }
}
