package com.ControllerView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;
import com.ControllerView.TelaInicialController;
import java.io.IOException;

public class Main extends Application  {
    private static Stage primaryStage;

        @Override
        public void start(Stage primaryStage) throws IOException {
            Main.primaryStage = primaryStage;
            switchScene("TelaInicial.fxml", "Tela Inicial");


        }

        public static void switchScene(String fxml, String title){
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setTitle(title);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            launch();
        }
    }
