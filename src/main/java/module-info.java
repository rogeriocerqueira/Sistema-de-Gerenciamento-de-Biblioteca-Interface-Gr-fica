module com.example.sistema_de_gerenciamento_de_biblioteca {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ControllerView to javafx.fxml;
    exports com.ControllerView;
}