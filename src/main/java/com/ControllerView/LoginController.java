package com.ControllerView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import com.ControllerView.TelaDestinoController;
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text errorText;

    @FXML
    public void loginButtonClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Aqui você pode adicionar a lógica de autenticação
        // Este é um exemplo simples
        if (username.equals("admin") && password.equals("admin")) {

            try {
                // Carregar a tela de destino
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaDestino.fxml"));
                Parent root = loader.load();

                // Obter o controlador da tela de destino
                TelaDestinoController controller = loader.getController();

                // Passar dados para o controlador da tela de destino, se necessário

                // Configurar a cena com a tela de destino
                Scene scene = new Scene(root);

                // Obter o palco atual
                Stage stage = (Stage) usernameField.getScene().getWindow();

                // Configurar a cena no palco
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Se o login falhar, exiba uma mensagem de erro
            errorText.setText("Usuário ou senha incorretos");
        }

    }

    @FXML
    public void gerenciadorButtonClicked(ActionEvent actionEvent) {
        Main.switchScene("AdministradoreBibliotecario.fxml", "Tela do Administrador");
    }

}
