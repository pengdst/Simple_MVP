package com.pengdst.simplemvplogin.login;

public interface OnLoginFinished {
    void onUsernameError();
    void onPasswordError();
    void onLoginSuccess(String username);
    void onLoginError();
}
