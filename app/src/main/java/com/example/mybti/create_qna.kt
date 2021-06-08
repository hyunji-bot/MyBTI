package com.example.mybti

import android.app.ProgressDialog.show
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_qna.*
import kotlinx.android.synthetic.main.create_qna_1.*
import kotlinx.android.synthetic.main.create_qna_1.editTextTextMultiLine2_1
import kotlinx.android.synthetic.main.create_qna_2.*
import kotlinx.android.synthetic.main.create_qna_3.*
import kotlinx.android.synthetic.main.create_qna_4.*
import java.io.File

class create_qna : AppCompatActivity() {
    var mbtiTest: MbtiTest = MbtiTest()
    var i: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_qna)

        frameLayout.removeView(create_qna_2)
        frameLayout.removeView(create_qna_3)
        frameLayout.removeView(create_qna_4)

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


        val intent = Intent(this, create_mbti::class.java) // 인텐트를 생성

        nextbtn.setOnClickListener { // 버튼 클릭시 할 행동
            this.scroll.scrollY = 0
            when(i) {
                0 -> {
                    if(check_EI()) {
                        saveTest_EI()
                        frameLayout.removeView(create_qna_1)
                        frameLayout.addView(create_qna_2)
                        removeBar()
                        bar.addView(imageView7)
                        bar.addView(imageView6)
                        bar.addView(imageView8)
                        bar.addView(imageView9)
                        i++
                    }
                    else {
                        Toast.makeText(this.getApplicationContext(),"입력사항을 모두 입력하세요!", Toast.LENGTH_SHORT).show()
                    }
                }
                1 -> {
                    saveTest_SN()
                    frameLayout.removeView(create_qna_2)
                    frameLayout.addView(create_qna_3)
                    removeBar()
                    bar.addView(imageView7)
                    bar.addView(imageView8)
                    bar.addView(imageView6)
                    bar.addView(imageView9)
                    i++
                }
                2 -> {
                    saveTest_TF()
                    frameLayout.removeView(create_qna_3)
                    frameLayout.addView(create_qna_4)
                    removeBar()
                    bar.addView(imageView7)
                    bar.addView(imageView8)
                    bar.addView(imageView9)
                    bar.addView(imageView6)
                    i++
                }
                3 -> {
                    saveTest_PJ()
                    intent.putExtra("mbti", mbtiTest)
                    startActivity(intent)  // 화면 전환하기
                    i++
                }
            }
        }
    }

    fun removeBar() {
        bar.removeView(imageView6)
        bar.removeView(imageView7)
        bar.removeView(imageView8)
        bar.removeView(imageView9)
    }

    fun check_EI(): Boolean {
        var result: Boolean = true
        if(editTextTextMultiLine1.text.toString().equals(""))
            result = false
        if(editTextTextMultiLine1_1.text.toString().equals(""))
            result = false
        if(editTextTextMultiLine1_2.text.toString().equals(""))
            result = false
        if(editTextTextMultiLine2.text.toString().equals(""))
            result = false
        if(editTextTextMultiLine2_1.text.toString().equals(""))
            result = false
        if(editTextTextMultiLine2_2.text.toString().equals(""))
            result = false
        if(editTextTextMultiLine3.text.toString().equals(""))
        result = false
        if(editTextTextMultiLine3_1.text.toString().equals(""))
            result = false
        if(editTextTextMultiLine3_2.text.toString().equals(""))
            result = false

        return result
    }

    fun saveTest_EI() {
        mbtiTest.EorIQuestion.add(editTextTextMultiLine1.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine1_1.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine1_2.text.toString())
        mbtiTest.EorIQuestion.add(editTextTextMultiLine2.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine2_1.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine2_2.text.toString())
        mbtiTest.EorIQuestion.add(editTextTextMultiLine3.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine3_1.text.toString())
        mbtiTest.EorIAnswer.add(editTextTextMultiLine3_2.text.toString())
    }

    fun saveTest_SN() {
        mbtiTest.SorNQuestion.add(editTextTextMultiLine4.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine4_1.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine4_2.text.toString())
        mbtiTest.SorNQuestion.add(editTextTextMultiLine5.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine5_1.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine5_2.text.toString())
        mbtiTest.SorNQuestion.add(editTextTextMultiLine6.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine6_1.text.toString())
        mbtiTest.SorNAnswer.add(editTextTextMultiLine6_2.text.toString())
    }

    fun saveTest_TF() {
        mbtiTest.TorFQuestion.add(editTextTextMultiLine7.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine7_1.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine7_2.text.toString())
        mbtiTest.TorFQuestion.add(editTextTextMultiLine8.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine8_1.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine8_2.text.toString())
        mbtiTest.TorFQuestion.add(editTextTextMultiLine9.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine9_1.text.toString())
        mbtiTest.TorFAnswer.add(editTextTextMultiLine9_2.text.toString())
    }

    fun saveTest_PJ() {
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