package com.example.ch11_jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ch11_jetpack.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}