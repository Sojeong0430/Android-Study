package com.example.study4

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.study4.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

/*        binding.btn2.setOnClickListener {
            val toast = Toast.makeText(this, "Hello", Toast.LENGTH_SHORT)
            toast.addCallback(object : Toast.Callback() {
                override fun onToastShown() {
                    super.onToastShown()
                    Log.d("ToastCallback", "Toast is shown")
                }

                override fun onToastHidden() {
                    super.onToastHidden()
                    Log.d("ToastCallback", "Toast is hidden")
                }
            })
            toast.show()
        }*/
    }
}