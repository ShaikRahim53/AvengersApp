package com.Rahim.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    lateinit var textToBedis : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        textToBedis = findViewById(R.id.textToAdd)

        if (intent!= null)
        {
            textToBedis.text = intent.getStringExtra("Nameoftext")
        }
    }
}