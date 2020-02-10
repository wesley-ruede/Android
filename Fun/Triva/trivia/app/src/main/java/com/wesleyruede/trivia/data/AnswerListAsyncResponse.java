package com.wesleyruede.trivia.data;

import com.wesleyruede.trivia.model.Question;
import java.util.ArrayList;

// the internet is built on asynchronous computing so this interface enables
// MainActivity to get a json response in the form of an ArrayList while
// handling null responses to the queue

public interface AnswerListAsyncResponse {
    void processFinished(ArrayList<Question> questionArrayList);
}
