package com.example.lab7_scorekeeper;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

import androidx.annotation.Nullable;

public class SettingsFragment extends PreferenceFragment {

    public SwitchPreference scorePref;
    SharedPreferences sharedPreferences;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // below line is used to add preference
        // fragment from our xml folder.
        addPreferencesFromResource(R.xml.preferences);

        sharedPreferences = getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        scorePref = (SwitchPreference) findPreference("save_scores"); //Preference Key
        scorePref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                if (scorePref.isChecked()) {
                    myEdit.putBoolean("save_scores", false);
                } else {
                    myEdit.putBoolean("save_scores", true);
                }
                myEdit.commit();
                return true;
            }
        });
    }


}