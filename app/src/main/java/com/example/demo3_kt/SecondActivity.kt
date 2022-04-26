package com.example.demo3_kt

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        val bundle = intent.extras
        val id1String = bundle?.getString(MainActivity.ID1)
        val b1 = findViewById<Button>(R.id.button1)
        b1.text = id1String

    }


}