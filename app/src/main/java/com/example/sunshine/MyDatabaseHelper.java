package com.example.sunshine;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static final int DATABASE_VERSION = 1 ;

    private static final String TABLE_NAME = "room_booking";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CHECK_IN_DATE = "in_date";
    private static final String COLUMN_CHECK_IN_OUT = "out_date";
    private static final String COLUMN_PACKAGE = "package";
    private static final String COLUMN_NO_OF_ROOMS = "rooms";
    private static final String COLUMN_PREFERENCE = "preference";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CHECK_IN_DATE + " TEXT, " +
                COLUMN_CHECK_IN_OUT + " TEXT, " +
                COLUMN_PACKAGE + " TEXT, " +
                COLUMN_NO_OF_ROOMS + " INTEGER, " +
                COLUMN_PREFERENCE + " TEXT);";
        db.execSQL(query);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    void bookroom(String checkInDate , String checkOutDate ,String packag , String number ,
                  String preference ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CHECK_IN_DATE,checkInDate);
        cv.put(COLUMN_CHECK_IN_OUT,checkOutDate);
        cv.put(COLUMN_PACKAGE, packag);
        cv.put(COLUMN_NO_OF_ROOMS,number);
        cv.put(COLUMN_PREFERENCE,preference);
        long result = db.insert(TABLE_NAME, null,cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Booking Successful", Toast.LENGTH_SHORT).show();
        }


    }
}
