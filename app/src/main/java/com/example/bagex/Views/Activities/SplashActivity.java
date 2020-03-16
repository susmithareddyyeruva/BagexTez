package com.example.bagex.Views.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bagex.R;
import com.example.bagex.Utils.Cis_TextView;
import com.example.bagex.Utils.Constants;
import com.example.bagex.Utils.SharedPrefsData;
import com.example.bagex.Views.Admin.AdminMainActivity;
import com.example.bagex.Views.BulkOperator.BulkOperatorMainActivity;
import com.example.bagex.Views.DeliveryAgent.DeliveryAgentMainActivity;
import com.example.bagex.Views.PickupAgent.PickupAgentMainActivity;


import rx.Subscription;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private Context context;
    private static int SPLASH_TIME_OUT = 3000;
    private Subscription mSubscription;
    String Title,Role;
    int value;


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
            /*    value = SharedPrefsData.getInt(context, Constants.ISLOGIN, Constants.PREF_NAME);
                Role = SharedPrefsData.getString(context, Constants.ROLE, Constants.PREF_NAME);
                if (value == 1) {
                    if(Role.equalsIgnoreCase("Admin")){
                        SharedPrefsData.putString(context, Constants.ROLE, Role, Constants.PREF_NAME);
                        Intent intent = new Intent(SplashActivity.this, AdminMainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }else if(Role.equalsIgnoreCase("Delivery Agent")){
                        SharedPrefsData.putString(context, Constants.ROLE, Role, Constants.PREF_NAME);
                        Intent intent = new Intent(SplashActivity.this, DeliveryAgentMainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }else if(Role.equalsIgnoreCase("Pickup Agent")){
                        SharedPrefsData.putString(context, Constants.ROLE, Role, Constants.PREF_NAME);
                        Intent intent = new Intent(SplashActivity.this, PickupAgentMainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }else if(Role.equalsIgnoreCase("Bulk Operator")){
                        SharedPrefsData.putString(context, Constants.ROLE, Role, Constants.PREF_NAME);
                        Intent intent = new Intent(SplashActivity.this, BulkOperatorMainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    } else {
                        SharedPrefsData.putString(context, Constants.ROLE, Role, Constants.PREF_NAME);
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }

                } else {
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }


                // close this activity
                finish();*/
            }
        }, SPLASH_TIME_OUT);


    }

}
