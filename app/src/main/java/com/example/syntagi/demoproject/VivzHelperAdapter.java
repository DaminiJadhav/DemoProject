package com.example.syntagi.demoproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VivzHelperAdapter {
    VivzHelperAda vivzHelperAda;

    public VivzHelperAdapter(Context context) {
        vivzHelperAda = new VivzHelperAda(context);
    }

    public long insertData(String name, String password)
    {
        SQLiteDatabase db = vivzHelperAda.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(VivzHelperAda.NAME, name);
        contentValues.put(VivzHelperAda.PASSWORD, password);
        long id = db.insert(VivzHelperAda.TABLE_NAME, null, contentValues);
        return id;

    }


    public String getallData() {
        SQLiteDatabase sqLiteDatabase = vivzHelperAda.getWritableDatabase();
        String[] column = {VivzHelperAda.UID, VivzHelperAda.NAME, VivzHelperAda.PASSWORD};
        Cursor cursor = sqLiteDatabase.query(VivzHelperAda.TABLE_NAME, column, null, null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {
//            int index1=cursor.getColumnIndex(VivzHelperAda.UID);
//            int cid=cursor.getInt(index1);
            int cid = cursor.getInt(0);
            String name = cursor.getString(1);
            String password = cursor.getString(2);
            stringBuffer.append(cid + " " + name + " " + password + "\n");
        }
        return stringBuffer.toString();
    }

    public String getDetail1(String name, String pass) {
        SQLiteDatabase sqLiteDatabase = vivzHelperAda.getWritableDatabase();
        //  String[] column={VivzHelperAda.UID  ,VivzHelperAda.NAME,VivzHelperAda.PASSWORD};
        String[] column = {VivzHelperAda.UID};
        String[] selectionarg = {name, pass};
        Cursor cursor = sqLiteDatabase.query(VivzHelperAda.TABLE_NAME, column, VivzHelperAda.NAME + " =? AND " + VivzHelperAda.PASSWORD + " =?", selectionarg, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {
//            int index1=cursor.getColumnIndex(VivzHelperAda.UID);
//            int cid=cursor.getInt(index1);
            int index0 = cursor.getColumnIndex(VivzHelperAda.UID);
//            int index1=cursor.getColumnIndex(VivzHelperAda.NAME);
//            int index2=cursor.getColumnIndex(VivzHelperAda.PASSWORD);
            String cid = cursor.getString(index0);
            stringBuffer.append(cid + "\n");
//           String per_name=cursor.getString(index1);
//            String password=cursor.getString(index2);
            //    stringBuffer.append(cid+""+per_name+ " " +password+"\n");
        }
        return stringBuffer.toString();
    }

    public int updatedata(String oldname,String newname)
    {
        SQLiteDatabase db=vivzHelperAda.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(VivzHelperAda.NAME,newname);
        String []whereargs={oldname};
        int count=db.update(VivzHelperAda.TABLE_NAME,contentValues,VivzHelperAda.NAME+" =? ",whereargs);
        return count;

    }

    public int deletedata()
    {
        SQLiteDatabase db=vivzHelperAda.getWritableDatabase();
        String []wherearg={"Ram"};
        int count=db.delete(VivzHelperAda.TABLE_NAME,VivzHelperAda.NAME+" =?",wherearg);
    return count;
    }

    class VivzHelperAda extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "vivzdb";
        private static final String TABLE_NAME = "student";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private Context context;
        private static final String PASSWORD = "Password";
        private static final String NAME = "Name";

        public VivzHelperAda(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Message.message(context, "Constructor called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " VARCHAR(255)," + PASSWORD + " VARCHAR(255));";
            try {
                db.execSQL(query);
            } catch (SQLException e) {
                Message.message(context, "onCreate called" + e);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                // String drop_table = "DROP TABLE "+TABLE_NAME+" IF EXISTS";
                db.execSQL("DROP TABLE IF EXISTS student");
                onCreate(db);
            } catch (SQLException e) {
                Message.message(context, "onUpgrade called" + e);
            }
        }
    }
}
