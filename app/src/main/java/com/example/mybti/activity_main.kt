package com.example.mybti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main2.*

class activity_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = Intent(this, test_main::class.java) // 인텐트를 생성

        Log.d("tag", this.intent.hasExtra("mbti").toString())
        if (this.intent.hasExtra("mbti")) {
            val temp = this.intent.getParcelableExtra<MbtiTest>("mbti")
            button2.text = temp.title
            intent.putExtra("mbti", temp)
        }

        button2.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(intent)  // 화면 전환하기
        }

        val intent2 = Intent(this, create::class.java)
        button.setOnClickListener {
            startActivity(intent2)
        }
    }
}
