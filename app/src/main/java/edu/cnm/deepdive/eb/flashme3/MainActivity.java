package edu.cnm.deepdive.eb.flashme3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import edu.cnm.deepdive.eb.flashme3.fragments.CardCreationFragment;
import edu.cnm.deepdive.eb.flashme3.fragments.DeckFragment;
import edu.cnm.deepdive.eb.flashme3.fragments.DeckMemberFragment;

// TODO create a database

public class MainActivity extends AppCompatActivity {
  FragmentManager manager = getSupportFragmentManager();
  Fragment fragment = manager.findFragmentById(R.id.fragment_container);


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mainScreenDeckFragment();

  }


  private void mainScreenDeckFragment() {
    if (fragment == null) {
      fragment = new DeckFragment();
      Bundle args = new Bundle();
      fragment.setArguments(args); // bundle
      manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

    }
  }

  public void goToDataBaseActivity(View view) {
    startActivity(new Intent(MainActivity.this, DeckActivity.class));
  }

  public void goToDeckFragment(View view) {
    fragment = new DeckFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args); // bundle
    manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
  }

  public void goToDeckMemberFragment(View view) {
    fragment = new DeckMemberFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args); // bundle
    manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

  }

  public void goToCardCreationFragment(View view) {
    fragment = new CardCreationFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args); // bundle
    manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
  }

//  public void showAddDialog(View view) {
//    AddContentFragment dialog = new AddContentFragment();
//    dialog.show(getSupportFragmentManager(), "AddContentFragment");
//  }

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
