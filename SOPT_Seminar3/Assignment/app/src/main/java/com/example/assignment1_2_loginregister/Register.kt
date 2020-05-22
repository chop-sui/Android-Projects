package com.example.assignment1_2_loginregister

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.assignment1_2_loginregister.data.ResponseRegister
import com.example.assignment1_2_loginregister.network.RequestToServer
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {

    val CODE =100
    lateinit var pref : SharedPreferences
    lateinit var editor :SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        check()
    }
    fun check()
    {
        pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        editor = pref.edit()
        btn_register.setOnClickListener {
            if(et_pwd.text.isNullOrBlank() || et_id.text.isNullOrBlank())
            {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
            }
            else{
                if(et_pwd.text.toString().equals(et_pwd_cf.text.toString()))
                {
                    connect()
                }
                else
                {
                    Toast.makeText(this, "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
    fun connect()
    {
        pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        editor = pref.edit()
        val requestToServer= RequestToServer
        val id = et_id.text.toString()
        val pw = et_pwd.text.toString()
        val name = et_name.text.toString()
        val phone = et_phone.text.toString()
        val email = et_email.text.toString()

        requestToServer.service.requestRegister(id, pw, name, phone, email)
            .enqueue(
                object : Callback<ResponseRegister> {
                    override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                        Log.d("통신 실패", "${t}")
                    }
                    override fun onResponse(
                        call: Call<ResponseRegister>,
                        response: Response<ResponseRegister>
                    ) {
                        if (response.isSuccessful) {
                            if (response.body()!!.success) {
                                Log.d("회원가입 성공", "id : ${id}, pw : ${pw}")
                                Toast.makeText(applicationContext, "회원가입 되었습니다.", Toast.LENGTH_SHORT).show()
                                val intent = Intent(applicationContext, Login::class.java)
                                editor.putString("id", et_id.text.toString())
                                editor.putString("pw", et_pwd.text.toString())
                                editor.commit()
                                intent.putExtra("id", et_id.text.toString())
                                intent.putExtra("pw", et_pwd.text.toString())
                                startActivityForResult(intent, CODE)
                            }
                            else
                            {
                                if (response.body()!!.status == 200) {
                                    Toast.makeText(applicationContext, "${response.body()!!.message}", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }
                })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== Activity.RESULT_OK)
        {
            if(requestCode==CODE)
            {
                finish()
            }
        }

    }



}