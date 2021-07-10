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
public class Gastos_periodicos {
    
    private int id_gastos_periodicos;
    private int id_inmueble;
    private int cantidad;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String cuenta_pago;
    private int proveedor_id;
    private int periodo_id;
    private String concepto;

    public Gastos_periodicos() {
    }

    public Gastos_periodicos(int id_gastos_periodicos, int id_inmueble, int cantidad, Date fecha_inicio, Date fecha_fin, String cuenta_pago, int proveedor_id, int periodo_id, String concepto) {
        this.id_gastos_periodicos = id_gastos_periodicos;
        this.id_inmueble = id_inmueble;
        this.cantidad = cantidad;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.cuenta_pago = cuenta_pago;
        this.proveedor_id = proveedor_id;
        this.periodo_id = periodo_id;
        this.concepto = concepto;
    }

    /**
     * @return the id_gastos_periodicos
     */
    public int getId_gastos_periodicos() {
        return id_gastos_periodicos;
    }

    /**
     * @return the id_inmueble
     */
    public int getId_inmueble() {
        return id_inmueble;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @return the fecha_inicio
     */
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @return the fecha_fin
     */
    public Date getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @return the cuenta_pago
     */
    public String getCuenta_pago() {
        return cuenta_pago;
    }

    /**
     * @return the proveedor_id
     */
    public int getProveedor_id() {
        return proveedor_id;
    }

    /**
     * @return the periodo_id
     */
    public int getPeriodo_id() {
        return periodo_id;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param id_gastos_periodicos the id_gastos_periodicos to set
     */
    public void setId_gastos_periodicos(int id_gastos_periodicos) {
        this.id_gastos_periodicos = id_gastos_periodicos;
    }

    /**
     * @param id_inmueble the id_inmueble to set
     */
    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * @param cuenta_pago the cuenta_pago to set
     */
    public void setCuenta_pago(String cuenta_pago) {
        this.cuenta_pago = cuenta_pago;
    }

    /**
     * @param proveedor_id the proveedor_id to set
     */
    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    /**
     * @param periodo_id the periodo_id to set
     */
    public void setPeriodo_id(int periodo_id) {
        this.periodo_id = periodo_id;
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
        sb.append("Gastos_periodicos{id_gastos_periodicos=").append(id_gastos_periodicos);
        sb.append(", id_inmueble=").append(id_inmueble);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", fecha_inicio=").append(fecha_inicio);
        sb.append(", fecha_fin=").append(fecha_fin);
        sb.append(", cuenta_pago=").append(cuenta_pago);
        sb.append(", proveedor_id=").append(proveedor_id);
        sb.append(", periodo_id=").append(periodo_id);
        sb.append(", concepto=").append(concepto);
        sb.append('}');
        return sb.toString();
    }
    
}
