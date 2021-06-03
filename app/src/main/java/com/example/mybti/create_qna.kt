package com.example.mybti

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import kotlinx.android.synthetic.main.activity_create_qna.*
import java.io.File

class create_qna : AppCompatActivity() {
    var mbtiTest: MbtiTest = MbtiTest()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_qna)

        Log.d("tag", intent.hasExtra("title").toString())
        if(intent.hasExtra("title")){
            val temp = intent.getStringExtra("title")
            Log.d("tag", temp)
            mbtiTest.title = temp
        }

        Log.d("tag", intent.hasExtra("image").toString())
        if(intent.hasExtra("image")) {
            val temp = intent.getStringExtra("image")
            Log.d("tag", temp)
            val imageBytes = Base64.decode(temp, 0)
            val image = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            mbtiTest.image.add(image)
        }


        val intent = Intent(this, activity_main::class.java) // 인텐트를 생성

        nextbtn.setOnClickListener { // 버튼 클릭시 할 행동
            saveTest()
            Log.d("mbti", mbtiTest.EorIAnswer[0])

            intent.putExtra("mbti", mbtiTest)

            startActivity(intent)  // 화면 전환하기
        }
    }

    fun saveTest() {
        mbtiTest.EorIQuestion.add(editTextTextMultiLine1.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine1_1.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine1_2.text.toString())
        mbtiTest.EorIQuestion.add(editTextTextMultiLine2.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine2_1.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine2_2.text.toString())
        mbtiTest.EorIQuestion.add(editTextTextMultiLine3.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine3_1.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine3_2.text.toString())

        mbtiTest.SorNQuestion.add(editTextTextMultiLine4.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine4_1.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine4_2.text.toString())
        mbtiTest.SorNQuestion.add(editTextTextMultiLine5.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine5_1.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine5_2.text.toString())
        mbtiTest.SorNQuestion.add(editTextTextMultiLine6.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine6_1.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine6_2.text.toString())

        mbtiTest.TorFQuestion.add(editTextTextMultiLine7.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine7_1.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine7_2.text.toString())
        mbtiTest.TorFQuestion.add(editTextTextMultiLine8.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine8_1.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine8_2.text.toString())
        mbtiTest.TorFQuestion.add(editTextTextMultiLine9.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine9_1.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine9_2.text.toString())

        mbtiTest.PorJQuestion.add(editTextTextMultiLine10.text.toString())
        mbtiTest.PorJAnswer.add(editTextTextMultiLine10_1.text.toString())
        mbtiTest.PorJAnswer.add(editTextTextMultiLine10_2.text.toString())
        mbtiTest.PorJQuestion.add(editTextTextMultiLine11.text.toString())
        mbtiTest.PorJAnswer.add(editTextTextMultiLine11_1.text.toString())
        mbtiTest.PorJAnswer.add(editTextTextMultiLine11_2.text.toString())
        mbtiTest.PorJQuestion.add(editTextTextMultiLine12.text.toString())
        mbtiTest.PorJAnswer.add(editTextTextMultiLine12_1.text.toString())
        mbtiTest.PorJAnswer.add(editTextTextMultiLine12_2.text.toString())

    }
}