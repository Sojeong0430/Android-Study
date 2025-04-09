package com.example.study

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.imageView.visibility = View.VISIBLE
            binding.button.visibility = View.INVISIBLE
        }

        binding.imageView.setOnClickListener(){
            binding.button.visibility = View.VISIBLE
            binding.imageView.visibility = View.INVISIBLE
        }

    }
}