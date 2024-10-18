package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }

    /**
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
     */
    public void menu() {
        control.precargaDePilares();
        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /**
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un
     * Project
     * en un Pillar en el sistema
     */
    public void registerProject() {
        System.out.println("Proporcione el pilar en donde desea registrar su proyecto");
        System.out.println("1) Biodiversidad");
        System.out.println("2) Agua");
        System.out.println("3) Tratamiento de Basuras");
        System.out.println("4) Energía");
        int pilar = reader.nextInt();
        reader.nextLine();
        if (pilar <= 4 && pilar >= 1) {
            Boolean result = false;
            System.out.println("Proporcione el id de su proyecto");
            String id = reader.nextLine();

            System.out.println("Proporcione el nombre de su proyecto");
            String nombre = reader.nextLine();

            System.out.println("Proporcione la descripcion de su proyecto");
            String descripcion = reader.nextLine();

            System.out.println("Proporcione el estado de su proyecto");
            System.out.println("1) Activo");
            System.out.println("2) Inactivo");
            int estado = reader.nextInt();
            if (estado >= 1 && estado <= 2) {
                result = control.registerProjectInPillar(pilar, id, nombre, descripcion, estado);
            }
            if (result) {
                System.out.println("Proyecto registrado con exito");
            } else {
                System.out.println("Error, intentelo de nuevo (probablemente memoria llena).");
            }

        } else {
            System.out.println("Valor de pilar invalido!");
        }

    }

    /**
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar
     */
    public void showProjectsByPillar() {
        System.out.println("Proporcione el pilar del cual deseas ver sus proyectos");
        System.out.println("1) Biodiversidad");
        System.out.println("2) Agua");
        System.out.println("3) Tratamiento de Basuras");
        System.out.println("4) Energía");
        int pilar = reader.nextInt();
        reader.nextLine();
        if (pilar <= 4 && pilar >= 1) {
            System.out.println(control.queryProjectsByPillar(pilar));
        } else {
            System.out.println("Valor de pilar invalido!");
        }

    }
}