package com.sintel.defteregimmibefulfulde;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void guide(MenuItem item) {
        Intent intent = new Intent(this, GuideUtilisation.class);
        startActivity(intent);
    }

    public void Partager(MenuItem item) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "");
        String app_url = "Télécharger Deftere Gimmi Be Fulfulde en cliquant sur le lien : https://play.google.com/store/apps/details?id=com.sintel.defteregimmibefulfulde";
        shareIntent.putExtra(Intent.EXTRA_TEXT, app_url);
        startActivity(Intent.createChooser(shareIntent, "Partager via"));
    }


    public void noter(MenuItem item) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.sintel.defteregimmibefulfulde"));
            startActivity(intent);
    }

    public void propos(MenuItem item) {
        Intent intent = new Intent(this, APropos.class);
        startActivity(intent);
    }
}

