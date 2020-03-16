package com.example.bagex.Services;

public interface APIConstantURL {


    //Global Base URL
    //String BASE_URL = "http://192.168.1.189/Poultry/API/api/";
    String BASE_URL = "http://13.84.230.14/";



    //Login
    String LOGINPage = BASE_URL + "Account/Login";

    // Admin Pending Orders
    String GetPendingOrders = BASE_URL + "Orders/GetPendingOrders";


}
