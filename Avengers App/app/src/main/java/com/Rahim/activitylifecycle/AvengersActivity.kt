package com.Rahim.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity(),View.OnClickListener {
    var titleName:String?= "The Avengers"
    lateinit var etText : EditText
    lateinit var sendButton : Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)
        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name),Context.MODE_PRIVATE)

        titleName = sharedPreferences.getString("titleName","The Avengers")
        title = titleName

        etText = findViewById(R.id.etText)
        sendButton = findViewById(R.id.sendButton)
        sendButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val textToSend = etText.text.toString()
        val intent = Intent(this@AvengersActivity,MessageActivity::class.java)
        intent.putExtra("Nameoftext",textToSend)
        startActivity(intent)
    }
}