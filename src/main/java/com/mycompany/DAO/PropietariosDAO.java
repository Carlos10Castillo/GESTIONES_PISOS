/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.gestiones_pisos.App;
import com.mycompany.models.Propietarios;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PORTATIL_2
 */
public class PropietariosDAO {
    public void insertar(Propietarios prop, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO gestiones_pisos.propietarios (nombre, apellidos, cif, domicilio, ciudad, codigo_postal, telefonodeltrabajo,"
                + " telefonoparticular, telefonomovil, numerodefax, email_trabajo, email_personal) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, prop.getNombre_prop());
        sentencia.setString(2, prop.getApellidos_prop());
        sentencia.setString(3, prop.getCif_prop());
        sentencia.setString(4, prop.getDomicilio_prop());
        sentencia.setInt(5, prop.getCiudad_prop());
        sentencia.setInt(6, prop.getCod_postal_prop());
        sentencia.setInt(7, prop.getTelf_trab_prop());
        sentencia.setInt(8, prop.getTelf_part_prop());
        sentencia.setInt(9, prop.getTelf_movil_prop());
        sentencia.setInt(10, prop.getNum_fax_prop());
        sentencia.setString(11, prop.getEmail_trab_prop());
        sentencia.setString(12, prop.getEmail_pers_prop());
        sentencia.executeUpdate();
    }
    
    public List<Propietarios> list_prop(Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        List<Propietarios> listado = new ArrayList<>();
        String sql = "SELECT * FROM gestiones_pisos.propietarios";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Propietarios a = new Propietarios();
            a.setIdpropietario(resultado.getInt(1));
            a.setNombre_prop(resultado.getString(2));
            a.setApellidos_prop(resultado.getString(3));
            a.setCif_prop(resultado.getString(4));
            a.setDomicilio_prop(resultado.getString(5));
            a.setCiudad_prop(resultado.getInt(6));
            a.setCod_postal_prop(resultado.getInt(7));
            a.setTelf_trab_prop(resultado.getInt(8));
            a.setTelf_part_prop(resultado.getInt(9));
            a.setTelf_movil_prop(resultado.getInt(10));
            a.setNum_fax_prop(resultado.getInt(11));
            a.setEmail_trab_prop(resultado.getString(12));
            a.setEmail_pers_prop(resultado.getString(13));
            listado.add(a);
        }
        return listado;
    }
    
    public void modificar(Propietarios prop, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "UPDATE gestiones_pisos.propietarios SET nombre = ?, apellidos = ?, domicilio = ?, ciudad = ?,"
                + " codigo_postal = ?, telefonodeltrabajo = ?, telefonoparticular = ?, telefonomovil = ?, numerodefax = ?, email_trabajo = ?, email_personal = ?"
                + "WHERE propietarios.idpropietario = ?";
        
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
        sentencia.setInt(12, App.prop.getIdpropietario());
        sentencia.executeUpdate();
    }
    
}
