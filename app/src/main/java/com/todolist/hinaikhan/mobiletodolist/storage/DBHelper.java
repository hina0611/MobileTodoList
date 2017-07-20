package com.todolist.hinaikhan.mobiletodolist.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by hinaikhan on 7/17/17.
 * SQLite halper to store, insert, add and delete items
 */

public class DBHelper extends SQLiteOpenHelper {

        private final static String TAG = DBHelper.class.getSimpleName();

        //Database information
        private static final String DATABASE_NAME = "postDataBaseList";
        private static final int DATABASE_VERSION = 4;
        private static final String TABLE_NAME = "lis";


        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " title text NOT NULL, " + "year text NOT NULL, " + "month text NOT NULL, " + "day text NOT NULL, " +
                    "note text," + "priority text NOT NULL, " + "status text NOT NULL)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            this.onCreate(db);
        }


        //insert list of items
        public boolean insertItems(String title, int year, int month, int day, String note, String priority, String status) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", title);
            contentValues.put("year", year);
            contentValues.put("month", month);
            contentValues.put("day", day);
            contentValues.put("note", note);
            contentValues.put("priority", priority);
            contentValues.put("status", status);
            db.insert(TABLE_NAME, null, contentValues);

            return true;
        }

        //update list of items
        public void updateItems(String id, String title, int year, int month, int day, String note, String priority, String status) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues contentsUpdateItems = new ContentValues();
            contentsUpdateItems.put("title", title);
            contentsUpdateItems.put("year", year);
            contentsUpdateItems.put("month", month);
            contentsUpdateItems.put("day", day);
            contentsUpdateItems.put("note", note);
            contentsUpdateItems.put("priority", priority);
            contentsUpdateItems.put("status", status);
            db.update(TABLE_NAME, contentsUpdateItems, "id = ?", new String[]{id});
        }

        //delete items
        public void deleteItems(String id) {
            SQLiteDatabase db = getWritableDatabase();
            db.delete(TABLE_NAME, "id = ?", new String[]{id});
        }


        public Cursor getItemList(String id) {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = ?", new String[]{id});
            return cursor;
        }


        public Cursor getAllItemList() {
            SQLiteDatabase db = getReadableDatabase();
            Cursor getCursorItems = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            return getCursorItems;
        }

}





























