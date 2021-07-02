/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

/**
 *
 * @author PORTATIL_2
 */
public class Propietarios {
    private int idpropietario;
    private String nombre_prop;
    private String apellidos_prop;
    private String cif_prop;
    private String domicilio_prop;
    private String ciudad_prop;
    private int cod_postal_prop;
    private int telf_trab_prop;
    private int telf_part_prop;
    private int telf_movil_prop;
    private int num_fax_prop;
    private String email_trab_prop;
    private String email_pers_prop;

    public Propietarios() {
    }

    public Propietarios(int idpropietario, String nombre_prop, String apellidos_prop, String cif_prop, String domicilio_prop, String ciudad_prop, int cod_postal_prop, int telf_trab_prop, int telf_part_prop, int telf_movil_prop, int num_fax_prop, String email_trab_prop, String email_pers_prop) {
        this.idpropietario = idpropietario;
        this.nombre_prop = nombre_prop;
        this.apellidos_prop = apellidos_prop;
        this.cif_prop = cif_prop;
        this.domicilio_prop = domicilio_prop;
        this.ciudad_prop = ciudad_prop;
        this.cod_postal_prop = cod_postal_prop;
        this.telf_trab_prop = telf_trab_prop;
        this.telf_part_prop = telf_part_prop;
        this.telf_movil_prop = telf_movil_prop;
        this.num_fax_prop = num_fax_prop;
        this.email_trab_prop = email_trab_prop;
        this.email_pers_prop = email_pers_prop;
    }

    /**
     * @return the idpropietario
     */
    public int getIdpropietario() {
        return idpropietario;
    }
    /**
     * @return the nombre_prop
     */
    public String getNombre_prop() {
        return nombre_prop;
    }

    /**
     * @return the apellidos_prop
     */
    public String getApellidos_prop() {
        return apellidos_prop;
    }

    /**
     * @return the cif_prop
     */
    public String getCif_prop() {
        return cif_prop;
    }

    /**
     * @return the domicilio_prop
     */
    public String getDomicilio_prop() {
        return domicilio_prop;
    }

    /**
     * @return the ciudad_prop
     */
    public String getCiudad_prop() {
        return ciudad_prop;
    }

    /**
     * @return the cod_postal_prop
     */
    public int getCod_postal_prop() {
        return cod_postal_prop;
    }

    /**
     * @return the telf_trab_prop
     */
    public int getTelf_trab_prop() {
        return telf_trab_prop;
    }

    /**
     * @return the telf_part_prop
     */
    public int getTelf_part_prop() {
        return telf_part_prop;
    }

    /**
     * @return the telf_movil_prop
     */
    public int getTelf_movil_prop() {
        return telf_movil_prop;
    }

    /**
     * @return the num_fax_prop
     */
    public int getNum_fax_prop() {
        return num_fax_prop;
    }

    /**
     * @return the email_trab_prop
     */
    public String getEmail_trab_prop() {
        return email_trab_prop;
    }

    /**
     * @return the email_pers_prop
     */
    public String getEmail_pers_prop() {
        return email_pers_prop;
    }

    /**
     * @param idpropietario the nombre_prop to set
     */
    public void setIdpropietario(int idpropietario) {
        this.idpropietario = idpropietario;
    }
    
    /**
     * @param nombre_prop the nombre_prop to set
     */
    public void setNombre_prop(String nombre_prop) {
        this.nombre_prop = nombre_prop;
    }

    /**
     * @param apellidos_prop the apellidos_prop to set
     */
    public void setApellidos_prop(String apellidos_prop) {
        this.apellidos_prop = apellidos_prop;
    }

    /**
     * @param cif_prop the cif_prop to set
     */
    public void setCif_prop(String cif_prop) {
        this.cif_prop = cif_prop;
    }

    /**
     * @param domicilio_prop the domicilio_prop to set
     */
    public void setDomicilio_prop(String domicilio_prop) {
        this.domicilio_prop = domicilio_prop;
    }

    /**
     * @param ciudad_prop the ciudad_prop to set
     */
    public void setCiudad_prop(String ciudad_prop) {
        this.ciudad_prop = ciudad_prop;
    }

    /**
     * @param cod_postal_prop the cod_postal_prop to set
     */
    public void setCod_postal_prop(int cod_postal_prop) {
        this.cod_postal_prop = cod_postal_prop;
    }

    /**
     * @param telf_trab_prop the telf_trab_prop to set
     */
    public void setTelf_trab_prop(int telf_trab_prop) {
        this.telf_trab_prop = telf_trab_prop;
    }

    /**
     * @param telf_part_prop the telf_part_prop to set
     */
    public void setTelf_part_prop(int telf_part_prop) {
        this.telf_part_prop = telf_part_prop;
    }

    /**
     * @param telf_movil_prop the telf_movil_prop to set
     */
    public void setTelf_movil_prop(int telf_movil_prop) {
        this.telf_movil_prop = telf_movil_prop;
    }

    /**
     * @param num_fax_prop the num_fax_prop to set
     */
    public void setNum_fax_prop(int num_fax_prop) {
        this.num_fax_prop = num_fax_prop;
    }

    /**
     * @param email_trab_prop the email_trab_prop to set
     */
    public void setEmail_trab_prop(String email_trab_prop) {
        this.email_trab_prop = email_trab_prop;
    }

    /**
     * @param email_pers_prop the email_pers_prop to set
     */
    public void setEmail_pers_prop(String email_pers_prop) {
        this.email_pers_prop = email_pers_prop;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Propietarios{nombre_prop=").append(nombre_prop);
        sb.append(", apellidos_prop=").append(apellidos_prop);
        sb.append(", cif_prop=").append(cif_prop);
        sb.append(", domicilio_prop=").append(domicilio_prop);
        sb.append(", ciudad_prop=").append(ciudad_prop);
        sb.append(", cod_postal_prop=").append(cod_postal_prop);
        sb.append(", telf_trab_prop=").append(telf_trab_prop);
        sb.append(", telf_part_prop=").append(telf_part_prop);
        sb.append(", telf_movil_prop=").append(telf_movil_prop);
        sb.append(", num_fax_prop=").append(num_fax_prop);
        sb.append(", email_trab_prop=").append(email_trab_prop);
        sb.append(", email_pers_prop=").append(email_pers_prop);
        sb.append('}');
        return sb.toString();
    }
    
}
