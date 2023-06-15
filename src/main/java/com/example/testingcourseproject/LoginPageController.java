package com.example.testingcourseproject;

import static com.example.testingcourseproject.Main.*;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class LoginPageController {
    public LoginPageController(){}
    Main m = new Main();
    @FXML
    private Button b_login;

    @FXML
    private Label l_errorMessage;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;

    public boolean isEmpty(){
        return tf_password.getText().isEmpty() || tf_username.getText().isEmpty();
    }
    public int searchInClients(){
        for(int i = 0; i < clients.size(); i++){
            if (clients.get(i).getAccount().getUsername().equals(tf_username.getText())
                    &&
                clients.get(i).getAccount().getPassword().equals(tf_password.getText()))
            {
                return i;
            }
        }
        return -1;
    }
    public int searchInAdmins(){
        for(int i = 0; i < admins.size(); i++){
            if(admins.get(i).getAccount().getUsername().equals(tf_username.getText())
                    &&
               admins.get(i).getAccount().getPassword().equals(tf_password.getText()))
            {
                return i;
            }
        }
        return -1;
    }
    public void login() throws IOException {
        long startTime = System.currentTimeMillis();
        l_errorMessage.setTextFill(Color.DARKRED);
        if (isEmpty()){
            l_errorMessage.setText("Please fill in the blanks");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process login: " + duration + "ms");
            return;
        }

        clientIndex = searchInClients();

        if (clientIndex != -1){
            m.changeScene("ClientPage.fxml");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process login: " + duration + "ms");
            return;
        }

        adminIndex = searchInAdmins();

        if (adminIndex != -1){
            m.changeScene("AdminPage.fxml");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process login: " + duration + "ms");
            return;
        }

        l_errorMessage.setText("Incorrect username or password");

        long endtime = System.currentTimeMillis();
        long duration = endtime - startTime;
        System.out.println("Time taken to process login: " + duration + "ms");
    }
}
