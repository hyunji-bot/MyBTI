package com.example.mybti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_create_mbti.*
import kotlinx.android.synthetic.main.create_mbti.*
import kotlinx.android.synthetic.main.create_mbti_2.*

class create_mbti : AppCompatActivity() {
    lateinit var mbtiTest: MbtiTest
    var i: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_mbti)
        val intent = Intent(this, activity_main::class.java) // 인텐트를 생성

        mbtiTest = this.intent.getParcelableExtra("mbti")

        frameLayout2.removeView(create_mbti_2)
        
        nextbtn.setOnClickListener { // 버튼 클릭시 할 행동
            this.scroll2.scrollY = 0
            if(i == 0) {
                saveMbtiResult1()
                frameLayout2.removeView(create_mbti)
                frameLayout2.addView(create_mbti_2)
                bar2.removeView(imageView6)
                bar2.addView(imageView6)
            }

            if(i == 1) {
                saveMbtiResult2()
                intent.putExtra("mbti", mbtiTest)
                startActivity(intent)
            }

            i++
        }
    }

    fun saveMbtiResult1() {
        mbtiTest.result.add(resultMultiLine1_1.text.toString())
        mbtiTest.result.add(resultMultiLine1_2.text.toString())
        mbtiTest.result.add(resultMultiLine1_3.text.toString())
        mbtiTest.result.add(resultMultiLine1_4.text.toString())
        mbtiTest.result.add(resultMultiLine1_5.text.toString())
        mbtiTest.result.add(resultMultiLine1_6.text.toString())
        mbtiTest.result.add(resultMultiLine1_7.text.toString())
        mbtiTest.result.add(resultMultiLine1_8.text.toString())
    }

    fun saveMbtiResult2() {
        mbtiTest.result.add(resultMultiLine2_1.text.toString())
        mbtiTest.result.add(resultMultiLine2_2.text.toString())
        mbtiTest.result.add(resultMultiLine2_3.text.toString())
        mbtiTest.result.add(resultMultiLine2_4.text.toString())
        mbtiTest.result.add(resultMultiLine2_5.text.toString())
        mbtiTest.result.add(resultMultiLine2_6.text.toString())
        mbtiTest.result.add(resultMultiLine2_7.text.toString())
        mbtiTest.result.add(resultMultiLine2_8.text.toString())
    }
}