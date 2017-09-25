package droidmentor.PoliticTeens_Client.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import droidmentor.PoliticTeens_Client.R;
import droidmentor.PoliticTeens_Client.S;


/**
 * A simple {@link Fragment} subclass.
 */
public class CongressFragment extends Fragment {


    private DatabaseReference mDatabase;
    TextView month_agenda;
    DataSnapshot dataSnapshot;
    String month_agenda_string = "";

    public CongressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("1","tq");
        View view = inflater.inflate(R.layout.fragment_congress, container, false);

        month_agenda = (TextView)view.findViewById(R.id.month_agenda_content);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                month_agenda_string = dataSnapshot.child("month_agenda").getValue(String.class);
                month_agenda.setText(month_agenda_string);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        Log.d("tq",month_agenda_string+"gaga"+mDatabase.child("month_agenda"));
        return view;
    }

}
