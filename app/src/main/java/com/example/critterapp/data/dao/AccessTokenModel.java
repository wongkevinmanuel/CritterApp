package com.example.critterapp.data.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class AccessTokenModel implements Parcelable {
    private long id;
    private String token;
    private String hashedToken;
    private String accessToken;
    private String tokenType;

    public void AuthModel(){

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.token);
        parcel.writeString(this.hashedToken);
        parcel.writeString(this.accessToken);
        parcel.writeString(this.tokenType);
    }

    private AccessTokenModel(Parcel in){
        this.id = in.readLong();
        this.token = in.readString();
        this.hashedToken = in.readString();
        this.accessToken = in.readString();
        this.tokenType = in.readString();
    }

    public static final Creator<AccessTokenModel> CREATOR = new Creator<AccessTokenModel>() {
        @Override
        public AccessTokenModel createFromParcel(Parcel parcel) {
            return new AccessTokenModel(parcel);
        }

        @Override
        public AccessTokenModel[] newArray(int size) {
            return new AccessTokenModel[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHashedToken() {
        return hashedToken;
    }

    public void setHashedToken(String hashedToken) {
        this.hashedToken = hashedToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
