package com.bipob01.modak.companion;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="FacultyDB";



    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String squlQureAttendance = "CREATE TABLE Attendance(id INTEGER PRIMARY KEY AUTOINCREMENT, CurrentDate VARCHAR UNIQUE," +
                " CurrentTime VARCHAR, SignInTime VARCHAR, DutyTime VARCHAR, SignOutTime VARCHAR)";
        db.execSQL(squlQureAttendance);
    }
    public Boolean addData(String currentDate,String signinTime, String currentTime, String dutyTime){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CurrentDate",currentDate);
        contentValues.put("CurrentTime",currentTime);
        contentValues.put("SignInTime",signinTime);
        contentValues.put("DutyTime", dutyTime);
        long result = database.insert("Attendance", null,contentValues);
        database.close();

        if(result == -1){
            return false;
        }
        else {
            return true;
        }

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String drpo = "DROP TABLE IF EXISTS Attendance";
        db.execSQL(drpo);

        onCreate(db);


    }
}
