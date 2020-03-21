package com.pengdst.simplemvplogin.login;

import android.text.TextUtils;

public class LoginPresenter {
    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username, String password){
        loginView.showProgressbar();
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
}
