package com.example.study4

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.study4.databinding.ActivitySecondBinding
import com.example.study4.databinding.CustomChoiceBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            intent.putExtra("text","눌림!!!!")
            setResult(RESULT_OK,intent)
            finish()
        }

        val item = arrayOf<Int>(1,2,3,4)
        val itemText = item.map { it.toString() }.toTypedArray() // Int 배열을 String 배열로 변환
        var single_seleted = 0

        binding.single.setOnClickListener {
            AlertDialog.Builder(this).run{
                setTitle("알림")
                setIcon(android.R.drawable.ic_dialog_alert)
                setSingleChoiceItems(itemText, 1, object:DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        single_seleted = which
                    }
                })
                setPositiveButton("yes",null)
                setNegativeButton("No",null)
                show()
            }
        }

        var items = arrayOf<String>("a","b","c")
        var cheked = arrayOf<Boolean>(true,true,false)
        binding.many.setOnClickListener {
            AlertDialog.Builder(this).run{
                setTitle("알림")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMultiChoiceItems(items, booleanArrayOf(true,false,false), object:DialogInterface.OnMultiChoiceClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                        cheked[which] = isChecked
                    }
                })
                setPositiveButton("yes",null)
                setNegativeButton("No",null)
                show()
            }
        }

        val cus_binding = CustomChoiceBinding.inflate(layoutInflater)

        val eventhandler_cus = object :DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    if(cus_binding.chi.isChecked == true){
                        binding.user.text = cus_binding.chi.text.toString()
                    }
                }
            }
        }

        val cus_dia = AlertDialog.Builder(this).run{
            setTitle("알림")
            setView(cus_binding.root)
            setPositiveButton("yes",null)
        }

        binding.user.setOnClickListener {
            cus_dia.show()
        }

    }
}