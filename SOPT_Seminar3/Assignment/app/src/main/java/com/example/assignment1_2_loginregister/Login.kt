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
    val CODE=1000
    val requestToServer = RequestToServer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        check()
    }
    fun check()
    {
        et_id.setText(intent.getStringExtra("id")?.toString())
        et_pwd.setText(intent.getStringExtra("pw")?.toString())
        setResult(Activity.RESULT_OK,intent)


        btn_login.setOnClickListener {
            if(et_id.text.isNullOrBlank() || et_pwd.text.isNullOrBlank())
            {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
            }
            else
            {
                requestToServer.service.requestLogin(
                    RequestLogin(id = et_id.text.toString(),
                        password = et_pwd.text.toString())
                ).enqueue(object : Callback<ResponseLogin>
                {
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        Log.d("로그인 통신 실패", "${t}")
                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        if(response.isSuccessful)
                        {
                            if(response.body()!!.success)
                            {
                                Log.d("로그인 성공", "id : ${et_id.text.toString()}, pw : ${et_pwd.text.toString()}")
                                Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                                val intent = Intent(applicationContext, MainActivity::class.java)
                                startActivityForResult(intent,CODE)
                            }
                            else
                            {
                                Toast.makeText(applicationContext, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }

                })

            }

        }
        tv_register.setOnClickListener {
            val intent = Intent(applicationContext, Register::class.java)
            startActivity(intent)

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CODE) {
                Log.d("로그인", "종료")
                finish()
            }
        }
    }

}
