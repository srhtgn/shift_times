package com.example.shifttimes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText emailEditText, passwordEditText;
    private Button loginButton, goToRegisterPageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();

        goToRegisterPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eposta = emailEditText.getText().toString();
                String sifre = passwordEditText.getText().toString();
                mAuth.signInWithEmailAndPassword(eposta, sifre)
                        .addOnCompleteListener(LoginActivity.this, new
                                OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            updateUI(user);
                                        } else {
                                            Toast.makeText(LoginActivity.this, "Giriş başarısız.", Toast.LENGTH_SHORT).show();
                                                    updateUI(null);
                                        }
                                    }
                                });
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Kullanici daha once giris yapmis mi kontrol et; buna gore arayuzu hazirla
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    public void updateUI(FirebaseUser user) {
        if (user != null) {
            Toast.makeText(this, user.getEmail() + " giriş yaptı",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Henüz giriş yapmadınız!",
                    Toast.LENGTH_LONG).show();
        }
    }




    private void initComponents() {
        mAuth = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        goToRegisterPageButton = findViewById(R.id.goToRegisterPageButton);
    }
}