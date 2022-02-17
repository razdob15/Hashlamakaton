package com.example.easygive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.easygive.models.Volunteer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        Volunteer vonlteer;
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference("users");

        vonlteer = new Volunteer();

        ArrayList<String> prefs = new ArrayList<String>();

        ImageView grandpa = findViewById(R.id.profile_image);
        grandpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darkenImage(grandpa);
                prefs.add("old");
            }
        });

        ImageView devide = findViewById(R.id.profile_image2);
        devide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darkenImage(devide);
                prefs.add("devide");
            }
        });

        ImageView field = findViewById(R.id.profile_image3);
        field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darkenImage(field);
                prefs.add("save");
            }
        });

        ImageView supermarket = findViewById(R.id.profile_image5);
        supermarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darkenImage(supermarket);
                prefs.add("gather");
            }
        });

        ImageView teens = findViewById(R.id.profile_image4);
        teens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darkenImage(teens);
                prefs.add("teens");
            }
        });

        Button nextButton = findViewById(R.id.textButton);
        nextButton.setOnClickListener(view -> {
            vonlteer.setName(savedInstanceState.getString("name"));
            vonlteer.setEmail(savedInstanceState.getString( "email"));
            vonlteer.setPoints(0);
            vonlteer.setPreferences(prefs);
            databaseReference.setValue(vonlteer);
            Intent intent = new Intent(view.getContext(), BottomNavigationActivity.class);
            startActivity(intent);
        });
    }

    private void darkenImage(ImageView imageView)
    {
        imageView.setColorFilter(Color.rgb(123, 123, 123), android.graphics.PorterDuff.Mode.MULTIPLY);
    }
}