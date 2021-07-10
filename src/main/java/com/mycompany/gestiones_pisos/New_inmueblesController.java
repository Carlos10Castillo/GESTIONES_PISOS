/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import com.mycompany.DAO.CiudadesDAO;
import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.InmueblesDAO;
import com.mycompany.DAO.PropietariosDAO;
import com.mycompany.DAO.Tipos_inmueblesDAO;
import com.mycompany.models.Ciudades;
import com.mycompany.models.Inmuebles;
import com.mycompany.models.Propietarios;
import com.mycompany.models.Relacion_inmuprop;
import com.mycompany.models.Tipos_inmuebles;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CARLOS
 */
public class New_inmueblesController {  
    
    //Campos de la pestaña Inmuebles
    @FXML
    private ComboBox new_list_tipos;
    @FXML
    private TextField new_destino_inmu;
    @FXML
    private TextField new_domicilio_imnu;
    @FXML
    private ComboBox new_list_ciudad;
    @FXML
    private TextField new_codposta_inmu;
    @FXML
    private TextField new_alias_inmu;
    @FXML
    private TextField new_porcentaje_inmu;
    @FXML
    private TextField new_refcatast_inmu;
    @FXML
    private TextField new_regpropiedad_inmu;
    @FXML
    private TextField new_tomo_inmu;
    @FXML
    private TextField new_libro_inmu;
    @FXML
    private TextField new_folio_inmu;
    @FXML
    private TextField new_finca_inmu;
    @FXML
    private TextField new_inspeccion_inmu;
    @FXML
    private TextField new_porcencomu_inmu;
    @FXML
    private TextField new_porcencomugeneral_inmu;
    @FXML
    private Button guardar_inmu;
    //Fin de Campos

    
    //Variables Temporales
    private static Connection con;
    private static Propietarios temp_prop;
    private static PropietariosDAO tempdao_prop;
    private static Ciudades temp_ciudad;
    private static CiudadesDAO tempdao_ciudades;
    private static Inmuebles temp_inmuebles;
    private static InmueblesDAO tempdao_inmuebles;
    private static Tipos_inmuebles temp_tipos;
    private static Tipos_inmueblesDAO tempdao_tipos;
    private static Relacion_inmuprop rela;
    ObservableList<Tipos_inmuebles> listadotipos;
    ObservableList<Ciudades> listadociudad; 
    ObservableList<Propietarios> listadoprop;
           
    //Fin Variables Temporales
        
    public void initlist_ciudades() throws SQLException{
        tempdao_ciudades = new CiudadesDAO();
        try {
            con = ConnDAO.conectar();
            listadociudad = FXCollections.observableArrayList(tempdao_ciudades.listado_ciudades(con));
            new_list_ciudad.setItems(listadociudad);
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
    
    public void initlist_tipos() throws SQLException{
        tempdao_tipos = new Tipos_inmueblesDAO();
        try {
            con = ConnDAO.conectar();
            listadotipos = FXCollections.observableArrayList(tempdao_tipos.listado_tipos(con));
            new_list_tipos.setItems(listadotipos);
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
    private void select_tipos(Event event) throws SQLException {
        temp_tipos = (Tipos_inmuebles) new_list_tipos.getSelectionModel().getSelectedItem();
        
    }
    
    @FXML
    private void select_ciudades(Event event) throws SQLException {
        temp_ciudad = (Ciudades) new_list_ciudad.getSelectionModel().getSelectedItem();
        
    }
    
    @FXML
    public void newlocalizacion(ActionEvent event) throws SQLException{
        try {
            //cargar ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inserciones/new_localizaciones.fxml"));
            //referencia al padre
            Parent root = loader.load();
            //creado del controlador manualmente
            New_localizacionesController controlador = loader.getController();
            //creado de escena y estado
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            controlador.initlist_region();
            controlador.initlist_paises();
            controlador.initlist_provincias();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            initlist_ciudades();    
                        
            
        } catch (IOException ex) {
            Logger.getLogger(View_inmueblesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void newTipos(ActionEvent event) throws SQLException{
        try {
            //cargar ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inserciones/new_tipos_inmuebles.fxml"));
            //referencia al padre
            Parent root = loader.load();
            //creado del controlador manualmente
            New_tipos_inmueblesController controlador = loader.getController();
            //creado de escena y estado
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
                        
            
        } catch (IOException ex) {
            Logger.getLogger(View_inmueblesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void guardar_inmu (ActionEvent event) throws SQLException{
        temp_inmuebles = new Inmuebles();
        tempdao_inmuebles = new InmueblesDAO();
        rela = new Relacion_inmuprop();
        try {
            con = ConnDAO.conectar();
            
            temp_inmuebles = new Inmuebles(-1, temp_tipos.getId_tipos_inmuebles(),
                new_destino_inmu.getText(), new_domicilio_imnu.getText(), temp_ciudad.getId_ciudad(),
                Integer.parseInt(new_codposta_inmu.getText()), new_alias_inmu.getText(),
                new_refcatast_inmu.getText(), new_regpropiedad_inmu.getText(), new_tomo_inmu.getText(), new_libro_inmu.getText(), 
                new_folio_inmu.getText(), new_finca_inmu.getText(), new_inspeccion_inmu.getText(),
                Integer.parseInt(new_porcencomu_inmu.getText()), Integer.parseInt(new_porcencomugeneral_inmu.getText()));
            
            if(new_destino_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de destino");
            }else if(new_domicilio_imnu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de domicilio");
            }else if(new_codposta_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de codigo postal");
            }else if(new_alias_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de alias");
            }else if(new_porcentaje_inmu.getText().isBlank() || Integer.parseInt(new_porcentaje_inmu.getText())>100){
                AlertaUtil.mostrarError("Corrija el campo de porcentaje de propiedad");
            }else if(new_refcatast_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de referencia catastral");
            }else if(new_regpropiedad_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de registro de la propiedad");
            }else if(new_tomo_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de tomo");
            }else if(new_libro_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de libro");
            }else if(new_folio_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de folio");
            }else if(new_finca_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de finca");
            }else if(new_inspeccion_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de inspeccion");
            }else if(new_porcencomu_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de procentaje de comunidad");
            }else if(new_porcencomugeneral_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de procentaje de comunidad general");
            }else{
                Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                confirmacion.setTitle("Insertar nuevo inmueble");
                confirmacion.setContentText("¿Esta seguro de que la informacion esta correcta?");
                Optional<ButtonType> respuesta = confirmacion.showAndWait();
                if (respuesta.get().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE){
                 return;
                }
                tempdao_inmuebles.insert_inmuebles(con, temp_inmuebles);
                rela = new Relacion_inmuprop(tempdao_inmuebles.list_inmu_ultimo(con), App.prop.getIdpropietario(), Integer.parseInt(new_porcentaje_inmu.getText()));
                tempdao_inmuebles.relacion_inmu_prop(con, rela);
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
