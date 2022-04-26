package com.example.demo3_kt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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

    fun doCall(view: View?) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:022222222")
        try {
            startActivity(intent)
        } catch (se: SecurityException) {
            val textView = findViewById<TextView>(R.id.textView1)
            textView.text = se.message
        }
    }
}