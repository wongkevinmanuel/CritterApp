package com.example.critterapp.ui.modules.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface LoginMvp {
    interface View {
        void onEmptyUserName(boolean isEmpty);
        void onEmptyPassword(boolean isEmpty);
        void onSuccessFullyLoggedIn(boolean extraLogin);
    }

    interface Presenter{
        //@NonNull
        //void onUserResponse(@Nullable Login response);
        void login(@NonNull String username, @NonNull String password
                    , @Nullable boolean isBasicAuth);
    }
}
