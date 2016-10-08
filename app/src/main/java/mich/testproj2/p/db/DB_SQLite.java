package mich.testproj2.p.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.antoshka.testproject_01_10_16.model.Person;
import com.example.antoshka.testproject_01_10_16.tools.Constants;

import java.util.ArrayList;

public class DB_SQLite
{
    public DBHelper dbHelper;
    public SQLiteDatabase db;

    public DB_SQLite(Context context)
    {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void insert (Person person)
    {
        ContentValues cv = new ContentValues();
        cv.put(Constants.KEY_NAME_COLUMN, person.getName());
        cv.put(Constants.KEY_SURNAME_COLUMN, person.getSecondName());
        cv.put(Constants.KEY_AGE_COLUMN,  person.getAge());
        db.beginTransaction();
        db.insert(Constants.DB_NAME, null, cv);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public ArrayList<Person> query ()
    {
        ArrayList<Person> res = new ArrayList<Person>();
        Cursor cursor = db.query(Constants.DB_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext())
        {
            int idInd = cursor.getColumnIndex(Constants.KEY_ID);
            int ageInd = cursor.getColumnIndex(Constants.KEY_AGE_COLUMN);
            int nameInd = cursor.getColumnIndex(Constants.KEY_NAME_COLUMN);
            int surnameInd = cursor.getColumnIndex(Constants.KEY_SURNAME_COLUMN);
            Person p = new Person (cursor.getInt(idInd),cursor.getString(nameInd),cursor.getString(surnameInd),cursor.getInt(ageInd));
            res.add(p);
        }
        db.close();
        return res;
    }

    public void delete (Person person)
    {
       db.delete(Constants.DB_NAME, Constants.KEY_ID + "="+ person.getId(), null);
    }

}
