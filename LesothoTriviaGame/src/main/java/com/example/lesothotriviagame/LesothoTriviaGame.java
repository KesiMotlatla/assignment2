package com.example.lesothotriviagame;

import javafx.application.Application;
import javafx.stage.Stage;

public class LesothoTriviaGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameManager gameManager = new GameManager(primaryStage);
        gameManager.startGame();

    }

    public static void main(String[] args) {
        launch(args);
    }
}