/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import com.mycompany.DAO.CiudadesDAO;
import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.PaisesDAO;
import com.mycompany.DAO.ProvinciasDAO;
import com.mycompany.DAO.RegionesDAO;
import com.mycompany.models.Ciudades;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author CARLOS
 */
public class New_localizacionesController{

    @FXML
    private ComboBox listado_pais;
    @FXML
    private ComboBox listado_region;
    @FXML
    private ComboBox listado_provincia;
    @FXML
    private TextField  fieldciudad;
    @FXML
    private Button guardar;
    
    private PaisesDAO tempdao_paises;
    private Paises temp_paises = new Paises();
    private RegionesDAO tempdao_regiones;
    private Regiones temp_regiones = new Regiones();
    private ProvinciasDAO tempdao_provincias;
    private Provincias temp_provincias;
    private CiudadesDAO tempdao_ciudades;
    private Ciudades temp_ciudades;
    private Connection con;

    
    
    
    public void initlist_paises() throws SQLException{
        tempdao_paises = new PaisesDAO();
        try {
            con = ConnDAO.conectar();
            ArrayList<Paises> listadotemp_pais = new ArrayList(tempdao_paises.listado_paises(con));
            ObservableList<Paises> listadopais = FXCollections.observableArrayList(listadotemp_pais);
            listado_pais.setItems(listadopais);
//          List<Propietarios> listadoprop = prop.list_prop(con);
//          listaprop.setItems(FXCollections.observableList(listadoprop));
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
        temp_paises = (Paises) listado_pais.getSelectionModel().getSelectedItem();
        initlist_region();
    }
    
    public void initlist_region() throws SQLException{
        tempdao_regiones = new RegionesDAO();
        try {
            con = ConnDAO.conectar();
            ArrayList<Regiones> listadotemp_pais = new ArrayList(tempdao_regiones.listado_regiones(con, temp_paises));
            ObservableList<Regiones> listadopais = FXCollections.observableArrayList(listadotemp_pais);
            listado_region.setItems(listadopais);
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
    private void selectregion(Event event) throws SQLException {
        temp_regiones = (Regiones) listado_region.getSelectionModel().getSelectedItem();
        initlist_provincias();
    }
    
    
    public void initlist_provincias() throws SQLException{
        tempdao_provincias = new ProvinciasDAO();
        try {
            con = ConnDAO.conectar();
            ArrayList<Regiones> listadotemp_provincia = new ArrayList( tempdao_provincias.listado_provincias(con, temp_regiones));
            ObservableList<Regiones> listadoprovincia = FXCollections.observableArrayList(listadotemp_provincia);
            listado_provincia.setItems(listadoprovincia);
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
    private void selectprovincia(Event event) throws SQLException {
        temp_provincias = (Provincias) listado_provincia.getSelectionModel().getSelectedItem();
        
    }
    
    @FXML
    public void new_pais(ActionEvent event) throws SQLException{
        try {
            //cargar ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inserciones/new_paises.fxml"));
            //referencia al padre
            Parent root = loader.load();
            //creado del controlador manualmente
            New_paisController controlador = loader.getController();
            //creado de escena y estado
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            initlist_paises();
            
            
        } catch (IOException ex) {
            Logger.getLogger(View_inmueblesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void new_region(ActionEvent event) throws SQLException{
        try {
            //cargar ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inserciones/new_regiones.fxml"));
            //referencia al padre
            Parent root = loader.load();
            //creado del controlador manualmente
            New_regionController controlador = loader.getController();
            //creado de escena y estado
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            controlador.initlist_pais();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(View_inmueblesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void new_provincia(ActionEvent event){
        tempdao_regiones = new RegionesDAO();
        try {
            con = ConnDAO.conectar();
            //cargar ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inserciones/new_provincias.fxml"));
            //referencia al padre
            Parent parent = loader.load();
            //creado del controlador manualmente
            New_provinciaController controlador = loader.getController();
            //creado de escena y estado
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            controlador.initlist_pais();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(View_inmueblesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("2. error de sql" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("3. error de clases" + ex.getMessage());
        }
    }
    
    @FXML
    public void guardar_ciudad (ActionEvent event) throws SQLException{
        temp_ciudades = new Ciudades();
        tempdao_ciudades = new CiudadesDAO();
        try {
            con = ConnDAO.conectar();
            temp_ciudades = new Ciudades(-1, fieldciudad.getText(), temp_provincias.getId_provincia());
            if(fieldciudad.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de ciudad");
            }else{
                tempdao_ciudades.insert_ciudades(con, temp_ciudades);
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
