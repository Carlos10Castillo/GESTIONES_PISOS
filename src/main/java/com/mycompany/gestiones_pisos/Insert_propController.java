/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.PropietariosDAO;
import com.mycompany.models.Propietarios;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author CARLOS
 */
public class Insert_propController  {

    @FXML
    private TextField nompro;
    @FXML
    private TextField apepro;
    @FXML
    private TextField cifpro;
    @FXML
    private TextField dompro;
    @FXML
    private TextField ciupro;
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
    
    private static PropietariosDAO prop;
    private static Connection con;
    
    @FXML
    public void insertar() throws SQLException{
        prop = new PropietariosDAO();
        Propietarios proptemp = new Propietarios();
        
        try {
            con = ConnDAO.conectar();
            proptemp = new Propietarios(-1, nompro.getText(), apepro.getText(), cifpro.getText(),
                    dompro.getText(), ciupro.getText(), Integer.parseInt(codpro.getText()),
                    Integer.parseInt(telftrabpro.getText()), Integer.parseInt(telfpartpro.getText()),
                    Integer.parseInt(telfmovilpro.getText()), Integer.parseInt(numfaxpro.getText()),
                    emailtrabpro.getText(), emailperspro.getText());
            prop.insertar(proptemp, con);
            nompro.clear();apepro.clear();
            cifpro.clear();
            dompro.clear();
            ciupro.clear();
            codpro.clear();
            telftrabpro.clear();
            telfpartpro.clear();
            telfmovilpro.clear();
            numfaxpro.clear();
            emailtrabpro.clear();
            emailperspro.clear();
            AlertaUtil.mostrarInfo("Propietario ingresado");
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("1. Fallo en la insercion del propietario\n" + ex.getMessage());
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("2. Fallo en la insercion del propietario\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("3. Fallo en la insercion del propietario\n" + ex.getMessage());
        }finally{
            ConnDAO.desconexion(con);
        }
    }
    
    

}
