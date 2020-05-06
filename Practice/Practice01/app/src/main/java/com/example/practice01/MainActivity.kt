package com.example.practice01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

fun main(args: Array<String>) {
    println("Hello World!")

    val a: Int = 10000
    val d: Double = 100.00
    val c: Float = 45.34f
    val l: Long = 10000004
    val s: Short = 10
    val b: Byte = 1
    val letter: Char = 'C'
    val bool: Boolean = true

    var rawString :String = "I am a Raw String!"
    val escapedString :String = "I am escaped String!\n"

    val numbers: IntArray = intArrayOf(1,2,3,4,5)

    val numbers2: MutableList<Int> = mutableListOf(1, 2, 3)
    val readOnlyView: List<Int> = numbers2

    println("Your Int Value is "+a)
    println("Your Double Value is "+d)
    println("Your Long Value is "+l)
    println("$letter")
    println("Your Boolean Value is "+"$bool")

    println("Hello! "+escapedString)
    println("Hello! "+rawString)

    println("Hey! I am an array element "+numbers[3])
    println("my mutable list--"+numbers2)
    numbers2.add(4)
    println("my mutable list after addition--"+numbers2)
    println(readOnlyView)
}
