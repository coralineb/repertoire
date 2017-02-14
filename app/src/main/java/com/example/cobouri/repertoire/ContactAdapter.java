package com.example.cobouri.repertoire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobouri on 12/01/2017.
 */
public class ContactAdapter extends BaseAdapter {
    private List<Contact> mListP;
    private Context mContext;
    private LayoutInflater mInflater;
    //Contient la liste des listeners

    public ContactAdapter(Context context, List<Contact> aListP) {
        mContext = context;
        mListP = aListP;
        mInflater = LayoutInflater.from(mContext);
    }

    public int getCount() {
        return mListP.size();
    }

    public Object getItem(int position) {
        return mListP.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        if (convertView == null) {
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.contactbd, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView Nom = (TextView)layoutItem.findViewById(R.id.nom);
        TextView Prenom = (TextView)layoutItem.findViewById(R.id.prenom);
        TextView Number = (TextView)layoutItem.findViewById(R.id.num);
        TextView Id = (TextView)layoutItem.findViewById(R.id.id);

        //(3) : Renseignement des valeurs
        Nom.setText(mListP.get(position).getNom());
        Prenom.setText(mListP.get(position).getPrenom());
        Number.setText(mListP.get(position).getNumber());
        Id.setText(mListP.get(position).getId().toString());


        //On retourne l'item créé.
        return layoutItem;
    }


}
