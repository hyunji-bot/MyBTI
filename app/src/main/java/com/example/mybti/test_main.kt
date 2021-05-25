package com.example.mybti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test_main_l.*


class test_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_main_l)

        val intent = Intent(this, activity_main::class.java) // 인텐트를 생성
        imageButton.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(intent)  // 화면 전환하기
        }

        val intent2 = Intent(this, test_progress::class.java) // 인텐트를 생성
        Start.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(intent2)  // 화면 전환하기
        }
    }
}
