package com.example.s2_a2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var dogList = arrayListOf<Dog>(
        Dog("Golden Retreiver", "Female", "2", "dog1"),
        Dog("Pug", "Male", "4", "dog2"),
        Dog("Huskey", "Male", "3", "dog3"),
        Dog("Poodle", "Female", "5", "dog4"),
        Dog("Yorkshire Terrier", "Male", "1", "dog5"),
        Dog("Bedlington Terrier", "Female", "3", "dog6")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdapter = MainRvAdapter(this, dogList)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.addItemDecoration(CustomDividerItemDecoration(this))

        val lm = LinearLayoutManager(this)
        mRecyclerView.layoutManager = lm
        mRecyclerView.setHasFixedSize(true)
    }
}
