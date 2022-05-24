package com.example.dvdloc_js;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnTechnique = (Button) findViewById(R.id.btnTechnique);

        btnTechnique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0){
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Technique");
                alertDialog.setMessage("voulez vous choisir un entrainement de technique ?");

                alertDialog.setPositiveButton("oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int arg1) {
                            Intent intent = new Intent(MainActivity.this, Technique.class);
                            startActivity(intent);
                        Toast.makeText(getApplicationContext(), btnTechnique.getText(), Toast.LENGTH_LONG).show();
                    }
                });

                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int arg1) {

                    }
                });
                alertDialog.show();

            }
        });

        Button btnPhysique = (Button) findViewById(R.id.btnPhysique);

        btnPhysique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0){
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Physique");
                alertDialog.setMessage("voulez vous choisir un entrainement physique ?");

                alertDialog.setPositiveButton("oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int arg1) {
                        Intent intent = new Intent(MainActivity.this, Physique.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), btnPhysique.getText(), Toast.LENGTH_LONG).show();
                    }
                });

                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int arg1) {

                    }
                });
                alertDialog.show();

            }
        });

        Button btnJeuDequipe = (Button) findViewById(R.id.btnJeuDequipe);

        btnJeuDequipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0){
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Jeu d'equipe");
                alertDialog.setMessage("voulez vous choisir un entrainement en jeu d'equipe ?");

                alertDialog.setPositiveButton("oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int arg1) {
                        Intent intent = new Intent(MainActivity.this, JeuDequipe.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), btnJeuDequipe.getText(), Toast.LENGTH_LONG).show();
                    }
                });

                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int arg1) {

                    }
                });
                alertDialog.show();

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menugeneral, menu);
        return true;
    }

    ActivityResultLauncher<Intent> reservationLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){

                @Override

                public void  onActivityResult(ActivityResult result){
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Toast.makeText(MainActivity.this, "Reservation confirmée", Toast.LENGTH_SHORT).show();
                    }
                    else if(result.getResultCode() == Activity.RESULT_CANCELED){
                        Toast.makeText(MainActivity.this, "Reservation annulée", Toast.LENGTH_SHORT).show();
                    }
                }

            });

    ActivityResultLauncher<Intent> rechercheLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){

                @Override

                public void  onActivityResult(ActivityResult result){
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        String titre = data.getStringExtra("titre");
                        Toast.makeText(MainActivity.this, titre, Toast.LENGTH_SHORT).show();
                    }
                }

            });

    public boolean onOptionsItemSelected(MenuItem item){

        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();

        switch (item.getItemId()){

            case R.id.menuRechercher:
                //Log.i("LocDVD", "Menu:Rechercher un film");
                Intent intentRecherche = new Intent(MainActivity.this, Recherche.class);
                rechercheLauncher.launch(intentRecherche);

                return true;

            case R.id.menuReserver:
                //Log.i("LocDVD", "Menu:Reserver un film");
                Intent intentReserver = new Intent (MainActivity.this, Reservation.class);
                reservationLauncher.launch(intentReserver);

                return true;
                //Traitement du resultat de l activité   réservation

            case R.id.menuMagasins:
                Log.i("LocDVD", "Menu:Magasins");
                return true;

            case R.id.menuContact:
                Log.i("LocDVD", "Menu:Contact");
                return true;
        }
        return true;
    }

}