package com.sintel.defteregimmibefulfulde;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class GuideUtilisation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPref sharedPref = new SharedPref(this);
        if (sharedPref.loadDarkModeState()){
            setTheme(R.style.DarkMode);
        } else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_utilisation);
    }

    public void Fermer(View view) {
        this.finish();
    }
}
