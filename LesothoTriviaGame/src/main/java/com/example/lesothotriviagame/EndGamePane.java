package com.example.lesothotriviagame;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EndGamePane extends GridPane {
    public EndGamePane(int score, int totalQuestions) {
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);

        Label endGameLabel = new Label("Game Over");
        Label scoreLabel = new Label("Your score: " + score + " out of " + totalQuestions);

        add(endGameLabel, 0, 0);
        add(scoreLabel, 0, 1);
    }
}
