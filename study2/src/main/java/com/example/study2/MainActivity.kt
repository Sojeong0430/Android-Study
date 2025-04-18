package com.example.study2

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.study2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //사진 찍기
        binding.btnPhoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE) // action, data
            startActivity(intent)
        }

        //전화 걸기
        binding.btnDial.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"))
            startActivity(intent)
        }

        //지도
        binding.btnGMap.setOnClickListener {
            val lat = 37.651450
            val lon = 127.01667
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+lat+","+lon))
            startActivity(intent)
        }

        //검색
        binding.btnWeb.setOnClickListener {
            //val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http:www.duksung.ac.kr"))
            //startActivity(intent)
        }

        binding.btnSms.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-1234-5678"))
            intent.putExtra("sms_body","안녕하세요")
            startActivity(intent)
        }

        binding.btnSearch.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY,"안드로이드")
            startActivity(intent)
        }
    }
}