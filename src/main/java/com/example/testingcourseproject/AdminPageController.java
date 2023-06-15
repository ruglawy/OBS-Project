package com.example.testingcourseproject;
import static com.example.testingcourseproject.Main.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminPageController {
    public AdminPageController(){}
    Main m = new Main();
    @FXML
    private Button b_createAccount;

    @FXML
    private Button b_deleteAccount;

    @FXML
    private Button b_logout;

    public void logout() throws IOException {
        m.changeScene("LoginPage.fxml");
    }
    public void createClient() throws IOException {
        m.changeScene("AddClientPage.fxml");
    }
    public void deleteClient() throws IOException {
        m.changeScene("DeleteClientPage.fxml");
    }
}
