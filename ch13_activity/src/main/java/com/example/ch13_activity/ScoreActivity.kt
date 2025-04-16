package com.example.ch13_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ch13_activity.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var scores = intent.getFloatArrayExtra("myscores")
        binding.rbar1.rating = scores!![0]
        binding.rbar2.rating = scores!![1]
        binding.rbar3.rating = scores!![2]

        binding.btnReturn.setOnClickListener {
            scores[0] = binding.rbar1.rating
            scores[1] = binding.rbar2.rating
            scores[2] = binding.rbar3.rating

            intent.putExtra("result",scores)
            setResult(RESULT_OK,intent)

            finish()
        }
    }
}