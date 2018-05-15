package com.example.argaa.firebasetutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClassesActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference;
    private EditText nombreMateria;
    private CheckBox lunes,martes,miercoles,jueves,viernes,sabado,domingo;
    private Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        mAuth = FirebaseAuth.getInstance();
        agregar = findViewById(R.id.btn_agregar);
        nombreMateria = findViewById(R.id.editTextMaterias);
        lunes = findViewById(R.id.lunes);
        martes = findViewById(R.id.martes);
        miercoles = findViewById(R.id.miercoles);
        jueves = findViewById(R.id.jueves);
        viernes = findViewById(R.id.viernes);
        sabado = findViewById(R.id.sabado);
        domingo = findViewById(R.id.domingo);



        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lunes.isChecked()){
                    String nombreMateriaa = nombreMateria.getText().toString();
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id).child("Materias").child("Lunes").child(nombreMateriaa);
                    database.setValue(nombreMateriaa);

                }
                if(martes.isChecked()){
                    String nombreMateriaa = nombreMateria.getText().toString();
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id).child("Materias").child("Martes").child(nombreMateriaa);
                    database.setValue(nombreMateriaa);

                }
                if(miercoles.isChecked()){
                    String nombreMateriaa = nombreMateria.getText().toString();
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id).child("Materias").child("Miercoles").child(nombreMateriaa);
                    database.setValue(nombreMateriaa);

                }
                if(jueves.isChecked()){
                    String nombreMateriaa = nombreMateria.getText().toString();
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id).child("Materias").child("Jueves").child(nombreMateriaa);
                    database.setValue(nombreMateriaa);

                }
                if(viernes.isChecked()){
                    String nombreMateriaa = nombreMateria.getText().toString();
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id).child("Materias").child("Viernes").child(nombreMateriaa);
                    database.setValue(nombreMateriaa);

                }
                if(sabado.isChecked()){
                    String nombreMateriaa = nombreMateria.getText().toString();
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id).child("Materias").child("Sabado").child(nombreMateriaa);
                    database.setValue(nombreMateriaa);

                }
                if(domingo.isChecked()){
                    String nombreMateriaa = nombreMateria.getText().toString();
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id).child("Materias").child("Domingo").child(nombreMateriaa);
                    database.setValue(nombreMateriaa);

                }
            }
        });
    }
}
