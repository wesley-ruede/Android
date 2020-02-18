package com.wesleyruede.contactmanagerlist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.wesleyruede.contactmanagerlist.data.DatabaseHandler;
import com.wesleyruede.contactmanagerlist.model.Contact;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        contactArrayList = new ArrayList<>();
        listView = findViewById(R.id.list_view);

//        db.addContact(new Contact("James","5467890234"));
//        db.addContact(new Contact("Tim","5467856234"));
//        db.addContact(new Contact("Dunkin","5467894234"));
//        db.addContact(new Contact("Judith","5467898934"));
//        db.addContact(new Contact("Mitch","5467892334"));
//        db.addContact(new Contact("Gabe","5467894834"));
//        db.addContact(new Contact("Savannah","5467894534"));

        /* List all Contacts */
        List<Contact> contactList = db.getAllContacts();
        for(Contact contact: contactList) {
            Log.d("all_contact_id", "onCreate: " + contact.getName());
            contactArrayList.add(contact.getName());
        }
        Log.d("contact_count", "onCreate: " + db.getCount());

        /* Create array adapter */

        arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contactArrayList);

        /* Add to list_view */
        listView.setAdapter(arrayAdapter);

        /* Attach event listener to list_view */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d("List", "onItemClick: " + contactArrayList.get(position));
            }
        });
    }
}