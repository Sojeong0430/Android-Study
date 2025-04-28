package com.example.study

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var datePickerDialog: DatePickerDialog
        lateinit var timePickerDialog: TimePickerDialog
        lateinit var mealPickerDialog: AlertDialog
        lateinit var otherPickerDialog: DatePickerDialog

        var y = 2025
        var m = 4
        var d = 12

        var h = 15
        var mi = 10

        var items = arrayOf<String>("많이", "보통", "적게")
        var selected = 1

        var multiItems = arrayOf<String>("나트륨 적게", "설탕 적게")
        var str = ""

        val dateEventHandler = object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    binding.dateT.text = "$y 년 $m 월 $d 일"
                    Toast.makeText(applicationContext,"$y 년 $m 월 $d 일",Toast.LENGTH_SHORT).show()
                }
                else if(which == DialogInterface.BUTTON_NEGATIVE){
                    Log.d("tag","close")
                }
            }
        }


        val mealEventHandler = object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    binding.mealT.text = "${items[selected]}"
                    Toast.makeText(applicationContext,"${items[selected]} 선택",Toast.LENGTH_SHORT).show()
                }
                else if(which == DialogInterface.BUTTON_NEGATIVE){
                    Log.d("tag","close")
                }
            }
        }

        val mul_selected = arrayOf<Boolean>(false,false)

        val otherEventHandler = object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    str = ""
                    for(i in 0..1){
                        if(mul_selected[i] == true){
                            str += multiItems[i]+" ";
                        }
                    }
                    binding.otherT.text = str
                    Toast.makeText(applicationContext,"$str 선택",Toast.LENGTH_SHORT).show()
                }
                else if(which == DialogInterface.BUTTON_NEGATIVE){
                    Log.d("tag","close")
                }
            }
        }

        //날짜 선택
        binding.date.setOnClickListener {
            datePickerDialog = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    y = year
                    m = month + 1
                    d = dayOfMonth
                }
            }, 2025, 3, 12)

            datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "확인", dateEventHandler)
            datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "취소", dateEventHandler)
            datePickerDialog.show()
        }

        //시간 선택
        binding.time.setOnClickListener {
            timePickerDialog = TimePickerDialog(this, object:TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    h = hourOfDay
                    mi = minute
                    binding.timeT.text = "$hourOfDay 시 $minute 분"
                    Toast.makeText(applicationContext,"$h 시 $mi 분",Toast.LENGTH_SHORT).show()
                }
            },17,30,true)
            timePickerDialog.show()
        }

        //식사량 선택
        binding.meal.setOnClickListener {
            AlertDialog.Builder(this).run{
                setTitle("식사량 선택")
                setIcon(android.R.drawable.ic_dialog_alert)
                setSingleChoiceItems(items,1,object:DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        selected = which
                    }
                })
                setPositiveButton("예",mealEventHandler)
                setNeutralButton("아니오",mealEventHandler)
                show()
            }
        }

        //특이사항
        binding.other.setOnClickListener {
            AlertDialog.Builder(this).run{
                setTitle("특이사항 선택")
                setMultiChoiceItems(multiItems, booleanArrayOf(false,false),object:DialogInterface.OnMultiChoiceClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                        mul_selected[which] = isChecked
                    }
                })
                setPositiveButton("예",otherEventHandler)
                setNegativeButton("아니오",otherEventHandler)
                show()
            }
        }

        binding.save.setOnClickListener {
            binding.save.text="수정"
            binding.result.text = "$y 년 $m 월 $d 일\n" + "$h 시 $mi 분\n" + "${items[selected]}\n" + str
            binding.result.visibility = View.VISIBLE
        }
    }
}