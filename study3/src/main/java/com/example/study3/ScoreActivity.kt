package com.example.study3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.study3.databinding.ActivityScoreBinding

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
            setResult(RESULT_OK,intent) //putExtra의 값을 넣은 상태에서 mainActivity로 돌아가게 된다
            finish()
        }
    }
}