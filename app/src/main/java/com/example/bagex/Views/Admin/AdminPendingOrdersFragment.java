package com.example.bagex.Views.Admin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.bagex.Views.Adapters.AdminPendingOrdersAdapter;
import com.example.bagex.Views.Fragments.BaseFragment;
import com.example.bagex.Views.ModelClass.RequestModelClasses.GetPendingOrdersRequestModel;
import com.example.bagex.Views.ModelClass.ResponseModelClasses.GetPendingOrdersResponeModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class AdminPendingOrdersFragment extends BaseFragment {

    private Context context;
    private View rootview;
    private Toolbar toolbar;
    private RecyclerView pendingRecyclerView;
    private Subscription mSubscription;
    private String authorizationToken;
    private ArrayList<GetPendingOrdersResponeModel.Datum> listResults = new ArrayList<>();
    private ArrayList<GetPendingOrdersResponeModel.Datum> BindDataListResults = new ArrayList<>();
    GetPendingOrdersResponeModel orderResponse;
    LinearLayoutManager mLayoutManager;
    private AdminPendingOrdersAdapter pendingOrdersAdapter;
    private ImageButton imageButton;


    public AdminPendingOrdersFragment() {
        // Required empty public constructor
    }

       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
           context = getActivity();

           // Inflate the layout for this fragment
           rootview = inflater.inflate(R.layout.fragment_admin_pending_orders, container, false);

           toolbar = rootview.findViewById(R.id.toolbar);
           toolbar.setTitle(getString(R.string.app_name));
           imageButton = rootview.findViewById(R.id.logoutbtn);
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

        pendingRecyclerView = rootview.findViewById(R.id.pendingRecyclerView);

        activity.showProgressDialog();

        getPendingOrders();

    }



    private void setView() {



    }

    private void getPendingOrders() {

        authorizationToken = SharedPrefsData.getString(context, Constants.Auth_Token, Constants.PREF_NAME);
        JsonObject object = pendingOrdersObject();
        APIService service = ServiceFactory.createRetrofitService(context, APIService.class);
        mSubscription = service.getPendingOrders(object,authorizationToken)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetPendingOrdersResponeModel>() {
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
                    public void onNext(final GetPendingOrdersResponeModel mResponse) {

                        activity.hideProgressDialog();
                        if (mResponse.getMessage().equalsIgnoreCase("Successful.")) {

                            orderResponse = mResponse;
                            BindDataListResults = (ArrayList<GetPendingOrdersResponeModel.Datum>) mResponse.getData();
                            listResults.addAll(BindDataListResults);
                            mLayoutManager = new LinearLayoutManager(context);
                            pendingRecyclerView.setLayoutManager(mLayoutManager);
                            pendingRecyclerView.setHasFixedSize(true);
                            pendingOrdersAdapter = new AdminPendingOrdersAdapter(context, listResults, pendingRecyclerView);
                            pendingRecyclerView.setAdapter(pendingOrdersAdapter);



                        }
                    }


                });
    }

    private JsonObject pendingOrdersObject() {
        GetPendingOrdersRequestModel mRequest = new GetPendingOrdersRequestModel();
        mRequest.setTservice("");
        mRequest.setMobile("");
        mRequest.setEmail("");
        mRequest.setFromdate("2020-03-13T10:11:05.789Z");
        mRequest.setTodate("2020-03-13T10:11:05.789Z");
        Log.e("pendingorders", "" + new Gson().toJsonTree(mRequest).getAsJsonObject());
        return new Gson().toJsonTree(mRequest).getAsJsonObject();
    }


}
