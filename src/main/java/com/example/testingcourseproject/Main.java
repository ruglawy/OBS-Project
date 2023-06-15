package com.example.testingcourseproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main extends Application {
    protected static List<Client> clients = new ArrayList<>();
    protected static List<Admin> admins = new ArrayList<>();
    protected static List<String> usernamesUsed = new ArrayList<>();
    protected static int clientIndex = -1;
    protected static int adminIndex = -1;
    private static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {
        long starttime = System.currentTimeMillis();
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 760, 430);
        stage.setTitle("Online Banking System");
        stage.setScene(scene);
        stage.show();
        long endtime = System.currentTimeMillis();
        long duration = endtime - starttime;
        System.out.println("Time taken to start the application: " + duration + "ms");
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {

        clients.add(new Client("303030", "Kareem", "Addrr",
                "010044887766", "ok@ok.com",
                1599.99, "kareem", "kareem2002"));
        clients.add(new Client("4332", "Medhat", "Adddd",
                "0187673824", "no@no.com",
                0, "medhat", "medhat2002"));
        admins.add(new Admin("88639", "admin", "pass2002"));
        usernamesUsed.add("kareem"); usernamesUsed.add("admin"); usernamesUsed.add("medhat");

        launch();
    }
}