package com.example.argaa.firebasetutorials;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference;

    private Toolbar mToolbar;

    private Button mScheduleButton;

    private ArrayList<String> valores = new ArrayList<>();
    private ArrayList<String> enMochila = new ArrayList<>();
    private ArrayList<String> keys = new ArrayList<>();

    private ListView libros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mScheduleButton = findViewById(R.id.schedule_button);

        mScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Schedule = new Intent(MainActivity.this, ScheduleActivity.class);
                startActivity(Schedule);
            }
        });

        mToolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("SmartLearn");

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            libros = findViewById(R.id.lista_libros);
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, valores);

            libros.setAdapter(arrayAdapter);
            String user_idD = mAuth.getInstance().getCurrentUser().getUid();
            mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(user_idD).child("Libros").child("1");
            mDatabaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String value = dataSnapshot.getValue(String.class);
                    valores.add(value);
                    enMochila.add(value);
                    String key = dataSnapshot.getKey();
                    keys.add(key);
                    arrayAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {



                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            libros.setAdapter(arrayAdapter);
            String user_iddx= mAuth.getInstance().getCurrentUser().getUid();
            mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(user_iddx).child("Libros").child("2");
            mDatabaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String value = dataSnapshot.getValue(String.class);
                    valores.add(value);
                    enMochila.add(value);
                    String key = dataSnapshot.getKey();
                    keys.add(key);
                    arrayAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    String value = dataSnapshot.getValue(String.class);
                    String key = dataSnapshot.getKey();
                    int index = keys.indexOf(key);
                    valores.set(index,value);
                    arrayAdapter.notifyDataSetChanged();

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            libros.setAdapter(arrayAdapter);
            String user_id= mAuth.getInstance().getCurrentUser().getUid();
            mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id).child("Libros").child("3");
            mDatabaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String value = dataSnapshot.getValue(String.class);
                    valores.add(value);
                    enMochila.add(value);
                    String key = dataSnapshot.getKey();
                    keys.add(key);
                    arrayAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    String value = dataSnapshot.getValue(String.class);
                    String key = dataSnapshot.getKey();
                    int index = keys.indexOf(key);
                    valores.set(index,value);
                    arrayAdapter.notifyDataSetChanged();

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            libros.setAdapter(arrayAdapter);
            String user_iddxs= mAuth.getInstance().getCurrentUser().getUid();
            mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(user_iddxs).child("Libros").child("4");
            mDatabaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String value = dataSnapshot.getValue(String.class);
                    valores.add(value);
                    enMochila.add(value);
                    String key = dataSnapshot.getKey();
                    keys.add(key);
                    arrayAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    String value = dataSnapshot.getValue(String.class);
                    String key = dataSnapshot.getKey();
                    int index = keys.indexOf(key);
                    valores.set(index,value);
                    arrayAdapter.notifyDataSetChanged();

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            libros.setAdapter(arrayAdapter);
            String user_iddxss= mAuth.getInstance().getCurrentUser().getUid();
            mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(user_iddxss).child("Libros").child("5");
            mDatabaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String value = dataSnapshot.getValue(String.class);
                    valores.add(value);
                    enMochila.add(value);
                    String key = dataSnapshot.getKey();
                    keys.add(key);
                    arrayAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    String value = dataSnapshot.getValue(String.class);
                    String key = dataSnapshot.getKey();
                    int index = keys.indexOf(key);
                    valores.set(index,value);
                    arrayAdapter.notifyDataSetChanged();

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
    }



    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {

            sendToStart();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.main_log_out_button){
            FirebaseAuth.getInstance().signOut();
            sendToStart();
        }

        return true;
    }

    public void sendToStart(){
        Intent startIntent = new Intent(MainActivity.this, StartActivity.class);
        startActivity(startIntent);
        finish();
    }
}


