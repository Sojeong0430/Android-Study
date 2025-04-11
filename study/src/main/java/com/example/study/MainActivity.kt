package com.example.study

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //시작 체크박스
        binding.chbStart.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked == true){
                binding.choiceAnimal.visibility = View.VISIBLE
            }
            else{
                binding.choiceAnimal.visibility = View.INVISIBLE
            }
        }

        //선택지에 따라 이미지 변경
        binding.btnOk.setOnClickListener {
            if(binding.rdDog.isChecked){
                binding.ivAnimal.setImageResource(R.drawable.dog)
            }
            else if(binding.rdCat.isChecked){
                binding.ivAnimal.setImageResource(R.drawable.cat)
            }
            else if(binding.rdRabbit.isChecked){
                binding.ivAnimal.setImageResource(R.drawable.rabbit)
            }
        }

        //길게 클릭
        binding.ivAnimal.setOnLongClickListener {
            //Log.d("tag","Long Click")

            //토스트 메시지 띄우기
            //Toast.makeText(this,"ImageView Long Event",Toast.LENGTH_LONG).show()
            val myToast = Toast.makeText(this,"Long",Toast.LENGTH_LONG)
            myToast.show()
            
            true
        }
        
        binding.rdGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rd_dog -> {
                    Toast.makeText(this,"Dog",Toast.LENGTH_SHORT).show()
                }
                R.id.rd_cat -> {
                    Toast.makeText(this,"Cat",Toast.LENGTH_SHORT).show()
                }
                R.id.rd_rabbit -> {
                    Toast.makeText(this,"Rabbit",Toast.LENGTH_SHORT).show()
                }
            }
        }
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
        //Log.d("tag","Key Down")

        when(keyCode){
            KeyEvent.KEYCODE_A -> {Log.d("tag","Key A Down")}
            KeyEvent.KEYCODE_0 -> {Log.d("tag","Key 0 Down")}
            KeyEvent.KEYCODE_BACK -> {Log.d("tag","Key BACK Down")}
        }

        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("tag","Key Up")
        return super.onKeyUp(keyCode, event)
    }
}