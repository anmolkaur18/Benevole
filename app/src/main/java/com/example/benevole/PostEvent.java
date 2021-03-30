package com.example.benevole;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.benevole.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class PostEvent extends AppCompatActivity {

    private Button b1;
    private TextInputLayout name, details, link;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Events");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_post_event);

        b1 = (Button) findViewById(R.id.btn);

        name = (TextInputLayout) findViewById(R.id.name);
        details = (TextInputLayout) findViewById(R.id.details);
        link = (TextInputLayout) findViewById(R.id.link);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getEditText().getText().toString();
                String details1 = details.getEditText().getText().toString();
                String link1 = link.getEditText().getText().toString();

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("name", name1);
                userMap.put("eventDetails", details1);
                userMap.put("link", link1);

                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(PostEvent.this,"Data Saved", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }



}