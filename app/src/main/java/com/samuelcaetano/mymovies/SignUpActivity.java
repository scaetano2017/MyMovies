package com.samuelcaetano.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.samuelcaetano.mymovies.User.User;

public class SignUpActivity extends AppCompatActivity {

    EditText username, email, password, passwordverify;
    Button btnRegister;
    private User user;
    FirebaseDatabase db;
    DatabaseReference ref;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        passwordverify = (EditText)findViewById(R.id.password2);

        btnRegister = (Button)findViewById(R.id.btnSignup);

        user = new User(username.getText().toString(), email.getText().toString(), password.getText().toString());
        db = FirebaseDatabase.getInstance();
        ref = db.getReference().child("User");
        FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
