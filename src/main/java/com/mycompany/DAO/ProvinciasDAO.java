/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.models.Provincias;
import com.mycompany.models.Regiones;
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
public class ProvinciasDAO {
    
    
    public List<Provincias> listado_provincias (Connection conexion, Regiones temp_region) throws SQLException, ClassNotFoundException, IOException{
        List<Provincias> listado = new ArrayList<>();
        String sql = "SELECT * FROM gestiones_pisos.provincia WHERE region_id = ?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, temp_region.getId_regiones());
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Provincias a = new Provincias();
            a.setId_provincia(resultado.getInt(1));
            a.setProvincia(resultado.getString(2));
            a.setId_region(resultado.getInt(3));
            listado.add(a);
        }
        
        return listado;        
    }
    
    public void insert_provincias(Connection conexion, Provincias provincias) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO gestiones_pisos.provincia (provincia, region_id) VALUES (?,?)";        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, provincias.getProvincia());
        sentencia.setInt(2, provincias.getId_region());
        sentencia.executeUpdate();
    }
}
