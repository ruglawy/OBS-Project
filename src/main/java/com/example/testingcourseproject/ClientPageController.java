package com.example.testingcourseproject;

import static com.example.testingcourseproject.Main.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientPageController implements Initializable {
    public ClientPageController(){}
    Main m = new Main();
    @FXML
    private Button b_logout;

    @FXML
    private Button b_payBill;

    @FXML
    private Button b_showLog;

    @FXML
    private Button b_transfer;

    @FXML
    private Label l_welcome;
    @FXML
    private Label l_balance;

    public void logout() throws IOException {
        m.changeScene("LoginPage.fxml");
    }
    public void payBill() throws IOException {
        m.changeScene("PayBillPage.fxml");
    }
    public void transfer() throws IOException {
        m.changeScene("TransferPage.fxml");
    }
    public void showLog() throws IOException {
        m.changeScene("HistoryPage.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l_welcome.setAlignment(Pos.CENTER); l_balance.setAlignment(Pos.CENTER);
        l_welcome.setText("Welcome back, " + clients.get(clientIndex).getName());
        l_balance.setText("Current balance: $" + clients.get(clientIndex).getBalance());
    }
}
