package edu.unbosque.fourpawscitizens.model;

import edu.unbosque.fourpawscitizens.model.daos.Pet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Permite cargar los registros del archivo CSV, además se crean todos los metodos del registro que se solicitan en el
programa
 */
public class Manager {
/**
 * Atributo dataFile de tipo (final) String
 */
    private final String dataFile;
    /**
     * Atributo id de tipo string
 */
    private String iD;
    /**
     * Atributo i de tipo int
 */
    private int i;
    /**
     * Atributo pets de tipo Pet
 */
    private Pet pets;
    /**
     * Atributo que inicializa el array de las mascotas
     */
    private final ArrayList<Pet> pet;

    /**
     * Constructor de la clase, inicializa los atributos creados a
     */
    public Manager() {
        iD = "NO-ID";
        pet = new ArrayList<>();
        pets = new Pet();
        dataFile = "./data/pets-citizens.csv";
        i = 0;
    }

    /**
     * Metodo que valida si elparametro es long
     * @param chair
     * @return
     */
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

    /**
     * Metodo que se encarga de leer el archivo csv y guardarlo en un arraylist
     * @return
     */
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

    /**
     * Metodo que genera Id ante los parametros leidos del csv
     * @return
     */
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

    /**
     * Metodo que filtra en los registros mediante el parametro microchip
     * @param microchip
     */
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

    /**
     * Metodo que cuenta la cantidad de animales por especie
     * @param species
     */
    public void countBySpecies(String species) {
        int cont = 0;
        for (int i = 0; i < pet.size(); i++) {
            if (pet.get(i).getSpecies().equals(species)) {
                cont++;
            }
        }
        System.out.println("El número de animales de la especie " + species + " es: " + cont);
    }

    /**
     * Metodo que retorna un número dado de animales según su localidad donde pueden ser los n primeros y los n ultimos
     * @param n
     * @param position
     * @param neighborhood
     * @return
     */
    public String findBypotentDangerousInNeighborhood(int n, String position, String neighborhood) {
        String r = "";
        int cont = 0;
        int cont2 = 0;
        int contN = pet.size() - 1;
        if (position.equals("TOP")) {
            while (cont != n) {
                if (pet.get(cont2).getNeighborhood().equals(neighborhood)) {
                    r += pet.get(cont2).toString() + "\n";
                    cont++;
                    cont2++;
                } else {
                    cont2 += 1;
                }


            }

        } else if (position.equals("LAST")) {
            while (cont != n) {
                if (pet.get(contN).getNeighborhood().equals(neighborhood)) {
                    r += pet.get(contN).toString() + "\n";
                    contN--;
                    cont++;
                } else {
                    contN--;
                }
            }

        }
        return r;


    }

    /**
     * Método que retorna los id de los animales que busca mediante los parametros del registro ingresados
     * @param sex
     * @param species
     * @param size
     * @param potentDangerous
     * @return
     */
    public String findByMultipleFields(String sex, String species, String size, String potentDangerous) {
        boolean bandera = false;
        if (potentDangerous.equalsIgnoreCase("si")) {
            bandera = true;
        }
        String resultado = "";
        for (Pet mascota : pet) {
            if (mascota.getSex().equalsIgnoreCase(sex) && mascota.getSpecies().equalsIgnoreCase(species) && mascota.getSize().equalsIgnoreCase(size) && mascota.isPotentDangerous() == bandera) {

                //(mascota.getPotentDangerous()&&potentDangerous.equalsIgnoreCase("si")||!!mascota.getPotentDangerous()&&potentDangerous.equalsIgnoreCase("mo"))){
                resultado += mascota.getId();
                resultado += "\n";
            }
        }
        return resultado;
    }
    /**
     * @return the dataFile
     */
    public String getDataFile() {
        return dataFile;
    }

    /**
     * @return the iD
     */
    public String getiD() {
        return iD;
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @return the pets
     */
    public Pet getPets() {
        return pets;
    }

    /**
     * @return the pet
     */
    public ArrayList<Pet> getPet() {
        return pet;
    }

    /**
     * @param iD the iD to set
     */
    public void setiD(String iD) {
        this.iD = iD;
    }

    /**
     * @param i the i to set
     */
    public void setI(int i) {
        this.i = i;
    }

    /**
     * @param pets the pets to set
     */
    public void setPets(Pet pets) {
        this.pets = pets;
    }
}
