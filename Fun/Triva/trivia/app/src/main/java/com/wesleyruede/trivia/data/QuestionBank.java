package com.wesleyruede.trivia.data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.wesleyruede.trivia.controller.AppController;
import com.wesleyruede.trivia.model.Question;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;

// Get all the Questions from an api using an json array of arrays

public class QuestionBank {
    ArrayList<Question> questionArrayList = new ArrayList<>();
    private String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    public List<Question> getQuestions(final AnswerListAsyncResponse callBack){

        // Handling Json requests and errors with Google's Volley library.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // iterate through the response ( till the end
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                Question question = new Question();
                                // get the string and bool value in each array
                                question.setAnswer(response.getJSONArray(i).get(0).toString());
                                question.setAnswerTrue(response.getJSONArray(i).getBoolean(1));

                                // Pack the set string and bool values of
                                // the Question objects to List
                                questionArrayList.add(question);

                                // Log.d("string", "onResponse: " + question.getAnswer());
                                // Log.d("JSON", "onResponse: " + response.getJSONArray(i).get(0));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        // handle null responses with an asynchronous Interface
                        if(null != callBack) callBack.processFinished(questionArrayList);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        // return the string and boolean values as an ArrayList
        return questionArrayList;
    }
}
