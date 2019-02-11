package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.Edit_Text);
        textView=findViewById(R.id.text1);

    }
    public void save_file(View view)
    {
        File file=null;
        String text1=editText1.getText().toString();
        FileOutputStream fileOutputStream=null;
        try
        {
            file=getFilesDir();
            fileOutputStream=openFileOutput("vivz.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            textView.setTextColor(Color.BLUE);
            textView.setText(text1 +"\nWritten to \n" +file.getAbsolutePath());
        }
        catch (FileNotFoundException e)
        {
            textView.setTextColor(Color.RED);
            textView.setText(e.toString());
        }
        catch (IOException e)
        {
            textView.setTextColor(Color.RED);
            textView.setText(e.toString());
        }
        finally {
            try
            {
                fileOutputStream.close();
            }
            catch (IOException e)
            {

                textView.setTextColor(Color.RED);
                textView.setText(e.toString());
            }
        }
    }
}
