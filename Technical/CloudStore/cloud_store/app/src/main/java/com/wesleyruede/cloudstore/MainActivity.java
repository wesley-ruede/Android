package com.wesleyruede.cloudstore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity" ;
    private EditText enterTitle;
    private EditText enterThought;
    private Button saveButton,showButton,updateTitle, deleteButton;
    private TextView recTitle;
    //private TextView recThought;

    // Keys
    public static final String KEY_TITLE = "title";
    public static final String KEY_THOUGHT = "thought";

    /* A connection to FireStore */
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    /* Alternate Way to create a reference to the collection's documents */
    // private DocumentReference getJournalRef = db.document("Journal/First Thoughts");
    private DocumentReference journalRef = db.collection("Journal")
            .document("First Thoughts");
    /* Create a new Document inside of the Collection */
    private CollectionReference collectionReference = db.collection("Journal");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveButton = findViewById(R.id.save_button);
        enterTitle = findViewById(R.id.edit_text_title);
        enterThought = findViewById(R.id.edit_text_thoughts);
        recTitle = findViewById(R.id.rec_title);
        // recThought = findViewById(R.id.rec_thought);
        showButton = findViewById(R.id.show_data);
        updateTitle = findViewById(R.id.update_all);
        deleteButton = findViewById(R.id.delete_all);

        /* CRUD */
        updateTitle.setOnClickListener(this); // Update
        deleteButton.setOnClickListener(this); // Delete

        /* Create */
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addThought();

//                String title = enterTitle.getText().toString().trim();
//                String thought = enterThought.getText().toString().trim();
//
//                Journal journal = new Journal();
//                journal.setTitle(title);
//                journal.setThought(thought);

//                Map<String, Object> data = new HashMap<>();
//                data.put(KEY_TITLE,title);
//                data.put(KEY_THOUGHT,thought);

//                journalRef.set(journal)
//                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                Toast.makeText(MainActivity.this,"Success",
//                                        Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.d(TAG, "onFailure: " + e.toString());
//                            }
//                        });
            }
        });
        /* Read */
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getThoughts();

//                journalRef.get()
//                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                            @Override
//                            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                if(documentSnapshot.exists()) {
//
//                                    Journal journal = documentSnapshot.toObject(Journal.class);
////                                    String title = documentSnapshot.getString(KEY_TITLE);
////                                    String thought = documentSnapshot.getString(KEY_THOUGHT);
//
//                                    if (journal != null) {
//                                        recTitle.setText(journal.getTitle());
//                                        recThought.setText(journal.getThought());
//                                    }
//
//                                }else {
//                                    Toast.makeText(MainActivity.this,"No data exists",
//                                            Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.d(TAG, "onFailure: " +e.toString());
//                            }
//                        });
            }
        });
    }
    /* Update */
    @Override
    protected void onStart() {
        super.onStart();
        /* Auto update the data when the save button is clicked */
        // Passing this to imply that the Snapshot listener be killed when
        // the activity ends to give back the memory as it takes a lot of memory
        collectionReference.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots,
                                @Nullable FirebaseFirestoreException e) {

                if (e != null) {
                    Log.d(TAG, "onEvent: " + e.toString());
                }
                /* Auto update with the newest documents in the collection */
                String data = "";
                if (queryDocumentSnapshots != null) {
                    for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {

                        Journal journal = snapshots.toObject(Journal.class);
                        data += "Title: " + journal.getTitle() + "\n"
                                + "Thought: " + journal.getThought() + "\n\n";
                    }
                }
                recTitle.setText(data);
            }
        });

//        journalRef.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot,
//                                @Nullable FirebaseFirestoreException e) {
//                if (e != null){
//                    Toast.makeText(MainActivity.this,"Something went wrong",
//                            Toast.LENGTH_SHORT).show();
//                }
//                if (documentSnapshot != null && documentSnapshot.exists()) {
//
//                    String data = "";
//                    Journal journal = documentSnapshot.toObject(Journal.class);
//
//                    data += "Title: " + journal.getTitle() +" \n"
//                            + "Thought " + journal.getThought() + "\n\n";
//                    recTitle.setText(data);
//
//                }else {
//                    recTitle.setText("");
//                }
//            }
//        });
    }
    /* Create */
    private void addThought() {
        String title = enterTitle.getText().toString().trim();
        String thought = enterThought.getText().toString().trim();
        /* Create a new document inside of the Journal collection */
        Journal journal = new Journal(title,thought);
        // The same document isn't overwritten again and again.
        //journal.setTitle(title);
        //journal.setThought(thought);

        collectionReference.add(journal)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(MainActivity.this,
                                "Document successfully created",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"Stack Trace" + e.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /* Buttons */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_all:
                updateAll();
                break;
            case R.id.delete_all:
                deleteThought();
                break;
        }
    }

    private void getThoughts() {
        collectionReference.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        String data = "";

                        for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots) {

                            Journal journal = snapshots.toObject(Journal.class);
                            data += "Title: " + journal.getTitle() + "\n"
                                    + "Thought: " + journal.getThought() + "\n\n";

//                            Log.d(TAG, "onSuccess: " + snapshots.getString(KEY_TITLE));
                            // recTitle.setText(journal.getTitle());
                        }
                        recTitle.setText(data);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"Error: " + e.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void deleteAll() {
        journalRef.delete();
    }

    /* Delete */
    private void deleteThought() {
        journalRef.update(KEY_THOUGHT, FieldValue.delete())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this,"Everything deleted",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "onFailure: " + e.toString());
                    }
                });
    }
    /* Update */
    private void updateAll() {
        String title = enterTitle.getText().toString().trim();
        String thought = enterThought.getText().toString().trim();

        Map<String,Object> data = new HashMap<>();
        data.put(KEY_TITLE,title);
        data.put(KEY_THOUGHT,thought);

        journalRef.update(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this,"Updated",Toast.LENGTH_SHORT).show();
            }})
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "onFailure: " + e.toString());
                    }
                });
    }
}
