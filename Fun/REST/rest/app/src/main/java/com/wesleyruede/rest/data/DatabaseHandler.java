package com.wesleyruede.rest.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.wesleyruede.rest.R;
import com.wesleyruede.rest.dbutil.DBUtil;
import com.wesleyruede.rest.model.Groups;
import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, DBUtil.DATABASE_NAME,null, DBUtil.DATABASE_VERSION);
        AndroidThreeTen.init(context);
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

    public void getMondayGroup(int mon_id) {
        SQLiteDatabase monday_query = this.getReadableDatabase();

        Cursor cursor = monday_query.query(DBUtil.MONDAY_TABLE,
                new String[]{DBUtil.KEY_ID,
                        DBUtil.KEY_GROUP_NAME,
                        DBUtil.KEY_GROUP_DAY,
                        DBUtil.KEY_START_TIME,
                        DBUtil.KEY_END_TIME},
                DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(mon_id)},null,null,null,null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Groups groups = new Groups();
        if(cursor != null) {
            groups.setId(Integer.parseInt(cursor.getString(cursor
                    .getColumnIndex(DBUtil.KEY_ID))));
            groups.setGroupName(cursor.getString(cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_NAME)));
            groups.setGroupDay(cursor.getString(cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_DAY)));

            LocalTime group_start_time = LocalTime.MIN.plusMinutes(150);
            String formatted_start_time = group_start_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(cursor.getLong(cursor
                            .getColumnIndex(DBUtil.KEY_START_TIME)))));
            groups.setGroupStartTime(formatted_start_time);

            LocalTime group_end_time = LocalTime.MIN.plusMinutes(0);
            String formatted_end_time = group_end_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(cursor.getLong(cursor
                            .getColumnIndex(DBUtil.KEY_END_TIME)))));
            groups.setGroupEndTime(formatted_end_time);
        }
    }

    public void getTuesdayGroup(int tues_id) {
        SQLiteDatabase tuesday_query = this.getReadableDatabase();

        Cursor tuesday_cursor = tuesday_query.query(DBUtil.TUESDAY_TABLE,
                new String[]{DBUtil.KEY_ID,
                        DBUtil.KEY_GROUP_NAME,
                        DBUtil.KEY_GROUP_DAY,
                        DBUtil.KEY_START_TIME,
                        DBUtil.KEY_END_TIME},
                DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(tues_id)},null,null,null,null);

        if (tuesday_cursor != null) {
            tuesday_cursor.moveToFirst();
        }

        Groups groups = new Groups();
        if(tuesday_cursor != null) {
            groups.setId(Integer.parseInt(tuesday_cursor.getString(tuesday_cursor
                    .getColumnIndex(DBUtil.KEY_ID))));
            groups.setGroupName(tuesday_cursor.getString(tuesday_cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_NAME)));
            groups.setGroupDay(tuesday_cursor.getString(tuesday_cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_DAY)));

            LocalTime group_start_time = LocalTime.MIN.plusMinutes(150);
            String formatted_start_time = group_start_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(tuesday_cursor.getLong(tuesday_cursor
                            .getColumnIndex(DBUtil.KEY_START_TIME)))));
            groups.setGroupStartTime(formatted_start_time);

            LocalTime group_end_time = LocalTime.MIN.plusMinutes(0);
            String formatted_end_time = group_end_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(tuesday_cursor.getLong(tuesday_cursor
                            .getColumnIndex(DBUtil.KEY_END_TIME)))));
            groups.setGroupEndTime(formatted_end_time);
        }
    }

    public void getWednesdayGroup(int wed_id) {
            SQLiteDatabase monday_query = this.getReadableDatabase();

            Cursor wednesday_cursor = monday_query.query(DBUtil.WEDNESDAY_TABLE,
                    new String[]{DBUtil.KEY_ID,
                            DBUtil.KEY_GROUP_NAME,
                            DBUtil.KEY_GROUP_DAY,
                            DBUtil.KEY_START_TIME,
                            DBUtil.KEY_END_TIME},
                    DBUtil.KEY_ID + "=?",
                    new String[]{String.valueOf(wed_id)},null,null,null,null);

            if (wednesday_cursor != null) {
                wednesday_cursor.moveToFirst();
            }

            Groups wed_groups = new Groups();
            if(wednesday_cursor != null) {
                wed_groups.setId(Integer.parseInt(wednesday_cursor.getString(wednesday_cursor
                        .getColumnIndex(DBUtil.KEY_ID))));
                wed_groups.setGroupName(wednesday_cursor.getString(wednesday_cursor
                        .getColumnIndex(DBUtil.KEY_GROUP_NAME)));
                wed_groups.setGroupDay(wednesday_cursor.getString(wednesday_cursor
                        .getColumnIndex(DBUtil.KEY_GROUP_DAY)));

                LocalTime group_start_time = LocalTime.MIN.plusMinutes(150);
                String formatted_start_time = group_start_time.format(DateTimeFormatter.ofPattern(
                        String.valueOf(wednesday_cursor.getLong(wednesday_cursor
                                .getColumnIndex(DBUtil.KEY_START_TIME)))));
                wed_groups.setGroupStartTime(formatted_start_time);

                LocalTime group_end_time = LocalTime.MIN.plusMinutes(0);

                String formatted_end_time = group_end_time.format(DateTimeFormatter.ofPattern(
                        String.valueOf(wednesday_cursor.getLong(wednesday_cursor
                                .getColumnIndex(DBUtil.KEY_END_TIME)))));
                wed_groups.setGroupEndTime(formatted_end_time);
            }
    }

    public void getThursdayGroup(int thur_id) {
        SQLiteDatabase monday_query = this.getReadableDatabase();

        Cursor thur_cursor = monday_query.query(DBUtil.THURSDAY_TABLE,
                new String[]{DBUtil.KEY_ID,
                        DBUtil.KEY_GROUP_NAME,
                        DBUtil.KEY_GROUP_DAY,
                        DBUtil.KEY_START_TIME,
                        DBUtil.KEY_END_TIME},
                DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(thur_id)},null,null,null,null);

        if (thur_cursor != null) {
            thur_cursor.moveToFirst();
        }

        Groups thur_groups = new Groups();
        if(thur_cursor != null) {
            thur_groups.setId(Integer.parseInt(thur_cursor.getString(thur_cursor
                    .getColumnIndex(DBUtil.KEY_ID))));
            thur_groups.setGroupName(thur_cursor.getString(thur_cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_NAME)));
            thur_groups.setGroupDay(thur_cursor.getString(thur_cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_DAY)));

            LocalTime group_start_time = LocalTime.MIN.plusMinutes(150);
            String formatted_start_time = group_start_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(thur_cursor.getLong(thur_cursor
                            .getColumnIndex(DBUtil.KEY_START_TIME)))));
            thur_groups.setGroupStartTime(formatted_start_time);

            LocalTime group_end_time = LocalTime.MIN.plusMinutes(0);

            String formatted_end_time = group_end_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(thur_cursor.getLong(thur_cursor
                            .getColumnIndex(DBUtil.KEY_END_TIME)))));
            thur_groups.setGroupEndTime(formatted_end_time);
        }
    }

    public void getFridayGroup(int fri_id) {
        SQLiteDatabase monday_query = this.getReadableDatabase();

        Cursor thur_cursor = monday_query.query(DBUtil.FRIDAY_TABLE,
                new String[]{DBUtil.KEY_ID,
                        DBUtil.KEY_GROUP_NAME,
                        DBUtil.KEY_GROUP_DAY,
                        DBUtil.KEY_START_TIME,
                        DBUtil.KEY_END_TIME},
                DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(fri_id)},null,null,null,null);

        if (thur_cursor != null) {
            thur_cursor.moveToFirst();
        }

        Groups thur_groups = new Groups();
        if(thur_cursor != null) {
            thur_groups.setId(Integer.parseInt(thur_cursor.getString(thur_cursor
                    .getColumnIndex(DBUtil.KEY_ID))));
            thur_groups.setGroupName(thur_cursor.getString(thur_cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_NAME)));
            thur_groups.setGroupDay(thur_cursor.getString(thur_cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_DAY)));

            LocalTime group_start_time = LocalTime.MIN.plusMinutes(150);
            String formatted_start_time = group_start_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(thur_cursor.getLong(thur_cursor
                            .getColumnIndex(DBUtil.KEY_START_TIME)))));
            thur_groups.setGroupStartTime(formatted_start_time);

            LocalTime group_end_time = LocalTime.MIN.plusMinutes(0);

            String formatted_end_time = group_end_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(thur_cursor.getLong(thur_cursor
                            .getColumnIndex(DBUtil.KEY_END_TIME)))));
            thur_groups.setGroupEndTime(formatted_end_time);
        }
    }

    public void getSaturdayGroup(int sat_id) {
        SQLiteDatabase monday_query = this.getReadableDatabase();

        Cursor sat_cursor = monday_query.query(DBUtil.SATURDAY_TABLE,
                new String[]{DBUtil.KEY_ID,
                        DBUtil.KEY_GROUP_NAME,
                        DBUtil.KEY_GROUP_DAY,
                        DBUtil.KEY_START_TIME,
                        DBUtil.KEY_END_TIME},
                DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(sat_id)},null,null,null,null);

        if (sat_cursor != null) {
            sat_cursor.moveToFirst();
        }

        Groups sat_groups = new Groups();
        if(sat_cursor != null) {
            sat_groups.setId(Integer.parseInt(sat_cursor.getString(sat_cursor
                    .getColumnIndex(DBUtil.KEY_ID))));
            sat_groups.setGroupName(sat_cursor.getString(sat_cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_NAME)));
            sat_groups.setGroupDay(sat_cursor.getString(sat_cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_DAY)));

            LocalTime group_start_time = LocalTime.MIN.plusMinutes(150);
            String formatted_start_time = group_start_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(sat_cursor.getLong(sat_cursor
                            .getColumnIndex(DBUtil.KEY_START_TIME)))));
            sat_groups.setGroupStartTime(formatted_start_time);

            LocalTime group_end_time = LocalTime.MIN.plusMinutes(0);

            String formatted_end_time = group_end_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(sat_cursor.getLong(sat_cursor
                            .getColumnIndex(DBUtil.KEY_END_TIME)))));
            sat_groups.setGroupEndTime(formatted_end_time);
        }
    }

    public void getSundayGroup(int sun_id) {
        SQLiteDatabase monday_query = this.getReadableDatabase();

        Cursor sun_cursor = monday_query.query(DBUtil.SUNDAY_TABLE,
                new String[]{DBUtil.KEY_ID,
                        DBUtil.KEY_GROUP_NAME,
                        DBUtil.KEY_GROUP_DAY,
                        DBUtil.KEY_START_TIME,
                        DBUtil.KEY_END_TIME},
                DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(sun_id)},null,null,null,null);

        if (sun_cursor != null) {
            sun_cursor.moveToFirst();
        }

        Groups sun_groups = new Groups();
        if(sun_cursor != null) {
            sun_groups.setId(Integer.parseInt(sun_cursor.getString(sun_cursor
                    .getColumnIndex(DBUtil.KEY_ID))));
            sun_groups.setGroupName(sun_cursor.getString(sun_cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_NAME)));
            sun_groups.setGroupDay(sun_cursor.getString(sun_cursor
                    .getColumnIndex(DBUtil.KEY_GROUP_DAY)));

            LocalTime group_start_time = LocalTime.MIN.plusMinutes(150);
            String formatted_start_time = group_start_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(sun_cursor.getLong(sun_cursor
                            .getColumnIndex(DBUtil.KEY_START_TIME)))));
            sun_groups.setGroupStartTime(formatted_start_time);

            LocalTime group_end_time = LocalTime.MIN.plusMinutes(0);

            String formatted_end_time = group_end_time.format(DateTimeFormatter.ofPattern(
                    String.valueOf(sun_cursor.getLong(sun_cursor
                            .getColumnIndex(DBUtil.KEY_END_TIME)))));
            sun_groups.setGroupEndTime(formatted_end_time);
        }
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

    public int updateMondayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // update the row
        // update(table_name,values,where id = 43)
        return  db.update(DBUtil.MONDAY_TABLE,values,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
    }

    public int updateTuesdayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // update the row
        // update(table_name,values,where id = 43)
        return  db.update(DBUtil.TUESDAY_TABLE,values,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
    }

    public int updateWednesdayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // update the row
        // update(table_name,values,where id = 43)
        return  db.update(DBUtil.WEDNESDAY_TABLE,values,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
    }

    public int updateThursdayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // update the row
        // update(table_name,values,where id = 43)
        return  db.update(DBUtil.THURSDAY_TABLE,values,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
    }

    public int updateFridayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // update the row
        // update(table_name,values,where id = 43)
        return  db.update(DBUtil.FRIDAY_TABLE,values,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
    }

    public int updateSaturdayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // update the row
        // update(table_name,values,where id = 43)
        return  db.update(DBUtil.SATURDAY_TABLE,values,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
    }

    public int updateSundayGroup(Groups groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBUtil.KEY_GROUP_NAME,groups.getGroupName());
        values.put(DBUtil.KEY_GROUP_DAY,groups.getGroupDay());
        values.put(DBUtil.KEY_START_TIME,groups.getGroupStartTime());
        values.put(DBUtil.KEY_END_TIME,groups.getGroupEndTime());

        // update the row
        // update(table_name,values,where id = 43)
        return  db.update(DBUtil.SUNDAY_TABLE,values,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(groups.getId())});
    }


    /* Delete */
    public void deleteMondayGroup(Groups wed_groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.MONDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(wed_groups.getId())});
        db.close();
    }

    public void deleteTuesdayGroup(Groups wed_groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.TUESDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(wed_groups.getId())});
        db.close();
    }

    public void deleteWednesdayGroup(Groups wed_groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.WEDNESDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(wed_groups.getId())});
        db.close();
    }

    public void deleteThursdayGroup(Groups wed_groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.THURSDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(wed_groups.getId())});
        db.close();
    }

    public void deleteFridayGroup(Groups wed_groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.FRIDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(wed_groups.getId())});
        db.close();
    }

    public void deleteSaturdayGroup(Groups wed_groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.SATURDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(wed_groups.getId())});
        db.close();
    }

    public void deleteSundayGroup(Groups wed_groups) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DBUtil.SUNDAY_TABLE,DBUtil.KEY_ID + "=?",
                new String[]{String.valueOf(wed_groups.getId())});
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