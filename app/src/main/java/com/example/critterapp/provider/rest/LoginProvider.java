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

    private static OkHttpClient okHttpClient;
    private final static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .setPrettyPrinting()
            .create();

    private static OkHttpClient provideOkHttpClient(@Nullable String authToken, @Nullable String otp){
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        if(BuildConfig.DEBUG){
                //client.addInterceptor(new HttpLoggingInterceptor()
                //        .setLevel(HttpLogginInterceptor.Level.BODY));
        }
        //client.addInterceptor(new AuthenticatorInterceptor());
        return client.build();
    }

    private static Retrofit provideRetrofit(@Nullable String authToken
                                    ,@Nullable String otp){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.REST_URL)
                .client(provideOkHttpClient("",""))
                .addConverterFactory(null) //Covertir response a gson
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static LoginRestService getLoginRestService(){
        return new Retrofit.Builder()
                .baseUrl("https://github.com/login/auth")
                .client(provideOkHttpClient(null,null))
                .addConverterFactory(null)//Git hub Response Converter
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(LoginRestService.class);
    }

    @NonNull
    public static LoginRestService getLoginRestService(@NonNull String authToken, @Nullable String otp){
       return provideRetrofit(authToken,otp).create(LoginRestService.class);
    }


}
