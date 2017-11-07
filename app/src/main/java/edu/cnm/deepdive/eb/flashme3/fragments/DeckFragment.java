package edu.cnm.deepdive.eb.flashme3.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.cnm.deepdive.eb.flashme3.R;

public class DeckFragment extends Fragment {

  Button addDeck;
  EditText deckName;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.content_main_fragment, container, false);
    addDeck = view.findViewById(R.id.id_search_button);
    deckName = view.findViewById(R.id.id_search_EditText);

    addDeck.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Toast.makeText(getActivity(), deckName.getText().toString(), Toast.LENGTH_SHORT).show();
      }
    });

    return view;

  }




}

