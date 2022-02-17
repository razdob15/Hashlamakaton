package com.example.easygive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        setupUI();


    }

    private void setupUI() {

        final EditText emailET = findViewById(R.id.email_et);
        final EditText passwordET = findViewById(R.id.password_et);
        Button loginBtn = findViewById(R.id.login_btn);


        loginBtn.setOnClickListener(view -> {
            String email = emailET.getText().toString();
            String password = passwordET.getText().toString();
            signIn(email, password);
        });

    }

    private void signUp(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                });

    }

    private void signIn(String email, String password) {
        if (email == null || password == null) {
            Toast t = new Toast(this);
            t.setText("Please fill the fields");
            t.show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast t = new Toast(this);
            t.setText("Email is invalid");
            t.show();
            return;
        }
        if (password.length() < 8) {
            Toast t = new Toast(this);
            t.setText("Password must contains 8 chars");
            t.show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        signUp(email, password);
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Log.i(TAG, "onStart: User is connected: " + currentUser.getEmail());
            nextActivity();
        } else Log.i(TAG, "onStart: No user...");
    }

    private void nextActivity() {
        Intent intent = new Intent(this, PreferencesActivity.class);
        startActivity(intent);

    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            nextActivity();
        }
        Log.i(TAG, "updateUI: User is null");
    }
}