package com.example.testingcourseproject;

import static com.example.testingcourseproject.Main.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class PayBillController implements Initializable {
    public PayBillController(){}
    Main m = new Main();
    @FXML
    private Button b_back;

    @FXML
    private Button b_pay;

    @FXML
    private ComboBox<String> cb_type;

    @FXML
    private Label l_message;

    @FXML
    private TextField tf_amount;

    @FXML
    private TextField tf_other;
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
        return tf_amount.getText().isEmpty() || cb_type.getSelectionModel().isEmpty();
    }
    public void enableOther(){
        if(!cb_type.getSelectionModel().isEmpty()) {
            if (cb_type.getSelectionModel().getSelectedItem().equals("Other")) {
                tf_other.setDisable(false);
            } else {
                tf_other.setDisable(true);
                tf_other.clear();
            }
        }
    }
    public void pay(){
        l_message.setAlignment(Pos.CENTER);

        long startTime = System.currentTimeMillis();
        if(isEmpty()){
            l_message.setTextFill(Color.DARKRED);
            l_message.setText("Please fill the blanks.");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process payment: " + duration + "ms");
            return;
        }

        double balance = clients.get(clientIndex).getBalance();
        double amount = Double.parseDouble(tf_amount.getText());

        if (balance < amount){
            l_message.setTextFill(Color.DARKRED);
            l_message.setText("Insufficient balance, your current balance is: $" + balance);

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process payment: " + duration + "ms");
            return;
        }
        if (amount <= 0){
            l_message.setTextFill(Color.DARKRED);
            l_message.setText("Please insert an amount more than 0");

            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            System.out.println("Time taken to process payment: " + duration + "ms");
            return;
        }
        balance -= amount;
        clients.get(clientIndex).setBalance(balance);

        if (tf_other.isDisable()){
            clients.get(clientIndex).addTransaction(cb_type.getSelectionModel().getSelectedItem(), -amount);
        } else {
            clients.get(clientIndex).addTransaction(tf_other.getText(), -amount);
        }

        l_message.setTextFill(Color.GREEN);
        l_message.setText("Payment successful, your new balance is: $" + balance);
        tf_other.clear(); tf_other.setDisable(true);
        tf_amount.clear(); cb_type.getSelectionModel().clearSelection();

        long endtime = System.currentTimeMillis();
        long duration = endtime - startTime;
        System.out.println("Time taken to process payment: " + duration + "ms");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cb_type.getItems().removeAll(cb_type.getItems());
        cb_type.getItems().addAll("Water", "Electricity", "Gas", "Other");
    }
}
