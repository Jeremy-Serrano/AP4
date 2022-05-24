package com.example.dvdloc_js;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Technique extends AppCompatActivity {

    public String EntrainementTechnique[]={
            "Passement de jambes",
            "roulette",
            "Stratégie d'attaque",
            "Stratégie contre-attaque",
            "Corner"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technique);

        //Venant de recherche
        String titre = this.getIntent().getStringExtra("titre");
        TextView titreDemande = findViewById(R.id.titreDemande);
        titreDemande.setText(titre);

        //Création d un adapter qui lie le tableau ou ListView
        //Constructeur : contexte : this, ressource, tableau (EntrainementTechnique)
        //La ressource est le type de liste à afficher : bouton radio...
        final ArrayAdapter<String> adapterList = new
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, EntrainementTechnique);

        //Implementation du listener dans la litsView pour recuperer le titre choisi
        ListView listTechnique = (ListView)findViewById(R.id.technique_listView);
        listTechnique.setAdapter(adapterList);

        //test de chaque item
        listTechnique.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
            public void onItemClick(AdapterView<?> adapter, View arg1, int position, long arg3) {

                Toast toast = Toast.makeText(getApplicationContext(), "position :" + String.valueOf(position), Toast.LENGTH_SHORT);
                toast.show();

                Toast toast2 = Toast.makeText(getApplicationContext(), "Titre :" + EntrainementTechnique[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}