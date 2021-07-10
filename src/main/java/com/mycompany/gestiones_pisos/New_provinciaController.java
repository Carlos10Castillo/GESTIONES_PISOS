/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.PaisesDAO;
import com.mycompany.DAO.ProvinciasDAO;
import com.mycompany.DAO.RegionesDAO;
import com.mycompany.models.Paises;
import com.mycompany.models.Provincias;
import com.mycompany.models.Regiones;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CARLOS
 */
public class New_provinciaController {
    
    @FXML
    private ComboBox listapais_newprovincia;
    @FXML
    private ComboBox listaregion_newprovincia;
    @FXML
    private TextField newfieldprovincia;
    @FXML
    private Button guardar;
    
    private PaisesDAO tempdao_pais;
    private RegionesDAO tempdao_region;
    private ProvinciasDAO tempdao_provincias;
    private Provincias temp_provincias;
    private Connection con;
    private Paises temp_pais = new Paises();
    private Regiones temp_regiones = new Regiones();
    
    
    
    public void initlist_pais() throws SQLException{
        tempdao_pais = new PaisesDAO();
        try {
            con = ConnDAO.conectar();
            ArrayList<Paises> listadotemp_pais = new ArrayList(tempdao_pais.listado_paises(con));
            ObservableList<Paises> listadopais = FXCollections.observableArrayList(listadotemp_pais);
            listapais_newprovincia.setItems(listadopais);
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
    private void selectpais(Event event) throws SQLException {
        temp_pais = (Paises) listapais_newprovincia.getSelectionModel().getSelectedItem();
        initlist_region();
    }
    
    public void initlist_region() throws SQLException{
        tempdao_region = new RegionesDAO();
        
        try {
            con = ConnDAO.conectar();
            ArrayList<Regiones> listadotemp_region = new ArrayList(tempdao_region.listado_regiones(con, temp_pais));
            ObservableList<Regiones> listadoregion = FXCollections.observableArrayList(listadotemp_region);
            listaregion_newprovincia.setItems(listadoregion);
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
    private void selectregion(Event event) {
        temp_regiones = (Regiones) listaregion_newprovincia.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    public void guardar_provincia(ActionEvent event) throws SQLException{
        tempdao_provincias = new ProvinciasDAO();
        temp_provincias = new Provincias();
        try {
            con = ConnDAO.conectar();
            temp_provincias = new Provincias(-1, newfieldprovincia.getText(), temp_regiones.getId_regiones());
            if(newfieldprovincia.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de provincia");
            }else{
                tempdao_provincias.insert_provincias(con, temp_provincias);
                AlertaUtil.mostrarInfo("Se ha guardado correctamente");
                Stage stage = (Stage) this.guardar.getScene().getWindow();
                stage.close();                
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(New_paisController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(New_paisController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(New_paisController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnDAO.desconexion(con);
        }
    }
}
