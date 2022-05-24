package com.example.dvdloc_js;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Recherche extends AppCompatActivity {

    //définition de 2 attributs privés
    private Button btnRecherche;
    private EditText edtRecherche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);

        edtRecherche = findViewById(R.id.edtRecherche);
        btnRecherche = findViewById(R.id.btnRecherche);


        btnRecherche.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View view){
                //Toast toast = Toast.makeText(getApplicationContext(), edtRecherche.getText(), Toast.LENGTH_SHORT);
                //toast.show();

                Intent intent = new Intent(Recherche.this, Technique.class);
                intent.putExtra("titre", edtRecherche.getText().toString());
                startActivity(intent);

            }

        });
    }


}