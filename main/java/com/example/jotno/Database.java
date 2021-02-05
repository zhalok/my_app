package com.example.jotno;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {

    private Context context;
    private static final String ID="id";
    private static final String DB_NAME="Tutor_information.db";
    private static final String TABLE_NAME="Tutor_info";
    private static final String NAME="Name";
    private static final String SUB="Subs";
    private static final String LOCATION="Location";

    private static final String AGE="Age";
    private static final String USERNAME="Username";
    private static final String PASSWORD="Password";
    private static final int VERSION=2;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+LOCATION+" VARCHAR(100), "+SUB+" VARCHAR(255), "+USERNAME+" VARCHAR(255), "+PASSWORD+" VARCHAR(255));";
    private static final String DROP_TABOLE = "DROP TABLE IF EXISTS "+TABLE_NAME+" ";
    private static final String SELECT = " SELECT * FROM "+TABLE_NAME+" ";

    public Database(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.context = context;

    }
//hiiiiiiiiiiiiiiii
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {

            Toast.makeText(context,"Oncreatemethod is called",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);

        }catch (Exception e)
        {
            Toast.makeText(context,"sorry there is some error",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try {
            Toast.makeText(context,"onUpgrade method was called",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(DROP_TABOLE);
            onCreate(sqLiteDatabase);
        }catch (Exception e)
        {
            Toast.makeText(context,"there is a problem calling the onupgrade method",Toast.LENGTH_SHORT).show();
        }


    }

    public long insertData(String Name,String Location,String Subs,String Username,String Password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,Name);
        contentValues.put(LOCATION,Location);
        contentValues.put(SUB,Subs);
        contentValues.put(USERNAME,Username);
        contentValues.put(PASSWORD,Password);
        long rowid = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid;

    }

    public Cursor getData(SQLiteDatabase sqLiteDatabase)
    {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Tutor_info",null);
        return cursor;

    }


}
