package com.example.critterapp.ui.modules.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.critterapp.data.dao.AccessTokenModel;
import com.example.critterapp.data.dao.AuthModel;
import com.example.critterapp.helper.InputHelper;
import com.example.critterapp.provider.rest.LoginProvider;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class LoginPresenter extends LoginActivity implements LoginMvp.Presenter{

    LoginPresenter(){
        //LoginProvider.clearHttpClient();
    }

    CompositeDisposable compositeDisposable = new CompositeDisposable();
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
            compositeDisposable.add(
            LoginProvider.getLoginRestService("", "")
                                .login(new AuthModel()).subscribeOn(Schedulers.io())
                                      .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<AccessTokenModel>() {
                        @Override
                        public void accept(AccessTokenModel accessTokenModel) throws Exception {
                            verificarToken(accessTokenModel);
                        }
                    }))
            ;
        }
    }

    private void verificarToken(AccessTokenModel accessTokenModel){
        if(!accessTokenModel.getToken().isEmpty())
            return;
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
