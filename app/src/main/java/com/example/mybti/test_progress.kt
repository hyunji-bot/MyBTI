package com.example.mybti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test_main_l.*
import kotlinx.android.synthetic.main.activity_test_progress_l.*
import kotlinx.android.synthetic.main.question_1.*
import kotlinx.android.synthetic.main.question_2.*
import kotlinx.android.synthetic.main.question_3.*
import kotlinx.android.synthetic.main.question_4.*


class test_progress : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_progress_l)

        val intent = Intent(this, test_result::class.java) // 인텐트를 생성

        button8.setOnClickListener { // 버튼 클릭시 할 행동

            startActivity(intent)  // 화면 전환하기
        }

        button9.setOnClickListener { // 버튼 클릭시 할 행동

        }

        button11.setOnClickListener { // 버튼 클릭시 할 행동

        }

        button12.setOnClickListener { // 버튼 클릭시 할 행동

        }

        button13.setOnClickListener { // 버튼 클릭시 할 행동

        }

        button14.setOnClickListener { // 버튼 클릭시 할 행동

        }

        button15.setOnClickListener { // 버튼 클릭시 할 행동

        }

        button16.setOnClickListener { // 버튼 클릭시 할 행동

        }



    }
}
