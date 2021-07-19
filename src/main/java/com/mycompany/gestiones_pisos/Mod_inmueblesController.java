/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import com.mycompany.DAO.CiudadesDAO;
import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.InmueblesDAO;
import com.mycompany.DAO.Tipos_inmueblesDAO;
import com.mycompany.models.Ciudades;
import com.mycompany.models.Inmuebles;
import com.mycompany.models.Tipos_inmuebles;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
public class Mod_inmueblesController {

    
    
    @FXML
    private ComboBox mod_lista_tipos;
    @FXML
    private TextField mod_destino_inmu;
    @FXML
    private TextField mod_domicilio_imnu;
    @FXML
    private ComboBox mod_lista_ciudades;
    @FXML
    private TextField mod_codposta_inmu;
    @FXML
    private TextField mod_alias_inmu;
    @FXML
    private TextField mod_porcentaje_inmu;
    @FXML
    private TextField mod_refcatast_inmu;
    @FXML
    private TextField mod_regpropiedad_inmu;
    @FXML
    private TextField mod_tomo_inmu;
    @FXML
    private TextField mod_libro_inmu;
    @FXML
    private TextField mod_folio_inmu;
    @FXML
    private TextField mod_finca_inmu;
    @FXML
    private TextField mod_inspeccion_inmu;
    @FXML
    private TextField mod_porcencomu_inmu;
    @FXML
    private TextField mod_porcencomugeneral_inmu;
    @FXML
    private Button mod_guardar_inmu;

    private static InmueblesDAO tempdao_inmuebles;
    private static Inmuebles temp_inmuebles;
    private static Inmuebles inmueble;
    private static CiudadesDAO tempdao_ciudades;
    private static Tipos_inmueblesDAO tempdao_tipos;
    private static Connection con;
    ObservableList<Ciudades> listadopais;    
    ObservableList<Tipos_inmuebles> listadotipos; 
        
    public void initlist_ciudades() throws SQLException {
        tempdao_ciudades = new CiudadesDAO();
        try {
            con = ConnDAO.conectar();
            listadopais = FXCollections.observableArrayList(tempdao_ciudades.listado_ciudades(con));
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

    public void initlist_tipos() throws SQLException {
        tempdao_tipos = new Tipos_inmueblesDAO();
        try {
            con = ConnDAO.conectar();
            listadotipos = FXCollections.observableArrayList(tempdao_tipos.listado_tipos(con));
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
    
    public void cargarinmu(Inmuebles inmu) {
        for(int i = 0; i < listadotipos.size(); i++){
            if(inmu.getInmueble_tipo_id()== listadotipos.get(i).getId_tipos_inmuebles()){
                mod_lista_tipos.setValue(listadotipos.get(i));
            }
        }
        mod_destino_inmu.setText(inmu.getDestino());
        mod_domicilio_imnu.setText(inmu.getDomicilio());
        for(int i = 0; i < listadopais.size(); i++){
            if(inmu.getCiudad() == listadopais.get(i).getId_ciudad()){
                mod_lista_ciudades.setValue(listadopais.get(i));
            }
        }
        mod_codposta_inmu.setText(String.valueOf(inmu.getCod_postal()));
        mod_alias_inmu.setText(inmu.getAlias());
        mod_porcentaje_inmu.setText(String.valueOf(inmu.getProcentaje()));
        mod_refcatast_inmu.setText(inmu.getRef_catastral());
        mod_regpropiedad_inmu.setText(inmu.getReg_propiedad());
        mod_tomo_inmu.setText(inmu.getTomo());
        mod_libro_inmu.setText(inmu.getLibro());
        mod_folio_inmu.setText(inmu.getFolio());
        mod_finca_inmu.setText(inmu.getFinca());
        mod_inspeccion_inmu.setText(inmu.getInspeccion());
        mod_porcencomu_inmu.setText(String.valueOf(inmu.getPorcentaje_comu()));
        mod_porcencomugeneral_inmu.setText(String.valueOf(inmu.getPorcentaje_comu_general()));
    }
    
    @FXML
    private void modificar_inmueble(ActionEvent event) {
        tempdao_inmuebles = new InmueblesDAO();
        temp_inmuebles = new Inmuebles();
        
        inmueble = new Inmuebles(-1,-1, mod_destino_inmu.getText(), mod_domicilio_imnu.getText(),-1,
            Integer.parseInt(mod_codposta_inmu.getText()), mod_alias_inmu.getText(), Integer.parseInt(mod_porcentaje_inmu.getText()), mod_refcatast_inmu.getText(),
            mod_regpropiedad_inmu.getText(), mod_tomo_inmu.getText(), mod_libro_inmu.getText(),
            mod_folio_inmu.getText(), mod_finca_inmu.getText(), mod_inspeccion_inmu.getText(), Integer.parseInt(mod_porcencomu_inmu.getText()), Integer.parseInt(mod_porcencomugeneral_inmu.getText()));
        
        


        try {
            con = ConnDAO.conectar();
            if(temp_inmuebles.comprobar_inmuebles(temp_inmuebles)){
                
            } else if(temp_inmuebles.getInmueble_tipo_id() <= 0){
                
            } else {
                
            }
            

                
                tempdao_inmuebles.mod_inmuebles(con, inmueble);
                AlertaUtil.mostrarInfo("Propietarios modificado");
                Stage stage = (Stage) this.mod_guardar_inmu.getScene().getWindow();
                stage.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(Mod_propietariosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mod_propietariosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mod_propietariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
