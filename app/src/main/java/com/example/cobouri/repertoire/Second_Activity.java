package com.example.cobouri.repertoire;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Coco on 08/01/2016.
 */
public class Second_Activity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        List<Contact> listP= Contact.listAll(Contact.class);
        //Création et initialisation de l'Adapter pour les personnes
        ContactAdapter adapter = new ContactAdapter(this, listP);

        //Récupération du composant ListView
        ListView list = (ListView)findViewById(R.id.list);

        //Initialisation de la liste avec les données
        list.setAdapter(adapter);
    }
}
