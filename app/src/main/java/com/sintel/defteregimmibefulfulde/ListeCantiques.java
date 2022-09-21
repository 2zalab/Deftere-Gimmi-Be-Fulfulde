package com.sintel.defteregimmibefulfulde;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListeCantiques extends AppCompatActivity {


    public static int pos;
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
        setContentView(R.layout.activity_liste_cantiques);
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.action_bar_layout_listecantique);

        listView = findViewById(R.id.ListeCantiques);
        SearchView searchView = findViewById(R.id.searchView);
        rechercher();

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
        for(int i = 1 ; i < liste_titre_cantiques.length + 1; i ++){
            if(liste_titre_cantiques[i - 1].toLowerCase().contains(ListeCantiques.motif_recherche.toLowerCase())){
                sortie.add(liste_titre_cantiques[i - 1]);
                positions.add(i - 1);
            }
        }
        Log.e("LISTE", sortie.toString());
        final CustomAdapter customAdapter = new CustomAdapter(sortie.toArray());
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListeCantiques.this, CantiqueActivity.class);
                intent.putExtra("position", positions.get(position));
                startActivity(intent);
            }
        });
        return sortie;
    }

    public class CustomAdapter extends BaseAdapter {

        private Object[] liste;
        CustomAdapter(){
            liste = liste_titre_cantiques;
        }
        CustomAdapter(Object liste1[]){
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
           // ImageView imageView = (ImageView) view.findViewById(R.id.ImageCantique);
            TextView textView_name = (TextView) view.findViewById(R.id.titleText);
            TextView textView_numero = (TextView) view.findViewById(R.id.numero);
            //imageView.setImageResource(R.drawable.ic_music_note_black_24dp);
            textView_numero.setText(""+(positions.get(position)+1));
            textView_name.setText(liste[position].toString());
            return view;
        }
    }

    public static String[] liste_titre_cantiques = {
            "Yesu yidi bikkon fu",
            "Dum seyo tokkago lawol",
            "Jodago ha kosde yesu",
            "Sobabe ngurte ha nder nyibre",
            "Baba cenido",
            "Mi don teddina ma allah",
            "Yesu krist don wanca be am",
            "Wodi sobajo am yesu",
            "Yeesu mayi ha gafingal",
            "Nda lekkita manga wari",
            "Baba mi yidi ma",
            "Bana mi woni aybejo",
            "wala sobajo buran yeesu",
            "Mi yidi yalade sabba",
            "Yeesu krist badita hande",
            "Sondu ha ladde",
            "Gafingal yeesu krist",
            "Duniyaru ndu mere",
            "Baddi be yeesu krist",
            "Labinol bernde",
            "War ha yeesu",
            "Baba am don yila be am",
            "Wodi lesdi ha allahhira",
            "Boyma mi anda kisnowo",
            "Gafingal yeesu",
            "Yeesu kisnowo kibuudo",
            "Minin ngidi dowtare",
            "Biddo allah",
            "Yeesu yidi yam",
            "Jodu be am",
            "Tapare duminde",
            "Yeesu badi wartugo",
            "Ha nder asaman",
            "Burdum ha yeesu",
            "Yeesu kisnowo yam",
            "Teddingo allah",
            "Ummatore yimbe allah",
            "Yeesu gainako boddo",
            "Timminol sodol",
            "Mobture hisnabe",
            "Allah jodida be ma",
            "Hubar mbelka",
            "Be siru",
            "Hakke am hosama gal kisnowo",
            "Yeesu be kisnowo",
            "Yimre nyalade sabbat",
            "Ngade zakka",
            "Endam yajaumirawo yeesu-krist",
            "Ruuhu cenido",
            "Berniwol seningol ha asaman",
            "Wartol yeesu nder wudare",
            "Zunubajo bana mi wa’i",
            "Boddumji don har ma ",
            "Jodibe ha lesdi fu",
            "Deftere allah lati jayngol",
            "Allah ewni ma ",
            "Gaynako boddo ",
            "Tokken lawol be gorgaku ",
            "To wodi yide ha sare  ",
            "Yeesu, mi tokkete toye fu",
            "Min ngari ha sudu mada ",
            "Mi yetti ngam yide baba be yeesu ",
            "Moye hisnata duniyaru  ",
            "Kugal mada lati bodngal ",
            "Yeesu jodan cakka meden",
            "Hokku en ruhu mada",
            "Sukka ma wari ",
            "Wi’i fu ha yeesu",
            "Tokkago lawol gongaku",
            "Baba jogam",
            "Sembe don nder yiam yeesu",
            "Ya jawmirawo mi yenwi ma",
            "Mi woni jayngol ma",
            "Lawol kisndam",
            "Ngam ma mi wadi dum",
            "War ha baba hande",
            "Endam kisnowo yam",
            "Ha dukki wade min latan aman’en",
            "Sanya pukarajo",
            "Mi don tefa jam be endam",
            "Mi don be mada",
            "Zunubajo mi hurgete",
            "Sawtu yeesu don noddi yam",
            "Barka kisnowo yeesu-krist",
            "Nyalade fu nder ngendam am ",
            "Bangte ko’e mon",
            "Balde fumi mari haje ma",
            "Dande yeesu don ewna min",
            "Yedgo be yeesu ha asaman",
            "Mi hebi seyo ha kisnowo",
            "Mi don wara jaumirawo",
            "Yimre suwam ",
            "Bernde men seyake ngam yeesu",
            "En mayan hideko ngeden",
            "Mo’ere yeesu",
            "Babirawo allah",
            "Mi don haba habre wonde",
            "Babare fu ha yeesu krist",
            "Mi numan foroy ha allah ",
            "Teffe gikku nbongu",
            "War ha yeesu",
            "To hendu saatundu wadi",
            "A yobi kisdam am bee sadaka",
            "Nda yesu kisnowo men ",
            "To a linyi taaku maada ",
            "Dum seyo mango haa am ",
            "Nder juude ma mi halfini"
    };


}
