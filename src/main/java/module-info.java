module com.mycompany.gestiones_pisos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.gestiones_pisos to javafx.fxml;
    exports com.mycompany.gestiones_pisos;
}
