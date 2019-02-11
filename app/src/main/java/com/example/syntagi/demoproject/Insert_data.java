package com.example.syntagi.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Insert_data extends AppCompatActivity {

    EditText userName,Pass,name;
    //VivzHelper vivzHelper;
    VivzHelperAdapter vivzHelperAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        userName=findViewById(R.id.user_name);
        Pass=findViewById(R.id.pass);
        name=findViewById(R.id.edit_txt);
        vivzHelperAdapter=new VivzHelperAdapter(this);
    }

    public void login(View view)
    {
        String user=userName.getText().toString();
        String pas=Pass.getText().toString();
        long id=vivzHelperAdapter.insertData(user,pas);
        if (id<0)
        {
            Message.message(this,"Unsuccessfully");
        }
else
        {
            Message.message(this,"Successfully Inserted Row");
        }

    }


    public void viewDetail(View view)
    {
        String data=vivzHelperAdapter.getallData();
        Message.message(this,data);
    }
    public void getDetail(View view)
    {
        String s1=name.getText().toString();
        String sub1=s1.substring(0,s1.indexOf(" "));
        String sub2=s1.substring(s1.indexOf(" ")+1);
        String s3=vivzHelperAdapter.getDetail1(sub1,sub2);
        Message.message(this,s3);
    }
    public void update(View view)
    {
        vivzHelperAdapter.updatedata("hello","Ram");

    }
    public void delete(View v)
    {
        int count=vivzHelperAdapter.deletedata();
        Message.message(this,""+count);
    }
}
