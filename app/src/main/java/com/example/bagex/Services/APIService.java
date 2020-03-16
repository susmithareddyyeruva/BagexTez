package com.example.bagex.Services;

import com.example.bagex.Views.ModelClass.ResponseModelClasses.GetBookedOrdersResponeModel;
import com.example.bagex.Views.ModelClass.ResponseModelClasses.GetPendingOrdersResponeModel;
import com.example.bagex.Views.ModelClass.ResponseModelClasses.LoginPostAPIResponse;
import com.google.gson.JsonObject;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

public interface APIService {

    // Login
    @POST(APIConstantURL.LOGINPage)
    Observable<LoginPostAPIResponse> postLogin(@Body JsonObject data);

    //Admin Pending Orders
    @POST(APIConstantURL.GetPendingOrders)
    Observable<GetPendingOrdersResponeModel> getPendingOrders(@Body JsonObject data, @Header("Authorization")String Authorization);

    //Admin Booked Orders
    @POST(APIConstantURL.GetBookedOrders)
    Observable<GetBookedOrdersResponeModel> getBookedOrders(@Body JsonObject data, @Header("Authorization")String Authorization);

}
