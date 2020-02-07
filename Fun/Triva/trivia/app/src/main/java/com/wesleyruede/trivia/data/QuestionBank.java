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
    private String url = "ghghghghghghg";

    public List<Question> getQuestions(final AnswerListAsyncResponse callBack){

        // Handling Json requests and errors with Google's Volley library.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                (JSONArray) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // iterate through the array of arrays
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                Question question = new Question();
                                // get the string and bool value of each array for for each array
                                question.setAnswer(response.getJSONArray(i).get(0).toString());
                                question.setAnswerTrue(response.getJSONArray(i).getBoolean(1));

                                // Add question objects to list-- .add() is a Volley method
                                questionArrayList.add(question);


                                // Log.d("string", "onResponse: " + question.getAnswer());
                                // Log.d("JSON", "onResponse: " + response.getJSONArray(i).get(0));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        // handle the possibility of a null response and
                        // handle the process asynchronously with an Interface
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
