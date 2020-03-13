package com.example.bagex.Views.DeliveryAgent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.bagex.R;
import com.example.bagex.Views.Activities.BaseActivity;

public class DeliveryAgentMainActivity extends BaseActivity {

    private Context context;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout content_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_agent_main);
        context = this.getApplicationContext();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new DeliveryNewOrdersFragment())
                .commit();
        content_frame = findViewById(R.id.content_frame);
        bottomNavigationView = findViewById(R.id.bottomNavigationView_delivery);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bnav_neworder:

                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new DeliveryNewOrdersFragment())
                                        .commit();
                                break;

                            case R.id.bnav_inprogress:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new DeliveryInprogressOrdersFragment())
                                        .commit();
                                break;

                            case R.id.bnav_completed:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new DeliveryCompletedOrdersFragment())
                                        .commit();
                                break;
                        }
                        return true;
                    }
                });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

