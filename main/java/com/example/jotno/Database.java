package com.example.jotno;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.SubscriptSpan;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.spec.ECField;

public class Database extends SQLiteOpenHelper {

    private Context context;
    private static final String ID="id";
    private static final String DB_NAME="Tutor_information.db";
    private static final String TABLE_NAME="Tutor_info";
    private static final String NAME="Name";
    private static final String SUB="Subs";
    private static final String LOCATION="Location";
    private static final String AGE="Age";
    private static final int VERSION=2;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+LOCATION+" VARCHAR(100), "+SUB+" VARCHAR(255) );";
    private static final String DROP_TABOLE = "DROP TABLE IF EXISTS "+TABLE_NAME+" ";
    public Database(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.context=context;

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

    public long insertData(String Name,String Location,String Subs){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,Name);
        contentValues.put(LOCATION,Location);
        contentValues.put(SUB,Subs);
        long rowid = sqLiteDatabase.insert(DB_NAME,null,contentValues);
        return rowid;

    }


}
