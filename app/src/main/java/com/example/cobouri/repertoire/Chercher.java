package com.example.cobouri.repertoire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobouri on 12/01/2017.
 */
public class Chercher extends AppCompatActivity {

    private List<Contact> lContact;
    private List<Contact> lRes;
    private ContactAdapter adapter;
    private ListView list;

    public class ListClickHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            TextView tvID = (TextView) view.findViewById(R.id.id);
            String text = tvID.getText().toString();
            Intent intent = new Intent(parent.getContext(), Modifier.class);
            intent.putExtra("select-id", text);
            startActivity(intent);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chercher);
        lContact = new ArrayList<>();
        lRes = new ArrayList();
        adapter = new ContactAdapter(this, lContact);
        list = (ListView)findViewById(R.id.listbd);

        //Initialisation de la liste avec les données
        list.setAdapter(adapter);
        list.setOnItemClickListener(new ListClickHandler());
        EditText lname = (EditText) findViewById(R.id.slname);
        lname.setText("");

    }


    private void recherche()
    {
        lContact.clear();
        lRes.clear();
        EditText recherche=(EditText) findViewById(R.id.slname); // Recherche
        list = (ListView)findViewById(R.id.listbd);
        lRes = (ArrayList<Contact>) Contact.find(Contact.class, "nom LIKE '%"
                + recherche.getText() + "%' OR prenom LIKE '%" + recherche.getText()+"%'" );

        if(lRes.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Aucun résultat", Toast.LENGTH_LONG).show();
            list.setVisibility(View.INVISIBLE);
        }
        else {

            for (Contact lRe : lRes) {
                lContact.add(lRe);
            }
            adapter.notifyDataSetChanged();
            list.setVisibility(View.VISIBLE);
        }
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
        recherche();


    }

    public void ClickChercher(View v)
    {
        try
        {
            recherche();
        }
        catch (Exception e){
            Log.e("Main : ", e.toString());
        }
    }
}
