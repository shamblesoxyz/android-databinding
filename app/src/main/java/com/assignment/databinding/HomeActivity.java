package com.assignment.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.assignment.databinding.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    public ObservableField<String> title = new ObservableField<>();
    private ListUserAdapter listUserAdapter;
    private ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        title.set("DataBinding for RecyclerView");
        binding.setHome(this);
        setData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(listUserAdapter);
    }

    private void setData() {
        List<UserModel> users = new ArrayList<>();
        for (int i=0; i<10; i++){
            UserModel user = new UserModel();
            user.setFirstname("Nguyen");
            user.setLastname("Trong Phuc " + i);
            users.add(user);
        }
        listUserAdapter = new ListUserAdapter(users);
    }
}