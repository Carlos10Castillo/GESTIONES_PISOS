/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.InmueblesDAO;
import com.mycompany.DAO.PropietariosDAO;
import com.mycompany.models.Inmuebles;
import com.mycompany.models.Propietarios;
import com.mycompany.models.Relacion_inmuprop;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author CARLOS
 */
public class Relacion_inmu_propController{  
    
    @FXML
    private ComboBox list_prop;
    @FXML
    private ListView list_inmu;
    @FXML
    private TextField porcentaje_prop;
    @FXML 
    private TextField buscador;
    
    private static PropietariosDAO tempdao_prop;
    private static InmueblesDAO tempdao_inmu;
    private static Connection con;
    private Propietarios selprop;
    private Inmuebles selinmu;
    private Relacion_inmuprop rela;
    ObservableList<Propietarios> listadoprop;    
    List<Inmuebles> listadoinmu;
    
    public void initlist_prop() throws SQLException{
        tempdao_prop = new PropietariosDAO();
        try {
            con = ConnDAO.conectar();
            listadoprop = FXCollections.observableArrayList(tempdao_prop.list_prop(con));
            list_prop.setItems(listadoprop);
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("Error cargando los datos de la aplicación 1\n" + ex.getMessage());
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("Error cargando los datos de la aplicación 2\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("Error cargando los datos de la aplicación 3\n" + ex.getMessage());
        }finally{
            ConnDAO.desconexion(con);
        }
    }
    
    public void initlist_inmu() throws SQLException{
        tempdao_inmu = new InmueblesDAO();
        try {
            con = ConnDAO.conectar();
            listadoinmu = FXCollections.observableArrayList(tempdao_inmu.list_inmu(con));
            list_inmu.setItems(FXCollections.observableArrayList(listadoinmu));
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("Error cargando los datos de la aplicación 1\n" + ex.getMessage());
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("Error cargando los datos de la aplicación 2\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("Error cargando los datos de la aplicación 3\n" + ex.getMessage());
        }finally{
            ConnDAO.desconexion(con);
        }
    }
    
    @FXML
    private void select_prop(Event event) throws SQLException {
        selprop = (Propietarios) list_prop.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    private void select_inmu(Event event) throws SQLException {
        selinmu  = (Inmuebles) list_inmu.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    private void buscar() {
        tempdao_inmu = new InmueblesDAO();
        list_inmu.getItems().clear();
        try {
            con = ConnDAO.conectar();
            if(buscador.getText().isBlank()){
                initlist_inmu();
            }else{
                List<Inmuebles> recursos = tempdao_inmu.list_inmu_buscador(con, buscador.getText());       
                list_inmu.setItems(FXCollections.observableList(recursos));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Relacion_inmu_propController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Relacion_inmu_propController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Relacion_inmu_propController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void guardar() throws SQLException{
        tempdao_inmu = new InmueblesDAO();
        rela = new Relacion_inmuprop(selinmu.getId_inmueble(), selprop.getIdpropietario(), Integer.parseInt(porcentaje_prop.getText()));
        
        try {
            con = ConnDAO.conectar();
            tempdao_inmu.relacion_inmu_prop(con, rela);
            AlertaUtil.mostrarInfo("Relacion creada");
        } catch (SQLException ex) {
            Logger.getLogger(Relacion_inmu_propController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Relacion_inmu_propController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Relacion_inmu_propController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnDAO.desconexion(con);
        }
        
    }
    
    
}
