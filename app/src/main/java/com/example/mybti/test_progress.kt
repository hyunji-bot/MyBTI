package com.example.mybti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_test_main_l.*
import kotlinx.android.synthetic.main.activity_test_progress_l.*
import kotlinx.android.synthetic.main.activity_test_progress_l.view.*
import kotlinx.android.synthetic.main.question_1.*
import kotlinx.android.synthetic.main.question_2.*
import kotlinx.android.synthetic.main.question_3.*
import kotlinx.android.synthetic.main.question_4.*


class test_progress : AppCompatActivity() {
    lateinit var mbti: MbtiTest
    val mbtiResult = MbtiTestResult()
    var testmbti: MbtiTest = MbtiTest()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_progress)

        val intent = Intent(this, test_result::class.java)

        var i = 0
        //mbti = this.intent.getParcelableExtra<MbtiTest>("mbti") // "A"
         makeTest() // test 를 위해 만듦. 테스트 만들지 않고 진행을 원하면 "A"를 주석처리하고 이 주석 두개를 풀면 된다.
        mbti = testmbti
        changeQuestion_EI(i)

        button8.setOnClickListener { // 버튼 클릭시 할 행동
            i++
            if(i in 0..2) {
                changeQuestion_EI(i)
            }
            if(i == 3) {
                seekBar4.progress = 1
                frameLayout.question_1.visibility = View.INVISIBLE
                frameLayout.question_2.visibility = View.VISIBLE
                i = 0
                changeQuestion_SN(i)
            }
        }

        button9.setOnClickListener { // 버튼 클릭시 할 행동
            i++
            if(i in 0..2) {
                changeQuestion_EI(i)
                mbtiResult.EorIpoint++
                Log.d("point", mbtiResult.EorIpoint.toString())
            }
            if(i == 3) {
                seekBar4.progress = 1
                frameLayout.question_1.visibility = View.INVISIBLE
                frameLayout.question_2.visibility = View.VISIBLE
                i = 0
                changeQuestion_SN(i)
            }
        }

        button11.setOnClickListener { // 버튼 클릭시 할 행동
            i++
            if(i in 0..2) {
                changeQuestion_SN(i)
            }
            if(i == 3) {
                seekBar4.progress = 2
                frameLayout.question_2.visibility = View.INVISIBLE
                frameLayout.question_3.visibility = View.VISIBLE
                i = 0
                changeQuestion_TF(i)
            }
        }

        button12.setOnClickListener { // 버튼 클릭시 할 행동
            i++
            if(i in 0..2) {
                changeQuestion_TF(i)
                mbtiResult.SorNpoint++
                Log.d("point", mbtiResult.SorNpoint.toString())
            }
            if(i == 3) {
                seekBar4.progress = 2
                frameLayout.question_2.visibility = View.INVISIBLE
                frameLayout.question_3.visibility = View.VISIBLE
                i = 0
                changeQuestion_TF(i)
            }
        }

        button13.setOnClickListener { // 버튼 클릭시 할 행동
            i++
            if(i in 0..2) {
                changeQuestion_TF(i)
            }
            if(i == 3) {
                seekBar4.progress = 3
                frameLayout.question_3.visibility = View.INVISIBLE
                frameLayout.question_4.visibility = View.VISIBLE
                i = 0
                changeQuestion_PJ(i)
            }
        }

        button14.setOnClickListener { // 버튼 클릭시 할 행동
            i++
            if(i in 0..2) {
                changeQuestion_TF(i)
                mbtiResult.TorFpoint++
                Log.d("point", mbtiResult.TorFpoint.toString())
            }
            if(i == 3) {
                seekBar4.progress = 3
                frameLayout.question_3.visibility = View.INVISIBLE
                frameLayout.question_4.visibility = View.VISIBLE
                i = 0
                changeQuestion_PJ(i)
            }
        }

        button15.setOnClickListener { // 버튼 클릭시 할 행동
            i++
            if(i in 0..2) {
                changeQuestion_PJ(i)
            }
            if(i == 3) {
                i = 0
                intent.putExtra("result", mbtiResult)
                startActivity(intent)
                finish()
            }
        }

        button16.setOnClickListener { // 버튼 클릭시 할 행동
            i++
            if(i in 0..2) {
                changeQuestion_PJ(i)
                mbtiResult.PorJpoint++
                Log.d("point", mbtiResult.PorJpoint.toString())
            }
            if(i == 3) {
                i = 0
                intent.putExtra("result", mbtiResult)
                startActivity(intent)
                finish()
            }
        }



    }

    fun changeQuestion_EI(i: Int) {
        textView6.text = mbti.EorIQuestion[i]
        button8.text = mbti.EorIAnswer[2*i]
        button9.text = mbti.EorIAnswer[2*i+1]
    }

    fun changeQuestion_SN(i: Int) {
        textView10.text = mbti.SorNQuestion[i]
        button11.text = mbti.SorNAnswer[2*i]
        button12.text = mbti.SorNAnswer[2*i+1]
    }

    fun changeQuestion_TF(i: Int) {
        textView11.text = mbti.TorFQuestion[i]
        button13.text = mbti.TorFAnswer[2*i]
        button14.text = mbti.TorFAnswer[2*i+1]
    }

    fun changeQuestion_PJ(i: Int) {
        textView12.text = mbti.PorJQuestion[i]
        button15.text = mbti.PorJAnswer[2*i]
        button16.text = mbti.PorJAnswer[2*i+1]
    }

    fun makeTest() {
        testmbti.EorIQuestion.add("EI1")
        testmbti.EorIQuestion.add("EI2")
        testmbti.EorIQuestion.add("EI3")
        testmbti.EorIAnswer.add("E1")
        testmbti.EorIAnswer.add("I1")
        testmbti.EorIAnswer.add("E2")
        testmbti.EorIAnswer.add("I2")
        testmbti.EorIAnswer.add("E3")
        testmbti.EorIAnswer.add("I3")

        testmbti.SorNQuestion.add("SN1")
        testmbti.SorNQuestion.add("SN2")
        testmbti.SorNQuestion.add("SN3")
        testmbti.SorNAnswer.add("S1")
        testmbti.SorNAnswer.add("N1")
        testmbti.SorNAnswer.add("S2")
        testmbti.SorNAnswer.add("N2")
        testmbti.SorNAnswer.add("S3")
        testmbti.SorNAnswer.add("N3")

        testmbti.TorFQuestion.add("TF1")
        testmbti.TorFQuestion.add("TF2")
        testmbti.TorFQuestion.add("TF3")
        testmbti.TorFAnswer.add("T1")
        testmbti.TorFAnswer.add("F1")
        testmbti.TorFAnswer.add("T2")
        testmbti.TorFAnswer.add("F2")
        testmbti.TorFAnswer.add("T3")
        testmbti.TorFAnswer.add("F3")

        testmbti.PorJQuestion.add("PJ1")
        testmbti.PorJQuestion.add("PJ2")
        testmbti.PorJQuestion.add("PJ3")
        testmbti.PorJAnswer.add("P1")
        testmbti.PorJAnswer.add("J1")
        testmbti.PorJAnswer.add("P2")
        testmbti.PorJAnswer.add("J2")
        testmbti.PorJAnswer.add("P3")
        testmbti.PorJAnswer.add("J3")

    }
}
