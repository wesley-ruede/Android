package com.wesleyruede.testtwo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.wesleyruede.testtwo.data.DatabaseHandler;
import com.wesleyruede.testtwo.model.Item;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private Button saveButton;
    private EditText itemAmount;
    private EditText itemColor;
    private EditText itemSize;
    private EditText itemName;
    private DatabaseHandler db;

    /* ListView/RecyclerView */
    private ListView listView;
    private Array itemArray;
    private ArrayList<String> itemArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = new DatabaseHandler(this);

        /* Check item Saved */
        List<Item> item_list = db.getAllItems();
        for (Item item_i:item_list) {
            Log.d("item_list", "onCreate: " + item_i.getDateItemAdded());
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopupDialog();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        /* ListView */

//        db.addItem(new Item("Cup","Pink"));
//        db.addItem(new Item("Cup","Red"));
//        db.addItem(new Item("Cup","Blue"));
//        db.addItem(new Item("Cup","Yellow"));
//        db.addItem(new Item("Cup","Brown"));
//        db.addItem(new Item("Cup","Black"));

        listView = findViewById(R.id.list_view);
        itemArrayList = new ArrayList<>();

        List<Item> item_list_two = db.getAllItems();
        for (Item item:item_list_two) {
            itemArrayList.add(item.getItemName());
        }
        /* Create ArrayAdapter*/
        arrayAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,itemArrayList
        );

        /* Add to ListView */
        listView.setAdapter(arrayAdapter);

        /* EventListener for clicks */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.d("ListPosition", "onItemClick: " + position);
                Log.d("ListNames", "onItemClick: " + itemArrayList.get(position));
            }
        });
    }

    private void createPopupDialog() {

        builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.popup,null);
        itemAmount = view.findViewById(R.id.item_amount);
        itemSize = view.findViewById(R.id.item_size);
        itemColor = view.findViewById(R.id.item_color);
        itemName = view.findViewById(R.id.item_name);
        saveButton = view.findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!itemName.getText().toString().isEmpty()
                        && !itemAmount.getText().toString().isEmpty()
                        && !itemColor.getText().toString().isEmpty()
                        && !itemSize.getText().toString().isEmpty()) {
                    saveItem(view);
                }else {
                    Snackbar.make(view,"Empty fields not allowed",
                            Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        builder.setView(view);
        dialog = builder.create(); // creating a dialog object
        dialog.show(); // Think Toast or Snackbar
    }

    private void saveItem(View view) {
        //Todo: save each item to db
        Item item = new Item();
        String newItem = itemName.getText().toString().trim();
        String newColor = itemColor.getText().toString().trim();
        int amount = Integer.parseInt(itemAmount.getText().toString().trim());
        int size = Integer.parseInt(itemSize.getText().toString().trim());

        item.setItemName(newItem);
        item.setItemColor(newColor);
        item.setItemQuantity(amount);
        item.setItemSize(size);

        db.addItem(item);
        // Snackbar needs a view
        Snackbar.make(view,"Item saved",Snackbar.LENGTH_SHORT).show();
        Log.d("item_id", "saveItem: " + item.getId());

        /* a delayed action to give the app time to store the data and dismiss the popup */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                //Todo: move to next screen - detail screen
                startActivity(new Intent(MainActivity.this, ListlessActivity.class));
            }
        },1200); // 1 sec
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}