package com.ControllerView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.ControllerView.Main;
import com.ControllerView.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PesquisaLivroController {

    @FXML
    public void pesquisaButtonClicked(ActionEvent actionEvent) {
        Main.switchScene("PesquisaLivro.fxml", "Tela de Opção Para Usuários");
    }

    @FXML
    public void renovacaoButtonClicked(ActionEvent actionEvent) {
        Main.switchScene("RenovaLivro.fxml", "Tela do Pesquisa de Livro");
    }

    @FXML
    public void ResultadoPesquisaButtonClicked(ActionEvent actionEvent) {
        Main.switchScene("ListadePesquisa.fxml", "Tela do Pesquisa de Livro");
    }


    public void addLivroButtonClicked(ActionEvent actionEvent) {
        Main.switchScene("TelaUsuario.fxml", "Registro de Livro");
    }

    public void SituacaoCadastralButtonClicked(ActionEvent actionEvent) {
        Main.switchScene("SituacaoCadastral.fxml", "Status de Empréstimo");
    }




}

