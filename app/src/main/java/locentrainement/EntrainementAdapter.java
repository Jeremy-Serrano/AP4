package locentrainement;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dvdloc_js.R;

public class EntrainementAdapter extends ArrayAdapter {
    
    public EntrainementAdapter(Context context, int textViewRessourceId){
        super(context, textViewRessourceId);
        
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View result = convertView;
        if (convertView == null){
            result = LayoutInflater.from(getContext()).inflate(R.layout.ligne, parent, false);
        }
        EntrainementPModel entrainement = (EntrainementPModel) getItem(position);
        
        TextView TitreEvent = (TextView) result.findViewById(R.id.titre);
        TitreEvent.setText(entrainement.getTitreEvent());

        TextView NomRealisateur = (TextView) result.findViewById(R.id.realisateur);
        NomRealisateur.setText(entrainement.getNomRealisateur());

        TextView DateEvent = (TextView) result.findViewById(R.id.txtAnnee);
        DateEvent.setText(entrainement.getDateEvent());

        ImageView imageview = (ImageView) result.findViewById(R.id.ligne_img);
        imageview.setImageResource(entrainement.getImgEntrainement());
        
        return result;
    }
    public void updateData() {this.notifyDataSetChanged();}
}
