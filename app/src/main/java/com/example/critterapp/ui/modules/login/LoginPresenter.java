package com.example.critterapp.ui.modules.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.critterapp.data.dao.AuthModel;
import com.example.critterapp.helper.InputHelper;
import com.example.critterapp.provider.rest.LoginProvider;

import io.reactivex.Observable;


public class LoginPresenter extends LoginActivity implements LoginMvp.Presenter{

    LoginPresenter(){
        LoginProvider.clearHttpClient();
    }

    @Override
    public void login(@NonNull String username, @NonNull String password
                        , @Nullable boolean isBasicAuth) {

        boolean usernameIsEmpty = InputHelper.isEmpty(username);
        boolean passwordIsEmpty = InputHelper.isEmpty(password);

        //if (getView() == null)  return;
        if (usernameIsEmpty) {
            //getView().onEmptyUserName(true);
        }
        if(passwordIsEmpty) {
            //getView().onEmptyPassword(true);
        }
        if((!usernameIsEmpty && !passwordIsEmpty)) {
            AuthModel authModel = new AuthModel();
            LoginProvider.getLoginRestService("", "")
                    .login(new AuthModel());

        }
    }
}
