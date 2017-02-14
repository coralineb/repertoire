package com.example.cobouri.repertoire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by Louloutte on 17/01/2017.
 */
public class AfficherContact extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichercontact);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name"); //"florent
        EditText nom = (EditText) findViewById(R.id.editnom);
        nom.setText(name);

    }
}
