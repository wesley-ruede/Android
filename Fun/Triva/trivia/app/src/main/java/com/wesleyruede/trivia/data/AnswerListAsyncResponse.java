package com.wesleyruede.trivia.data;
import com.wesleyruede.trivia.model.Question;
import java.util.ArrayList;

// the internet is built on Asynchronous computing
// and this interface enables the MainActivity to get
// a json response in the form of an ArrayList
// while handling null responses to the queue

public interface AnswerListAsyncResponse {
    void processFinished(ArrayList<Question> questionArrayList);
}
