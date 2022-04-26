package com.example.demo3_kt

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        val bundle = intent.extras
        val id1String = bundle?.getString(MainActivity.ID1)
        val b1 = findViewById<Button>(R.id.button1)
        b1.text = id1String
        b1.setOnClickListener(this)
        val b2 = findViewById<Button>(R.id.button2)
        b2.setOnClickListener(this)
        val b3 = findViewById<Button>(R.id.button3)
        b3.setOnClickListener(MyInnerListener())
        val b4 = findViewById<Button>(R.id.button4)
        b4.setOnClickListener(AnotherListener(this))
        val b5 = findViewById<Button>(R.id.button5)
        b5.setOnClickListener(View.OnClickListener { v ->
            Toast.makeText(
                this,
                "button5 clicked",
                Toast.LENGTH_LONG
            ).show()
        })
        val b6 = findViewById<Button>(R.id.button6)
        b6.setOnClickListener(View.OnClickListener { _ ->
            Toast.makeText(
                this,
                "button6 clicked",
                Toast.LENGTH_LONG
            ).show()
        })
        val b7 = findViewById<Button>(R.id.button7)
        b7.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                this,
                "button7 clicked",
                Toast.LENGTH_LONG
            ).show()
        })
        val b8 = findViewById<Button>(R.id.button8)
        b8.setOnClickListener() {
            Toast.makeText(
                this,
                "button8 clicked",
                Toast.LENGTH_LONG
            ).show()
        }
        val b9 = findViewById<Button>(R.id.button9)
        b9.setOnClickListener {
            Toast.makeText(
                this,
                "button9 clicked",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    inner class MyInnerListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            Toast.makeText(this@SecondActivity,"button3 clicked",Toast.LENGTH_LONG).show()
        }

    }


    override fun onClick(p0: View?) {
        var message = ""
        when (p0?.id) {
            R.id.button1 -> message = "button1"
            R.id.button2 -> message = "button2"
        }
        Toast.makeText(this, "${message} clicked", Toast.LENGTH_LONG).show()
    }


}