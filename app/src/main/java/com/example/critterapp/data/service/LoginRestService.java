package com.example.critterapp.data.service;

import androidx.annotation.NonNull;
import com.example.critterapp.data.dao.model.AbstractLogin;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginRestService {
    @GET("user")
    Observable<Login> loginAccessToken();

    @POST("authorizations")
    Observable<AccessTokenModel> login(@NonNull @Body AuthModel authModel);
}
