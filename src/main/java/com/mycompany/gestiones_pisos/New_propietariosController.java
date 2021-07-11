/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import com.mycompany.DAO.CiudadesDAO;
import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.PropietariosDAO;
import com.mycompany.models.Ciudades;
import com.mycompany.models.Propietarios;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
public class New_propietariosController {

    @FXML
    private TextField new_nompro;
    @FXML
    private TextField new_apepro;
    @FXML
    private TextField new_cifpro;
    @FXML
    private TextField new_dompro;
    @FXML
    private ComboBox list_ciudades;
    @FXML
    private TextField new_codpro;
    @FXML
    private TextField new_telftrabpro;
    @FXML
    private TextField new_telfpartpro;
    @FXML
    private TextField new_telfmovilpro;
    @FXML
    private TextField new_numfaxpro;
    @FXML
    private TextField new_emailtrabpro;
    @FXML
    private TextField new_emailperspro;
    @FXML
    private Button guardar_prop;

    //Variables temporales
    private static Connection con;
    private static CiudadesDAO tempdao_ciudades;
    private Ciudades temp_ciudad_id;
    private static PropietariosDAO prop;
    //Fin de variables temporales

    public void initlist_ciudades() throws SQLException {
        tempdao_ciudades = new CiudadesDAO();
        try {
            con = ConnDAO.conectar();
            ObservableList<Ciudades> listadopais = FXCollections.observableArrayList(tempdao_ciudades.listado_ciudades(con));
            list_ciudades.setItems(listadopais);
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("Error cargando los datos de la aplicación 1\n" + ex.getMessage());
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("Error cargando los datos de la aplicación 2\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("Error cargando los datos de la aplicación 3\n" + ex.getMessage());
        } finally {
            ConnDAO.desconexion(con);
        }
    }
    
    @FXML
    public void seleccion_ciudad(Event event) throws SQLException {
        temp_ciudad_id = (Ciudades)list_ciudades.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void insertar() throws SQLException {
        prop = new PropietariosDAO();
        Propietarios proptemp = new Propietarios();

        try {
            con = ConnDAO.conectar();
            proptemp = new Propietarios(-1, new_nompro.getText(), new_apepro.getText(), new_cifpro.getText(),
                    new_dompro.getText(), temp_ciudad_id.getId_ciudad(), Integer.parseInt(new_codpro.getText()),
                    Integer.parseInt(new_telftrabpro.getText()), Integer.parseInt(new_telfpartpro.getText()),
                    Integer.parseInt(new_telfmovilpro.getText()), Integer.parseInt(new_numfaxpro.getText()),
                    new_emailtrabpro.getText(), new_emailperspro.getText());
            if (new_nompro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de nombre");
            } else if (new_apepro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de apellidos");
            } else if (new_cifpro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de cif");
            } else if (new_dompro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de domicilio");
            } else if (temp_ciudad_id == null) {
                AlertaUtil.mostrarError("Seleccione una ciudad");
            } else if (new_codpro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de codigo postal");
            } else if (new_telfpartpro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de telefono particular");
            } else if (new_telfmovilpro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de telefono movil");
            } else {
                prop.insertar(proptemp, con);
//                new_nompro.clear();
//                new_apepro.clear();
//                new_cifpro.clear();
//                new_dompro.clear();
//                list_ciudades.setValue(0);
//                new_codpro.clear();
//                new_telftrabpro.clear();
//                new_telfpartpro.clear();
//                new_telfmovilpro.clear();
//                new_numfaxpro.clear();
//                new_emailtrabpro.clear();
//                new_emailperspro.clear();
                AlertaUtil.mostrarInfo("Propietario ingresado");
                Stage stage = (Stage) this.guardar_prop.getScene().getWindow();
                stage.close();
            }

        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("1. Fallo en la insercion del propietario\n" + ex.getMessage());
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("2. Fallo en la insercion del propietario\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("3. Fallo en la insercion del propietario\n" + ex.getMessage());
        } finally {
            ConnDAO.desconexion(con);
        }
    }

    @FXML
    public void newlocalizacion(ActionEvent event) throws SQLException {
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

}
