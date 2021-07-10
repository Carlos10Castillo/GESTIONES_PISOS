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
public class Relacion_inmuprop {
    
    private int id_inmu;
    private int id_prop;
    private int porcentaje;

    public Relacion_inmuprop() {
    }

    public Relacion_inmuprop(int id_inmu, int id_prop, int porcentaje) {
        this.id_inmu = id_inmu;
        this.id_prop = id_prop;
        this.porcentaje = porcentaje;
    }

    /**
     * @return the id_inmu
     */
    public int getId_inmu() {
        return id_inmu;
    }

    /**
     * @return the id_prop
     */
    public int getId_prop() {
        return id_prop;
    }

    /**
     * @return the porcentaje
     */
    public int getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param id_inmu the id_inmu to set
     */
    public void setId_inmu(int id_inmu) {
        this.id_inmu = id_inmu;
    }

    /**
     * @param id_prop the id_prop to set
     */
    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Relacion_inmuprop{id_inmu=").append(id_inmu);
        sb.append(", id_prop=").append(id_prop);
        sb.append(", porcentaje=").append(porcentaje);
        sb.append('}');
        return sb.toString();
    }
    
    
}
