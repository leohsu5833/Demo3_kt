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
    companion object {
        const val ID1 = "id";
    }

    fun doActivity(v : View) {
        val intent = Intent()
        val bundle = Bundle()
        bundle.putString(ID1, "12345")
        intent.putExtras(bundle)
        intent.setClass(this,SecondActivity::class.java)
        startActivity(intent)
    }
}