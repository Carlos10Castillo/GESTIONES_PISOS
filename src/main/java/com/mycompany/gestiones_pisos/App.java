package com.mycompany.gestiones_pisos;

import com.mycompany.models.Propietarios;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Propietarios prop = new Propietarios();
    
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("panel_control"), 1920,1020);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    static void setPropietario(Propietarios p) {       
        prop = p;
    }
    
    static void loadiniciarlistados() throws IOException, SQLException {
        String fxml = "view_propietarios";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        View_inmueblesController controller = new View_inmueblesController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.initlist_prop();
        controller.initlist_ciudades();
        controller.initlist_inmu();
        controller.initlist_tipos();
    }
    

}