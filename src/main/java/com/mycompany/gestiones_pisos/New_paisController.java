/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.PaisesDAO;
import com.mycompany.models.Paises;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CARLOS
 */
public class New_paisController{

    @FXML
    private TextField newfieldpais;
    @FXML
    private Button guardar;
    private PaisesDAO tempdao;
    private Paises temp;
    private Connection conn;
    
    @FXML
    public void guardado (ActionEvent event) throws SQLException{
        tempdao = new PaisesDAO();
        temp = new Paises();
        try {
            conn = ConnDAO.conectar();
            temp = new Paises(-1, newfieldpais.getText());
            if(newfieldpais.getText().isBlank()){
                AlertaUtil.mostrarError("Rellene el campo de ciudad");
            }else{
                tempdao.insert_paises(conn, temp);
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
            ConnDAO.desconexion(conn);
        }
    }
}
