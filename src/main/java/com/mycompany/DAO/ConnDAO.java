/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.gestiones_pisos.App;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author PORTATIL_2
 */
public class ConnDAO {
    
    /**
     * Es el metodo que te permite conectarte con la base de datos
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public static Connection conectar() throws ClassNotFoundException, SQLException, IOException {
        
        Connection conexion;
        Properties configuration = new Properties();
        configuration.load(new FileInputStream(new File(App.class.getResource("conexionbd_pisos.properties").getPath())));
        String host = configuration.getProperty("host");
        String port = configuration.getProperty("port");
        String name = configuration.getProperty("name");
        String username = configuration.getProperty("username");
        String password = configuration.getProperty("password");

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
        return conexion;
    }
    
    /**
     * Es el metodo que te permite desconectarte con la base de datos
     * @param conexion
     * @throws SQLException
     */
    public static void desconexion (Connection conexion) throws SQLException{
        conexion.close();
    }
}
