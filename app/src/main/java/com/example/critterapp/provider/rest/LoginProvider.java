package com.example.critterapp.provider.rest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.critterapp.BuildConfig;
import com.example.critterapp.data.service.LoginRestService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class LoginProvider {

    private final static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .setPrettyPrinting()
            .create();

    private static OkHttpClient provideOkHttpClient(@Nullable String authToken, @Nullable String otp){
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        if(BuildConfig.DEBUG){
            client.addInterceptor(null);
        }
        client.addInterceptor(null);
        return client.build();
    }

    private Retrofit provideRetrofit(@Nullable String authToken
                                    ,@Nullable String otp){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.REST_URL)
                .client(provideOkHttpClient("",""))
                .addConverterFactory(null)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @NonNull
    public static LoginRestService getLoginRestServive(){
       //return provideRetrofit("","").create(LoginRestService.class);
        return null;
    }
}
