package com.ControllerView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistroLivroController {

    @FXML
    private TextField tituloTextField;

    @FXML
    private TextField autorTextField;

    @FXML
    private TextField editoraTextField;

    @FXML
    private TextField isbnTextField;

    @FXML
    private TextField categoriaTextField;

    @FXML
    private Button registrarButton;

    @FXML
    public void initialize() {
        registrarButton.setOnAction(event -> {
            // Verifica se todos os campos estão preenchidos antes de exibir o popup
            if (!tituloTextField.getText().isEmpty() && !autorTextField.getText().isEmpty() &&
                    !editoraTextField.getText().isEmpty() && !isbnTextField.getText().isEmpty() &&
                    !categoriaTextField.getText().isEmpty()) {
                exibirPopup("Livro cadastrado com sucesso!");
            } else {
                exibirPopup("Por favor, preencha todos os campos.");
            }
        });
    }

    public void exibirPopup(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Livro cadastrado com Sucesso!");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }


}
