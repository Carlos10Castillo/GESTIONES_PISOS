/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;


import com.mycompany.gestiones_pisos.App;
import com.mycompany.models.Inmuebles;
import com.mycompany.models.Relacion_inmuprop;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CARLOS
 */
public class InmueblesDAO {
    
    public List<Inmuebles> list_inmu(Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        List<Inmuebles> listado = new ArrayList<>();
        String sql = "SELECT * FROM gestiones_pisos.inmuebles";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);  
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Inmuebles a = new Inmuebles();
            a.setId_inmueble(resultado.getInt(1));
            a.setInmueble_tipo_id(resultado.getInt(2));
            a.setDestino(resultado.getString(3));
            a.setDomicilio(resultado.getString(4));
            a.setCiudad(resultado.getInt(5));
            a.setCod_postal(resultado.getInt(6));
            a.setAlias(resultado.getString(7));
            a.setRef_catastral(resultado.getString(8));
            a.setReg_propiedad(resultado.getString(9));
            a.setTomo(resultado.getString(10));
            a.setLibro(resultado.getString(11));
            a.setFolio(resultado.getString(12));
            a.setFinca(resultado.getString(13));
            a.setInspeccion(resultado.getString(14));
            a.setPorcentaje_comu(resultado.getInt(15));
            a.setPorcentaje_comu_general(resultado.getInt(16));
            listado.add(a);
        }
        return listado;
    }
    
    public List<Inmuebles> list_inmu_filtrado (Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        List<Inmuebles> listado = new ArrayList<>();
        String sql = "SELECT a.* FROM gestiones_pisos.inmuebles_propietarios AS b "
                + "INNER JOIN inmuebles AS a ON a.idinmueble = b.inmuebles_id WHERE propietarios_id = ?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, App.prop.getIdpropietario());   
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Inmuebles a = new Inmuebles();
            a.setId_inmueble(resultado.getInt(1));
            a.setInmueble_tipo_id(resultado.getInt(2));
            a.setDestino(resultado.getString(3));
            a.setDomicilio(resultado.getString(4));
            a.setCiudad(resultado.getInt(5));
            a.setCod_postal(resultado.getInt(6));
            a.setAlias(resultado.getString(7));
            a.setRef_catastral(resultado.getString(8));
            a.setReg_propiedad(resultado.getString(9));
            a.setTomo(resultado.getString(10));
            a.setLibro(resultado.getString(11));
            a.setFolio(resultado.getString(12));
            a.setFinca(resultado.getString(13));
            a.setInspeccion(resultado.getString(14));
            a.setPorcentaje_comu(resultado.getInt(15));
            a.setPorcentaje_comu_general(resultado.getInt(16));
            listado.add(a);
        }
        return listado;
    }
    
    public int list_inmu_ultimo(Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        int id = 0;
        String sql = "SELECT MAX(idinmueble) FROM gestiones_pisos.inmuebles";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);  
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            id = resultado.getInt(1);
        }
        return id;
    }
    
    public List<Inmuebles> list_inmu_buscador(Connection conexion, String b) throws SQLException, ClassNotFoundException, IOException{
        List<Inmuebles> listado = new ArrayList<>();
        String sql = "SELECT * FROM gestiones_pisos.inmuebles WHERE domicilio = ?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);  
        sentencia.setString(1, b);
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Inmuebles a = new Inmuebles();
            a.setId_inmueble(resultado.getInt(1));
            a.setInmueble_tipo_id(resultado.getInt(2));
            a.setDestino(resultado.getString(3));
            a.setDomicilio(resultado.getString(4));
            a.setCiudad(resultado.getInt(5));
            a.setCod_postal(resultado.getInt(6));
            a.setAlias(resultado.getString(7));
            a.setRef_catastral(resultado.getString(8));
            a.setReg_propiedad(resultado.getString(9));
            a.setTomo(resultado.getString(10));
            a.setLibro(resultado.getString(11));
            a.setFolio(resultado.getString(12));
            a.setFinca(resultado.getString(13));
            a.setInspeccion(resultado.getString(14));
            a.setPorcentaje_comu(resultado.getInt(15));
            a.setPorcentaje_comu_general(resultado.getInt(16));
            listado.add(a);
        }
        return listado;
    }

    public void insert_inmuebles(Connection conexion, Inmuebles inmu) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO gestiones_pisos.inmuebles (inmueble_tipo_id, destino, domicilio, ciudad_id, codigo_postal, alias, "
                + "refcatastral, registro_propiedad, tomo, libro, folio, finca, inspeccion, porcentaje_comunidad, porcentaje_comunidad_general) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, inmu.getInmueble_tipo_id());
        sentencia.setString(2, inmu.getDestino());
        sentencia.setString(3, inmu.getDomicilio());
        sentencia.setInt(4, inmu.getCiudad());
        sentencia.setInt(5, inmu.getCod_postal());
        sentencia.setString(6, inmu.getAlias());
        sentencia.setString(7, inmu.getRef_catastral());
        sentencia.setString(8, inmu.getReg_propiedad());
        sentencia.setString(9, inmu.getTomo());
        sentencia.setString(10, inmu.getLibro());
        sentencia.setString(11, inmu.getFolio());
        sentencia.setString(12, inmu.getFinca());
        sentencia.setString(13, inmu.getInspeccion());
        sentencia.setInt(14, inmu.getPorcentaje_comu());
        sentencia.setInt(15, inmu.getPorcentaje_comu_general());
        sentencia.executeUpdate();
    }
    
    public void relacion_inmu_prop(Connection conexion, Relacion_inmuprop rela) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO gestiones_pisos.inmuebles_propietarios (inmuebles_id, propietarios_id, porcentaje_prop) VALUES (?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, rela.getId_inmu());
        sentencia.setInt(2, rela.getId_prop());
        sentencia.setInt(3, rela.getPorcentaje());
        sentencia.executeUpdate();
    }
}
