package com.example.bagex.Views.PickupAgent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bagex.R;
import com.example.bagex.Utils.Constants;
import com.example.bagex.Utils.SharedPrefsData;
import com.example.bagex.Views.Activities.LoginActivity;


public class PickupNewOrdersFragment extends Fragment {

    private Context context;
    private View rootview;
    private Toolbar toolbar;
    private ImageButton imageButton;

    public PickupNewOrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();

        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_pickup_new_orders, container, false);

        toolbar = rootview.findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        imageButton=rootview.findViewById(R.id.logoutbtn);
        imageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPrefsData.getInstance(context).ClearData(context);

                Toast.makeText(getActivity(),"Logout Successfully.!",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getActivity(), LoginActivity.class);

                startActivity(i);



            }
        });

        initView();

        setView();

        return rootview;


      }

    private void initView() {

    }

    private void setView() {
    }
}
