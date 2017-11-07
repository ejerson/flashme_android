package edu.cnm.deepdive.eb.flashme3;

import static edu.cnm.deepdive.eb.flashme3.DeckActivity.dbHelper;

import android.database.sqlite.SQLiteDatabase;

public class DeckClass {

  private String cardName;

  // TODO create a way for each deck to be populated with card content


  public DeckClass(String cardName) {
    this.cardName = cardName;
  }

  public String getCardName() {
    return cardName;
  }

  public void setCardName(String cardName) {
        SQLiteDatabase db;
        db = dbHelper.getReadableDatabase();
        String str="SELECT card_name FROM love ";
        db.execSQL(str);

  }
}
