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
public class Mod_propietariosController {

    @FXML
    private TextField mod_nompro;
    @FXML
    private TextField mod_apepro;
    @FXML
    private TextField mod_cifpro;
    @FXML
    private TextField mod_dompro;
    @FXML
    private TextField mod_codpro;
    @FXML
    private TextField mod_telftrabpro;
    @FXML
    private TextField mod_telfpartpro;
    @FXML
    private TextField mod_telfmovilpro;
    @FXML
    private TextField mod_numfaxpro;
    @FXML
    private TextField mod_emailtrabpro;
    @FXML
    private TextField mod_emailperspro;
    @FXML
    private Button mod_guardar_prop;
    @FXML
    private ComboBox mod_list_ciudades;

    private Connection con;
    private CiudadesDAO tempdao_ciudades;
    private Ciudades temp_ciudad_id = new Ciudades();
    private Propietarios temp_prop;
    private PropietariosDAO tempdao_prop;
    ObservableList<Ciudades> listadopais;

    public void initlist_ciudades() throws SQLException {
        tempdao_ciudades = new CiudadesDAO();
        try {
            con = ConnDAO.conectar();
            listadopais = FXCollections.observableArrayList(tempdao_ciudades.listado_ciudades(con));
            mod_list_ciudades.setItems(listadopais);
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
    private void seleccion_ciudad(ActionEvent event) {
        temp_ciudad_id = (Ciudades) mod_list_ciudades.getSelectionModel().getSelectedItem();
    }

    public void cargarprop(Propietarios prop) {
        mod_nompro.setText(prop.getNombre_prop());
        mod_apepro.setText(prop.getApellidos_prop());
        mod_cifpro.setText(prop.getCif_prop());
        mod_dompro.setText(prop.getDomicilio_prop());
        for (int i = 0; i < listadopais.size(); i++) {
            if (prop.getCiudad_prop() == listadopais.get(i).getId_ciudad()) {
                mod_list_ciudades.setValue(listadopais.get(i));
            }
        }
        mod_codpro.setText(String.valueOf(prop.getCod_postal_prop()));
        mod_telftrabpro.setText(String.valueOf(prop.getTelf_trab_prop()));
        mod_telfpartpro.setText(String.valueOf(prop.getTelf_part_prop()));
        mod_telfmovilpro.setText(String.valueOf(prop.getTelf_movil_prop()));
        mod_numfaxpro.setText(String.valueOf(prop.getNum_fax_prop()));
        mod_emailtrabpro.setText(prop.getEmail_trab_prop());
        mod_emailperspro.setText(prop.getEmail_pers_prop());
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

    @FXML
    private void modificar(ActionEvent event) {
        tempdao_prop = new PropietariosDAO();
        temp_prop = new Propietarios();
        int temp_mod_telftrabpro = 0;
        int temp_mod_telfpartpro = 0;
        int temp_mod_numfaxpro = 0;
        int temp_mod_ciudad = 0;
        String temp_mod_emailtrabpro = "";
        String temp_mod_emailperspro = "";
        Boolean a = true;
        Boolean b = true;
        Boolean c = true;
        Boolean d = true;
        Boolean f = true;
        Boolean g = true;


        try {
            con = ConnDAO.conectar();

            if (mod_nompro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de nombre");
                a = false;
            } else if (mod_apepro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de apellidos");
                b = false;
            } else if (mod_cifpro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de cif");
                c = false;
            } else if (mod_dompro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de domicilio");
                d = false;
            } else if (mod_codpro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de codigo postal");
                f = false;
            } else if (mod_telfmovilpro.getText().isBlank()) {
                AlertaUtil.mostrarError("Rellene el campo de telefono movil");
                g = false;
            } else if (mod_telftrabpro.getText().isBlank()) {
                temp_mod_telftrabpro = 0;
            } else if (mod_telfpartpro.getText().isBlank()) {
                temp_mod_telfpartpro = 0;
            } else if (mod_numfaxpro.getText().isBlank()) {
                temp_mod_numfaxpro = 0;
            } else if (mod_emailtrabpro.getText().isBlank()) {
                temp_mod_emailtrabpro = "null";
            } else if (mod_emailperspro.getText().isBlank()) {
                temp_mod_emailperspro = "null";
            } else if (temp_ciudad_id.getId_ciudad() <= 0) {
                temp_mod_ciudad = App.prop.getCiudad_prop();
            } else {
                temp_mod_telftrabpro = Integer.parseInt(mod_telftrabpro.getText());
                temp_mod_telfpartpro = Integer.parseInt(mod_telfpartpro.getText());
                temp_mod_numfaxpro = Integer.parseInt(mod_numfaxpro.getText());
                temp_mod_ciudad = temp_ciudad_id.getId_ciudad();
                temp_mod_emailtrabpro = mod_emailtrabpro.getText();
                temp_mod_emailperspro = mod_emailperspro.getText();
            }
            if (a == true && b == true && c == true && d == true && f == true && g == true) {
                temp_prop = new Propietarios(-1, mod_nompro.getText(), mod_apepro.getText(), mod_cifpro.getText(), mod_dompro.getText(),
                        temp_mod_ciudad, Integer.parseInt(mod_codpro.getText()), temp_mod_telftrabpro,
                        temp_mod_telfpartpro, Integer.parseInt(mod_telfmovilpro.getText()),
                        temp_mod_numfaxpro, temp_mod_emailtrabpro, temp_mod_emailperspro);
                tempdao_prop.modificar(temp_prop, con);
                AlertaUtil.mostrarInfo("Propietarios modificado");
                Stage stage = (Stage) this.mod_guardar_prop.getScene().getWindow();
                stage.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Mod_propietariosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mod_propietariosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Mod_propietariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
