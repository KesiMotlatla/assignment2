package com.example.lesothotriviagame;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Objects;

public class GameManager {
    private final Stage primaryStage;
    private final Question[] questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    public GameManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.questions = new Question[]{
                new Question("What is the capital city of Lesotho?", "Maseru", new String[]{"Maseru", "Leribe", "Mafeteng", "Thaba-Tseka"}, "maseru.jpeg"),
                new Question("Which mountain range dominates Lesotho's landscape?", "Drakensberg", new String[]{"Andes", "Himalayas", "Drakensberg", "Rockies"}, "Drakensberg.jpeg"),
                new Question("What is the traditional attire worn by Basotho people?", "Sotho blanket", new String[]{"Kimono", "Sari", "Dashiki", "Sotho blanket"}, "Sotho blanket.png"),
                new Question("Which river forms part of Lesotho's border with South Africa?", "Orange", new String[]{"Nile", "Zambezi", "Orange", "Limpopo"}, "orange.jpeg"),
                new Question("What is the nickname given to Lesotho?", "Mountain Kingdom", new String[]{"Mountain Kingdom", "Land of the Rising Sun", "Pearl of Africa", "Emerald Isle"}, "Mountain Kingdom.jpeg")
        };
    }

    public void startGame() {
        primaryStage.setTitle("Lesotho Trivia Game");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);


        QuestionPane questionPane = new QuestionPane(questions[currentQuestionIndex], this);
        GridPane.setConstraints(questionPane, 0, 0);
        grid.getChildren().add(questionPane);
        grid.setStyle("-fx-background-color: #007bff;");

        String cssFile = Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm();


        Scene scene = new Scene(grid, 600, 400);
        scene.getStylesheets().add(cssFile);




        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void nextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            primaryStage.getScene().setRoot(new QuestionPane(questions[currentQuestionIndex], this));
        } else {
            endGame();
        }
    }

    public void updateScore(boolean isCorrect) {
        if (isCorrect) {
            score++;
        }
    }

    private void endGame() {
        primaryStage.getScene().setRoot(new EndGamePane(score, questions.length));
    }
}