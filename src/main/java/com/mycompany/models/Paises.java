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
public class Paises {
    private int id_paises;
    private String paises;

    public Paises() {
    }

    public Paises(int id_paises, String paises) {
        this.id_paises = id_paises;
        this.paises = paises;
    }

    /**
     * @return the id_paises
     */
    public int getId_paises() {
        return id_paises;
    }

    /**
     * @return the paises
     */
    public String getPaises() {
        return paises;
    }

    /**
     * @param id_paises the id_paises to set
     */
    public void setId_paises(int id_paises) {
        this.id_paises = id_paises;
    }

    /**
     * @param paises the paises to set
     */
    public void setPaises(String paises) {
        this.paises = paises;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(paises);
        return sb.toString();
    }
    
    
}
