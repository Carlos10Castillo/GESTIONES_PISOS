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
public class Tipos_inmuebles {
    private int id_tipos_inmuebles;
    private String tipos_inmuebles;

    public Tipos_inmuebles() {
    }

    public Tipos_inmuebles(int id_tipos_inmuebles, String tipos_inmuebles) {
        this.id_tipos_inmuebles = id_tipos_inmuebles;
        this.tipos_inmuebles = tipos_inmuebles;
    }

    /**
     * @return the id_tipos_inmuebles
     */
    public int getId_tipos_inmuebles() {
        return id_tipos_inmuebles;
    }

    /**
     * @return the tipos_inmuebles
     */
    public String getTipos_inmuebles() {
        return tipos_inmuebles;
    }

    /**
     * @param id_tipos_inmuebles the id_tipos_inmuebles to set
     */
    public void setId_tipos_inmuebles(int id_tipos_inmuebles) {
        this.id_tipos_inmuebles = id_tipos_inmuebles;
    }

    /**
     * @param tipos_inmuebles the tipos_inmuebles to set
     */
    public void setTipos_inmuebles(String tipos_inmuebles) {
        this.tipos_inmuebles = tipos_inmuebles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(tipos_inmuebles);
        return sb.toString();
    }
}
