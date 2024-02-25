package com.ControllerView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.ControllerView.Main;

public class TelaInicialController {

    @FXML
    public void usuarioButtonClicked(ActionEvent actionEvent) {
        Main.switchScene("TelaUsuario.fxml", "Tela do Geral de Usuário");
    }

    @FXML
    public void administradorButtonClicked(ActionEvent actionEvent) {
        Main.switchScene("Login.fxml", "Tela do Administrador");
    }

}
