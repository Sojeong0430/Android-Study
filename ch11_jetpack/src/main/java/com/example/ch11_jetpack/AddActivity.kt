package com.example.ch11_jetpack

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ch11_jetpack.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.addToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val date = intent.getStringExtra("today")
        binding.date.text = date

        binding.btnSave.setOnClickListener {
            val todo_str = binding.addEditView.text.toString()
            val db = DBHelper(this).writableDatabase
            db.execSQL("insert into TODO_TB (todo) values (?)", arrayOf<String>(todo_str))
            db.close() // 끝난 후 반드시 닫아주기

            val intent = intent
            intent.putExtra("result",binding.addEditView.text.toString())
            setResult(Activity.RESULT_OK, intent)

            finish()
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = intent
        intent.putExtra("result","")
        setResult(Activity.RESULT_OK, intent)

        finish()

        return super.onSupportNavigateUp()
    }
}