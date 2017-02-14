package com.example.cobouri.repertoire;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Louloutte on 06/02/2017.
 */

public class Modifier extends AppCompatActivity
{

    Long idPersonne;
    Contact base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifier);
        Intent reception = getIntent();
        idPersonne = Long.parseLong(reception.getStringExtra("select-id"));

        List<Contact> res = Contact.find(Contact.class, "id = " + idPersonne.toString());
        base = res.get(0);

        EditText etNom = (EditText) findViewById(R.id.NomM);
        EditText etPrenom = (EditText) findViewById(R.id.PrenomM);
        EditText etTel = (EditText) findViewById(R.id.TelM);

        etNom.setText(base.getNom());
        etPrenom.setText(base.getPrenom());
        etTel.setText(base.getNumber());

        Toast.makeText(getApplicationContext(), "ID "+base.getId().toString()+"!", Toast.LENGTH_LONG).show();
    }

    public void onClickModif(View v)
    {
        EditText etNom = (EditText) findViewById(R.id.NomM);
        EditText etPrenom = (EditText) findViewById(R.id.PrenomM);
        EditText etTel = (EditText) findViewById(R.id.TelM);

        String nomModif = etNom.getText().toString();
        String prenomModif = etPrenom.getText().toString();
        String telModif = etTel.getText().toString();

        // si click modif mais informations inchangée
        if(nomModif.equals(base.getNom()) && prenomModif.equals(base.getPrenom()) && telModif.equals(base.getNumber()))
        {
            Toast.makeText(getApplicationContext(), "Vous n'avez fait aucune modification !", Toast.LENGTH_LONG).show();
        }
        else
        {
            base.setNom(nomModif);
            base.setPrenom(prenomModif);
            base.setNumber(telModif);
            base.save();

            Toast.makeText(getApplicationContext(), "Modification faite !", Toast.LENGTH_LONG).show();

            finish();
        }
    }

    public void onClickSuppr(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Item");

        builder.setMessage("Voulez vous vraiment supprimer ce contact ?");
        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                base.delete();
                Toast.makeText(getApplicationContext(), "Suppression faite !", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        builder.setNegativeButton("Non", null);
        builder.show();
    }

    public void onClickRetourRecherche(View v)
    {
        finish();
    }
}
