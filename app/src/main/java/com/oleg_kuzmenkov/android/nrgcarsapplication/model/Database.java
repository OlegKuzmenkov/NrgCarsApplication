package com.oleg_kuzmenkov.android.nrgcarsapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

public class Database extends SQLiteOpenHelper {
    // Car table
    static final String TABLE_CAR = "cars";
    static final String COLUMN_CAR_MODEL = "car_model";
    static final String COLUMN_CREATION_DATE = "creation_date";
    static final String COLUMN_TOP_SPEED = "top_speed";
    static final String COLUMN_PRICE = "price";

    private static final String COLUMN_CAR_ID = "_id";
    private  static final String COLUMN_DETAILS = "details";

    // Car table creation SQL statement
    private static final String TABLE_QUESTION_CREATE = "create table "
            + TABLE_CAR
            + "("
            + COLUMN_CAR_ID + " integer primary key autoincrement, "
            + COLUMN_CAR_MODEL + " text, "
            + COLUMN_CREATION_DATE + " text,"
            + COLUMN_TOP_SPEED + " text,"
            + COLUMN_PRICE + " text,"
            + COLUMN_DETAILS + " text"
            + ");";


    private static final String DATABASE_NAME = "questions.db";
    private static final int DATABASE_VERSION = 1;

    Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_QUESTION_CREATE);
        addCars(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * Add cars to database
     */
    private void addCars(@NonNull final SQLiteDatabase sqLiteDatabase) {
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CAR_MODEL, "Acura NSX");
        cv.put(COLUMN_CREATION_DATE, "2010");
        cv.put(COLUMN_TOP_SPEED, "306");
        cv.put(COLUMN_PRICE, "33 700");
        cv.put(COLUMN_DETAILS, "Very good choice");
        sqLiteDatabase.insert(TABLE_CAR, null, cv);

        cv.put(COLUMN_CAR_MODEL, "BMV M6");
        cv.put(COLUMN_CREATION_DATE, "2011");
        cv.put(COLUMN_TOP_SPEED, "300");
        cv.put(COLUMN_PRICE, "29 400");
        cv.put(COLUMN_DETAILS, "Very good choice");
        sqLiteDatabase.insert(TABLE_CAR, null, cv);

        cv.put(COLUMN_CAR_MODEL, "Honda Accord");
        cv.put(COLUMN_CREATION_DATE, "2014");
        cv.put(COLUMN_TOP_SPEED, "250");
        cv.put(COLUMN_PRICE, "18 500");
        cv.put(COLUMN_DETAILS, "Normal choice");
        sqLiteDatabase.insert(TABLE_CAR, null, cv);

        cv.put(COLUMN_CAR_MODEL, "Lamborgini Aventador");
        cv.put(COLUMN_CREATION_DATE, "2017");
        cv.put(COLUMN_TOP_SPEED, "350");
        cv.put(COLUMN_PRICE, "230 000");
        cv.put(COLUMN_DETAILS, "Crazy choice");
        sqLiteDatabase.insert(TABLE_CAR, null, cv);

        cv.put(COLUMN_CAR_MODEL, "Audi SQ5");
        cv.put(COLUMN_CREATION_DATE, "2016");
        cv.put(COLUMN_TOP_SPEED, "260");
        cv.put(COLUMN_PRICE, "40 000");
        cv.put(COLUMN_DETAILS, "Good choice");
        sqLiteDatabase.insert(TABLE_CAR, null, cv);

        cv.put(COLUMN_CAR_MODEL, "Mercedez E");
        cv.put(COLUMN_CREATION_DATE, "2014");
        cv.put(COLUMN_TOP_SPEED, "239");
        cv.put(COLUMN_PRICE, "14 000");
        cv.put(COLUMN_DETAILS, "Good choice");
        sqLiteDatabase.insert(TABLE_CAR, null, cv);

        cv.put(COLUMN_CAR_MODEL, "Volkswagen Passat");
        cv.put(COLUMN_CREATION_DATE, "2016");
        cv.put(COLUMN_TOP_SPEED, "232");
        cv.put(COLUMN_PRICE, "22 000");
        cv.put(COLUMN_DETAILS, "Normal choice");
        sqLiteDatabase.insert(TABLE_CAR, null, cv);

        cv.put(COLUMN_CAR_MODEL, "Ferrari California");
        cv.put(COLUMN_CREATION_DATE, "2014");
        cv.put(COLUMN_TOP_SPEED, "315");
        cv.put(COLUMN_PRICE, "144 000");
        cv.put(COLUMN_DETAILS, "Best choice");
        sqLiteDatabase.insert(TABLE_CAR, null, cv);

        cv.put(COLUMN_CAR_MODEL, "Ford Escape");
        cv.put(COLUMN_CREATION_DATE, "2012");
        cv.put(COLUMN_TOP_SPEED, "160");
        cv.put(COLUMN_PRICE, "12 400");
        cv.put(COLUMN_DETAILS, "Very Good choice");
        sqLiteDatabase.insert(TABLE_CAR, null, cv);

        cv.put(COLUMN_CAR_MODEL, "Mitsubishi Lancer");
        cv.put(COLUMN_CREATION_DATE, "2015");
        cv.put(COLUMN_TOP_SPEED, "230");
        cv.put(COLUMN_PRICE, "19 000");
        cv.put(COLUMN_DETAILS, "Good choice");
        sqLiteDatabase.insert(TABLE_CAR, null, cv);
    }
}
