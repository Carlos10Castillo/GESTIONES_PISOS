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
public class Inquilinos {
    
    private int id_inquilino;
    private String nombre_inqui;
    private String apellidos_inqui;
    private String cif_inqui;
    private String domicilio_inqui;
    private String ciudad_inqui;
    private int cod_postal_inqui;
    private int telf_trab_inqui;
    private int telf_part_inqui;
    private int telf_movil_inqui;
    private int num_fax_inqui;
    private String email_trab_inqui;
    private String email_pers_inqui;

    public Inquilinos() {
    }

    public Inquilinos(int id_inquilino, String nombre_inqui, String apellidos_inqui, String cif_inqui, String domicilio_inqui, String ciudad_inqui, int cod_postal_inqui, int telf_trab_inqui, int telf_part_inqui, int telf_movil_inqui, int num_fax_inqui, String email_trab_inqui, String email_pers_inqui) {
        this.id_inquilino = id_inquilino;
        this.nombre_inqui = nombre_inqui;
        this.apellidos_inqui = apellidos_inqui;
        this.cif_inqui = cif_inqui;
        this.domicilio_inqui = domicilio_inqui;
        this.ciudad_inqui = ciudad_inqui;
        this.cod_postal_inqui = cod_postal_inqui;
        this.telf_trab_inqui = telf_trab_inqui;
        this.telf_part_inqui = telf_part_inqui;
        this.telf_movil_inqui = telf_movil_inqui;
        this.num_fax_inqui = num_fax_inqui;
        this.email_trab_inqui = email_trab_inqui;
        this.email_pers_inqui = email_pers_inqui;
    }

    /**
     * @return the id_inquilino
     */
    public int getId_inquilino() {
        return id_inquilino;
    }

    /**
     * @return the nombre_inqui
     */
    public String getNombre_inqui() {
        return nombre_inqui;
    }

    /**
     * @return the apellidos_inqui
     */
    public String getApellidos_inqui() {
        return apellidos_inqui;
    }

    /**
     * @return the cif_inqui
     */
    public String getCif_inqui() {
        return cif_inqui;
    }

    /**
     * @return the domicilio_inqui
     */
    public String getDomicilio_inqui() {
        return domicilio_inqui;
    }

    /**
     * @return the ciudad_inqui
     */
    public String getCiudad_inqui() {
        return ciudad_inqui;
    }

    /**
     * @return the cod_postal_inqui
     */
    public int getCod_postal_inqui() {
        return cod_postal_inqui;
    }

    /**
     * @return the telf_trab_inqui
     */
    public int getTelf_trab_inqui() {
        return telf_trab_inqui;
    }

    /**
     * @return the telf_part_inqui
     */
    public int getTelf_part_inqui() {
        return telf_part_inqui;
    }

    /**
     * @return the telf_movil_inqui
     */
    public int getTelf_movil_inqui() {
        return telf_movil_inqui;
    }

    /**
     * @return the num_fax_inqui
     */
    public int getNum_fax_inqui() {
        return num_fax_inqui;
    }

    /**
     * @return the email_trab_inqui
     */
    public String getEmail_trab_inqui() {
        return email_trab_inqui;
    }

    /**
     * @return the email_pers_inqui
     */
    public String getEmail_pers_inqui() {
        return email_pers_inqui;
    }

    /**
     * @param id_inquilino the id_inquilino to set
     */
    public void setId_inquilino(int id_inquilino) {
        this.id_inquilino = id_inquilino;
    }

    /**
     * @param nombre_inqui the nombre_inqui to set
     */
    public void setNombre_inqui(String nombre_inqui) {
        this.nombre_inqui = nombre_inqui;
    }

    /**
     * @param apellidos_inqui the apellidos_inqui to set
     */
    public void setApellidos_inqui(String apellidos_inqui) {
        this.apellidos_inqui = apellidos_inqui;
    }

    /**
     * @param cif_inqui the cif_inqui to set
     */
    public void setCif_inqui(String cif_inqui) {
        this.cif_inqui = cif_inqui;
    }

    /**
     * @param domicilio_inqui the domicilio_inqui to set
     */
    public void setDomicilio_inqui(String domicilio_inqui) {
        this.domicilio_inqui = domicilio_inqui;
    }

    /**
     * @param ciudad_inqui the ciudad_inqui to set
     */
    public void setCiudad_inqui(String ciudad_inqui) {
        this.ciudad_inqui = ciudad_inqui;
    }

    /**
     * @param cod_postal_inqui the cod_postal_inqui to set
     */
    public void setCod_postal_inqui(int cod_postal_inqui) {
        this.cod_postal_inqui = cod_postal_inqui;
    }

    /**
     * @param telf_trab_inqui the telf_trab_inqui to set
     */
    public void setTelf_trab_inqui(int telf_trab_inqui) {
        this.telf_trab_inqui = telf_trab_inqui;
    }

    /**
     * @param telf_part_inqui the telf_part_inqui to set
     */
    public void setTelf_part_inqui(int telf_part_inqui) {
        this.telf_part_inqui = telf_part_inqui;
    }

    /**
     * @param telf_movil_inqui the telf_movil_inqui to set
     */
    public void setTelf_movil_inqui(int telf_movil_inqui) {
        this.telf_movil_inqui = telf_movil_inqui;
    }

    /**
     * @param num_fax_inqui the num_fax_inqui to set
     */
    public void setNum_fax_inqui(int num_fax_inqui) {
        this.num_fax_inqui = num_fax_inqui;
    }

    /**
     * @param email_trab_inqui the email_trab_inqui to set
     */
    public void setEmail_trab_inqui(String email_trab_inqui) {
        this.email_trab_inqui = email_trab_inqui;
    }

    /**
     * @param email_pers_inqui the email_pers_inqui to set
     */
    public void setEmail_pers_inqui(String email_pers_inqui) {
        this.email_pers_inqui = email_pers_inqui;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inquilinos{id_inquilino=").append(id_inquilino);
        sb.append(", nombre_inqui=").append(nombre_inqui);
        sb.append(", apellidos_inqui=").append(apellidos_inqui);
        sb.append(", cif_inqui=").append(cif_inqui);
        sb.append(", domicilio_inqui=").append(domicilio_inqui);
        sb.append(", ciudad_inqui=").append(ciudad_inqui);
        sb.append(", cod_postal_inqui=").append(cod_postal_inqui);
        sb.append(", telf_trab_inqui=").append(telf_trab_inqui);
        sb.append(", telf_part_inqui=").append(telf_part_inqui);
        sb.append(", telf_movil_inqui=").append(telf_movil_inqui);
        sb.append(", num_fax_inqui=").append(num_fax_inqui);
        sb.append(", email_trab_inqui=").append(email_trab_inqui);
        sb.append(", email_pers_inqui=").append(email_pers_inqui);
        sb.append('}');
        return sb.toString();
    }
    
}
