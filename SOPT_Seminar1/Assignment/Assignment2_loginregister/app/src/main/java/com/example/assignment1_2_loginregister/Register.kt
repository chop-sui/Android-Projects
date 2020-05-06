package com.example.assignment1_2_loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

       /* val et_email = findViewById<EditText>(R.id.et_email)
        val et_pwd = findViewById<EditText>(R.id.et_pwd)
        val btn_register = findViewById<Button>(R.id.btn_register)*/ //Kotlin Extension 사용

        btn_register.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            intent.putExtra("email", et_email.getText().toString())
            intent.putExtra("password", et_pwd.getText().toString())

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
