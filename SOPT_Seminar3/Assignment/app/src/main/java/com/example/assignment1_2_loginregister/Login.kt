package com.example.assignment1_2_loginregister

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.assignment1_2_loginregister.data.RequestLogin
import com.example.assignment1_2_loginregister.data.ResponseLogin
import com.example.assignment1_2_loginregister.network.RequestToServer
import com.example.assignment1_2_loginregister.network.customEnqueue
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private val REQUEST_CODE = 100
    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if(MySharedPreferences.getUserId(this).isNullOrBlank()
            || MySharedPreferences.getUserPwd(this).isNullOrBlank()) {
            login()
        }

        tv_register.setOnClickListener{
            var intent = Intent(this, Register::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    fun login() {

        et_id.textChangedListener {
            if(it.isNullOrBlank()) {
                showToast("아이디를 입력해주세요")
            }
        }
        btn_login.setOnClickListener {
            if(et_id.text.isNullOrBlank() || et_pwd.text.isNullOrBlank()) {
                showToast("아이디/비밀번호를 확인하세요")
            }
            else {
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = et_id.text.toString(),
                        password = et_pwd.text.toString()
                    )
                ).customEnqueue(
                    onError = {showToast("잘못된 요청입니다.")},
                    onSuccess = {
                        if(it.success) {
                            MySharedPreferences.setUserId(this, et_id.text.toString())
                            MySharedPreferences.setUserPwd(this, et_pwd.text.toString())
                            showToast("${MySharedPreferences.getUserId(this)} 로그인 성공")
                            var intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            showToast("아이디/비밀번호를 확인하세요")
                        }
                    }
                )
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val id = data?.getStringExtra("id")
                val pwd = data?.getStringExtra("pwd")
                et_id.setText(id)
                et_pwd.setText(pwd)
                login()
            }
        }
    }
}