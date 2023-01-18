package com.example.mobile_darts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAccess {

                                                //////////////////////////////////////////////////////////
                                                //CREATION, OUVERTURE ET FERMETURE DE LA BASE DE DONNEES//
                                                //////////////////////////////////////////////////////////

    private DatabaseOpenHelper openHelper;          // On declare un DatabaseopenHelper
    private SQLiteDatabase db;                      // On creer un objet sqlite db
    private static DatabaseAccess instance;
    Cursor c = null;                                // Contient le resultat d'une requete effectue sur une base


    // Constructeur prive pour ne pas pouvoir creer cette objet en dehors de la classe
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    // Retourne l instance de la classe
    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    // Ouvre la connexion de la base de donnees
    public void open() {
        this.db=openHelper.getWritableDatabase();
    }

    // Ferme la connexion de la base de donnees
    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

                                                            /////////////////////////////////////
                                                            ///REQUETE VERS LA BASE DE DONNEES///
                                                            /////////////////////////////////////
    // Envoie le nom des joueurs a la base de données
    public void setNomJoueurs(String Nom){

        ContentValues value = new ContentValues();
        value.put("Nom",Nom);
        db.insert("Joueur",null,value);
    }
    public void addJoueur(int NbJ, String Nom)
    {
        for(int i = 0; i<NbJ;i++)
        {

        }
        ContentValues value = new ContentValues();
        value.put("Nom",Nom);
        db.insert("Joueur",null,value);
    }

}

