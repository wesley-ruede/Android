package com.wesleyruede.rest.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.wesleyruede.rest.R;
import com.wesleyruede.rest.dbutil.DBUtil;
import com.wesleyruede.rest.model.Groups;

public class DatabaseHandler extends SQLiteOpenHelper {
    //private LocalTime local_time;
    //private DateTimeFormatter dateTimeFormatter;

    public DatabaseHandler(Context context) {
        super(context, DBUtil.DATABASE_NAME,null, DBUtil.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String MONDAY_GROUP_TABLE = "CREATE TABLE " + DBUtil.MONDAY_TABLE + "("
                + DBUtil.KEY_ID + " INTEGER PRIMARY KEY,"
                + DBUtil.KEY_GROUP_NAME + " TEXT,"
                + DBUtil.KEY_GROUP_DAY + " TEXT,"
                + DBUtil.KEY_START_TIME + " TEXT,"
                + DBUtil.KEY_END_TIME + " TEXT);";
        String TUESDAY_GROUP_TABLE = "CREATE TABLE " + DBUtil.TUESDAY_TABLE + "("
                + DBUtil.KEY_ID + " INTEGER PRIMARY KEY,"
                + DBUtil.KEY_GROUP_NAME + " TEXT,"
                + DBUtil.KEY_GROUP_DAY + " TEXT,"
                + DBUtil.KEY_START_TIME + " TEXT,"
                + DBUtil.KEY_END_TIME + " TEXT);";
        String WEDNESDAY_GROUP_TABLE = "CREATE TABLE " + DBUtil.WEDNESDAY_TABLE + "("
                + DBUtil.KEY_ID + " INTEGER PRIMARY KEY,"
                + DBUtil.KEY_GROUP_NAME + " TEXT,"
                + DBUtil.KEY_GROUP_DAY + " TEXT,"
                + DBUtil.KEY_START_TIME + " TEXT,"
                + DBUtil.KEY_END_TIME + " TEXT);";
        String THURSDAY_GROUP_TABLE = "CREATE TABLE " + DBUtil.THURSDAY_TABLE + "("
                + DBUtil.KEY_ID + " INTEGER PRIMARY KEY,"
                + DBUtil.KEY_GROUP_NAME + " TEXT,"
                + DBUtil.KEY_GROUP_DAY + " TEXT,"
                + DBUtil.KEY_START_TIME + " TEXT,"
                + DBUtil.KEY_END_TIME + " TEXT);";
        String FRIDAY_GROUP_TABLE = "CREATE TABLE " + DBUtil.FRIDAY_TABLE + "("
                + DBUtil.KEY_ID + " INTEGER PRIMARY KEY,"
                + DBUtil.KEY_GROUP_NAME + " TEXT,"
                + DBUtil.KEY_GROUP_DAY + " TEXT,"
                + DBUtil.KEY_START_TIME + " TEXT,"
                + DBUtil.KEY_END_TIME + " TEXT);";
        String SATURDAY_GROUP_TABLE = "CREATE TABLE " + DBUtil.SATURDAY_TABLE + "("
                + DBUtil.KEY_ID + " INTEGER PRIMARY KEY,"
                + DBUtil.KEY_GROUP_NAME + " TEXT,"
                + DBUtil.KEY_GROUP_DAY + " TEXT,"
                + DBUtil.KEY_START_TIME + " TEXT,"
                + DBUtil.KEY_END_TIME + " TEXT);";
        String SUNDAY_GROUP_TABLE = "CREATE TABLE " + DBUtil.SUNDAY_TABLE + "("
                + DBUtil.KEY_ID + " INTEGER PRIMARY KEY,"
                + DBUtil.KEY_GROUP_NAME + " TEXT,"
                + DBUtil.KEY_GROUP_DAY + " TEXT,"
                + DBUtil.KEY_START_TIME + " TEXT,"
                + DBUtil.KEY_END_TIME + " TEXT);";

        db.execSQL(MONDAY_GROUP_TABLE);
        db.execSQL(TUESDAY_GROUP_TABLE);
        db.execSQL(WEDNESDAY_GROUP_TABLE);
        db.execSQL(THURSDAY_GROUP_TABLE);
        db.execSQL(FRIDAY_GROUP_TABLE);
        db.execSQL(SATURDAY_GROUP_TABLE);
        db.execSQL(SUNDAY_GROUP_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE = String.valueOf(R.string.db_drop);
        db.execSQL(DROP_TABLE, new String[]{DBUtil.DATABASE_NAME});
        onCreate(db);
    }

    /* CRUD */


    /* Create */
    public void mondayAddGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // Insert Row
        db.insert(DBUtil.MONDAY_TABLE,null,values);
        Log.d("DB handler", "addContact: " + "item added");
        db.close();
    }

    public void tuesdayAddGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // Insert Row
        db.insert(DBUtil.TUESDAY_TABLE,null,values);
        Log.d("DB handler", "addContact: " + "item added");
        db.close();
    }

    public void wednesdayAddGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // Insert Row
        db.insert(DBUtil.WEDNESDAY_TABLE,null,values);
        Log.d("DB handler", "addContact: " + "item added");
        db.close();
    }

    public void thursdayAddGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // Insert Row
        db.insert(DBUtil.THURSDAY_TABLE,null,values);
        Log.d("DB handler", "addContact: " + "item added");
        db.close();
    }

    public void fridayAddGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // Insert Row
        db.insert(DBUtil.FRIDAY_TABLE,null,values);
        Log.d("DB handler", "addContact: " + "item added");
        db.close();
    }

    public void saturdayAddGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // Insert Row
        db.insert(DBUtil.SATURDAY_TABLE,null,values);
        Log.d("DB handler", "addContact: " + "item added");
        db.close();
    }

    public void sundayAddGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // Insert Row
        db.insert(DBUtil.SUNDAY_TABLE,null,values);
        Log.d("DB handler", "addContact: " + "item added");
        db.close();
    }


    /* Read */
    public void getMondayGroup(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DBUtil.MONDAY_TABLE,
                new String[]{DBUtil.KEY_ID,
                        DBUtil.KEY_GROUP_NAME,
                        DBUtil.KEY_GROUP_DAY,
                        DBUtil.KEY_START_TIME,
                        DBUtil.KEY_END_TIME},
                DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(id)},null,null,null,null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Groups groups = new Groups();
        if(cursor != null) {
            groups.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBUtil.KEY_ID))));
            groups.setGroupName(cursor.getString(cursor.getColumnIndex(DBUtil.KEY_GROUP_NAME)));
            groups.setGroupDay(cursor.getString(cursor.getColumnIndex(DBUtil.KEY_GROUP_DAY)));
            groups.setGroupStartTime(cursor.getString(cursor.getColumnIndex(DBUtil.KEY_START_TIME)));
            groups.setGroupEndTime(cursor.getString(cursor.getColumnIndex(DBUtil.KEY_END_TIME)));

            /*String local = local_time.MIN.plus(Duration.ofMinutes(260L)).toString();

            // Human readable timestamp
            DateFormat dateFormat = DateFormat.getDateInstance();
            String formattedDate = dateFormat.format(new Date(cursor.getLong(
                    cursor.getColumnIndex(DBUtil.KEY_START_TIME)).getTime()); // Feb 23, 2020
            groups.setDateCreated(formattedDate);*/
        }
    }

    public void getTuesdayGroup() {

    }

    public void getWednesdayGroup() {

    }

    public void getThursdayGroup() {

    }

    public void getFridayGroup() {

    }

    public void getSaturdayGroup() {

    }

    public void getSundayGroup() {

    }

    public void getAllMondayGroups() {

    }

    public void getAllTuesdayGroups() {

    }

    public void getAllWednesdayGroups() {

    }

    public void getAllThursdayGroups() {

    }

    public void getAllFridayGroups() {

    }

    public void getAllSaturdayGroups() {

    }

    public void getAllSundayGroup() {

    }


    /* Update */
    public void updateMondayGroup() {

    }

    public void updateTuesdayGroup() {

    }

    public void updateWednesdayGroup() {

    }

    public void updateThursdayGroup() {

    }

    public void updateFridayGroup() {

    }

    public void updateSaturdayGroup() {

    }

    public void updateSundayGroup() {

    }


    /* Delete */
    public void deleteMondayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.MONDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
        db.close();
    }

    public void deleteTuesdayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.TUESDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
        db.close();
    }

    public void deleteWednesdayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.WEDNESDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
        db.close();
    }

    public void deleteThursdayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.THURSDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
        db.close();
    }

    public void deleteFridayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.FRIDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
        db.close();
    }

    public void deleteSaturdayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.SATURDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
        db.close();
    }

    public void deleteSundayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.SUNDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
        db.close();
    }


    /* Count */
    public int countMondayGroups() {
        String countQuery = "SELECT * FROM " + DBUtil.MONDAY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }

    public int countTuesdayGroups() {
        String countQuery = "SELECT * FROM " + DBUtil.TUESDAY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }

    public int countWednesdayGroups() {
        String countQuery = "SELECT * FROM " + DBUtil.WEDNESDAY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();

    }

    public int countThursdayGroups() {
        String countQuery = "SELECT * FROM " + DBUtil.THURSDAY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }

    public int countFridayGroups() {
        String countQuery = "SELECT * FROM " + DBUtil.FRIDAY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }

    public int countSaturdayGroups() {
        String countQuery = "SELECT * FROM " + DBUtil.SATURDAY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }

    public int countSundayGroups() {
        String countQuery = "SELECT * FROM " + DBUtil.SUNDAY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }
}