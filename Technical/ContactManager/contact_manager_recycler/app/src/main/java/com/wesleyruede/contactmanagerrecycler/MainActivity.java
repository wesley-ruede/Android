package com.wesleyruede.contactmanagerrecycler;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.wesleyruede.contactmanagerrecycler.adapter.RecyclerViewAdapter;
import com.wesleyruede.contactmanagerrecycler.data.DatabaseHandler;
import com.wesleyruede.contactmanagerrecycler.model.Contact;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        contactArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /* List all Contacts */
        List<Contact> contactList = db.getAllContacts();
        for(Contact contact: contactList) {
            Log.d("all_contact_id", "onCreate: " + contact.getName());
            contactArrayList.add(contact);
        }
        Log.d("contact_count", "onCreate: " + db.getCount());

        /* Setup Adapter */
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);


//        db.addContact(new Contact("James","5467890234"));
//        db.addContact(new Contact("Tim","5467856234"));
//        db.addContact(new Contact("Jezeb","5467894234"));
//        db.addContact(new Contact("Judith","5467898934"));
//        db.addContact(new Contact("Mitch", "5467892334"));
//        db.addContact(new Contact("Gabe", "5467894834"));
//        db.addContact(new Contact("Savannah", "5467894534"));
    }
}