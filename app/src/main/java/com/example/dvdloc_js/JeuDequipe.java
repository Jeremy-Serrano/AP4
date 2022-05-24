package com.example.dvdloc_js;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class JeuDequipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu_dequipe);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}