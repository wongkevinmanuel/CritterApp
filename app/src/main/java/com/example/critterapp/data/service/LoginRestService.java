package com.example.critterapp.data.service;

import androidx.annotation.NonNull;

import com.example.critterapp.data.dao.AccessTokenModel;
import com.example.critterapp.data.dao.AuthModel;
import com.example.critterapp.data.dao.model.AbstractLogin;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginRestService {
    @GET("user")
    Observable<AbstractLogin> loginAccessToken();
    //Login

    @POST("authorizations")
    Observable<AccessTokenModel> login(@NonNull @Body AuthModel authModel);
    //AccessTokenModel

    //@POST("authorizations")
    //Observable<Login> login(@NonNull @Body AuthModel authModel);
    //AccessTokenModel
}
