package com.assignment.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.assignment.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    UserModel userModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        userModel = new UserModel("Nguyen", "Trong Phuc");
        binding.setUser(userModel);
    }
}