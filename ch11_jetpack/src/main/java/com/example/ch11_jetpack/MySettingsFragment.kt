package com.example.ch11_jetpack

import android.os.Bundle
import android.text.TextUtils
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class MySettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val idPreference: EditTextPreference? = findPreference("ID")
        val colorPreference: ListPreference? = findPreference("close")

        idPreference?.summaryProvider = Preference.SummaryProvider<EditTextPreference> { preference ->
            val idText = preference.text
            if (TextUtils.isEmpty(idText)) {
                "ID 설정이 되지 않았습니다."
            } else {
                "설정된 ID는 $idText 입니다."
            }
        }
        colorPreference?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
    }
}
