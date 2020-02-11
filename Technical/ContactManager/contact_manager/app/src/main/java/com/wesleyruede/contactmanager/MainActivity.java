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


        Contact jeremy = new Contact();
        jeremy.setName("jeremy");
        jeremy.setPhoneNumber("7887878");

        Contact tim = new Contact();
        tim.setName("Tim");
        tim.setPhoneNumber("34354665");

        //  db.addContact(jeremy);

        List<Contact> contactList = db.getAllContacts();

        for(Contact contact: contactList) {
            Log.d("MainActvity", "onCreate: " + contact.getPhoneNumber());
        }
    }
}
