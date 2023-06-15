package com.example.testingcourseproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import static com.example.testingcourseproject.Main.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class TransferPageController {
    public TransferPageController(){}
    Main m = new Main();
    @FXML
    private Button b_back;

    @FXML
    private Button b_transfer;

    @FXML
    private Label l_message;

    @FXML
    private TextField tf_amount;

    @FXML
    private TextField tf_username;

    public void keyPressed(KeyEvent ke) {
        AtomicBoolean hasPoint = new AtomicBoolean(false);
        tf_amount.addEventFilter(KeyEvent.KEY_TYPED, event -> {
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
    public void goBack() throws IOException {
        m.changeScene("ClientPage.fxml");
    }
    public boolean isEmpty(){
        return tf_amount.getText().isEmpty() || tf_username.getText().isEmpty();
    }
    public void transfer(){
        long startTime = System.currentTimeMillis();
        l_message.setAlignment(Pos.CENTER);
        if (isEmpty()){
            l_message.setTextFill(Color.DARKRED);
            l_message.setText("Please fill the blanks");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process transfer: " + duration + "ms");
            return;
        }

        double amount = Double.parseDouble(tf_amount.getText());
        double balance = clients.get(clientIndex).getBalance();
        String username = tf_username.getText();

        if (balance < amount){
            l_message.setTextFill(Color.DARKRED);
            l_message.setText("Insufficient balance, your current balance is: $" + balance);

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process transfer: " + duration + "ms");
            return;
        }
        if (amount <= 0){
            l_message.setTextFill(Color.DARKRED);
            l_message.setText("Please insert an amount more than 0");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process transfer: " + duration + "ms");
            return;
        }
        for(Client client:clients){
            if (client.getAccount().getUsername().equals(username)){
                balance -= amount;
                clients.get(clientIndex).setBalance(balance);

                double balanceOther = client.getBalance();
                balanceOther += amount;
                client.setBalance(balanceOther);

                clients.get(clientIndex).addTransaction("Transfer to: " + client.getName(), -amount);
                client.addTransaction("Received from: " + clients.get(clientIndex).getName(), amount);

                l_message.setTextFill(Color.GREEN);
                l_message.setText("Transfer successful, your new balance is: $" + balance);

                long endtime = System.currentTimeMillis();
                long duration = endtime - startTime;
                System.out.println("Time taken to process transfer: " + duration + "ms");
                return;
            }
        }

        l_message.setTextFill(Color.DARKRED);
        l_message.setText("Username does not exist.");

        long endtime = System.currentTimeMillis();
        long duration = endtime - startTime;
        System.out.println("Time taken to process transfer: " + duration + "ms");
    }
}
