package com.example.critterapp.data.dao.model;

import android.os.Parcelable;

import androidx.annotation.Nullable;

import io.reactivex.Observable;
import io.requery.Column;
import io.requery.Entity;
import io.requery.Key;
import lombk.NoArgsConstructor;

@Entity
@NoArgsConstructor
public abstract class  AbstractLogin implements Parcelable {
    @Key long id;
    @Column String login;
    String avatarUrl;
    String name;
    String location;
    String email;
    String token;

    @Nullable boolean isLoggedIn;

    public Observable<Login> udate(){
        return Rxhelper;
    }


}
