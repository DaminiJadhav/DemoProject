package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login_Screen extends AppCompatActivity {
    TextInputEditText username, password;
    TextInputLayout til_userName, til_pass;
    private static final String email_pattern = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(email_pattern);
    private Matcher matcher;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);
        username = findViewById(R.id.ed1);
        password = findViewById(R.id.ed2);
        btn = findViewById(R.id.sign_in);
        til_userName = findViewById(R.id.til_user_name);
        til_pass = findViewById(R.id.txtlayout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Validationdata())
                {
                    Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean validate(String email) {
        matcher = pattern.matcher(email);
      return matcher.matches();
    }

    public boolean password(String password) {
        if (password.length() <= 5) {
            return false;
        }
        return true;
    }

    public boolean Validationdata()
    {
        String user = username.getText().toString();
        if (TextUtils.isEmpty(til_userName.getEditText().getText().toString())) {
            til_userName.setError(getString(R.string.empty_user_name));
            return false;
        }
        else if (!validate(user)) {
            til_userName.setError(getString(R.string.error_invalid_user_name));
            return false;

        }
        else {
            til_userName.setError(null);

        }

        String pass = password.getText().toString();
        if (TextUtils.isEmpty(til_pass.getEditText().getText().toString())) {
            til_pass.setError(getString(R.string.empty_password));
            return false;
        }
        else if (!password(pass)) {
            til_pass.setError(getString(R.string.error_invalid_password));
            return false;
        }

        else {
            til_pass.setError(null);
        }
        return true;
    }

}
