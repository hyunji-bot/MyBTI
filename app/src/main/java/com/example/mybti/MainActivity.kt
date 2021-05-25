package com.example.mybti

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val OPEN_GALLERY = 1
    var mbtiTest :MbtiTest = MbtiTest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, create::class.java) // 인텐트를 생성

        Log.d("mbti", getIntent().hasExtra("mbti").toString())
        if(getIntent().hasExtra("mbti")) {
            val temp = getIntent().getParcelableExtra<MbtiTest>("mbti")
            Log.d("tag", temp.title)
            Log.d("tag", temp.EorIAnswer[0])
        }

        button6.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(intent)  // 화면 전환하기
        }
    }

    // images loading
    private fun openGallery() {
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, OPEN_GALLERY)
    }

}
