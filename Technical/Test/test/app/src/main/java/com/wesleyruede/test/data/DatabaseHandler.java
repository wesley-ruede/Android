package com.wesleyruede.test.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.wesleyruede.test.R;
import com.wesleyruede.test.model.Journal;
import com.wesleyruede.test.util.Util;

public class DatabaseHandler extends SQLiteOpenHelper {
    private Context context;

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }
    
    /* Create a table in the database*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        
        String CREATE_JOURNAL_TABLE = "CREATE TABLE " + Util.TABLE_NAME  +"("
                + Util.KEY_ID + " INTEGER PRIMARY KEY,"
                + Util.KEY_ENTRY + " TEXT" + ")";
        db.execSQL(CREATE_JOURNAL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE = String.valueOf(R.string.drop_table);
        db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});
        onCreate(db);
    }

    /* CRUD */

    public void addEntry(Journal journal) {
        //Todo: get a writable database
        //Todo: instantiate ContentValues
        //Todo: create a relation between key and value
        //Todo: inert values to table
        //Todo: close

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_ENTRY,journal.getJournalEntry());
        db.insert(Util.TABLE_NAME,null,values);
        db.close();
    }

    public void deleteEntry(Journal journal) {
        //Todo: get a writable database
        //Todo: call delete method. pass table,id,query,string[]of journal id's
        //Todo: close

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME,Util.KEY_ID+ "=?",
                new String[]{String.valueOf(journal.getId())});
        db.close();
    }

    public Journal getEntry(int id) {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME,new String[]{Util.KEY_ID,Util.KEY_ENTRY},
                Util.KEY_ID + "=?",new String[]{String.valueOf(id)},
                null,null,null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Journal journal = new Journal();
        journal.setId(Integer.parseInt(cursor.getString(0)));
        journal.setJournalEntry(cursor.getString(1));
        cursor.close();

        return journal;
    }
}
