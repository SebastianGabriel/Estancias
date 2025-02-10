import entidades.Cliente;
import entidades.Comentario;
import java.util.*;

import entidades.*;
import persistencia.*;
import servicios.*;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static FamiliaServicio fs = new FamiliaServicio();
    private static CasaServicio cs = new CasaServicio();

    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() throws Exception {
        System.out.println("");
        int op;
        do {
            System.out.println("""
                    ****** MENÚ ******
                    Ingrese una opcion :
                    0. Salir
                    1. Listar Familias con tres hijos
                    2. Casas Disponibles en el Reino Unido en agosto 2020
                    3. Listar Familias con hotmail
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
                case 2:
                    cs.casasDisponiblesReinoUnido();
                    break;
                case 3:
                    fs.mostrarFamiliasConHotmail();
                    break;
                default:
                    break;
            }

        } while (op != 0);
    }
}