package com.example.assignment1_2_loginregister.network

import com.example.assignment1_2_loginregister.data.RequestLogin
import com.example.assignment1_2_loginregister.data.ResponseLogin
import com.example.assignment1_2_loginregister.data.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface{
    @POST("/user/signin")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>

    @POST("/user/signup")
    fun requestRegister(
        @Body body: String,
        pw: String,
        name: String,
        phone: String,
        email: String
    ) :Call<ResponseRegister>
}