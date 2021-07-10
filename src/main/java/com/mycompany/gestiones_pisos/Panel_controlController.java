/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestiones_pisos;

import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;


/**
 * FXML Controller class
 *
 * @author CARLOS
 */
public class Panel_controlController{

    @FXML
    private void propietarios() throws IOException, SQLException{
        App.loadiniciarlistados();
    }
}
