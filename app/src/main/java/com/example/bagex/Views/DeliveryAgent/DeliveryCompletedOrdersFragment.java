package com.example.bagex.Views.DeliveryAgent;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bagex.R;
import com.example.bagex.Services.APIService;
import com.example.bagex.Services.ServiceFactory;
import com.example.bagex.Utils.Constants;
import com.example.bagex.Utils.SharedPrefsData;
import com.example.bagex.Views.Activities.LoginActivity;
import com.example.bagex.Views.Adapters.DeliveryCompletedOrdersAdapter;
import com.example.bagex.Views.Fragments.BaseFragment;
import com.example.bagex.Views.ModelClass.RequestModelClasses.GetBookedOrdersRequestModel;
import com.example.bagex.Views.ModelClass.ResponseModelClasses.GetBookedOrdersResponeModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class DeliveryCompletedOrdersFragment extends BaseFragment {

    private Context context;
    private View rootview;
    private Toolbar toolbar;
    private ImageButton imageButton;
    private RecyclerView recyclerView;
    private Subscription mSubscription;
    private String authorizationToken;
    private ArrayList<GetBookedOrdersResponeModel.Datum> listResults = new ArrayList<>();
    private ArrayList<GetBookedOrdersResponeModel.Datum> BindDataListResults = new ArrayList<>();
    GetBookedOrdersResponeModel orderResponse;
    LinearLayoutManager mLayoutManager;
    private DeliveryCompletedOrdersAdapter deliveryCompletedOrdersAdapter;
    List<String> statusList = new ArrayList<>();

    public DeliveryCompletedOrdersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_delivery_completed_orders, container, false);
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
        recyclerView = rootview.findViewById(R.id.recyclerView);

        activity.showProgressDialog();

        getOrders();
    }

    private void setView() {
    }
    private void getOrders() {

        authorizationToken = SharedPrefsData.getString(context, Constants.Auth_Token, Constants.PREF_NAME);
        JsonObject object = bookedOrdersObject();
        APIService service = ServiceFactory.createRetrofitService(context, APIService.class);
        mSubscription = service.getBookedOrders(object,authorizationToken)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetBookedOrdersResponeModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            ((HttpException) e).code();
                            ((HttpException) e).message();
                            ((HttpException) e).response().errorBody();
                            try {
                                ((HttpException) e).response().errorBody().string();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onNext(final GetBookedOrdersResponeModel mResponse) {

                        activity.hideProgressDialog();
                        if (mResponse.getMessage().equalsIgnoreCase("Successful.")) {

                            orderResponse = mResponse;
                            BindDataListResults = (ArrayList<GetBookedOrdersResponeModel.Datum>) mResponse.getData();
                            listResults.addAll(BindDataListResults);
                            mLayoutManager = new LinearLayoutManager(context);
                            recyclerView.setLayoutManager(mLayoutManager);
                            recyclerView.setHasFixedSize(true);
                            deliveryCompletedOrdersAdapter = new DeliveryCompletedOrdersAdapter(context, listResults, recyclerView);
                            recyclerView.setAdapter(deliveryCompletedOrdersAdapter);



                        }
                    }


                });
    }

    private JsonObject bookedOrdersObject() {
        GetBookedOrdersRequestModel mRequest = new GetBookedOrdersRequestModel();
        statusList.add("aSO002");
        mRequest.setStatuslist(statusList);
        mRequest.setAwbno(0);
        mRequest.setAgentid("");
        mRequest.setUserid("");
        mRequest.setDeparturetime("2020-03-16T07:19:36.320Z");
        mRequest.setArrivaltime("");
        mRequest.setSlotdate(null);
        mRequest.setSlottime(null);
        mRequest.setMobile("");
        mRequest.setServicetype("");
        Log.e("orders", "" + new Gson().toJsonTree(mRequest).getAsJsonObject());
        return new Gson().toJsonTree(mRequest).getAsJsonObject();
    }

}
