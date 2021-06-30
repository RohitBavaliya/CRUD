package com.example.firebasedataretrive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class InsertData extends AppCompatActivity {
    EditText addName, addUrl, addEmail, addCourse;
    Button addRecord, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        addName = (EditText) findViewById(R.id.addName);
        addCourse = (EditText) findViewById(R.id.addCourse);
        addEmail = (EditText) findViewById(R.id.addEmail);
        addUrl = (EditText) findViewById(R.id.addUrl);

        back = (Button) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        addRecord = (Button) findViewById(R.id.addRecords);
        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRecordProcess();
            }
        });

    }

    private void addRecordProcess()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("name",addName.getText().toString());
        map.put("course",addCourse.getText().toString());
        map.put("email",addEmail.getText().toString());
        map.put("purl",addUrl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("students").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        addName.setText("");
                        addCourse.setText("");
                        addEmail.setText("");
                        addUrl.setText("");
                        Toast.makeText(InsertData.this, "Data Inserted Successfully..", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(InsertData.this, "Data could not inserted..", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}