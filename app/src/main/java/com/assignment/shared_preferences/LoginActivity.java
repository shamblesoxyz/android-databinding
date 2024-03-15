package com.assignment.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.assignment.databinding.HomeActivity;
import com.assignment.databinding.R;

public class LoginActivity extends AppCompatActivity {
    EditText usernameField;
    EditText passwordField;
    CheckBox rememberCheckbox;
    Button loginButton;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Mapping();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();
                if (username.equals("admin") && password.equals("admin")){
                    Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT).show();
                    if (rememberCheckbox.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("account", username);
                        editor.putString("password", password);
                        editor.putBoolean("state", true);
                        editor.commit();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("account");
                        editor.remove("password");
                        editor.remove("state");
                        editor.commit();
                    }
                }
                Toast.makeText(getApplicationContext(), "Login fail", Toast.LENGTH_SHORT).show();
            }
        });
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        usernameField.setText(sharedPreferences.getString("account", ""));
        passwordField.setText(sharedPreferences.getString("password", ""));
        rememberCheckbox.setChecked(sharedPreferences.getBoolean("state", false));
    }

    private void Mapping() {
        usernameField = (EditText) findViewById(R.id.eidt_text_username);
        passwordField = (EditText) findViewById(R.id.eidt_text_password);
        loginButton = (Button) findViewById(R.id.button_login);
        rememberCheckbox = (CheckBox) findViewById(R.id.checkbox_remember);
    }
}