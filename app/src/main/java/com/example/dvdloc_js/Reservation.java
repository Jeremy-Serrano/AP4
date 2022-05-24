package com.example.dvdloc_js;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Reservation extends AppCompatActivity {
    private Button btnConfirmer;
    private Button btnAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        //Confirmation
        btnConfirmer = findViewById(R.id.btnConfirmerResa);
        btnConfirmer.setOnClickListener(new Button.OnClickListener(){
            @Override

            public void onClick(View view){
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        //Annuler
        btnAnnuler = findViewById(R.id.btnAnnulerResa);
        btnAnnuler.setOnClickListener(new Button.OnClickListener(){
            @Override

            public void onClick(View view){
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}