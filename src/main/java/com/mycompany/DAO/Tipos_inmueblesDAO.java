/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.models.Tipos_inmuebles;
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
public class Tipos_inmueblesDAO {
    
        public List<Tipos_inmuebles> listado_tipos (Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        List<Tipos_inmuebles> listado = new ArrayList<>();
        String sql = "SELECT * FROM gestiones_pisos.inmueble_tipo";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Tipos_inmuebles a = new Tipos_inmuebles();
            a.setId_tipos_inmuebles(resultado.getInt(1));
            a.setTipos_inmuebles(resultado.getString(2));
            listado.add(a);
        }
        
        return listado;        
    }
    
    public void insert_regiones(Connection conexion, Tipos_inmuebles tipos) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO gestiones_pisos.inmueble_tipo (tipos) VALUES (?)";        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, tipos.getTipos_inmuebles());
        sentencia.executeUpdate();
    }
}
