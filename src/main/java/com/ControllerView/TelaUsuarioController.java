package com.ControllerView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TelaUsuarioController {

    @FXML
    public void pesquisaButtonClicked(ActionEvent actionEvent) {
        Main.switchScene("PesquisaLivro.fxml", "Tela do Usuário");
    }

    @FXML
    public void renovacaoButtonClicked(ActionEvent actionEvent) {
        Main.switchScene("RenovaLivro.fxml", "Tela do Pesquisa de Livro");
    }
}
