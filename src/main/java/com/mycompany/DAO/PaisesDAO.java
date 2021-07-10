/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.models.Paises;
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
public class PaisesDAO {
    
    public List<Paises> listado_paises (Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        List<Paises> listado = new ArrayList<>();
        String sql = "SELECT * FROM gestiones_pisos.paises";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Paises a = new Paises();
            a.setId_paises(resultado.getInt(1));
            a.setPaises(resultado.getString(2));
            listado.add(a);
        }
        
        return listado;        
    }
    
    public void insert_paises(Connection conexion, Paises pais) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO gestiones_pisos.paises (pais) VALUES (?)";        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, pais.getPaises());
        sentencia.executeUpdate();
    }
}
