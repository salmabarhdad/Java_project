package com.example.projet_chatapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView {

    @FXML
    private Label username_label;
    @FXML
    private TextField password_log;
    @FXML
    private TextField username_log;




    @FXML
    public void onLoginButtonClick() throws IOException {
        if(username_log.getText().equals("admin") && password_log.getText().equals("admin"))
        {
            Stage s = (Stage) username_label.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("appview.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            s.setScene(scene);
        }


    }
}
