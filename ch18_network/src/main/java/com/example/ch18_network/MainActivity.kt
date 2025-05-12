package com.example.ch18_network

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ch18_network.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fragment 객체 선언
        var jsonfragment = JsonFragment()
        var xmlfragment = XmlFragment()
        val bundle = Bundle()

        binding.btnSearch.setOnClickListener {
            val loc = binding.edtLoc.text.toString()
            if(loc == ""){ // 아무것도 입력하지 않았다면
                Toast.makeText(this, "지역 ID를 입력하세요. 예: 서울은 108, 제주는 184", Toast.LENGTH_SHORT).show()
            }
            else {
                bundle.putString("searchLoc", binding.edtLoc.text.toString())

                if (binding.rGroup.checkedRadioButtonId == R.id.rbJson) {
                    jsonfragment.arguments = bundle
                    supportFragmentManager.beginTransaction() // 어떤 Fragment를 사용할 것인가
                        .replace(R.id.activity_content, jsonfragment)
                        .commit() // commit을 해야 반영된다
                } else if (binding.rGroup.checkedRadioButtonId == R.id.rbXml) {
                    xmlfragment.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.activity_content, xmlfragment)
                        .commit()
                }
            }
        }
    }

}