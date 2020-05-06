package com.example.assignment1_2_loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*val et_email = findViewById<EditText>(R.id.et_email)
        val et_pwd = findViewById<EditText>(R.id.et_pwd)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val tv_register = findViewById<TextView>(R.id.tv_register)*/

        btn_login.setOnClickListener {
            if (et_email.text.isNullOrBlank()||et_pwd.text.isNullOrBlank()){
                Toast.makeText(this, "이메일과 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        tv_register.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivityForResult(intent, 1000)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1000 && resultCode == RESULT_OK){
            Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
            et_email.setText(data?.getStringExtra("email"))
            et_pwd.setText(data?.getStringExtra("password"))
        }
    }
}
