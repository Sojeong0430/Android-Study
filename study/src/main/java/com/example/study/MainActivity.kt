package com.example.study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //바인딩 객체 획득
        val binding = ActivityMainBinding.inflate(layoutInflater)
        //액티비티 화면 출력
        setContentView(binding.root)

        //뷰 객체 이용
        binding.visibleBtn.setOnClickListener{
            binding.targetView.visibility
        }

    }
}