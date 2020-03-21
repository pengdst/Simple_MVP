package com.pengdst.simplemvplogin.login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginPresenter implements OnLoginFinished {
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(final String username, final String password){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)){
                    onLoginSuccess(username);
                }else if(username.equals("pengkuh") && password.equals("admin")){
                    onLoginError();
                }else{
                    onLoginError();
                }
                loginView.hideProgressbar();
            }
        }, 2000);
    }

    @Override
    public void onUsernameError() {
        loginView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
    }

    @Override
    public void onLoginSuccess(String username) {
        loginView.onLoginSuccess(username);
    }

    @Override
    public void onLoginError() {
        loginView.onLoginError();
    }
}
