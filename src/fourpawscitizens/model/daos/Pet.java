package edu.unbosque.fourpawscitizens.model.daos;

import java.util.ArrayList;
/**
 * Clase Pet se encarga de instanciar todos los atributos
 */
public class Pet {
/**
 * Atributo id de tipo string
 */
    private String id;
    /**
     * Atributo microchip de tipo long
 */
    private long microchip;
    /**
     * Atributo especie de tipo String
     */
    private String species;
    /**
     * Atributo sex de tipo String
     */
    private String sex;
    /**
     * Atributo size de tipo String
     */
    private String size;
    /**
     * Atributo de potencialmente peligroso de tipo boolean
     */
    private boolean potentDangerous;
    /**
     * Atributo vecindario de tipo String
     */
    private String neighborhood;

    public Pet(){

    }
/**
 * Constructor de la clase, inicializa los atributos creados
 */
    public Pet (String id, long microchip, String species, String sex, String size, Boolean potentDangerous, String neighborhood ) {

    this.id = id;
    this.microchip = microchip;
    this.species = species;
    this.sex = sex;
    this.size = size;
    this.potentDangerous = potentDangerous;
    this.neighborhood = neighborhood;

    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the microchip
     */
    public long getMicrochip() {
        return microchip;
    }

    /**
     * @return the species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @return the potentDangerous
     */
    public boolean isPotentDangerous() {
        return potentDangerous;
    }

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param microchip the microchip to set
     */
    public void setMicrochip(long microchip) {
        this.microchip = microchip;
    }

    /**
     * @param species the species to set
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @param potentDangerous the potentDangerous to set
     */
    public void setPotentDangerous(boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String toString() {
        return
                "iD: " + getId() +"\n"+
                        "species: " + getSpecies() + "\n" +
                        "sex :" + getSex() + "\n" +
                        "size :" + getSize() + '\n' +
                        "potentDangerous :" + isPotentDangerous() +"\n"+
                        "neighborhood :" + getNeighborhood() + "\n" ;
    }
}
