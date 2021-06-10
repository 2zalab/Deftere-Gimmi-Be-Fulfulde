package com.sintel.defteregimmibefulfulde;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

public class MainActivity extends BaseActivity {
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
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        final EditText NumeroCantique = findViewById(R.id.EditText);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        NumeroCantique.clearFocus();

        Button btn = findViewById(R.id.Idbutton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = 1;
                try {
                    num = Integer.parseInt(NumeroCantique.getText().toString());
                }catch (Exception e){
                    new AlertDialog.Builder(MainActivity.this)
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

                if (0 < num  && num < 108 ) {
                    Intent intent = new Intent(MainActivity.this,CantiqueActivity.class);
                    intent.putExtra("position",num-1);
                    startActivity(intent);
                    //finish();
                }

                else {
                    new AlertDialog.Builder(MainActivity.this)
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
        });
    }

    public void exit(MenuItem item) {
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Confirmer la fermeture !");
        alertDialogBuilder.setIcon(R.drawable.ic_warning_black_24dp);
        alertDialogBuilder.setMessage("Voulez-vous vraiment quitter?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setNeutralButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog= alertDialogBuilder.create();
        alertDialog.show();
    }



    public void ActiverModeSombre(MenuItem item) {
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
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        finish();
    }

    public void OuvrirListeCantique(View view) {
        Intent intent = new Intent(this, ListeCantiques.class);
        startActivity(intent);
    }

    public void OuvrirRechercheActivity(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void OuvrirFavoris(View view) {
        Intent intent = new Intent(this, FavorisActivity.class);
        startActivity(intent);
    }

    public void Sommaire(View view) {
        startActivity(new Intent(this,SommaireActivity.class));
    }
}
