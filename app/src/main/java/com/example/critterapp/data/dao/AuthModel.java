package com.example.critterapp.data.dao;

import android.os.Parcelable;

import java.util.List;

@Getter @Setter @NoAgrsContructor
public class AuthModel implements Parcelable {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private List<String> scopes;
    private String state;
}
