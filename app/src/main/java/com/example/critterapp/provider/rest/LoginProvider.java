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
        if(okHttpClient == null){
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            if(BuildConfig.DEBUG){
                client.addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLogginInterceptor.Level.BODY));
            }
            client.addInterceptor(new AuthenticatorInterceptor());
            client.addInterceptor(new PaginationInterceptor());
            client.addInterceptor(new ContentTypeInterceptor());
            okHttpClient = client.build();
        }
        return okHttpClient;
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
