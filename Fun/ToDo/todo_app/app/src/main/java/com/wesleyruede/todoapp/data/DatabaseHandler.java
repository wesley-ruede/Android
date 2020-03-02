package com.wesleyruede.todoapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.wesleyruede.todoapp.model.Item;
import com.wesleyruede.todoapp.util.Constants;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private final Context context;
    public DatabaseHandler(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_ITEM_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY,"
                + Constants.KEY_ITEM_NAME + " INTEGER,"
                + Constants.KEY_ITEM_COLOR + " TEXT, "
                + Constants.KEY_ITEM_AMOUNT + " INTEGER,"
                + Constants.KEY_ITEM_SIZE + " INTEGER,"
                + Constants.KEY_DATE_ADDED + " LONG);";
        db.execSQL(CREATE_ITEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }

    /* CRUD */

    public void addItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.KEY_ITEM_NAME, item.getItemName());
        values.put(Constants.KEY_ITEM_AMOUNT, item.getItemAmount());
        values.put(Constants.KEY_ITEM_COLOR, item.getItemColor());
        values.put(Constants.KEY_ITEM_SIZE, item.getItemSize());
        values.put(Constants.KEY_DATE_ADDED, java.lang.System.currentTimeMillis()); // system timestamp

        // Insert the row
        db.insert(Constants.TABLE_NAME,null,values);
        Log.d("DBHandler", "addItem: " + item.getId());
    }

    public Item getItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME,
                new String[]{Constants.KEY_ID,
                        Constants.KEY_ITEM_NAME,
                        Constants.KEY_ITEM_AMOUNT,
                        Constants.KEY_ITEM_COLOR,
                        Constants.KEY_ITEM_SIZE,
                        Constants.KEY_DATE_ADDED},
                Constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)},null,null,null,null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Item item = new Item();
        if(cursor != null) {
            item.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
            item.setItemName(cursor.getString(cursor.getColumnIndex(Constants.KEY_ITEM_NAME)));
            item.setItemAmount(cursor.getInt(cursor.getColumnIndex(Constants.KEY_ITEM_AMOUNT)));
            item.setItemSize(cursor.getInt(cursor.getColumnIndex(Constants.KEY_ITEM_SIZE)));
            item.setItemColor(cursor.getString(cursor.getColumnIndex(Constants.KEY_ITEM_COLOR)));
            // Get a human readable timestamp
            DateFormat dateFormat = DateFormat.getDateInstance();
            String formattedDate = dateFormat.format(new Date(cursor.getLong(
                    cursor.getColumnIndex(Constants.KEY_DATE_ADDED))).getTime()); // Feb 23, 2020
            item.setDateCreated(formattedDate);
        }
        return item;

    }

    public List<Item> getAllItems() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Item> itemList = new ArrayList<>();

        Cursor cursor = db.query(Constants.TABLE_NAME,new String[]{
                Constants.KEY_ID,Constants.KEY_ITEM_NAME,Constants.KEY_ITEM_AMOUNT,
                Constants.KEY_ITEM_SIZE,Constants.KEY_DATE_ADDED},
                null,null,null,null,
                Constants.KEY_DATE_ADDED + " DESC");

        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
                item.setItemName(cursor.getString(cursor.getColumnIndex(Constants.KEY_ITEM_NAME)));
                item.setItemAmount(cursor.getInt(cursor.getColumnIndex(Constants.KEY_ITEM_AMOUNT)));
                item.setItemSize(cursor.getInt(cursor.getColumnIndex(Constants.KEY_ITEM_SIZE)));
                DateFormat dateFormat = DateFormat.getDateInstance();
                String formattedDate = dateFormat.format(new Date(cursor.getLong(
                        cursor.getColumnIndex(Constants.KEY_DATE_ADDED))).getTime()); // Feb 23, 2020
                item.setDateCreated(formattedDate);

                // Add to arrayList
                itemList.add(item);
            } while (cursor.moveToFirst());
        }
        cursor.close();
        return itemList;
    }

    public int updateItem(Item item) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.KEY_ITEM_NAME, item.getItemName());
        values.put(Constants.KEY_ITEM_AMOUNT, item.getItemAmount());
        values.put(Constants.KEY_ITEM_COLOR, item.getItemColor());
        values.put(Constants.KEY_ITEM_SIZE, item.getItemSize());
        values.put(Constants.KEY_DATE_ADDED, java.lang.System.currentTimeMillis());

        return db.update(Constants.TABLE_NAME,values,Constants.KEY_ID + "=?",
                new String[]{String.valueOf(item.getId())});
    }

    public void deleteItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Constants.TABLE_NAME,Constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    public int getItemCount() {
        String countQuery = "SELECT * FROM " + Constants.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }
}
