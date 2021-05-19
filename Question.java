package com.codecademy.unqoute;

class Question {


    int correctAnswer, playerAnswer, imageId;
    public String questionText;
    public String answer0;
    public String answer1;
    public String answer2;
    public String answer3;

    public Question(int imageId, String questionText, String answer0, String answer1, String answer2, String answer3, int correctAnswer) {
        this.imageId = imageId;
        this.questionText = questionText;
        this.answer0 = answer0;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
        playerAnswer = -1;
    }

    public boolean isCorrect() {
        return correctAnswer == playerAnswer;
    }


}
