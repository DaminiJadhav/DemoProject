package com.example.syntagi.demoproject;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VivzHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="vivzdatabase";
    private static final String TABLE_NAME="vivzTABLE";
    private static final int DATABASE_VERSION=3;
    private static final String UID="_id";
    private Context context;
    private static final String PASSWORD="Password";
    private static final String NAME="Name";
    public VivzHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
        Message.message(context,"Constructor called");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+PASSWORD+" VARCHAR(255));";
        try {
            db.execSQL(query);
        }
        catch(SQLException e)
        {
           Message.message(context,"onCreate called"+e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      try {
         // String drop_table = "DROP TABLE "+TABLE_NAME+" IF EXISTS";
          db.execSQL("DROP TABLE IF EXISTS vivzTABLE");
          onCreate(db);
      }catch (SQLException e)
      {
          Message.message(context,"onUpgrade called"+e);
      }
    }
}
