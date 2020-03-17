package com.example.bagex.Views.Activities.Admin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.bagex.R;
import com.example.bagex.Views.Activities.BaseActivity;
import com.example.bagex.Views.Fragments.Admin.AdminAssignedOrdersFragment;
import com.example.bagex.Views.Fragments.Admin.AdminBookedOrdersFragment;
import com.example.bagex.Views.Fragments.Admin.AdminPendingOrdersFragment;

public class AdminMainActivity extends BaseActivity {

    private Context context;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout content_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        context = this.getApplicationContext();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new AdminBookedOrdersFragment())
                .commit();
        content_frame = findViewById(R.id.content_frame);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bnav_booked:

                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new AdminBookedOrdersFragment())
                                        .commit();
                                break;


                            case R.id.bnav_paypending:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new AdminPendingOrdersFragment())
                                        .commit();
                                break;

                            case R.id.bnav_assigned:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new AdminAssignedOrdersFragment())
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
