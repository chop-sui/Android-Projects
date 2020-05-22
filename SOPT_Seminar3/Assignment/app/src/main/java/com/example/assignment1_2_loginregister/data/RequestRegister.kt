package com.example.assignment1_2_loginregister.data

data class RequestRegister(
    val id: String,
    val password: String,
    val name: String,
    val email: String,
    val phone: String
)