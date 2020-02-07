package com.wesleyruede.trivia.model;

// take the answer whether true or false
// and be able to find out if the string
// is set to true or false

public class Question {
    private String answer;
    private Boolean answerTrue;

    public Question() {

    }
    // a xml string (R.string) and a literal Bool (true)
    public Question(String answer, Boolean answerTrue) {
        this.answer = answer;
        this.answerTrue = answerTrue;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean getAnswerTrue() {
        return answerTrue;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setAnswerTrue(Boolean answerTrue) {
        this.answerTrue = answerTrue;
    }

    // set each Question to a string instead
    // of a memory address when the json url
    // 2-d array is iterated through

    @Override
    public String toString() {
        return "Question{" +
                "answer='" + answer + '\'' +
                ", answerTrue=" + answerTrue +
                '}';
    }
}


