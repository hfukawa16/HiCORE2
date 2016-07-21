package jp.co.dit.android.apps.HiCore;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MenuPreferenceActivity extends PreferenceActivity {
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.menu_preference);
	}
}