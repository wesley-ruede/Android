package com.wesleyruede.contactmanager;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.wesleyruede.contactmanager.data.DatabaseHandler;
import com.wesleyruede.contactmanager.model.Contact;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);


        Log.d("contact_count", "onCreate: " + db.getCount());

        // Create a Contact object to be stored in the db
        Contact jeremy = new Contact();
        jeremy.setName("jeremy");
        jeremy.setPhoneNumber("7887878");

        Contact tim = new Contact();
        tim.setName("Tim");
        tim.setPhoneNumber("34354665");
//        db.addContact(jeremy);
//        db.addContact(tim);
//        db.addContact(jeremy);

//        Select a single contact by id
//        Contact c = db.getContact(2);
//        Log.d("one_contact", "onCreate: " + c.getName()+ ", " + c.getPhoneNumber());
//
//        Update a single entry's info
//        c.setName("New Jeremy");
//        c.setPhoneNumber("38439495");
//        int updateRow = db.updateContact(c);
//        Log.d("row_id", "onCreate: " + updateRow);

//        Delete the given entry
//        db.deleteContact(c);

        List<Contact> contactList = db.getAllContacts();

        for(Contact contact: contactList) {
            Log.d("all_contact_id", "onCreate: " + contact.getId());
        }
    }
}
