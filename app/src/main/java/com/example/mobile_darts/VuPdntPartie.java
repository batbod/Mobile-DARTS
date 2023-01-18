package com.example.mobile_darts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VuPdntPartie extends AppCompatActivity {

    Button ButtonPause ;
    Button ButtonArreter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vu_pdnt_partie);

        ButtonPause = (Button)findViewById(R.id.buttonPause);
        ButtonArreter = (Button)findViewById(R.id.buttonArreter);

        ButtonArreter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent AvntPartieActivityIntent = new Intent(VuPdntPartie.this, VuAvntPartie.class);      // Fournit une liaison d'exécution entre les deux activités
                startActivity(AvntPartieActivityIntent);                                                               // Lance la première activité

            }});
    }
}