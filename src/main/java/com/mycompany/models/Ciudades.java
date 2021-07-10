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
public class Ciudades {
    private int id_ciudad;
    private String ciudad;
    private int id_provincia;

    public Ciudades() {
    }

    public Ciudades(int id_ciudad, String ciudad, int id_provincia) {
        this.id_ciudad = id_ciudad;
        this.ciudad = ciudad;
        this.id_provincia = id_provincia;
    }

    /**
     * @return the id_ciudad
     */
    public int getId_ciudad() {
        return id_ciudad;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }
    
    /**
     * @return the id_provincia
     */
    public int getId_provincia() {
        return id_provincia;
    }

    /**
     * @param id_ciudad the id_ciudad to set
     */
    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    /**
     * @param id_provincia the id_provincia to set
     */
    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(ciudad);
        return sb.toString();
    }
        
}
