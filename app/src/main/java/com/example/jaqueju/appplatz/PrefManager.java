package com.example.jaqueju.appplatz;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 */
//Essa classe é referente à introdução do Aplicativo
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PREVENT_MODE = 0;
    private static final String PREF_NAME = "Platz - Bem VIndo!";
    private static final String IS_FIRST_TIME_LAUNCH = "É o primeiro time Launcher";

    public PrefManager(Context context) {
        this._context = context;
        pref = context.getSharedPreferences(PREF_NAME, PREVENT_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
