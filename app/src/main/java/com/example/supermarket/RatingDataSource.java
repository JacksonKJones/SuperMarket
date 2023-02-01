package com.example.supermarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

public class RatingDataSource {

    private SQLiteDatabase database;
    private RatingDBHelper dbHelper;

    public RatingDataSource(Context context) {
        dbHelper = new RatingDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertRating(Rating c) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("marketname", c.getName());
            initialValues.put("marketaddress", c.getAddress());
            initialValues.put("liquor", c.getLiquor());
            initialValues.put("produce", c.getProduce());
            initialValues.put("meat", c.getMeat());
            initialValues.put("cheese", c.getCheese());
            initialValues.put("checkout", c.getCheckout());

            didSucceed = database.insert("rating", null, initialValues) > 0;
        }
        catch (Exception e) {

        }
        return didSucceed;
    }

    public boolean updateRating(Rating c) {
        boolean didSucceed = false;
        try {
            Long rowID = (long) c.getRatingID();
            ContentValues updateValues = new ContentValues();

            updateValues.put("marketname", c.getName());
            updateValues.put("marketaddress", c.getAddress());
            updateValues.put("liquor", c.getLiquor());
            updateValues.put("produce", c.getProduce());
            updateValues.put("meat", c.getMeat());
            updateValues.put("cheese", c.getCheese());
            updateValues.put("checkout", c.getCheckout());

            didSucceed = database.update("rating", updateValues, "_id=" + rowID, null) > 0;
        }
        catch (Exception e) {

        }
        return didSucceed;
    }

    public int getLastRatingID() {
        int lastId;
        try {
            String query = "Select MAX(_id) from rating";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        }
        catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }
}
