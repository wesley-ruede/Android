package com.wesleyruede.trivia.model;

// Get the string and bool in the json array and determine if the response
// is correct or incorrect. Assist with the construction of a List of these
// Questions by iterating through the json api and add all elements into a
// response which is prepared to be shown in activity_main.xml through calling

public class Question {
    private String answer;
    private Boolean answerTrue;

    public Question() {

    }
    // a Json String and Boolean " " / (true/false)
    public Question(String answer, Boolean answerTrue) {
        this.answer = answer;
        this.answerTrue = answerTrue;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setAnswerTrue(Boolean answerTrue) {
        this.answerTrue = answerTrue;
    }

    // set each Question to a String  and boolean instead of a memory
    // address when the json url (array of arrays) is stepped through

    @Override
    public String toString() {
        return "Question{" +
                "answer='" + answer + '\'' +
                ", answerTrue=" + answerTrue +
                '}';
    }
}


