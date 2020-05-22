package com.example.assignment1_2_loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment1_2_loginregister.data.RequestRegister
import com.example.assignment1_2_loginregister.network.RequestToServer
import com.example.assignment1_2_loginregister.network.customEnqueue
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    private lateinit var id: String
    private lateinit var pwd: String
    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener{
            id = et_id.text.toString()
            pwd = et_pwd.text.toString()

            if(et_id.text.isNullOrBlank() || et_pwd.text.isNullOrBlank() || et_pwd_cf.text.isNullOrBlank() || et_name.text.isNullOrBlank() || et_email.text.isNullOrBlank() || et_phone.text.isNullOrBlank()) {
                showToast("정보를 모두 작성해주세요.")
            }
            else {
                if(pwd == et_pwd_cf.text.toString()) {
                    requestToServer.service.requestRegister(
                        RequestRegister(
                            id = et_id.text.toString(),
                            password = et_pwd.text.toString(),
                            name = et_name.text.toString(),
                            email = et_email.text.toString(),
                            phone = et_phone.text.toString()
                        )
                    ).customEnqueue(
                        onError = {showToast("잘못된 요청입니다")},
                        onSuccess = {
                            if(it.status == 200) {
                                showToast("중복되는 아이디입니다.")
                            }
                            else if(it.success) {
                                showToast("회원가입 성공")
                                var intent = Intent(this@Register, Login::class.java)
                                intent.putExtra("id", id)
                                intent.putExtra("pwd", pwd)
                                setResult(RESULT_OK, intent)

                                MySharedPreferences.setUserId(this@Register, id)
                                MySharedPreferences.setUserPwd(this@Register, pwd)
                            }
                            else {
                                showToast("정보를 모두 작성해주세요.")
                            }
                        }
                    )
                } else {
                    showToast("비밀번호를 확인해주세요.")
                }
            }
        }
    }
}