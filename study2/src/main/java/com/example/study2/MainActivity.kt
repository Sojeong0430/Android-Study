package com.example.study2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.study2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var TAG = "tag"

        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDate.setOnClickListener {
            DatePickerDialog(this, object:DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    //TODO("Not yet implemented")
                    Log.d("tag","$year ${month+1} $dayOfMonth")

                    binding.btnDate.text = "$year ${month+1} $dayOfMonth"
                }
            },2025,4,12).show()
        }

        binding.btnTime.setOnClickListener {
            TimePickerDialog(this,object :TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    //TODO("Not yet implemented")

                    binding.btnTime.text = "$hourOfDay $minute"
                    binding.btnItem.setTextColor(Color.rgb(255,0,0))
                }
            },15,19,true).show()
        }

        //이벤트 핸들러
        val eventhandler = object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                //TODO("Not yet implemented")
                if(which == DialogInterface.BUTTON_POSITIVE){
                    Log.d("tag", "POSITIVE BUTTON")
                }
                else if(which == DialogInterface.BUTTON_NEGATIVE){
                    Log.d("tag", "NEGATIVE BUTTON")
                }
                else if(which == DialogInterface.BUTTON_NEUTRAL){
                    Log.d("tag", "NEUTRAL BUTTON")
                }
            }
        }

        var items = arrayOf<String>("빨강","초록","파랑","노랑")

        var selected = 1

        //이벤트 핸들러2
        val eventhandler2 = object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                //TODO("Not yet implemented")
                if(which == DialogInterface.BUTTON_POSITIVE){
                    Log.d("tag", "POSITIVE BUTTON")
                    binding.btnSingle.text = "${items[selected]} 선택"
                    binding.btnSingle.textSize = 24f
                    binding.btnSingle.setTextColor(Color.rgb(255,0,0,))
                }
                else if(which == DialogInterface.BUTTON_NEGATIVE){
                    Log.d("tag", "NEGATIVE BUTTON")
                }
                else if(which == DialogInterface.BUTTON_NEUTRAL){
                    Log.d("tag", "NEUTRAL BUTTON")
                }
            }
        }

/*        binding.btnAlert.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("종료")
            dialog.setMessage("정말로 종료하실건가요?")
            dialog.setIcon(android.R.drawable.ic_dialog_alert)
            dialog.setPositiveButton("OK",null)
            dialog.setNegativeButton("NO",null)
            dialog.setNeutralButton("MORE",null)
            dialog.show()
        }*/

        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).run{
                setTitle("종료")
                setMessage("정말로 종료하실건가요?")
                setIcon(android.R.drawable.ic_dialog_alert)
                setPositiveButton("OK",eventhandler)
                setNegativeButton("NO",eventhandler)
                setNeutralButton("MORE",eventhandler)
                show()
            }
        }

        binding.btnItem.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("알림")
                setIcon(android.R.drawable.ic_dialog_alert)
                setItems(items,object:DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        //TODO("Not yet implemented")
                        binding.btnItem.text = "${items[which]} 선택"
                        binding.btnItem.textSize = 24f
                        binding.btnItem.setTextColor(Color.rgb(255,0,0,))
                    }
                })
                setPositiveButton("예", eventhandler)
                setNegativeButton("아니오", eventhandler)
                setNeutralButton("상세정보", eventhandler)
                show()
            }
        }

        binding.btnSingle.setOnClickListener {
            AlertDialog.Builder(this).run{
                setTitle("알림")
                setSingleChoiceItems(items, 1, object:DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        //TODO("Not yet implemented")
                        selected = which
                    }
                })
                setIcon(android.R.drawable.ic_dialog_alert)
                setPositiveButton("OK",eventhandler2)
                setNegativeButton("NO",eventhandler2)
                setNeutralButton("MORE",eventhandler2)
                show()
            }
        }

        binding.btnMulti.setOnClickListener {
            AlertDialog.Builder(this).run{
                setTitle("알림")
                setMultiChoiceItems(items, booleanArrayOf(true,true,false,false), null)
                setIcon(android.R.drawable.ic_dialog_alert)
                setPositiveButton("OK",eventhandler)
                setNegativeButton("NO",eventhandler)
                setNeutralButton("MORE",eventhandler)
                show()
            }
        }
    }
}