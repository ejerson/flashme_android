package edu.cnm.deepdive.eb.flashme3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

  public static final String DATABASE_NAME = "LIST_DECK";
  public static final String DATABASE_TABLE = "LIST_TABLE";
  public static final String DATABASE_CARD_TABLE = "CARD_TABLE";

  public static final int DATABASE_VERSION = 1;

  public static final String ID_COLUMN = "_id";
  public static final String CONTENT_COLUMN = "content";
  public static final String CARD_NAME_COLUMN = "card_name";
//  public static final String COLOR_COLUMN = "color";

  private static final String SCRIPT_CREATE_DATABASE =
      "CREATE TABLE " + DATABASE_TABLE + " (" + ID_COLUMN + " integer primary key autoincrement, "
          + CONTENT_COLUMN + " text not null)";
//  private static final String SCRIPT_CREATE_CARD_DATABASE =
//      "CREATE TABLE " + DATABASE_CARD_TABLE + " (" + ID_COLUMN + " integer primary key autoincrement, "
//          + CARD_NAME_COLUMN + " text not null)";

  public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME+".db", null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(SCRIPT_CREATE_DATABASE);
//    sqLiteDatabase.execSQL(SCRIPT_CREATE_CARD_DATABASE);


  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

  }

  // insert into my sqlite database
  public long insert(SQLiteDatabase db, String content) {  // add String color parameter if I want color back
    ContentValues contentValues = new ContentValues();
    contentValues.put(CONTENT_COLUMN, content);
    return db.insert(DATABASE_TABLE, null, contentValues);
  }

  public long insertCardName(SQLiteDatabase db, String card_name) {  // add String color parameter if I want color back
    ContentValues contentValues = new ContentValues();
    contentValues.put(CARD_NAME_COLUMN, card_name);
    return db.insert(DATABASE_CARD_TABLE, null, contentValues);
  }

}
