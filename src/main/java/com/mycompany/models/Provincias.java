/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

/**
 *
 * @author CARLOS
 */
public class Provincias {
    private int id_provincia;
    private String provincia;
    private int id_region;

    public Provincias() {
    }

    public Provincias(int id_provincia, String provincia, int id_region) {
        this.id_provincia = id_provincia;
        this.provincia = provincia;
        this.id_region = id_region;
    }

    /**
     * @return the id_provincia
     */
    public int getId_provincia() {
        return id_provincia;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }
    
    /**
     * @return the id_region
     */
    public int getId_region() {
        return id_region;
    }

    /**
     * @param id_provincia the id_provincia to set
     */
    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    /**
     * @param id_region the id_region to set
     */
    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(provincia);
        return sb.toString();
    }
    
    
}
