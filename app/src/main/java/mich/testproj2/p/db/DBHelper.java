package mich.testproj2.p.db;

/**
 * Created by michigan on 10/07/2016.
 */
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import mich.testproj2.p.Tools.Config;

/**
 * Created by Antoshka on 03.10.2016.
 */

public class DBHelper extends SQLiteOpenHelper
{

    public DBHelper(Context context)
    {
        super(context, Config.DB_NAME, null, Config.DB_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler)
    {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.d(Config.LOG_TAG, "--- onCreate database ---");
        db.execSQL("create table " + Config.DB_NAME + " ("
                + Config.KEY_ID + " integer primary key autoincrement,"
                + Config.KEY_NAME_COLUMN + " text,"
                + Config.KEY_SURNAME_COLUMN + " text,"
                + Config.KEY_AGE_COLUMN + " integer"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}