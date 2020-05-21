package com.wesleyruede.androidarchitecture.mvc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.wesleyruede.androidarchitecture.R;

import java.util.ArrayList;
import java.util.List;

public class MVCActivity extends AppCompatActivity {
    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle("MVC");

        list = findViewById(R.id.list_view);
        adapter = new ArrayAdapter<>(this,R.layout.row_layout,R.id.list_text, listValues);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MVCActivity.this,"item clicked" + listValues.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        ArrayList<String> vals = new ArrayList<>();
        vals.add("USA");
        vals.add("Argentina");
        vals.add("Buenos Arees");
        vals.add("zijn means are");
        vals.add("Geen means not ");
        vals.add("USA");
        vals.add("Argentina");
        vals.add("Buenos Arees");
        vals.add("zijn means are");
        vals.add("Geen means not ");
        vals.add("USA");
        vals.add("Argentina");
        vals.add("Buenos Arees");
        vals.add("zijn means are");
        vals.add("Geen means not ");
        vals.add("USA");
        vals.add("Argentina");
        vals.add("Buenos Arees");
        vals.add("zijn means are");
        vals.add("Geen means not ");
        vals.add("USA");
        vals.add("Argentina");
        //noinspection SpellCheckingInspection
        vals.add("Buenos Arees");
        vals.add("zijn means are");
        vals.add("Geen means not ");
    }

    public void setValues(List<String> values){
        listValues.clear();
        listValues.addAll(values);
        adapter.notifyDataSetChanged();
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVCActivity.class);
    }
}
