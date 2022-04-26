package com.example.demo3_kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun doActivity(v : View) {
        val intent = Intent()
        intent.setClass(this,SecondActivity::class.java)
        startActivity(intent)
    }
}