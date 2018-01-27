package com.tutexp.card_reader.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by noushad on 1/27/18.
 */

public class SharedPrefManager {

    private static final String KEY_LOADED = "com.tutexp.card_reader.loaded";
    private static SharedPrefManager mInstance;
    private static Context sContext;
    private static final String SHARED_PREF_NAME = "com.tutexp.card_reader.mealmanager";

    private SharedPrefManager(Context context) {
        sContext = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean clear() {
        SharedPreferences sharedPreferences = sContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
        return true;
    }

    public void setLoaded() {
        SharedPreferences sharedPreferences = sContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_LOADED, 101);
        editor.apply();
    }

    public boolean isLoaded() {
        return getLoadedStatus() == 101;
    }

    private int getLoadedStatus() {
        SharedPreferences sharedPreferences = sContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        int status = sharedPreferences.getInt(KEY_LOADED, 0);
        return status;
    }


}
