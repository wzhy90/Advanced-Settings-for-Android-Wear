package com.sssemil.advancedsettings.util.preference;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;

import java.io.IOException;


public class Button2Preference extends Preference {

    private static final String TAG = "Advanced Settings";
    private Context mContext;

    public Button2Preference(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    public int getIcon() {
        // Delegate to super if no specific icons are set
        return super.getIcon();
    }

    @Override
    public void onPreferenceClick() {
        try {
            if (!super.getActivity().equals("null")) {
                switch (String.valueOf(super.getActivity())) {
                    case "system_menu":
                        Intent intent = new Intent(Settings.ACTION_PRIVACY_SETTINGS);
                        mContext.startActivity(intent);
                        break;
                    default:
                        Runtime.getRuntime().exec(String.valueOf(super.getActivity()));
                        break;
                }
            }
        } catch (IOException e) {
            Log.d(TAG, "catch " + e.toString() + " hit in run", e);
        }

    }
}
