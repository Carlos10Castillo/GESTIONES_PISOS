/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.Tipos_inmueblesDAO;
import com.mycompany.models.Tipos_inmuebles;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CARLOS
 */
public class New_tipos_inmueblesController {   
    
    @FXML
    private TextField new_tipo_inmu;
    @FXML
    private Button button_guardar;
    
    private Tipos_inmueblesDAO tempdao_tipos = new Tipos_inmueblesDAO();
    private Tipos_inmuebles temp_tipos = new Tipos_inmuebles();
    private Connection con;
    
    @FXML
    public void guardar_tipo_inmu() throws SQLException{
        temp_tipos= new Tipos_inmuebles();
        tempdao_tipos = new Tipos_inmueblesDAO();

        try {
            con = ConnDAO.conectar();
            temp_tipos = new Tipos_inmuebles(-1, new_tipo_inmu.getText());
            if(new_tipo_inmu.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de nueva region");
            }else{
                tempdao_tipos.insert_regiones(con, temp_tipos);
                AlertaUtil.mostrarInfo("Se ha guardado correctamente");
                Stage stage = (Stage) this.button_guardar.getScene().getWindow();
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
