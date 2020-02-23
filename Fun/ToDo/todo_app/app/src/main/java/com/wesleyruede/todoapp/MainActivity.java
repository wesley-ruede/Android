package com.wesleyruede.todoapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.wesleyruede.todoapp.data.DatabaseHandler;
import com.wesleyruede.todoapp.model.Item;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private Button saveButton;
    private EditText itemAmount;
    private EditText itemColor;
    private EditText itemSize;
    private EditText itemName;
    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        databaseHandler = new DatabaseHandler(this);

        // check if item was saved
//        List<Item> item_list = databaseHandler.getAllItems();
//        for (Item item_i:item_list) {
//            Log.d("item_list", "onCreate: " + item_i.getDateCreated());
//        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopupDialog();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
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
        item.setItemAmount(amount);
        item.setItemSize(size);

        databaseHandler.addItem(item);
        // Snackbar needs a view
        Snackbar.make(view,"Item saved",Snackbar.LENGTH_SHORT).show();
        Log.d("item_id", "saveItem: " + item.getId());
        Log.d("item_name", "saveItem: " +item.getItemName());
        Log.d("item_color", "saveItem: " + item.getItemColor());
        Log.d("item_date", "saveItem: " + item.getDateCreated());
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