package com.example.bagex.Views.PickupAgent;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bagex.R;


public class PickupNewOrdersFragment extends Fragment {

    private Context context;
    private View rootview;
    private Toolbar toolbar;

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

        initView();

        setView();

        return rootview;


      }

    private void initView() {

    }

    private void setView() {
    }
}
