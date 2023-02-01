package com.example.supermarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class RatingDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myratings.db";
    private static final int DATABASE_VERSION = 1;
    public static final String SUPERMARKET_TABLE = "SUPERMARKET_TABLE";
    public static final String COLUMN_ID = "COLUMN_ID";
    public static final String COLUMN_NAME = "COLUMN_NAME";
    public static final String COLUMN_ADDRESS = "COLUMN_ADDRESS";
    public static final String COLUMN_LIQUOR = "COLUMN_LIQUOR_RATING";
    public static final String COLUMN_PRODUCE = "COLUMN_PRODUCE_RATING";
    public static final String COLUMN_MEAT = "COLUMN_MEAT_RATING";
    public static final String COLUMN_CHEESE = "COLUMN_CHEESE_RATING";
    public static final String COLUMN_CHECKOUT = "COLUMN_CHECKOUT_RATING";
    String CREATE_TABLE_RATING  = "CREATE TABLE " + SUPERMARKET_TABLE + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT, " + COLUMN_ADDRESS + " TEXT, " + COLUMN_LIQUOR +" REAL, " + COLUMN_PRODUCE +" REAL, "
            + COLUMN_MEAT +" REAL, " + COLUMN_CHEESE +" REAL, " + COLUMN_CHECKOUT +" REAL )";


    public RatingDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RATING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(RatingDBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS rating");
        onCreate(db);
    }

    public boolean addRating(Rating rating){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME,rating.getName());
        cv.put(COLUMN_ADDRESS, rating.getAddress());
        cv.put(COLUMN_LIQUOR, rating.getLiquor());
        cv.put(COLUMN_PRODUCE, rating.getProduce());
        cv.put(COLUMN_MEAT, rating.getMeat());
        cv.put(COLUMN_CHEESE, rating.getCheese());
        cv.put(COLUMN_CHECKOUT, rating.getCheckout());
        long insert = db.insert(SUPERMARKET_TABLE, null, cv);
        if(insert == -1){
            System.out.println("Failed to add " + rating.toString());
            return false;
        }
        return true;
    }

    public ArrayList<Rating> getAllRatings(){
        ArrayList<Rating> returnList = new ArrayList<>();
        String query= ("SELECT * FROM " + SUPERMARKET_TABLE);
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                Rating newRating = new Rating(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getFloat(3),
                        cursor.getFloat(4),
                        cursor.getFloat(5),
                        cursor.getFloat(6),
                        cursor.getFloat(7)
                );
                returnList.add(newRating);
            }
            while (cursor.moveToNext());

        }
        else{

        }
        db.close();
        cursor.close();
        return returnList;
    }


}

