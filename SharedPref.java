package com.sintel.defteregimmibefulfulde;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private SharedPreferences sharedPreferences;
    public SharedPref(Context context){
        sharedPreferences=context.getSharedPreferences("filename",Context.MODE_PRIVATE);
    }

    public void setDarkModeState(Boolean state){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("darkTheme",state);
        editor.apply();
    }

    public Boolean loadDarkModeState (){
        return sharedPreferences.getBoolean("darkTheme",false);
    }
}
