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
import com.mycompany.models.Tipos_inmuebles;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CARLOS
 */
public class View_inmueblesController  {
    
    //Desplegable de seleccion de propietarios 
    @FXML
    private ComboBox listaprop;
    //Fin de Desplegable
    
    
    //Campos de la pestaña Datos personales
    @FXML
    private TextField nompro;
    @FXML
    private TextField apepro;
    @FXML
    private TextField cifpro;
    @FXML
    private TextField dompro;
    @FXML
    private TextField ciudad_prop;
    @FXML
    private TextField codpro;
    @FXML
    private TextField telftrabpro;
    @FXML
    private TextField telfpartpro;
    @FXML
    private TextField telfmovilpro;
    @FXML
    private TextField numfaxpro;
    @FXML
    private TextField emailtrabpro;
    @FXML
    private TextField emailperspro;  
    //Fin de Campos
    
    
    //Campos de la pestaña Inmuebles
    @FXML
    private ListView lista_inmuebles;
    @FXML
    private TextField tipo_inmu;
    @FXML
    private TextField destino_inmu;
    @FXML
    private TextField domicilio_imnu;
    @FXML
    private TextField ciudad_inmu;
    @FXML
    private TextField codposta_inmu;
    @FXML
    private TextField alias_inmu;
    @FXML
    private TextField porcentaje_inmu;
    @FXML
    private TextField refcatast_inmu;
    @FXML
    private TextField regpropiedad_inmu;
    @FXML
    private TextField tomo_inmu;
    @FXML
    private TextField libro_inmu;
    @FXML
    private TextField folio_inmu;
    @FXML
    private TextField finca_inmu;
    @FXML
    private TextField inspeccion_inmu;
    @FXML
    private TextField porcencomu_inmu;
    @FXML
    private TextField porcencomugeneral_inmu;
    //Fin de Campos
    
    //Variables Temporales
    private static PropietariosDAO prop;
    private static InmueblesDAO inmu;
    private static CiudadesDAO tempdao_ciudades;
    private static Tipos_inmueblesDAO tempdao_tipos;
    private static Connection con;
    private Propietarios selprop;
    private Inmuebles selinmu;
    private Ciudades temp_ciudad_id = new Ciudades();
    ObservableList<Ciudades> listadopais;    
    ObservableList<Tipos_inmuebles> listadotipos;  
    //Fin Variables Temporales
       
    //Inicializacion de listas
    public void initlist_prop() throws SQLException{
        prop = new PropietariosDAO();
        try {
            con = ConnDAO.conectar();
            ObservableList<Propietarios> listadoprop = FXCollections.observableArrayList(prop.list_prop(con));
            listaprop.setItems(listadoprop);
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
        inmu = new InmueblesDAO();
        lista_inmuebles.getItems().clear();
        try {
            con = ConnDAO.conectar();
            List<Inmuebles> listadoinmu = inmu.list_inmu_filtrado(con);
            lista_inmuebles.setItems(FXCollections.observableList(listadoinmu));
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
    
    public void initlist_ciudades() throws SQLException{
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
        }finally{
            ConnDAO.desconexion(con);
        }
    }
    
    public void initlist_tipos() throws SQLException{
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
        }finally{
            ConnDAO.desconexion(con);
        }
    }
    //Fin de inicializacion de listas
    
    //Carga y seleccion de datos
    private void cargarprop(Propietarios prop) {
        nompro.setText(prop.getNombre_prop());
        apepro.setText(prop.getApellidos_prop());
        cifpro.setText(prop.getCif_prop());
        dompro.setText(prop.getDomicilio_prop());
        for(int i = 0; i < listadopais.size(); i++){
            if(selprop.getCiudad_prop() == listadopais.get(i).getId_ciudad()){
                ciudad_prop.setText(listadopais.get(i).getCiudad());
            }
        }
        codpro.setText(String.valueOf(prop.getCod_postal_prop()));
        telftrabpro.setText(String.valueOf(prop.getTelf_trab_prop()));
        telfpartpro.setText(String.valueOf(prop.getTelf_part_prop()));
        telfmovilpro.setText(String.valueOf(prop.getTelf_movil_prop()));
        numfaxpro.setText(String.valueOf(prop.getNum_fax_prop()));
        emailtrabpro.setText(prop.getEmail_trab_prop());
        emailperspro.setText(prop.getEmail_pers_prop());
    }
    
    @FXML
    public void seleccion_prop(Event event) throws SQLException {
        selprop = (Propietarios)listaprop.getSelectionModel().getSelectedItem();
        
        cargarprop(selprop);
        App.setPropietario(selprop);
        initlist_inmu();
    }
    
    private void cargarinmu(Inmuebles inmu) {
        for(int i = 0; i < listadotipos.size(); i++){
            if(selinmu.getInmueble_tipo_id()== listadotipos.get(i).getId_tipos_inmuebles()){
                tipo_inmu.setText(listadotipos.get(i).getTipos_inmuebles());
            }
        }
        destino_inmu.setText(inmu.getDestino());
        domicilio_imnu.setText(inmu.getDomicilio());
        for(int i = 0; i < listadopais.size(); i++){
            if(selprop.getCiudad_prop() == listadopais.get(i).getId_ciudad()){
                ciudad_inmu.setText(listadopais.get(i).getCiudad());
            }
        }
        codposta_inmu.setText(String.valueOf(inmu.getCod_postal()));
        alias_inmu.setText(inmu.getAlias());
        refcatast_inmu.setText(inmu.getRef_catastral());
        regpropiedad_inmu.setText(inmu.getReg_propiedad());
        tomo_inmu.setText(inmu.getTomo());
        libro_inmu.setText(inmu.getLibro());
        folio_inmu.setText(inmu.getFolio());
        finca_inmu.setText(inmu.getFinca());
        inspeccion_inmu.setText(inmu.getInspeccion());
        porcencomu_inmu.setText(String.valueOf(inmu.getPorcentaje_comu()));
        porcencomugeneral_inmu.setText(String.valueOf(inmu.getPorcentaje_comu_general()));
    }
    
    @FXML
    public void seleccion_inmu(Event event) throws SQLException {
        selinmu = (Inmuebles)lista_inmuebles.getSelectionModel().getSelectedItem();
        cargarinmu(selinmu);
    }
    //Fin de carga y seleccion de datos
    
    //Ventanas emergentes
        //Inmuebles
        @FXML
        public void newInmuebles(ActionEvent event) throws SQLException {
        if(selprop != null){
            try {
                //cargar ventana
                FXMLLoader loader = new FXMLLoader(getClass().getResource("inserciones/new_inmuebles.fxml"));
                //referencia al padre
                Parent root = loader.load();
                //creado del controlador manualmente
                New_inmueblesController controlador = loader.getController();
                //creado de escena y estado
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                controlador.initlist_ciudades();
                controlador.initlist_tipos();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                Logger.getLogger(View_inmueblesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(selprop == null){
            AlertaUtil.mostrarWarning("Seleccione un Propietario");
        }
    }
    
        @FXML
        public void relInmuebles(ActionEvent event) throws SQLException{
        try {
            //cargar ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("relaciones/relacion_inmu_prop.fxml"));
            //referencia al padre
            Parent root = loader.load();
            //creado del controlador manualmente
            Relacion_inmu_propController controlador = loader.getController();
            //creado de escena y estado
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            controlador.initlist_inmu();
            controlador.initlist_prop();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(View_inmueblesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //Fin inmuebles
    
        //Propietarios
        @FXML
        public void newPropietarios(ActionEvent event) throws SQLException {
            try {
                //cargar ventana
                FXMLLoader loader = new FXMLLoader(getClass().getResource("inserciones/new_propietarios.fxml"));
                //referencia al padre
                Parent root = loader.load();
                //creado del controlador manualmente
                New_propietariosController controlador = loader.getController();
                //creado de escena y estado
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                controlador.initlist_ciudades();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                Logger.getLogger(View_inmueblesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Fin Propietarios
    //Fin de ventanas emergentes

}
