package com.example.supermarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class RatingDatabase extends SQLiteOpenHelper {
    public static final String RATING_TABLE = "RATING_TABLE";
    public static final String COLUMN_MARKET_NAME = "MARKET_NAME";
    public static final String COLUMN_MARKET_ADDRESS = "MARKET_ADDRESS";
    public static final String COLUMN_LIQUOR_RATING = "LIQUOR_RATING";
    public static final String COLUMN_PRODUCE_RATING = "PRODUCE_RATING";
    public static final String COLUMN_MEAT_RATING = "MEAT_RATING";
    public static final String COLUMN_CHEESE_RATING = "CHEESE_RATING";
    public static final String COLUMN_CHECKOUT_RATING = "CHECKOUT_RATING";
    public static final String COLUMN_ID = "ID";

    public RatingDatabase(@Nullable Context context) {
        super(context, "rating.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + RATING_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_MARKET_NAME + " TEXT, " + COLUMN_MARKET_ADDRESS + " TEXT,  " + COLUMN_LIQUOR_RATING + " REAL, " + COLUMN_PRODUCE_RATING + " REAL, " + COLUMN_MEAT_RATING + " REAL, " + COLUMN_CHEESE_RATING + " REAL, " + COLUMN_CHECKOUT_RATING + " REAL)";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(RatingModel ratingModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_MARKET_NAME, ratingModel.getName());
        cv.put(COLUMN_MARKET_ADDRESS, ratingModel.getAddress());

        return true;
    }
}
