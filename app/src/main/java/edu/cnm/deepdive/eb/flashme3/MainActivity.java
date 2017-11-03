package edu.cnm.deepdive.eb.flashme3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import edu.cnm.deepdive.eb.flashme3.fragments.DeckFragment;
import edu.cnm.deepdive.eb.flashme3.fragments.DeckMemberFragment;

public class MainActivity extends AppCompatActivity {
  FragmentManager manager = getSupportFragmentManager();
  Fragment fragment = manager.findFragmentById(R.id.fragment_container);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    mainScreenDeckFragment();

//    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//    fab.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//            .setAction("Action", null).show();
//      }
//    });
  }


  private void mainScreenDeckFragment() {
    if (fragment == null) {
      fragment = new DeckFragment();
      Bundle args = new Bundle();
      fragment.setArguments(args); // bundle
      manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
  }

  public void goToDeckFragment(View view) {
    fragment = new DeckFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args); // bundle
    manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
  }

  public void goToDeckMemberFragment(View view) {
//      startActivity(new Intent(DeckActivity.this, CardActivity.class));
    fragment = new DeckMemberFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args); // bundle
    manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

  }
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
