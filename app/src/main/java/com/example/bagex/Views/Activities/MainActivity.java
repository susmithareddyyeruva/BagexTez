package com.example.bagex.Views.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bagex.R;
import com.example.bagex.Utils.Constants;
import com.example.bagex.Utils.SharedPrefsData;

public class MainActivity extends BaseActivity {

    private TextView role;
    private String roleStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        role = findViewById(R.id.role_txt);
        roleStr = SharedPrefsData.getString(this, Constants.ROLE, Constants.PREF_NAME);
        role.setText(roleStr);
    }
}
