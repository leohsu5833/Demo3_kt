package com.example.demo3_kt

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.READ_CONTACTS
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun doActivity(v: View) {
        val intent = Intent()
        val bundle = Bundle()
        bundle.putString(ID1, "12345")
        intent.putExtras(bundle)
        intent.setClass(this, SecondActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val ID1 = "id";
        const val PHONE_PERMISSION_CHECK = 8888
    }

    fun doCall(view: View?) {
        if (ContextCompat.checkSelfPermission(
                this,
                CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    CALL_PHONE
                )
            ) {
                showPromptDialog()
            } else {
                askForPermission()
            }
        } else {
            callAction()
        }
    }

    private fun askForPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(CALL_PHONE), PHONE_PERMISSION_CHECK
        )
    }

    private fun showPromptDialog() {
        AlertDialog.Builder(this)
            .setTitle("need call phone permission")
            .setMessage("for authentication")
            .setPositiveButton("OK"){d,w -> askForPermission()}
            .setNegativeButton("No"){d,w -> finish()}
            .show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PHONE_PERMISSION_CHECK -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    callAction()
                } else {
                    val textView = findViewById<TextView>(R.id.textView1)
                    textView.text = "oops"

                }
            }
        }
    }

    private fun callAction() {
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