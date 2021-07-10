/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.models.Ciudades;
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
public class CiudadesDAO {
    
    public List<Ciudades> listado_ciudades (Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        List<Ciudades> listado = new ArrayList<>();
        String sql = "SELECT * FROM gestiones_pisos.ciudades";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Ciudades a = new Ciudades();
            a.setId_ciudad(resultado.getInt(1));
            a.setCiudad(resultado.getString(2));
            a.setId_provincia(resultado.getInt(3));
            listado.add(a);
        }
        
        return listado;        
    }
    
    public void insert_ciudades (Connection conexion, Ciudades ciudades) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO gestiones_pisos.ciudades (ciudad, provincia_id) VALUES (?,?)";        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, ciudades.getCiudad());
        sentencia.setInt(2, ciudades.getId_provincia());
        sentencia.executeUpdate();
    }
}
