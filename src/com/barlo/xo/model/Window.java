package com.barlo.xo.model;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //creating a Group object
        Parent root = FXMLLoader.load(getClass().getResource("../view/GUI/XOBarloGUI.fxml"));

        //Creating a Scene by passing the group object, height and width
        Scene scene = new Scene(root ,210, 270);

        //setting color to the scene
        scene.setFill(Color.BROWN);

        //Setting the title to Stage.
        primaryStage.setTitle("XO Game");

        //Adding the scene to Stage
        primaryStage.setScene(scene);

        //Displaying the contents of the stage
        primaryStage.show();
    }

}
