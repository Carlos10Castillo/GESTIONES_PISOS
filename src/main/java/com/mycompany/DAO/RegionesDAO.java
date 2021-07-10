/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.models.Paises;
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
public class RegionesDAO {
    
    public List<Regiones> listado_regiones (Connection conexion, Paises temp_pais) throws SQLException, ClassNotFoundException, IOException{
        List<Regiones> listado = new ArrayList<>();
        String sql = "SELECT * FROM gestiones_pisos.ccaa_region WHERE pais_id = ?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, temp_pais.getId_paises());
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Regiones a = new Regiones();
            a.setId_regiones(resultado.getInt(1));
            a.setRegiones(resultado.getString(2));
            a.setId_paises(resultado.getInt(3));
            listado.add(a);
        }
        return listado;        
    }
    
    public void insert_regiones(Connection conexion, Regiones regiones) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO gestiones_pisos.ccaa_region (region, pais_id) VALUES (?,?)";        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, regiones.getRegiones());
        sentencia.setInt(2, regiones.getId_paises());
        sentencia.executeUpdate();
    }
}
