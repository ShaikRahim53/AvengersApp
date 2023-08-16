package com.Rahim.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var etMobileNumber : EditText
    lateinit var etPassword : EditText
    lateinit var loginButton : Button
    lateinit var txtForgotPassword : TextView
    lateinit var txtRegister : TextView
    lateinit var sharedPreferences: SharedPreferences
    val validMobileNumber = "9182031938"
    val validPassword = arrayOf("tony","steve","bruce","thanos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        val loggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if(loggedIn)
        {
            val intent = Intent(this@LoginActivity,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }
        title = "Log in"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        loginButton = findViewById(R.id.loginButton)
        txtForgotPassword = findViewById(R.id.forgotPassword)
        txtRegister = findViewById(R.id.registerHere)
        loginButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val mobileNumber = etMobileNumber.text.toString()
        val password = etPassword.text.toString()
        var nameOfAvenger = "Avengers"
        val intent = Intent(this@LoginActivity,AvengersActivity::class.java)
        if (( mobileNumber == validMobileNumber))
        {
            if ( password == validPassword[0])
            {

                nameOfAvenger = "Iron Man"
                savePreferences(nameOfAvenger)
                startActivity(intent)
            }
            else if( password == validPassword[1])
            {

                nameOfAvenger = "Captain America"
                savePreferences(nameOfAvenger)
                startActivity(intent)
            }
            else if( password == validPassword[2])
            {

                nameOfAvenger = "The Hulk"
                savePreferences(nameOfAvenger)
                startActivity(intent)
            }
            else if( password == validPassword[3])
            {

                nameOfAvenger = "The Avengers"
                savePreferences(nameOfAvenger)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(
                    this@LoginActivity,
                    "Incorrect credentials",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        else {
            Toast.makeText(
                this@LoginActivity,
                "Incorrect credentials",
                Toast.LENGTH_LONG
            ).show()
        }
        }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title:String)
    {
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("titleName",title).apply()
    }
}
