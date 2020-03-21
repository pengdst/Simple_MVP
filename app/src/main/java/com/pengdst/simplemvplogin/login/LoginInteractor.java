package com.pengdst.simplemvplogin.login;

public interface LoginInteractor {
    void onUsernameError();
    void onPasswordError();
    void onLoginSuccess(String username);
    void onLoginError();
}
