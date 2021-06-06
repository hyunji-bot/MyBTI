package com.example.mybti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_create_mbti.*

class create_mbti : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_mbti)
        val intent = Intent(this, create_mbti::class.java) // 인텐트를 생성

        nextbtn.setOnClickListener { // 버튼 클릭시 할 행동

            startActivity(intent)  // 화면 전환하기
        }
    }


}