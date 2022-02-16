package com.example.easygive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        ImageView grandpa = findViewById(R.id.profile_image);
        grandpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darkenImage(grandpa);
            }
        });

        ImageView devide = findViewById(R.id.profile_image2);
        devide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darkenImage(devide);
            }
        });

        ImageView field = findViewById(R.id.profile_image3);
        field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darkenImage(field);
            }
        });

        ImageView supermarket = findViewById(R.id.profile_image5);
        supermarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darkenImage(supermarket);
            }
        });

        ImageView teens = findViewById(R.id.profile_image4);
        teens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darkenImage(teens);
            }
        });


        Button nextButton = findViewById(R.id.textButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void darkenImage(ImageView imageView)
    {
        imageView.setColorFilter(Color.rgb(123, 123, 123), android.graphics.PorterDuff.Mode.MULTIPLY);
    }
}