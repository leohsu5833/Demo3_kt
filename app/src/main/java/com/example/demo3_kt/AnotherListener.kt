package com.example.demo3_kt

import android.view.View
import android.widget.Toast

class AnotherListener(secondActivity: SecondActivity) :
    View.OnClickListener {
    val context = secondActivity
    override fun onClick(p0: View?) {
        Toast.makeText(context, "Another Listener", Toast.LENGTH_LONG).show()
    }

}
