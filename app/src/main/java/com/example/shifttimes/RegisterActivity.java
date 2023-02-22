package com.example.shifttimes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText emailEditText, passwordEditText;
    private Button registerButton;
    private Button goToLoginPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponents();

        goToLoginPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterActivity.this, new
                                OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            updateUI(user);
                                        } else {
                                            Toast.makeText(RegisterActivity.this, "Kayıt başarısız.", Toast.LENGTH_SHORT).show();
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
//         Kullanici daha once giris yapmis mi kontrol et; buna gore arayuzu hazirla
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
        registerButton = findViewById(R.id.registerButton);
        goToLoginPageButton = findViewById(R.id.goToLoginPageButton);
    }
}