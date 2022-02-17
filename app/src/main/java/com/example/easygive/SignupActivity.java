package com.example.easygive;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthOptions;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        setupUI(savedInstanceState);
    }

    private void setupUI(Bundle bundle) {
        final EditText emailET = findViewById(R.id.email_et);
        final EditText passwordET = findViewById(R.id.password_et);
        final EditText repasswordET = findViewById(R.id.re_password_et);
        Button loginBtn = findViewById(R.id.login_btn);
        Button signupBtn = findViewById(R.id.signup_btn);

        emailET.setText(bundle.getString("email"));

        loginBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
        });
        signupBtn.setOnClickListener(view -> {
            String email = emailET.getText().toString();
            String password = passwordET.getText().toString();
            String repassword = repasswordET.getText().toString();
            signup(email, password, repassword);
        });
    }

    private void signupUser(String email, String password) {
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
                        Toast.makeText(SignupActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                });
    }

    private void signup(String email, String password, String repassword) {
        if (email == null || password == null || repassword == null) {
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_LONG).show();
            return;
        }
        if (!password.equals(repassword)) {
            Toast.makeText(this, "Passwords does not match", Toast.LENGTH_LONG).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email is invalid", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.length() < 8) {
            Toast.makeText(this, "Password must contains 8 chars", Toast.LENGTH_LONG).show();
            return;
        }
        signupUser(email, password);
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
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle bundle = new Bundle();
        if (mAuth.getCurrentUser() != null) {
            bundle.putString("email", mAuth.getCurrentUser().getEmail());
        }
        startActivity(intent, bundle);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            nextActivity();
        }
        Log.i(TAG, "updateUI: User is null");
    }
}