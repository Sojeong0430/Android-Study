package com.example.ch08_event

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ch08_event.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chbStart.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked == true){
                binding.choiceAnimal.visibility = View.VISIBLE
            }
            else{
                binding.choiceAnimal.visibility = View.INVISIBLE
            }
        }

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

        binding.ivAnimal.setOnLongClickListener{
            //Log.d("tag","ImageView LongClick Event")

            Toast.makeText(this,"ImageView LongClick Event",Toast.LENGTH_LONG).show()
            //같은 표현
            val my_toast = Toast.makeText(this,"ImageView LongClick Event",Toast.LENGTH_LONG)
            my_toast.show()

            true
        }

        binding.rdGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rd_dog -> {Toast.makeText(this,"Dog 선택됨",Toast.LENGTH_SHORT).show()}
                R.id.rd_cat -> {Toast.makeText(this,"Cat 선택됨",Toast.LENGTH_SHORT).show()}
                R.id.rd_rabbit -> {Toast.makeText(this,"Rabbit 선택됨",Toast.LENGTH_SHORT).show()}

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