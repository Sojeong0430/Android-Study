package com.example.ch08_event

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.ch08_event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    // 터치 이벤트 콜백 함수 선언
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                Log.d("tag","Touch Down ${event.x}, ${event.y}")
            }
            MotionEvent.ACTION_UP->{
                Log.d("tag","Touch Up")
            }
        }
        return super.onTouchEvent(event)
    }

    // 키보드 콜백 함수
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("tag","Key Down")
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("tag","Key Up")
        return super.onKeyUp(keyCode, event)
    }
}