package edu.unbosque.fourpawscitizens;

import edu.unbosque.fourpawscitizens.model.Manager;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager control = new Manager();
        Scanner reader = new Scanner(System.in);
        int number = 0;
        System.out.println("Señor Usuario, ingrese el número de la opción a escoger: \n" +
                "1) Upload Data \n" +
                "0) Exit");
        while(number>=0) {

            try {
                number = reader.nextInt();
                if (number == 1) {
                    control.UploadData();
                    System.out.println("El proceso de carga del archivo ha finalizado\n");
                    System.out.println("Señor Usuario, ingrese el número de la opción a escoger: \n" +
                            "2) assign ID \n" +
                            "3) find By Microchip \n" +
                            "4) count By Species \n" +
                            "5) find By Potent Dangerous in Neighborhood \n" +
                            "6) find By Multiple Fields \n" +
                            "0) Exit \n");

                }else if (number == 0){
                    System.exit(0);
                }
                if (number == 2){
                    control.assignID();

                    System.out.println("El proceso de asignación de ids ha finalizado");
                    System.out.println(control.getPet().get(38).getId());
                    }
                 if (number == 3){
                    System.out.println("Ingrese el microchip a buscar");
                    long microchip = 0;
                    microchip = reader.nextLong();
                    control.findByMicrochip(microchip);
                }
                if(number== 4){
                    System.out.println("Ingrese la especie a contar");
                    String specie;
                    specie = reader.next();
                    control.countBySpecies(specie);
                }

                }
             catch (InputMismatchException i) {
                System.out.println("Dato erroneo, Señor Usuario, ingrese un número valido ");
                reader.next();
            }
        }
    }
}
