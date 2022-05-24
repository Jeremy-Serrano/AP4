package com.example.dvdloc_js;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;

import locentrainement.EntrainementAdapter;
import locentrainement.EntrainementPModel;

public class Physique extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physique);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listePhysique = (ListView) findViewById(R.id.physique_listview);
        EntrainementAdapter entrainementAdapter = new EntrainementAdapter(this, R.layout.ligne);

        try{
            XmlPullParser xmlPullParser = getResources().getXml(R.xml.liste_physique);
            //tant que la fin du fichier non atteinte
            while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT){
                //si la balise ouvrante
                if(xmlPullParser.getEventType() == XmlPullParser.START_TAG){
                    //si la balise est Entrainement
                    if(xmlPullParser.getName().equals("Entrainement")){
                        EntrainementPModel unPhysique = new EntrainementPModel();
                        unPhysique.setTitreEvent(xmlPullParser.getAttributeValue(3));
                        //Log.i("locentrainement", "TitreEvent = " + unPhysique.getTitreEvent());
                        unPhysique.setNomRealisateur(xmlPullParser.getAttributeValue(2));
                        //Log.i("locentrainement", "Realisateur = " + unPhysique.getNomRealisateur());
                        unPhysique.setDateEvent(xmlPullParser.getAttributeValue(0));
                        //Log.i("locentrainement", "getDateEvent = " + unPhysique.getDateEvent());

                        //recuperation au nom de l image dans drawable
                        //String path = getPackageName() + ":drawable/"+ xmlPullParser.getAttributeValue("imgVideo", "");
                        int resID = getResources().getIdentifier(xmlPullParser.getAttributeValue(1), "drawable", getPackageName());
                        unPhysique.setImgEntrainement(resID);
                        //Log.i("locentrainement", "Img 1= ";drawable + xmlPullParser.getAttributeValue(1));

                        entrainementAdapter.add(unPhysique);
                    }
                }
                xmlPullParser.next();
            }

        }catch(Exception e){
            Log.i("locentrainement", "erreurs trouvées" + e.getMessage());
            e.printStackTrace();
        }

        //association de l adapter a la listview
        listePhysique.setAdapter(entrainementAdapter);
    }
}