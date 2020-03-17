package com.example.bagex.Views.BulkOperator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.bagex.R;
import com.example.bagex.Utils.SharedPrefsData;
import com.example.bagex.Views.Activities.LoginActivity;

public class BulkOperatorMainActivity extends AppCompatActivity
{
    private ImageButton imageButton;

    private Toolbar toolbar;
    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulk_operator_main);
        //toolbar = findViewById(R.id.toolbar);
        //toolbar.setTitle(getString(R.string.app_name));
        imageButton=findViewById(R.id.logoutbtn);
        b1=findViewById(R.id.arrivaltxt);
        b2=findViewById(R.id.departuretxt);
        imageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPrefsData.getInstance(getApplicationContext()).ClearData(getApplicationContext());

                Toast.makeText(getApplicationContext(),"Logout Successfully.!",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), LoginActivity.class);

                startActivity(i);



            }
        });
    }
}
