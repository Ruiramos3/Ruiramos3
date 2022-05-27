package com.example.afinally;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class addNote extends AppCompatActivity {

    EditText titleInput;
    EditText descriptionInput;
    MaterialButton addBtn;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUser;
    FirestoreRecyclerAdapter<Nav, MyAdapter.MyViewHolder> noteAdapter;
    Context context;
    RealmResults<Nav> noteslist;

    public void MyAdapter(Context context, RealmResults<Nav> noteslist) {
        this.context = context;
        this.noteslist = noteslist;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        firebaseFirestore = FirebaseFirestore.getInstance();

        titleInput = findViewById(R.id.noteTitle);
        descriptionInput = findViewById(R.id.noteDescription);
        addBtn = findViewById(R.id.addBtn);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        Query query = firebaseFirestore.collection("notes1").document(firebaseUser.getUid()).collection("myNotes").orderBy("creationTime", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Nav> allNotes = new FirestoreRecyclerOptions.Builder<Nav>()
                .setQuery(query,Nav.class)
                        .build();

        noteAdapter = new FirestoreRecyclerAdapter<Nav, MyAdapter.MyViewHolder>(allNotes) {
            @Override
            protected void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position, @NonNull Nav model) {
                Nav note = noteslist.get(position);
                holder.titleOutput.setText(note.getTitle());
                holder.descriptionOutput.setText(note.getDescription());

                String formatTime = DateFormat.getDateTimeInstance().format(note.creationTime);
                holder.timeOutput.setText(formatTime);


            }

            @NonNull
            @Override
            public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                return new MyAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
            }
        };

        addBtn.setOnClickListener(v -> {
            String title = titleInput.getText().toString();
            String description = descriptionInput.getText().toString();
            long creationTime = System.currentTimeMillis();

            DocumentReference docref = firebaseFirestore.collection("notes1").document();
            Map<String,Object> notes1 = new HashMap<>();
            notes1.put("Title",title);
            notes1.put("Description",description);

            docref.set(notes1).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(addNote.this, "Note added", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(addNote.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });



        });


    }
}