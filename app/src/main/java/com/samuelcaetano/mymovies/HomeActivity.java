package com.samuelcaetano.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button loginbutton;
    Button signupbutton;

    Intent loginIntent;

    Animation fadeOutAnimation;
    Animation fadeInAnimation;
    Animation moveOutAnimation;
    Animation moveInAnimation;

    AnimationSet fadeOffScreen;
    AnimationSet fadeIntoScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loginbutton=findViewById(R.id.login);
        signupbutton=findViewById(R.id.signup);

        loginIntent = new Intent(HomeActivity.this, LoginActivity.class);

        fadeOutAnimation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.fadeout);
        fadeInAnimation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.fadein);
        moveOutAnimation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.moveout);
        moveInAnimation = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.movein);

        fadeOffScreen = new AnimationSet(true);
        fadeIntoScreen = new AnimationSet(true);

        fadeOffScreen.addAnimation(fadeOutAnimation);
        fadeOffScreen.addAnimation(moveOutAnimation);
        fadeIntoScreen.addAnimation(fadeInAnimation);
        fadeIntoScreen.addAnimation(moveInAnimation);

        fadeOffScreen.setFillAfter(true);

        fadeOffScreen.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(loginIntent);
                overridePendingTransition(0, android.R.anim.fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginbutton.startAnimation(fadeOutAnimation);
                loginbutton.setEnabled(false);
                signupbutton.startAnimation(fadeOffScreen);
                signupbutton.setEnabled(false);
            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(!loginbutton.isEnabled() && !signupbutton.isEnabled()) {

            loginbutton.startAnimation(fadeInAnimation);
            loginbutton.setEnabled(true);

            signupbutton.startAnimation(fadeIntoScreen);
            signupbutton.setEnabled(true);
        }
    }
}