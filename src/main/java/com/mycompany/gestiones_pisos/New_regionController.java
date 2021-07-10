/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.PaisesDAO;
import com.mycompany.DAO.RegionesDAO;
import com.mycompany.models.Paises;
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
public class New_regionController{
  
    @FXML
    private ComboBox listapais_newregion;
    @FXML
    private TextField newfieldregione;
    @FXML
    private Button guardar;
    
    private PaisesDAO tempdao_pais;
    private RegionesDAO tempdao_regiones;
    private Connection con;
    private Paises temp_pais = new Paises();
    private Regiones temp_regiones;

    
    public void initlist_pais() throws SQLException{
        tempdao_pais = new PaisesDAO();
        try {
            con = ConnDAO.conectar();
            ArrayList<Paises> listadotemp_pais = new ArrayList(tempdao_pais.listado_paises(con));
            ObservableList<Paises> listadopais = FXCollections.observableArrayList(listadotemp_pais);
            listapais_newregion.setItems(listadopais);
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
        temp_pais = (Paises) listapais_newregion.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    public void guardar_regiones(ActionEvent event) throws SQLException{
        temp_regiones= new Regiones();
        tempdao_regiones = new RegionesDAO();

        try {
            con = ConnDAO.conectar();
            temp_regiones = new Regiones(-1, newfieldregione.getText(), temp_pais.getId_paises());
            if(newfieldregione.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de nueva region");
            }else{
                tempdao_regiones.insert_regiones(con, temp_regiones);
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
