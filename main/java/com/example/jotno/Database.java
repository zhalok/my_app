package com.example.jotno;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private Context context;
    private static final String ID="id";
    private static final String DB_NAME="MYDATABASE.db";
    private static final String TABLE_NAME="Tutor_info";
    private static final String NAME="Name";
    private static final String DEPARTMENT="Department";
    private static final String AGE="Age";
    private static final int VERSION=2;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+AGE+" INTEGER "+DEPARTMENT+" VARCHAR(100) );";
    private static final String DROP_TABOLE = "DROP TABLE IF EXISTS "+TABLE_NAME+" ";
    public Database(Context context) {
        super(context, DB_NAME, null, VERSION);
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

              sqLiteDatabase.execSQL(DROP_TABOLE);


    }
}
