package com.wesleyruede.parse;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // private RequestQueue requestQueue;
    private TextView jsonTextView;
    RequestQueue queue;

    private String arrayUrl = "https://jsonplaceholder.typicode.com/todos";
    private String objectUrl = "https://jsonplaceholder.typicode.com/todos/1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonTextView = findViewById(R.id.json_text_view);
        // Queue the json request and fetch the data
        // requestQueue = Volley.newRequestQueue(this);
        // use the singleton method

        queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                objectUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                // json response comes as Queue
                try {
                    Log.d("JsonObject", "onResponse: " + jsonObject);
                    jsonTextView.setText(jsonObject.getString("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            // need to catch the error
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Error", "onErrorResponse:  " + volleyError.getMessage());

            }
        });

        // jsonArrayRequest
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                arrayUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                // how to get a single entry in the array
                for(int i = 0;i < jsonArray.length(); i++) {
                    try {
                        // store the array objects as json objects
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Log.d("JsonArray", "onResponse: " + jsonObject.getString("title"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(jsonArrayRequest);
        // requestQueue.add(jsonArrayRequest);
        //requestQueue.add(jsonObjectRequest);
    }
}
