package com.pengdst.simplemvplogin.login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginPresenter {
    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(final String username, final String password){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){
                    loginView.setUsernameError();
                    loginView.setPasswordError();
                    loginView.hideProgressbar();
                }else if(username.equals("pengkuh") && password.equals("admin")){
                    loginView.onLoginSuccess(username);
                    loginView.hideProgressbar();
                }else{
                    loginView.onLoginError();
                    loginView.hideProgressbar();
                }
            }
        }, 3000);
    }
}
