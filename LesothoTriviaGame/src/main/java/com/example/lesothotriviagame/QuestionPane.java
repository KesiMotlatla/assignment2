package com.example.lesothotriviagame;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class QuestionPane extends GridPane {
    public QuestionPane(Question question, GameManager gameManager) {
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);

        VBox questionBox = new VBox();
        questionBox.setStyle("-fx-background-color: #007bff;");
        questionBox.getChildren().addAll(new javafx.scene.control.Label(question.getQuestion()));

        ToggleGroup optionsGroup = new ToggleGroup();

        VBox optionsBox = new VBox(5);
        optionsBox.setStyle("-fx-background-color: #007bff;");
        for (String option : question.getOptions()) {
            RadioButton radioButton = new RadioButton(option);
            radioButton.setToggleGroup(optionsGroup);
            optionsBox.getChildren().add(radioButton);
        }

        optionsGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton selectedRadioButton = (RadioButton) newValue;
            if (selectedRadioButton != null) {
                gameManager.updateScore(selectedRadioButton.getText().equals(question.getCorrectAnswer()));
            }
        });

        ImageView imageView = new ImageView(new Image(question.getImagePath()));
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        Button nextButton = new Button("Next Question");
        nextButton.setOnAction(e -> gameManager.nextQuestion());

        add(questionBox, 0, 0);
        add(optionsBox, 0, 1);
        add(imageView, 1, 0, 1, 2);
        add(nextButton, 0, 2);
    }
}

