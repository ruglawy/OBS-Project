package com.example.testingcourseproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

import static com.example.testingcourseproject.Main.*;
public class DeleteClientController {
    public DeleteClientController(){}
    Main m = new Main();
    @FXML
    private Button b_delete;

    @FXML
    private Button b_goback;
    @FXML
    private Label l_message;

    @FXML
    private TextField tf_username;
    public boolean isEmpty(){
        return tf_username.getText().isEmpty();
    }
    public void goBack() throws IOException {
        m.changeScene("AdminPage.fxml");
    }
    public void delete(){
        long startTime = System.currentTimeMillis();
        l_message.setAlignment(Pos.CENTER);
        if(isEmpty()){
            l_message.setTextFill(Color.DARKRED);
            l_message.setText("Insert a username.");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process client deletion: " + duration + "ms");
            return;
        }

        for (int i = 0; i < clients.size(); i++){
            if(clients.get(i).getAccount().getUsername().equals(tf_username.getText())){
                clients.remove(i);
                l_message.setTextFill(Color.GREEN);
                l_message.setText("Client successfully deleted.");

                long endtime = System.currentTimeMillis();
                long duration = endtime - startTime;
                System.out.println("Time taken to process client deletion: " + duration + "ms");
                return;
            }
        }
        l_message.setTextFill(Color.DARKRED);
        l_message.setText("Username does not exist.");

        long endtime = System.currentTimeMillis();
        long duration = endtime - startTime;
        System.out.println("Time taken to process client deletion: " + duration + "ms");
    }
}
