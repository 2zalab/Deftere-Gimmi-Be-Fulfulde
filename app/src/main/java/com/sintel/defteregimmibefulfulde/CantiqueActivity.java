package com.sintel.defteregimmibefulfulde;

import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashSet;
import java.util.Set;

import de.hdodenhof.circleimageview.CircleImageView;

public class CantiqueActivity extends AppCompatActivity {
    int size_texte_cantique=19;
    int size_title=24;
    int nbre_zoom=1;
    ImageView ModeSombre,share;

public static int position;
MediaPlayer mp;
SharedPreferences sharedPreferences;
private Set<String> liste_favoris = new HashSet<String>();
EditText NumeroCantique;
TextView titre, total_duration, curentTime,refTitre;
BottomNavigationView bottomNavigationView;
Menu menu;
String[] ContenuCantique,reference;
ImageButton play,pause, stop;
SeekBar seekBar;
private Handler handler=new Handler();
private SharedPref sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref=new SharedPref(this);
        if (sharedPref.loadDarkModeState()){
            setTheme(R.style.DarkMode);
        } else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantique);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM|ActionBar.DISPLAY_HOME_AS_UP|ActionBar.DISPLAY_SHOW_HOME);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_cantique);
        sharedPreferences = getSharedPreferences("com.sintel.defteregimmibefulfulde", MODE_PRIVATE);
        liste_favoris = sharedPreferences.getStringSet("liste_favoris",  new HashSet<String>());
        ModeSombre=findViewById(R.id.sombre);
        share=findViewById(R.id.share);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        seekBar=findViewById(R.id.seekBar);
        total_duration=findViewById(R.id.TotalDuration);
        curentTime=findViewById(R.id.textCurentTime);


        seekBar.setMax(100);
        seekBar.setEnabled(false);
        ContenuCantique = getResources().getStringArray(R.array.ContenuCantique);
        reference=getResources().getStringArray(R.array.reference_titre);

        pause.setEnabled(false);
        pause.setBackground(getResources().getDrawable(R.drawable.background_border_round_desactive));

        stop.setEnabled(false);
        stop.setBackground(getResources().getDrawable(R.drawable.background_border_round_desactive));

        ModeSombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActiverModeSombre();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PartagerCantique((position+1)+"-"+liste_titre_cantiques[position]+"\n"+reference[position]+"\n \n"+ContenuCantique[position]+"\n"+"--------------------------------------------------------\n"+"Partager depuis l'application Deftere Gimmi Be Fulfulde");
            }
        });

        //on recupere le numero de la recherche
        position = getIntent().getIntExtra("position", 1);
        NumeroCantique = findViewById(R.id.NumCantique);

        //on recupere le numero puis on ecrit dans la zone de recherche
        int num = getIntent().getIntExtra("numero", 108);
        if (num < 108 && num >0){
            NumeroCantique.setText(""+num);
        }

        final Button btn = findViewById(R.id.Idbutton);
        titre=findViewById(R.id.titre_cantique);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        menu= bottomNavigationView.getMenu();

        if(liste_favoris.contains(""+position)){
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
        }


        if (position < 107) {
                AfficherCantique(position);
                LireCantique(position);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifier_numero();

                if(liste_favoris.contains(""+position)){
                    menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
                }else{
                    menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
                }

                NumeroCantique.setText("");
            }
        });

        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                SeekBar seekBar=(SeekBar)v;
                int playPosition=(mp.getDuration() / 100)*seekBar.getProgress();
                mp.seekTo(playPosition);
                curentTime.setText(milliSecondsToTime(mp.getCurrentPosition()));
                return false;
            }
        });
    }


    private Runnable updater = new Runnable() {
        @Override
        public void run() {
            updateSeekbar();
            long CurentDuration = mp.getCurrentPosition();
            long TotalTime = mp.getDuration();
            curentTime.setText(milliSecondsToTime(CurentDuration));
            total_duration.setText(milliSecondsToTime(TotalTime));
        }
    };

    private void updateSeekbar(){
        if (mp.isPlaying()){
            seekBar.setProgress((int)(((float)mp.getCurrentPosition()/mp.getDuration())*100));
            handler.postDelayed(updater,1000);
        } else {
            seekBar.setProgress(0);
            handler.removeCallbacks(updater);
        }
    }

    private String milliSecondsToTime(long milliSeconds){
        String timerString = "";
        String secondString;
        int heure = (int)(milliSeconds/(1000*60*60));
        int minutes = (int)(milliSeconds%(1000*60*60))/(1000*60);
        int seconds =(int)((milliSeconds%(1000*60*60))%(1000*60)/1000);

        if (heure>0){
            timerString=heure+":";
        }

        if (seconds<10){
            secondString="0"+seconds;
        } else {
            secondString=""+seconds;
        }
        timerString=timerString+minutes+":"+secondString;
        return timerString;
    }

    private void PartagerCantique(String s) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, s);
        startActivity(intent);
    }

    private void ActiverModeSombre() {
        if (sharedPref.loadDarkModeState()){
            sharedPref.setDarkModeState(false);
            //Toast.makeText(this, "Mode Sombre désactivé", Toast.LENGTH_SHORT).show();
            ReStartApp();
        } else {
            sharedPref.setDarkModeState(true);
            //Toast.makeText(this, "Mode Sombre activé", Toast.LENGTH_SHORT).show();
            ReStartApp();
        }
    }

    private void ReStartApp() {
        super.onRestart();

        if(mp!=null){
            mp.pause();
            handler.removeCallbacks(updater);
        }
        stopPlayer();

        int numero;
        if (!(NumeroCantique.getText().toString().isEmpty())){
            numero=Integer.parseInt(NumeroCantique.getText().toString());
        } else {
            numero =108;
        }
        Intent intent=new Intent(this,CantiqueActivity.class);
        intent.putExtra("position",position);
        intent.putExtra("numero",numero);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mp!=null){
            mp.pause();
            handler.removeCallbacks(updater);
        }
        stopPlayer();
        //startActivity(new Intent(this,MainActivity.class));
        //finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mp!=null){
            mp.pause();
            handler.removeCallbacks(updater);
        }
        stopPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mp!=null){
            mp.pause();
            handler.removeCallbacks(updater);
        }
        stopPlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mp!=null){
            mp.pause();
            handler.removeCallbacks(updater);
        }
        stopPlayer();
    }

    private void verifier_numero(){
        int num = 1;
        try {
            num = Integer.parseInt(NumeroCantique.getText().toString());
        } catch (Exception e) {
            new AlertDialog.Builder(CantiqueActivity.this)
                    .setTitle("Numero incorrect")
                    .setMessage("Entrer un numero compris entre 1 et 107")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
            return;
        }

        if (0 < num && num < 108) {
            position=num-1;
            AfficherCantique(position);
            LireCantique(position);
        }
        else {
            new AlertDialog.Builder(CantiqueActivity.this)
                    .setTitle("Numero incorrect")
                    .setMessage("Entrer un numero compris entre 1 et 107")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).show();
        }
    }


    public  void AfficherCantique(int NumeroCantique){
        TextView textView = findViewById(R.id.TexteCantique);
        refTitre=findViewById(R.id.TexteTitreCantique);
        String text = ContenuCantique[NumeroCantique];
        titre.setText(""+(NumeroCantique+1)+"-"+liste_titre_cantiques[NumeroCantique]);
        refTitre.setText(reference[NumeroCantique]);
        textView.setText(text);
    }

    public void LireCantique (final int numeroCantique){

            final int[] MelodieCantique = new int[]{
                    R.raw.c1, R.raw.c2, R.raw.c3, 0, R.raw.c5, R.raw.c6, R.raw.c7, R.raw.c8, R.raw.c31, R.raw.c10,
                    R.raw.c11, R.raw.c12, R.raw.c13, R.raw.c14, R.raw.c15, 0, R.raw.c17, R.raw.c18, R.raw.c19, R.raw.c20,
                    R.raw.c21, R.raw.c22, R.raw.c23, R.raw.c24, R.raw.c25, R.raw.c26, R.raw.c27, R.raw.c28, R.raw.c29, R.raw.c30,
                    R.raw.c31, R.raw.c32, R.raw.c33, R.raw.c34, R.raw.c35, R.raw.c36, R.raw.c37, R.raw.c38, R.raw.c39, R.raw.c40,
                    R.raw.c41, R.raw.c42, R.raw.c43, R.raw.c44, R.raw.c45, 0, R.raw.c47, R.raw.c48, 0, R.raw.c50, 0,
                    R.raw.c52, R.raw.c53, R.raw.c54, R.raw.c55, R.raw.c56, R.raw.c57, R.raw.c58, R.raw.c59, R.raw.c60,
                    R.raw.c61, R.raw.c62, R.raw.c64, R.raw.c64, R.raw.c65, R.raw.c38, R.raw.c67, R.raw.c68, 0, R.raw.c70,
                    R.raw.c71, R.raw.c72, R.raw.c73, R.raw.c74, R.raw.c75, R.raw.c76, R.raw.c77, R.raw.c78, 0, R.raw.c80,
                    R.raw.c81, R.raw.c82, R.raw.c83, 0, R.raw.c85, R.raw.c86, R.raw.c87, R.raw.c88, R.raw.c89, R.raw.c90,
                    R.raw.c91, R.raw.c92, R.raw.c93, R.raw.c94, R.raw.c95, 0, R.raw.c97, R.raw.c98, R.raw.c99, R.raw.c100,
                    R.raw.c101, R.raw.c102, R.raw.c103, R.raw.c104, R.raw.c105, R.raw.c106, R.raw.c107};

            play.setEnabled(!(numeroCantique == 3 || numeroCantique == 15 || numeroCantique == 45 || numeroCantique == 48 || numeroCantique == 50 || numeroCantique == 68 || numeroCantique == 78
                    || numeroCantique == 83 || numeroCantique == 95));

            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    seekBar.setEnabled(true);
                    //on desactive le bouton play
                    play.setEnabled(false);
                    play.setBackground(getResources().getDrawable(R.drawable.background_border_round_desactive));

                    //on active les boutons pause et stop
                    pause.setEnabled(true);
                    pause.setBackground(getResources().getDrawable(R.drawable.background_border_round_black));

                    stop.setEnabled(true);
                    stop.setBackground(getResources().getDrawable(R.drawable.background_border_round_red));

                    if(mp==null){
                        mp= MediaPlayer.create(CantiqueActivity.this, MelodieCantique[numeroCantique]);
                        mp.setLooping(true);
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                stopPlayer();
                            }
                        });
                    }
                    mp.start();
                    updateSeekbar();
                    mp.setLooping(true);
                }
            });

            pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //on desactive le bouton pause
                    pause.setEnabled(false);
                    pause.setBackground(getResources().getDrawable(R.drawable.background_border_round_desactive));

                    //on active les boutons play et stop
                    play.setEnabled(true);
                    play.setBackground(getResources().getDrawable(R.drawable.background_border_round_green));

                    stop.setEnabled(true);
                    stop.setBackground(getResources().getDrawable(R.drawable.background_border_round_red));

                    if(mp!=null){
                        handler.removeCallbacks(updater);
                        mp.pause();
                    }
                }
            });

            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    seekBar.setProgress(0);

                    if(mp!=null){
                        handler.removeCallbacks(updater);
                        mp.pause();
                    }
                    stopPlayer();

                    //on desactive les boutons stop et pause
                    stop.setEnabled(false);
                    stop.setBackground(getResources().getDrawable(R.drawable.background_border_round_desactive));

                    pause.setEnabled(false);
                    pause.setBackground(getResources().getDrawable(R.drawable.background_border_round_desactive));

                    //on active le bouton play
                    play.setEnabled(true);
                    play.setBackground(getResources().getDrawable(R.drawable.background_border_round_green));


                }
            });
        }

    private  void  stopPlayer(){
        if (mp!=null){
            mp.stop();
            mp.reset();
            mp.release();
            mp=null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
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

    public void AfficherCantiquePrecedent(MenuItem item) {

        seekBar.setProgress(0);

        if(mp!=null){
            handler.removeCallbacks(updater);
            mp.pause();
        }
        stopPlayer();
        pause.setEnabled(false);
        pause.setBackground(getResources().getDrawable(R.drawable.background_border_round_desactive));

        stop.setEnabled(false);
        stop.setBackground(getResources().getDrawable(R.drawable.background_border_round_desactive));

        play.setEnabled(true);
        play.setBackground(getResources().getDrawable(R.drawable.background_border_round_green));

        if (position>0) {
            AfficherCantique(position-1);
            LireCantique(position-1);
            position--;
        }
        else {
            Toast.makeText(CantiqueActivity.this, "Vous avez atteint le numero minimal", Toast.LENGTH_SHORT).show();
        }

        if(liste_favoris.contains(""+position)){
          menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
        }else{
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
        }
        NumeroCantique.setText("");
    }


    public void AfficherCantiqueSuivant(MenuItem item) {
        //on iniatiale la progression à 0
        seekBar.setProgress(0);

        // on met pause sur le cantique puis on le stop
        if(mp!=null){
            handler.removeCallbacks(updater);
            mp.pause();
        }
        stopPlayer();

        // activation du bouton play et desactivation des autres boutons
        pause.setEnabled(false);
        pause.setBackground(getResources().getDrawable(R.drawable.background_border_round_desactive));

        stop.setEnabled(false);
        stop.setBackground(getResources().getDrawable(R.drawable.background_border_round_desactive));
        play.setEnabled(true);
        play.setBackground(getResources().getDrawable(R.drawable.background_border_round_green));

        if (position==106){
            Toast.makeText(CantiqueActivity.this, "Vous avez atteint le numero maximal", Toast.LENGTH_SHORT).show();
        }
        else{
            AfficherCantique(position+1);
            LireCantique(position+1);
            position++;
        }

        if(liste_favoris.contains(""+position)){
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
        }else{
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
        }
        NumeroCantique.setText("");
    }

    public void AgrandirTexte(MenuItem item) {
        if (nbre_zoom<=20) {
            TextView textView = findViewById(R.id.TexteCantique);
            TextView title = findViewById(R.id.titre_cantique);
            title.setTextSize(size_title+1);
            textView.setTextSize(size_texte_cantique + 1);
            size_texte_cantique++;
            size_title++;
            nbre_zoom++;
        }
    }

    public void AjouterFavoris(MenuItem item) {
        if(liste_favoris.contains(""+position)){
            liste_favoris.remove(""+position);
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
            Toast.makeText(this, "Cantique retiré de la liste des favoris", Toast.LENGTH_SHORT).show();
        }else{
            liste_favoris.add(""+position);
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
            Toast.makeText(this, "Cantique ajouté à la liste des favoris", Toast.LENGTH_SHORT).show();
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("liste_favoris", liste_favoris);
        editor.apply();
    }

    public void ReduireTexte(MenuItem item) {
        if(nbre_zoom>=1) {
            TextView textView = findViewById(R.id.TexteCantique);
            TextView title = findViewById(R.id.titre_cantique);
            title.setTextSize(size_title-1);
            textView.setTextSize(size_texte_cantique - 1);
            size_texte_cantique--;
            size_title--;
            nbre_zoom--;
        }
    }
}