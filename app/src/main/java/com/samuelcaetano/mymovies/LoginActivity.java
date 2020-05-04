package com.samuelcaetano.mymovies;

import android.annotation.TargetApi;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button btnLogin;
    FirebaseDatabase db;
    DatabaseReference ref;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference().child("User");
        FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task<AuthResult> result = firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString());

            }
        });
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, android.R.anim.fade_out);
    }
}
