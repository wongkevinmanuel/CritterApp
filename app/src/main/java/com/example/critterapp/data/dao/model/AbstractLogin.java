package com.example.critterapp.data.dao.model;

import android.os.Parcelable;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_login")
public abstract class  AbstractLogin implements Parcelable {
    @PrimaryKey
    private long id;
    private String avatarUrl;
    @ColumnInfo(name="user_name")
    private String nameUser;
    private String location;
    private String email;
    private String token;

    @Nullable
    private boolean isLoggedIn;

    public Observable<Login> udate(){
        return Rxhelper;
    }

}
