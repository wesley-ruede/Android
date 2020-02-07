package com.wesleyruede.myapplication;
// this class exists so Question[] can get its respective bool response
// which is validated through checkAnswer() in MainActivity and
// displays a Toast in response to the True and False Buttons
public class Question {

    private int answerResId;
    private boolean answerTrue;

    // given index in array of questions and bool response
    public Question(int answerResId, boolean answerTrue) {
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

}
