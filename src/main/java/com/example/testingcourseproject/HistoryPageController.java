package com.example.testingcourseproject;

import static com.example.testingcourseproject.Main.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoryPageController implements Initializable {
    public HistoryPageController(){}
    Main m = new Main();
    @FXML
    private TableView<Transaction> tv_log;
    @FXML
    private Button b_back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        long startTime = System.currentTimeMillis();
        TableColumn<Transaction, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Transaction, String> descriptionColumn = new TableColumn<>("Type");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Transaction, Double> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        tv_log.getColumns().clear();

        tv_log.getColumns().addAll(idColumn, descriptionColumn, amountColumn);

        tv_log.getItems().addAll(clients.get(clientIndex).getTransactions());

        long endtime = System.currentTimeMillis();
        long duration = endtime - startTime;
        System.out.println("Time taken to process transaction history page: " + duration + "ms");
    }
    public void goBack() throws IOException {
        m.changeScene("ClientPage.fxml");
    }
}
