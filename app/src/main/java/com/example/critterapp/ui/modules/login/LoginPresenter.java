package com.example.critterapp.ui.modules.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.critterapp.helper.InputHelper;

import java.util.Objects;

public class LoginPresenter extends LoginMvp.Presenter{


    @Override
    public void login(@NonNull String username, @NonNull String password
                        , @Nullable boolean isBasicAuth) {

        boolean usernameIsEmpty = InputHelper.isEmpty(username);
        boolean passwordIsEmpty = InputHelper.isEmpty(password);

        boolean view = false;
        if (view)  return;

        //view.onEmptyUserName(usernameIsEmpty);
        //view.onEmptyPassword(passwordIsEmpty);

    }
}
