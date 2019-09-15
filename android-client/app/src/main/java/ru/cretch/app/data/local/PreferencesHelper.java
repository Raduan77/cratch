package ru.cretch.app.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class PreferencesHelper implements IPreferencesHelper {

    private static final String TAG_SESS_ID = "TAG_SESS_ID";
    private static final String TAG_RC = "TAG_RC";
    private static final String TAG_RC_NAME = "TAG_RC_NAME";
    private static final String APP_PREF = "MyPreferences";
    private static final String TAG_FILTERS = "TAG_FILTERS";
    private static final String TAG = "PreferencesHelper";
    private static SharedPreferences sharedPref;

    private Context appContext;

    @Inject
    PreferencesHelper(Context appContext){
        this.appContext = appContext;
        sharedPref = appContext.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE);
    }

    @Override
    public void saveSessId(String data) {

        sharedPref.edit().putString(TAG_SESS_ID, data).apply();
    }


    @Override
    public String getSessId() {
        String data = sharedPref.getString(TAG_SESS_ID, "");

        return data;
    }
}
