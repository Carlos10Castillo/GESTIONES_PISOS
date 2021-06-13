module com.mycompany.gestiones_pisos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;


    opens com.mycompany.gestiones_pisos to javafx.fxml;
    exports com.mycompany.gestiones_pisos;
}
