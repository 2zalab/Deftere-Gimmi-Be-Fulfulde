package com.sintel.defteregimmibefulfulde;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.codesgood.views.JustifiedTextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FavorisActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private Set<String> liste_favoris = new HashSet<String>();
    String [] CantiquesFavoris ;
    ArrayList<Integer> positions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref sharedPref = new SharedPref(this);
        if (sharedPref.loadDarkModeState()){
            setTheme(R.style.DarkMode);
        } else {
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.activity_favoris);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM|ActionBar.DISPLAY_HOME_AS_UP|ActionBar.DISPLAY_SHOW_HOME);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_favoris);
        init();

    }


    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    private void init(){
        sharedPreferences = getSharedPreferences("com.sintel.defteregimmibefulfulde", MODE_PRIVATE);
        liste_favoris = sharedPreferences.getStringSet("liste_favoris",  new HashSet<String>());

        CantiquesFavoris = new String[liste_favoris.size()];
        ListView listView = findViewById(R.id.CantiquesFavoris);
        positions = new ArrayList<>();
        int ligne = 0;
        for(int i=0; i<=ListeCantiques.liste_titre_cantiques.length; i++){
            if (liste_favoris.contains(""+i)){
                CantiquesFavoris[ligne] = ListeCantiques.liste_titre_cantiques[i];
                ligne ++;
                positions.add(i);
            }
        }

        if (liste_favoris.isEmpty()){
           TextView textView = findViewById(R.id.favorisvide);
           textView.setText(getString(R.string.favorisvide));
        } else {
            final FavorisAdapter adapter = new FavorisAdapter();
            listView.setAdapter(adapter);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FavorisActivity.this, CantiqueActivity.class);
                intent.putExtra("position",positions.get(position));
                //intent.putExtra("position", Integer.parseInt(liste_favoris.toArray()[position].toString()));
                startActivity(intent);
            }
        });
    }
    public class FavorisAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return CantiquesFavoris.length;
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
            textView_numero.setText(""+((positions.get(position)+1)));
            textView_name.setText(CantiquesFavoris[position]);
            return view;
        }
    }
}
