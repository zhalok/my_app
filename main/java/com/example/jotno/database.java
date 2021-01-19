package com.example.jotno;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    private Context context;
    private static final String ID="id";
    private static final String DB_NAME="MYDATABASE";
    private static final String TABLE_NAME="Tutor info";
    private static final String NAME="Name";
    private static final String DEPARTMENT="Department";
    private static final String GENDER="Gender";
    private static final int VERSION=1;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+ID+" INTEGER);";
    public database( Context context) {
        super(context, DB_NAME, null, 1);
        this.context=context;

    }

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

    }
}
