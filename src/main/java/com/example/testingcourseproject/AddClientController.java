package com.example.testingcourseproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.example.testingcourseproject.Main.*;
public class AddClientController {
    public AddClientController(){}
    Main m = new Main();
    @FXML
    private Button b_create;

    @FXML
    private Button b_goBack;

    @FXML
    private TextField tf_address;

    @FXML
    private TextField tf_balance;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_number;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;
    @FXML
    private Label l_errorMessage;

    public void goBack() throws IOException {
        m.changeScene("AdminPage.fxml");
    }
    public void keyPressedName(KeyEvent ke) {
        tf_name.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String character = event.getCharacter();
            if (!character.matches("[a-zA-Z]| ?")) {
                event.consume();
            }
        });
    }
    public void keyPressed(KeyEvent ke) {
        AtomicBoolean hasPoint = new AtomicBoolean(false);
        tf_balance.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String input = event.getCharacter();
            if (input.equals(".")){
                if (!hasPoint.get()) {
                    hasPoint.set(true);
                } else {
                    event.consume();
                }
                return;
            }
            if (!input.matches("[0-9]*")) {
                event.consume();
            }
        });
    }
    public void keyPressedID(KeyEvent ke){
        tf_id.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String input = event.getCharacter();
            if (!input.matches("[0-9]*")) {
                event.consume();
            }
        });
    }
    public void keyPressedNumber(KeyEvent ke){
        tf_number.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String character = event.getCharacter();
            if (!character.matches("[0-9]")) {
                event.consume();
            }
        });
    }
    public boolean isEmpty() {
        return tf_address.getText().isEmpty() || tf_balance.getText().isEmpty() ||
                tf_email.getText().isEmpty() || tf_id.getText().isEmpty() ||
                tf_name.getText().isEmpty() || tf_number.getText().isEmpty() ||
                tf_password.getText().isEmpty() || tf_username.getText().isEmpty();
    }
    public boolean doesUsernameExist(String username){
        for(Client client:clients){
            if (client.getAccount().getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    public boolean doesIDExist(String id){
        for(Client client:clients){
            if (client.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    public boolean isIDValid(){
        return tf_id.getText().length() == 14;
    }
    public boolean isNumberValid(){
        String number = tf_number.getText();
        if (number.length() != 11) return false;
        if (number.charAt(0) != '0') return false;
        if (number.charAt(1) != '1') return false;
        return number.charAt(2) == '0' ||
                number.charAt(2) == '1' ||
                number.charAt(2) == '2' ||
                number.charAt(2) == '5';
    }
    public boolean isPasswordStrong(){
        return tf_password.getText().length() >= 8;
    }
    public boolean doesEmailExist(String email){
        for(Client client:clients){
            if (client.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    public void createClient(){
        long startTime = System.currentTimeMillis();
        l_errorMessage.setAlignment(Pos.CENTER);
        l_errorMessage.setTextFill(Color.DARKRED);
        if (isEmpty()){
            l_errorMessage.setText("Please fill the blanks.");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process adding client: " + duration + "ms");
            return;
        }
        if (doesUsernameExist(tf_username.getText())){
            l_errorMessage.setText("Username already exists.");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process adding client: " + duration + "ms");
            return;
        }
        if (doesIDExist(tf_id.getText())){
            l_errorMessage.setText("ID already exists.");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process adding client: " + duration + "ms");
            return;
        }
        if (doesEmailExist(tf_email.getText())){
            l_errorMessage.setText("Email already exists.");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process adding client: " + duration + "ms");
            return;
        }
        if(!isIDValid()){
            l_errorMessage.setText("Invalid ID.");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process adding client: " + duration + "ms");
            return;
        }
        if(!isNumberValid()){
            l_errorMessage.setText("Invalid phone number.");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process adding client: " + duration + "ms");
            return;
        }
        if(!isPasswordStrong()){
            l_errorMessage.setText("Password should be atleast 8 characters long.");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process adding client: " + duration + "ms");
            return;
        }

        double balance = Double.parseDouble(tf_balance.getText());

        clients.add(new Client(tf_id.getText(), tf_name.getText(), tf_address.getText(),
                               tf_number.getText(), tf_email.getText(), balance,
                               tf_username.getText(), tf_password.getText()));

        l_errorMessage.setTextFill(Color.GREEN);
        l_errorMessage.setText("Client's account successfully created!");

        tf_balance.clear(); tf_username.clear(); tf_number.clear(); tf_name.clear();
        tf_id.clear(); tf_password.clear(); tf_email.clear(); tf_address.clear();

        long endtime = System.currentTimeMillis();
        long duration = endtime - startTime;
        System.out.println("Time taken to process adding client: " + duration + "ms");
    }
}
