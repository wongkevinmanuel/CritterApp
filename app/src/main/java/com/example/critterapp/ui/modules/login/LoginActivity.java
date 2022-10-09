package com.example.critterapp.ui.modules.login;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.critterapp.R;
import com.example.critterapp.helper.InputHelper;
import com.example.critterapp.provider.rest.LoginProvider;
import com.example.critterapp.ui.base.BaseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.OnClick;

// extends AppCompactActivity
public class LoginActivity extends BaseActivity<LoginMvp.View, LoginPresenter> implements LoginMvp.View { //AppCompatActivity implements LoginMvp.View {
    @BindView(R.id.usernameEditText)
    TextInputEditText usernameEditText;
    @BindView(R.id.passwordEditText)
    TextInputEditText  passwordEditText;
    @BindView(R.id.login)
    FloatingActionButton login;
    @BindView(R.id.progress)
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);
    }

    @Override
    public void onEmptyUserName(boolean isEmpty) {
        usernameEditText.setText("INGRESA TU USUARIO");
    }

    @Override
    public void onEmptyPassword(boolean isEmpty) {

    }

    @Override
    public void onSuccessFullyLoggedIn(boolean extraLogin) {

    }

    @OnClick(R.id.login) public void onClick(){
        doLogin();
    }

    private void doLogin(){
        if(progress.getVisibility() == View.GONE){
            String username= InputHelper.toString(usernameEditText);
            String password = InputHelper.toString(passwordEditText);
            //login(username,password, false);

        }
    }
}
