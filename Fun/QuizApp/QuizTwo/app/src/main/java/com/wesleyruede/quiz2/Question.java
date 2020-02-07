package com.wesleyruede.quiz2;

// A Model of a question for people to choose true or
// false, the Controller will confirm the correct response
// and display a message to the screen as a View

public class Question {
    private int answerResId;
    private boolean answerTrue;

    public Question(int questionIndex, boolean answerIsTrue) {
        this.answerResId = questionIndex;
        this.answerTrue = answerIsTrue;
    }

    // we need to get the resource index
    public int getAnswerResId() {
        return answerResId;
    }

    // check if the bool parameter is true or false
    public boolean isAnswerTrue() {
        return answerTrue;
    }
}