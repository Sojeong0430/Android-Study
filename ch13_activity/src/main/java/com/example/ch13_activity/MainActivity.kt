package com.example.ch13_activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ch13_activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var scores : FloatArray? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        scores = savedInstanceState?.let{
            it.getFloatArray(("datas"))
        }
            ?: let {
                floatArrayOf(1.0f, 2.0f, 3.0f)
            }

        binding.tvScore1.text = scores!![0].toString()
        binding.tvScore2.text = scores!![1].toString()
        binding.tvScore3.text = scores!![2].toString()

        val requestLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val result = it.data?.getFloatArrayExtra("result")
            scores = result
            binding.tvScore1.text = result!![0].toString()
            binding.tvScore2.text = result!![1].toString()
            binding.tvScore3.text = result!![2].toString()
        }

            binding.btnScore.setOnClickListener {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("myscores",scores)
            //startActivity(intent)
            requestLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putFloatArray("datas", scores)
    }
}