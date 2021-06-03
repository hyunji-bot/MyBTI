package com.example.mybti

import android.content.Intent
import android.graphics.BitmapFactory
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_test_main_l.*


class test_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_main_l)

        val intent = Intent(this, activity_main::class.java) // 인텐트를 생성
        val intent2 = Intent(this, test_progress::class.java) // 인텐트를 생성

        val temp = this.intent.getParcelableExtra<MbtiTest>("mbti")
        if(temp != null) {
            intent2.putExtra("mbti", temp)
            textView.text = temp.title

            imageView.setImageBitmap(temp.image[0])
        }

        imageButton.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(intent)  // 화면 전환하기
        }

        Start.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(intent2)  // 화면 전환하기
        }
    }
}
