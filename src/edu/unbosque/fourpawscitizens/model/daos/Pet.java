package edu.unbosque.fourpawscitizens.model.daos;

import java.util.ArrayList;

public class Pet {

    private String id;
    private long microchip;
    private String species;
    private String sex;
    private String size;
    private boolean potentDangerous;
    private String neighborhood;

    public Pet(){

    }

    public Pet (String id, long microchip, String species, String sex, String size, Boolean potentDangerous, String neighborhood ) {

        this.id = id;
        this.microchip = microchip;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.potentDangerous = potentDangerous;
        this.neighborhood = neighborhood;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getMicrochip() {
        return microchip;
    }

    public void setMicrochip(long microchip) {
        this.microchip = microchip;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isPotentDangerous() {
        return potentDangerous;
    }

    public void setPotentDangerous(boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

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
