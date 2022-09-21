package com.example.critterapp.ui.modules.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.critterapp.helper.InputHelper;


public class LoginPresenter extends LoginActivity implements LoginMvp.Presenter{


    @Override
    public void login(@NonNull String username, @NonNull String password
                        , @Nullable boolean isBasicAuth) {

        boolean usernameIsEmpty = InputHelper.isEmpty(username);
        boolean passwordIsEmpty = InputHelper.isEmpty(password);

        //if (getView() == null)  return;
        if (usernameIsEmpty) {
            //getView().onEmptyUserName(false);

            //onEmptyUserName(usernameIsEmpty);
        }
        //view.onEmptyPassword(passwordIsEmpty);

    }
}
