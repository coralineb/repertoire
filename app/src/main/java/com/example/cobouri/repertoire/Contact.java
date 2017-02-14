package com.example.cobouri.repertoire;

import com.orm.SugarRecord;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by cobouri on 12/01/2017.
 */
public class Contact extends SugarRecord{
    String nom;
    String prenom;
    String number;

    public Contact() {
    }

    public Contact(String nom, String prenom, String number) {
        this.nom = nom;
        this.prenom = prenom;
        this.number = number;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", number='" + number + '\'' +
                '}';
    }


}
