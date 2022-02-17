package com.example.easygive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.easygive.models.Volunteer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        Volunteer vonlteer;
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference("users");

        vonlteer = new Volunteer(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid());

        ArrayList<String> prefs = new ArrayList<>();

        ImageView grandpa = findViewById(R.id.profile_image);
        grandpa.setOnClickListener(view -> {
            darkenImage(grandpa);
            prefs.add("מבוגרים");
        });

        ImageView devide = findViewById(R.id.profile_image2);
        devide.setOnClickListener(view -> {
            darkenImage(devide);
            prefs.add("חלוקת מזון");
        });

        ImageView field = findViewById(R.id.profile_image3);
        field.setOnClickListener(view -> {
            darkenImage(field);
            prefs.add("הצלת מזון בחקלאות");
        });

        ImageView supermarket = findViewById(R.id.profile_image5);
        supermarket.setOnClickListener(view -> {
            darkenImage(supermarket);
            prefs.add("איסוף מזון");
        });

        ImageView teens = findViewById(R.id.profile_image4);
        teens.setOnClickListener(view -> {
            darkenImage(teens);
            prefs.add("נוער");
        });

        Button nextButton = findViewById(R.id.textButton);
        nextButton.setOnClickListener(view -> {
            Bundle bundle2 = getIntent().getExtras();
            int iend = bundle2.getString("email").indexOf("@");
            String subString = "";
            if (iend != -1) {
                subString = bundle2.getString("email").substring(0, iend); //this will give abc
            }
            vonlteer.setName(subString);
            vonlteer.setEmail(bundle2.getString("email"));
            vonlteer.setPoints(0);
            vonlteer.setPreferences(prefs);
            databaseReference.child(vonlteer.getId()).setValue(vonlteer);
            Intent intent = new Intent(view.getContext(), BottomNavigationActivity.class);
            startActivity(intent);
        });
    }

    private void darkenImage(ImageView imageView) {
        imageView.setColorFilter(Color.rgb(123, 123, 123), android.graphics.PorterDuff.Mode.MULTIPLY);
    }
}