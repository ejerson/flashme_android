package edu.cnm.deepdive.eb.flashme3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import edu.cnm.deepdive.eb.flashme3.database.ColorCursorAdapter;
import edu.cnm.deepdive.eb.flashme3.database.DatabaseHelper;
import edu.cnm.deepdive.eb.flashme3.fragments.AddContentFragment;

public class DeckActivity extends AppCompatActivity {

  public static DatabaseHelper dbHelper;
  private ListView databaseListView;
  private SQLiteDatabase sqLiteDatabase;

  FragmentManager manager = getSupportFragmentManager();
  Fragment fragment = manager.findFragmentById(R.id.fragment_container);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_database);

    databaseListView = (ListView) findViewById(R.id.database_list);

    dbHelper = new DatabaseHelper(this);


    sqLiteDatabase = dbHelper.getReadableDatabase();

    refresh();

        databaseListView.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//        SQLiteDatabase db;
//        db = dbHelper.getWritableDatabase();
//        String str="INSERT INTO love (_id, card_name) VALUES ('10', 'yeye');";
//        db.execSQL(str);

        getAllData();
//        startActivity(new Intent(DeckActivity.this, CardActivity.class));

        // use a class that I can instantiate, which contains a way for me to get items from
        // the database

        // When a user clicks on a deck item list, they are sent to that deck's
        // fragment or activity.
                // SELECT
        //

        }
    });




  }

  public Cursor getAllData() {
    SQLiteDatabase db;
    db = dbHelper.getWritableDatabase();
    Cursor cursor = db.rawQuery("SELECT card_name FROM love WHERE _id = '1'", null);
    // TODO find a way to see if I am able to get the value of my query


    if (cursor.moveToFirst()) {
      String mValue = String.valueOf(cursor);
      Toast toast = Toast.makeText(this, mValue, Toast.LENGTH_SHORT);
      toast.show();
    }
   

    return cursor;
  }

  // query the database
  public void refresh() {
    Cursor cursor = sqLiteDatabase.query(DatabaseHelper.DATABASE_TABLE,
        new String[]{DatabaseHelper.ID_COLUMN, DatabaseHelper.CONTENT_COLUMN, /**DatabaseHelper.COLOR_COLUMN*/},
        null, null, null, null, null);

    ColorCursorAdapter cursorAdapter = new ColorCursorAdapter(this,
        cursor, true);

    databaseListView.setAdapter(cursorAdapter);
  }

  public void showAddDialog(View view) {
    AddContentFragment dialog = new AddContentFragment();
    dialog.show(getSupportFragmentManager(), "AddContentFragment");
  }

  @Override
  protected void onDestroy() {
    dbHelper.close();
    super.onDestroy();
  }
}
