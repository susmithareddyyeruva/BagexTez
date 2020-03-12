package com.example.bagex.Views.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bagex.R;
import com.example.bagex.Utils.Cis_TextView;


import rx.Subscription;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private Context context;
    private static int SPLASH_TIME_OUT = 3000;
    private Subscription mSubscription;
    String Title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = SplashActivity.this;
        /* intializing and assigning ID's */
        initViews();
        /* Navigation's and using the views */
        setViews();
    }


    private void initViews() {
        imageView = findViewById(R.id.imageView);


    }

    private void setViews() {


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();


            }
        }, SPLASH_TIME_OUT);


    }

}
