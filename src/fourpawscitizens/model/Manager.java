package edu.unbosque.fourpawscitizens.model;

import edu.unbosque.fourpawscitizens.model.daos.Pet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Manager {

    private final String dataFile;
    private String iD;
    private int i;
    private Pet pets;
    private final ArrayList<Pet> pet;

    public Manager() {
        iD = "NO-ID";
        pet = new ArrayList<>();
        pets = new Pet();
        dataFile = "./data/pets-citizens.csv";
        i = 0;
    }

    public static boolean isNumeric(String chair) {

        boolean result;

        try {
            Long.parseLong(chair);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }

        return result;
    }

    public String UploadData() {

        String line = "";
        String chair = "";
        File f = new File(this.dataFile);


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.ISO_8859_1));
            line = br.readLine();

            line = line.replace(";", " ");

            System.out.println(line + "\n");


            while (line != null) {

                String[] file = line.split(";");

                if (isNumeric(file[0]) && file.length == 6) {

                    if (file[4].equals("SI")) {
                        file[4] = "true";
                    } else {
                        file[4] = "false";
                    }
                    pet.add(new Pet(iD, Long.parseLong(file[0]), file[1], file[2], file[3], Boolean.valueOf(file[4]), file[5]));

                }

                line = br.readLine();
            }

            br.close();


        } catch (IOException e) {
            return null;
        }
        return chair;


    }

    public String assignID() {


        for (int i = 0; i < pet.size(); i++) {

            String microchip = String.valueOf(pet.get(i).getMicrochip());
            String microchipLast3 = microchip.substring(microchip.length() - 3);
            String idSpecies = pet.get(i).getSpecies().substring(0, 1);
            String idSex = pet.get(i).getSex().substring(0, 1);
            String idSize = "";
            String idPotentDangerous = "";
            String idNeighborhood = pet.get(i).getNeighborhood();

            if (pet.get(i).getSize().equals("MINIATURA")) {
                idSize = "MI";
            } else {
                idSize = pet.get(i).getSize().substring(0, 1);
            }

            if (pet.get(i).isPotentDangerous() == false) {
                idPotentDangerous = "F";
            } else {
                idPotentDangerous = "T";
            }
            iD = microchipLast3 + "-" + idSpecies + idSex + idSize + idPotentDangerous + "-" + idNeighborhood;
            pet.get(i).setId(iD);
            System.out.println(iD);

        }

        return iD;
    }
    public void findByMicrochip(long microchip) {

        for (int i = 0; i < pet.size(); i++) {
            if (microchip == pet.get(i).getMicrochip()) {

                System.out.println("ID: " + pet.get(i).getId() +
                        "\nSpecies: " + pet.get(i).getSpecies() +
                        "\nGender: " + pet.get(i).getSex() +
                        "\nSize: " + pet.get(i).getSize() +
                        "\nPotentially Dangerous :" + pet.get(i).isPotentDangerous() +
                        "\nNeighborhood :" + pet.get(i).getNeighborhood());

            }
        }
    }

    public void countBySpecies(String species) {
        int cont = 0;
        for (int i = 0; i < pet.size(); i++) {
            if (pet.get(i).getSpecies().equals(species)) {
                cont++;
            }
        }
        System.out.println("El número de animales de la especie " + species + " es: " + cont);
    }


    public String getDataFile() {
        return dataFile;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Pet getPets() {
        return pets;
    }

    public void setPets(Pet pets) {
        this.pets = pets;
    }

    public ArrayList<Pet> getPet() {
        return pet;
    }
}
