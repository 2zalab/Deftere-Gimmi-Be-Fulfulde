package com.sintel.defteregimmibefulfulde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    public static String motif_recherche = "";
    ListView listView;
    private ArrayList<Integer> positions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref sharedPref = new SharedPref(this);
        if (sharedPref.loadDarkModeState()){
            setTheme(R.style.DarkMode);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        listView = findViewById(R.id.ResultatRecherche);
        SearchView searchView = findViewById(R.id.IdsearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                motif_recherche = newText;
                rechercher();
                return false;
            }
        });
    }

    public ArrayList<String> rechercher(){
        final ArrayList<String> sortie = new ArrayList<>();
        positions = new ArrayList<>();
        for(int i = 1 ; i <ListeCantiques.liste_titre_cantiques.length + 1; i ++){
            if(ListeCantiques.liste_titre_cantiques[i - 1].toLowerCase().contains(motif_recherche.toLowerCase())){
                sortie.add(ListeCantiques.liste_titre_cantiques[i - 1]);
                positions.add(i - 1);
            }
        }
        Log.e("LISTE", sortie.toString());
        final RechercheAdapter rechercheAdapter = new RechercheAdapter(sortie.toArray());
        listView.setAdapter(rechercheAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchActivity.this, CantiqueActivity.class);
                intent.putExtra("position", positions.get(position));
                startActivity(intent);
            }
        });
        return sortie;
    }


    public class RechercheAdapter extends BaseAdapter {

        private Object[] liste;
        RechercheAdapter(){
            liste = ListeCantiques.liste_titre_cantiques;
        }
        RechercheAdapter(Object liste1[]){
            liste = liste1;
        }

        @Override
        public int getCount() {
            return liste.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.custom_layout, null);
            //ImageView imageView = (ImageView) view.findViewById(R.id.ImageCantique);
            TextView textView_name = (TextView) view.findViewById(R.id.titleText);
            TextView textView_numero = (TextView) view.findViewById(R.id.numero);
            //imageView.setImageResource(R.drawable.ic_music_note_black_24dp);
            textView_numero.setText(""+(positions.get(position)+1));
            textView_name.setText(liste[position].toString());
            return view;
        }
    }
}
