package com.example.assignment1_2_loginregister.data

data class ResponseLogin(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Somedata?
)

data class Somedata (
    val jwt : String
)