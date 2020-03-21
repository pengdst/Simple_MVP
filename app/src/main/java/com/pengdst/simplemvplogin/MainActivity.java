package com.pengdst.simplemvplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.pengdst.simplemvplogin.databinding.ActivityMainBinding;
import com.pengdst.simplemvplogin.helpers.ConstantsHelpers;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent data = getIntent();

        String username = data.getStringExtra(ConstantsHelpers.USERNAME_CONS);

        binding.tvHello.setText("Welcome, "+username);
    }
}
