package com.shiifu.agenda.agendaics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.shiifu.agenda.agendaics.EvenementBdd;

import java.util.ArrayList;

public class EdtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edt);

        EvenementBdd evenementBdd = new EvenementBdd(this);
        evenementBdd.openForRead();

        ArrayList<String> evenements = evenementBdd.getAllEventString();
        if (evenements != null) {
            evenementBdd.close();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, evenements);
            ListView list = (ListView) findViewById(R.id.listViewEdt);
            list.setAdapter(adapter);
        }
        else {
            // add message for user
            Toast.makeText(this, "La base de données est vide, synchronisez puis revenez.", Toast.LENGTH_SHORT).show();
        }
    }
}
