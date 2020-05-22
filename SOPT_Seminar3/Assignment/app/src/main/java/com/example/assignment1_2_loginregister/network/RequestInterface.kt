package com.example.assignment1_2_loginregister.network

import com.example.assignment1_2_loginregister.data.RequestLogin
import com.example.assignment1_2_loginregister.data.RequestRegister
import com.example.assignment1_2_loginregister.data.ResponseLogin
import com.example.assignment1_2_loginregister.data.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface{
    @POST("/user/signin")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>

    @POST("/user/signup")
    fun requestRegister(@Body body : RequestRegister) : Call<ResponseRegister>

}