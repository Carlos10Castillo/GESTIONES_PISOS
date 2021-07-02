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
public class Inmuebles {
    private int id_inmueble;
    private int inmueble_tipo_id;
    private String destino;
    private String domicilio;
    private int ciudad;
    private int cod_postal;
    private String alias;
    private int porcentaje;
    private String ref_catastral;
    private String reg_propiedad;
    private String tomo;
    private String libro;
    private String folio;
    private String finca;
    private int porcentaje_comu;
    private int porcentaje_comu_general;

    public Inmuebles() {
    }

    public Inmuebles(int id_inmueble, int inmueble_tipo_id, String destino, String domicilio, int ciudad, int cod_postal, String alias, int porcentaje, String ref_catastral, String reg_propiedad, String tomo, String libro, String folio, String finca, int porcentaje_comu, int porcentaje_comu_general) {
        this.id_inmueble = id_inmueble;
        this.inmueble_tipo_id = inmueble_tipo_id;
        this.destino = destino;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.cod_postal = cod_postal;
        this.alias = alias;
        this.porcentaje = porcentaje;
        this.ref_catastral = ref_catastral;
        this.reg_propiedad = reg_propiedad;
        this.tomo = tomo;
        this.libro = libro;
        this.folio = folio;
        this.finca = finca;
        this.porcentaje_comu = porcentaje_comu;
        this.porcentaje_comu_general = porcentaje_comu_general;
    }
    

    /**
     * @return the id_inmueble
     */
    public int getId_inmueble() {
        return id_inmueble;
    }

    /**
     * @return the inmueble_tipo_id
     */
    public int getInmueble_tipo_id() {
        return inmueble_tipo_id;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @return the ciudad
     */
    public int getCiudad() {
        return ciudad;
    }

    /**
     * @return the cod_postal
     */
    public int getCod_postal() {
        return cod_postal;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @return the porcentaje
     */
    public int getPorcentaje() {
        return porcentaje;
    }

    /**
     * @return the ref_catastral
     */
    public String getRef_catastral() {
        return ref_catastral;
    }

    /**
     * @return the reg_propiedad
     */
    public String getReg_propiedad() {
        return reg_propiedad;
    }

    /**
     * @return the tomo
     */
    public String getTomo() {
        return tomo;
    }

    /**
     * @return the libro
     */
    public String getLibro() {
        return libro;
    }

    /**
     * @return the folio
     */
    public String getFolio() {
        return folio;
    }

    /**
     * @return the finca
     */
    public String getFinca() {
        return finca;
    }

    /**
     * @return the porcentaje_comu
     */
    public int getPorcentaje_comu() {
        return porcentaje_comu;
    }

    /**
     * @return the porcentaje_comu_general
     */
    public int getPorcentaje_comu_general() {
        return porcentaje_comu_general;
    }

    /**
     * @param id_inmueble the id_inmueble to set
     */
    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    /**
     * @param inmueble_tipo_id the inmueble_tipo_id to set
     */
    public void setInmueble_tipo_id(int inmueble_tipo_id) {
        this.inmueble_tipo_id = inmueble_tipo_id;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @param cod_postal the cod_postal to set
     */
    public void setCod_postal(int cod_postal) {
        this.cod_postal = cod_postal;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @param ref_catastral the ref_catastral to set
     */
    public void setRef_catastral(String ref_catastral) {
        this.ref_catastral = ref_catastral;
    }

    /**
     * @param reg_propiedad the reg_propiedad to set
     */
    public void setReg_propiedad(String reg_propiedad) {
        this.reg_propiedad = reg_propiedad;
    }

    /**
     * @param tomo the tomo to set
     */
    public void setTomo(String tomo) {
        this.tomo = tomo;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(String libro) {
        this.libro = libro;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * @param finca the finca to set
     */
    public void setFinca(String finca) {
        this.finca = finca;
    }

    /**
     * @param porcentaje_comu the porcentaje_comu to set
     */
    public void setPorcentaje_comu(int porcentaje_comu) {
        this.porcentaje_comu = porcentaje_comu;
    }

    /**
     * @param porcentaje_comu_general the porcentaje_comu_general to set
     */
    public void setPorcentaje_comu_general(int porcentaje_comu_general) {
        this.porcentaje_comu_general = porcentaje_comu_general;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inmuebles{id_inmueble=").append(id_inmueble);
        sb.append(", inmueble_tipo_id=").append(inmueble_tipo_id);
        sb.append(", destino=").append(destino);
        sb.append(", domicilio=").append(domicilio);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", cod_postal=").append(cod_postal);
        sb.append(", alias=").append(alias);
        sb.append(", porcentaje=").append(porcentaje);
        sb.append(", ref_catastral=").append(ref_catastral);
        sb.append(", reg_propiedad=").append(reg_propiedad);
        sb.append(", tomo=").append(tomo);
        sb.append(", libro=").append(libro);
        sb.append(", folio=").append(folio);
        sb.append(", finca=").append(finca);
        sb.append(", porcentaje_comu=").append(porcentaje_comu);
        sb.append(", porcentaje_comu_general=").append(porcentaje_comu_general);
        sb.append('}');
        return sb.toString();
    }
}
