package com.example.bagex.Services;

import com.example.bagex.Views.ModelClass.ResponseModelClasses.LoginPostAPIResponse;
import com.google.gson.JsonObject;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

public interface APIService {

    // Login
    @POST(APIConstantURL.LOGINPage)
    Observable<LoginPostAPIResponse> postLogin(@Body JsonObject data);
  }
