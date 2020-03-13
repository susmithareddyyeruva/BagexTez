package com.example.bagex.Views.PickupAgent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.bagex.R;

public class PickupAgentMainActivity extends AppCompatActivity {

    private Context context;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout content_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_agent_main);
        context = this.getApplicationContext();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new PickupNewOrdersFragment())
                .commit();
        content_frame = findViewById(R.id.content_frame);
        bottomNavigationView = findViewById(R.id.bottomNavigationView_pickup);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bnav_neworder:

                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new PickupNewOrdersFragment())
                                        .commit();
                                break;

                            case R.id.bnav_inprogress:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new PickupInprogressOrdersFragment())
                                        .commit();
                                break;

                            case R.id.bnav_completed:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new PickupCompletedOrdersFragment())
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