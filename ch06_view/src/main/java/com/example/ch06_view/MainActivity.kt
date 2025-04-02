package com.example.ch06_view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ch06_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("tag","start...") // 디버깅 로그 찍어보기

        binding.progBar.visibility = View.INVISIBLE

        binding.tvMain.text = "View Binding 테스트"

        binding.tvMain.setTextColor(Color.rgb(200,100,150))
    }
}