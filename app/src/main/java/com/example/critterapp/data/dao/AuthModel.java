package com.example.critterapp.data.dao;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

//Room tiene anotacion siguientes
//@Getter @Setter @NoAgrsContructor
public class AuthModel implements Parcelable {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private List<String> scopes;
    private String state;

    public AuthModel(){}

    private AuthModel(Parcel in) {
        clientId = in.readString();
        clientSecret = in.readString();
        redirectUri = in.readString();
        scopes = in.createStringArrayList();
        state = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(clientId);
        dest.writeString(clientSecret);
        dest.writeString(redirectUri);
        dest.writeStringList(scopes);
        dest.writeString(state);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AuthModel> CREATOR = new Creator<AuthModel>() {
        @Override
        public AuthModel createFromParcel(Parcel in) {
            return new AuthModel(in);
        }

        @Override
        public AuthModel[] newArray(int size) {
            return new AuthModel[size];
        }
    };
}
