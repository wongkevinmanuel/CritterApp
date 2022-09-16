package com.example.critterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.critterapp.helper.InputHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;


import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.usernameEditText)
    TextInputEditText usernameEditText;
    @BindView(R.id.passwordEditText)
    TextInputEditText  passwordEditText;
    @BindView(R.id.login)
    FloatingActionButton login;
    @BindView(R.id.progress)
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @OnClick (R.id.login) public void onClick(){
        doLogin();
    }

    private void doLogin(){
        if(progress.getVisibility() == View.GONE){
            String username= InputHelper.toString();
            String password = InputHelper.toString();
            getPresentes().login(username, password);
        }
    }

}