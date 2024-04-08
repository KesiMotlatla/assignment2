package com.example.lesothotriviagame;

public class Question {
    private final String question;
    private final String correctAnswer;
    private final String[] options;
    private final String imagePath;

    public Question(String question, String correctAnswer, String[] options, String imagePath) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.options = options;
        this.imagePath = imagePath;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getImagePath() {
        return imagePath;
    }
}