package com.example.syntagi.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class edit_text extends AppCompatActivity implements TextWatcher {
EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        et=findViewById(R.id.edittext);
        et.addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(this,"before change",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this,"on text change",Toast.LENGTH_LONG).show();
    }

    @Override
    public void afterTextChanged(Editable s) {

        try {
            int no = Integer.parseInt(s.toString());

            if (no > 100) {
                s.replace(0, s.length(), "100");
            }
        }
        catch (NumberFormatException e)
        {

        }
    }
}
