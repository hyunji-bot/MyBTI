package com.example.mybti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_l.*

class activity_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_l)

        val intent = Intent(this, test_main::class.java) // 인텐트를 생성
        button2.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(intent)  // 화면 전환하기
        }
    }
}