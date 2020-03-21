package com.pengdst.simplemvplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pengdst.simplemvplogin.databinding.ActivityLoginBinding;
import com.pengdst.simplemvplogin.helpers.ConstantsHelpers;
import com.pengdst.simplemvplogin.login.LoginPresenter;
import com.pengdst.simplemvplogin.login.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {
    ActivityLoginBinding binding;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initPresenter();

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login(binding.etUsername.getText().toString(), binding.etPassword.getText().toString());
            }
        });
    }

    private void initPresenter() {
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void setUsernameError() {
        binding.etUsername.setError("Please Fill Username");
    }

    @Override
    public void setPasswordError() {
        binding.etPassword.setError("Please Fill Password");
    }

    @Override
    public void showProgressbar() {
        binding.pbLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        binding.pbLogin.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoginSuccess(String username) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra(ConstantsHelpers.USERNAME_CONS, username);
        Toast.makeText(getApplicationContext(), "Success login "+username, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    @Override
    public void onLoginError() {
        Toast.makeText(getApplicationContext(), "Password and Username Wrong", Toast.LENGTH_SHORT).show();
    }
}
