package com.assignment.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.assignment.databinding.HomeActivity;
import com.assignment.databinding.R;

public class EmailLoginActivity extends AppCompatActivity {

    private EditText emailField;
    private EditText passwordField;
    private CheckBox rememberCheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_login);
        emailField = (EditText) findViewById(R.id.email);
        passwordField = (EditText) findViewById(R.id.password);
        passwordField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                    if (id == R.id.login || id == EditorInfo.IME_NULL) {
                        attemptLogin();
                        return true;
                    }
                    return false;
                }
            });
        Button emailLoginButton = (Button) findViewById(R.id.email_sign_in_button);
        emailLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        rememberCheckbox = (CheckBox) findViewById(R.id.checkBoxRememberMe);
        if(!new PrefManager(this).isUserLogedOut()) {
            startHomeActivity();
        }
    }
    private void attemptLogin() {
        emailField.setError(null);
        passwordField.setError(null);

        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordField.setError(getString(R.string.error_invalid_password));
            focusView = passwordField;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailField.setError(getString(R.string.error_invalid_email));
            focusView = emailField;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        } else {
            if (rememberCheckbox.isChecked()) {
                saveLoginDetails(email, password);
            }
            startHomeActivity();
        }
    }

    private void startHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void saveLoginDetails(String email, String password) {
        new PrefManager(this).saveLoginDetails(email, password);
    }

    private boolean isEmailValid(String email) {
        return email.contains("@gmail.");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }
}