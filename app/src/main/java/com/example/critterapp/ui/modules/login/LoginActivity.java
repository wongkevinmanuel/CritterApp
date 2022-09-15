package com.example.critterapp.ui.modules.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.critterapp.R;

public class LoginActivity extends AppCompatActivity implements LoginMvp.View {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);
    }

    @Override
    public void onEmptyUserName(boolean isEmpty) {

    }

    @Override
    public void onEmptyPassword(boolean isEmpty) {

    }

    @Override
    public void onSuccessFullyLoggedIn(boolean extraLogin) {

    }
}
