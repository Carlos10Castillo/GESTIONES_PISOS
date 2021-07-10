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
public class Regiones {
    private int id_regiones;
    private String regiones;
    private int id_paises;

    public Regiones() {
    }

    public Regiones(int id_regiones, String regiones, int id_paises) {
        this.id_regiones = id_regiones;
        this.regiones = regiones;
        this.id_paises = id_paises;
    }

    /**
     * @return the id_regiones
     */
    public int getId_regiones() {
        return id_regiones;
    }

    /**
     * @return the regiones
     */
    public String getRegiones() {
        return regiones;
    }
    
    /**
     * @return the id_paises
     */
    public int getId_paises() {
        return id_paises;
    }

    /**
     * @param id_regiones the id_regiones to set
     */
    public void setId_regiones(int id_regiones) {
        this.id_regiones = id_regiones;
    }

    /**
     * @param regiones the regiones to set
     */
    public void setRegiones(String regiones) {
        this.regiones = regiones;
    }
    
    /**
     * @param regiones the regiones to set
     */
    public void setId_paises(int id_paises) {
        this.id_paises = id_paises;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(regiones);
        return sb.toString();
    }
    
    
}
