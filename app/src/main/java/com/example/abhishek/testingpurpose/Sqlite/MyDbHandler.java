package com.example.abhishek.testingpurpose.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "demo";
    private static String key_id = "id";
    private static String key_name = "name";
    private static String key_email = "email";
    private static String key_mobile = "mobile";

    private static String key_table = "user_table";

    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_user = "CREATE TABLE " + key_table + "(" + key_id + " INTEGER PRIMARY KEY," + key_name + " TEXT," +
                key_email + " TEXT," + key_mobile + " TEXT" + ")";
        db.execSQL(create_user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public int insertUser(User user) {
        int i = 0;
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(key_id, user.getId());
            contentValues.put(key_name, user.getName());
            contentValues.put(key_email, user.getEmail());
            contentValues.put(key_mobile, user.getPhone());
            sqLiteDatabase.insert(key_table, null, contentValues);
            i = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public int deleteUser(String id) {
        int i = 0;
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            sqLiteDatabase.delete(key_table, key_id + "=?", new String[]{id});
            sqLiteDatabase.close();
            i = 1;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return i;
    }

    public ArrayList<User> viewUser() {
        ArrayList<User> userArrayList = null;
        try {
            String query = "SELECT * from " + key_table;
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                userArrayList = new ArrayList<>();
                do {
                    User user = new User();
                    user.setId(cursor.getString(0));
                    user.setName(cursor.getString(1));
                    user.setEmail(cursor.getString(2));
                    user.setPhone(cursor.getString(3));
                    userArrayList.add(user);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return userArrayList;
    }

    public boolean UpdateUser(User user) {
        boolean send=false;
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(key_id, user.getId());
            contentValues.put(key_name, user.getName());
            contentValues.put(key_email, user.getEmail());
            contentValues.put(key_mobile, user.getPhone());
            sqLiteDatabase.update(key_table,contentValues,"id=?",new String[]{user.getId()});
            send=true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return send;
    }

    @Override
    public synchronized void close() {
        super.close();
    }

}


