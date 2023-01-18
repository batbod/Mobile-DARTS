package com.example.mobile_darts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class VuAvntPartie extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Declaration des variables
        EditText EditTextNomJ1;
        EditText EditTextNomJ2;
        EditText EditTextNomJ3;
        EditText EditTextNomJ4;
        TextView TextViewNomJ;
        Button ButtonAjout ;
        Button ButtonJouer ;
        CheckBox CheckBox301;
        CheckBox CheckBox501;
        final String[] Joueur = new String[4];


        setContentView(R.layout.activity_vu_avnt_partie);

        // Initialisation des variables

        EditTextNomJ1 = (EditText)findViewById(R.id.editTextNomJ1);
        EditTextNomJ2 = (EditText)findViewById(R.id.editTextNomJ2);
        EditTextNomJ3 = (EditText)findViewById(R.id.editTextNomJ3);
        EditTextNomJ4 = (EditText)findViewById(R.id.editTextNomJ4);
        ButtonJouer = (Button)findViewById(R.id.ButtonJouer);
        CheckBox301 = (CheckBox)findViewById(R.id.checkBox301);
        CheckBox501 = (CheckBox)findViewById(R.id.checkBox501);


        // Si la checkbox301 est clique la 501 se deselectionne
        CheckBox301.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox501.setChecked(false);
            }});

        // Si la checkbox501 est clique la 301 se deselectionne
        CheckBox501.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox301.setChecked(false);
            }});

        ButtonJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent PdntPartieActivityIntent = new Intent(VuAvntPartie.this, VuPdntPartie.class);      // Fournit une liaison d'exécution entre les deux activités
                startActivity(PdntPartieActivityIntent);                                                               // Lance la deuxième activité

                Joueur[0] = EditTextNomJ1.getText().toString();
                Joueur[1] = EditTextNomJ2.getText().toString();
                Joueur[2] = EditTextNomJ3.getText().toString();
                Joueur[3] = EditTextNomJ4.getText().toString();

                // Ouvre la base de données
                final DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
                db.open();

                for(int i = 0; i<4; i++)
                {
                    db.setNomJoueurs(Joueur[i]);
                }

            }});
    }
}