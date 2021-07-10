/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import java.sql.Date;

/**
 *
 * @author CARLOS
 */
public class Pagos_alquileres {
    private int id_ingreso;
    private String cuenta_ingreso;
    private Date mes_año;
    private int cantidad_a_ingresar;
    private Date fecha_ingreso;
    private int cantidad_ingresada;
    private int dif_ingreso;
    private String concepto_dif;
    private int contrato_detalle_dif;
    private String concepto;

    public Pagos_alquileres() {
    }

    public Pagos_alquileres(int id_ingreso, String cuenta_ingreso, Date mes_año, int cantidad_a_ingresar, Date fecha_ingreso, int cantidad_ingresada, int dif_ingreso, String concepto_dif, int contrato_detalle_dif, String concepto) {
        this.id_ingreso = id_ingreso;
        this.cuenta_ingreso = cuenta_ingreso;
        this.mes_año = mes_año;
        this.cantidad_a_ingresar = cantidad_a_ingresar;
        this.fecha_ingreso = fecha_ingreso;
        this.cantidad_ingresada = cantidad_ingresada;
        this.dif_ingreso = dif_ingreso;
        this.concepto_dif = concepto_dif;
        this.contrato_detalle_dif = contrato_detalle_dif;
        this.concepto = concepto;
    }

    /**
     * @return the id_ingreso
     */
    public int getId_ingreso() {
        return id_ingreso;
    }

    /**
     * @return the cuenta_ingreso
     */
    public String getCuenta_ingreso() {
        return cuenta_ingreso;
    }

    /**
     * @return the mes_año
     */
    public Date getMes_año() {
        return mes_año;
    }

    /**
     * @return the cantidad_a_ingresar
     */
    public int getCantidad_a_ingresar() {
        return cantidad_a_ingresar;
    }

    /**
     * @return the fecha_ingreso
     */
    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * @return the cantidad_ingresada
     */
    public int getCantidad_ingresada() {
        return cantidad_ingresada;
    }

    /**
     * @return the dif_ingreso
     */
    public int getDif_ingreso() {
        return dif_ingreso;
    }

    /**
     * @return the concepto_dif
     */
    public String getConcepto_dif() {
        return concepto_dif;
    }

    /**
     * @return the contrato_detalle_dif
     */
    public int getContrato_detalle_dif() {
        return contrato_detalle_dif;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param id_ingreso the id_ingreso to set
     */
    public void setId_ingreso(int id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    /**
     * @param cuenta_ingreso the cuenta_ingreso to set
     */
    public void setCuenta_ingreso(String cuenta_ingreso) {
        this.cuenta_ingreso = cuenta_ingreso;
    }

    /**
     * @param mes_año the mes_año to set
     */
    public void setMes_año(Date mes_año) {
        this.mes_año = mes_año;
    }

    /**
     * @param cantidad_a_ingresar the cantidad_a_ingresar to set
     */
    public void setCantidad_a_ingresar(int cantidad_a_ingresar) {
        this.cantidad_a_ingresar = cantidad_a_ingresar;
    }

    /**
     * @param fecha_ingreso the fecha_ingreso to set
     */
    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * @param cantidad_ingresada the cantidad_ingresada to set
     */
    public void setCantidad_ingresada(int cantidad_ingresada) {
        this.cantidad_ingresada = cantidad_ingresada;
    }

    /**
     * @param dif_ingreso the dif_ingreso to set
     */
    public void setDif_ingreso(int dif_ingreso) {
        this.dif_ingreso = dif_ingreso;
    }

    /**
     * @param concepto_dif the concepto_dif to set
     */
    public void setConcepto_dif(String concepto_dif) {
        this.concepto_dif = concepto_dif;
    }

    /**
     * @param contrato_detalle_dif the contrato_detalle_dif to set
     */
    public void setContrato_detalle_dif(int contrato_detalle_dif) {
        this.contrato_detalle_dif = contrato_detalle_dif;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pagos_alquileres{id_ingreso=").append(id_ingreso);
        sb.append(", cuenta_ingreso=").append(cuenta_ingreso);
        sb.append(", mes_a\u00f1o=").append(mes_año);
        sb.append(", cantidad_a_ingresar=").append(cantidad_a_ingresar);
        sb.append(", fecha_ingreso=").append(fecha_ingreso);
        sb.append(", cantidad_ingresada=").append(cantidad_ingresada);
        sb.append(", dif_ingreso=").append(dif_ingreso);
        sb.append(", concepto_dif=").append(concepto_dif);
        sb.append(", contrato_detalle_dif=").append(contrato_detalle_dif);
        sb.append(", concepto=").append(concepto);
        sb.append('}');
        return sb.toString();
    }
}
