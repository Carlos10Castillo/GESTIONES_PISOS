/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.models.Propietarios;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PORTATIL_2
 */
public class PropietariosDAO {
    public void insertar(Propietarios prop, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO gestiones_pisos.propietarios (NOMBRE, APELLIDOS, DOMICILIO, CIUDAD, CODIGO_POSTAL,"
                + " TELEFONODELTRABAJO, TELEFONOPARTICULAR,"
                + " TELEFONOMOVIL, NUMERODEFAX, EMAIL_TRABAJO, EMAIL_PERSONAL) values (?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, prop.getNombre_prop());
        sentencia.setString(2, prop.getApellidos_prop());
        sentencia.setString(3, prop.getDomicilio_prop());
        sentencia.setInt(4, prop.getCiudad_prop());
        sentencia.setInt(5, prop.getCod_postal_prop());
        sentencia.setInt(6, prop.getTelf_trab_prop());
        sentencia.setInt(7, prop.getTelf_part_prop());
        sentencia.setInt(8, prop.getTelf_movil_prop());
        sentencia.setInt(9, prop.getNum_fax_prop());
        sentencia.setString(10, prop.getEmail_trab_prop());
        sentencia.setString(11, prop.getEmail_pers_prop());
        sentencia.executeUpdate();
    }
}
