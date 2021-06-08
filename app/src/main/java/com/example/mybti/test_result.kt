package com.example.mybti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_test_result_l.*

class test_result : AppCompatActivity() {
    lateinit var temp: MbtiTestResult
    lateinit var mbti: MbtiTest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_result)

        temp = this.intent.getParcelableExtra<MbtiTestResult>("result")
        Log.d("tag", temp.mbti[0] + temp.mbti[1] + temp.mbti[2] + temp.mbti[3])
        temp.resultCalculating()
        textView3.text = temp.mbti[0] + temp.mbti[1] + temp.mbti[2] + temp.mbti[3]

        mbti = this.intent.getParcelableExtra<MbtiTest>("mbti")

        textView4.text = calculateResult() + "\n가장 잘 어울리는 mbti는\n" + calculateBest()

        val intentMain = Intent(this, activity_main::class.java)
        button4.setOnClickListener {
            startActivity(intentMain)
            finish()
        }

    }

    // result 순서는
    // INTJ, INTP, ENTJ , ENTP, INFJ, INFP, ENFJ, ENFP, ISTJ, ISFJ, ESTJ, ESFJ, ISTP, ISFP, ESTP, ESFP
    fun calculateResult(): String {
        var result = ""
        var temp_mbti = temp.mbti[0] + temp.mbti[1] + temp.mbti[2] + temp.mbti[3]
        Log.d("tag", temp_mbti)
        if(temp_mbti.equals("INTJ"))
            result = mbti.result[0]
        if(temp_mbti.equals("INTP"))
            result = mbti.result[1]
        if(temp_mbti.equals("ENTJ"))
            result = mbti.result[2]
        if(temp_mbti.equals("ENTP"))
            result = mbti.result[3]

        if(temp_mbti.equals("INFJ"))
            result = mbti.result[4]
        if(temp_mbti.equals("INFP"))
            result = mbti.result[5]
        if(temp_mbti.equals("ENFJ"))
            result = mbti.result[6]
        if(temp_mbti.equals("ENFP"))
            result = mbti.result[7]

        if(temp_mbti.equals("ISTJ"))
            result = mbti.result[8]
        if(temp_mbti.equals("ISFJ"))
            result = mbti.result[9]
        if(temp_mbti.equals("ESTJ"))
            result = mbti.result[10]
        if(temp_mbti.equals("ESFJ"))
            result = mbti.result[11]

        if(temp_mbti.equals("ISTP"))
            result = mbti.result[12]
        if(temp_mbti.equals("ISFP"))
            result = mbti.result[13]
        if(temp_mbti.equals("ESTP"))
            result = mbti.result[14]
        if(temp_mbti.equals("ESFP"))
            result = mbti.result[15]

        return result
    }

    fun calculateBest(): String {
        var result = ""
        var temp_mbti = temp.bestCompatibility()

        if(temp_mbti.equals("INTJ"))
            result = mbti.result[0]
        if(temp_mbti.equals("INTP"))
            result = mbti.result[1]
        if(temp_mbti.equals("ENTJ"))
            result = mbti.result[2]
        if(temp_mbti.equals("ENTP"))
            result = mbti.result[3]

        if(temp_mbti.equals("INFJ"))
            result = mbti.result[4]
        if(temp_mbti.equals("INFP"))
            result = mbti.result[5]
        if(temp_mbti.equals("ENFJ"))
            result = mbti.result[6]
        if(temp_mbti.equals("ENFP"))
            result = mbti.result[7]

        if(temp_mbti.equals("ISTJ"))
            result = mbti.result[8]
        if(temp_mbti.equals("ISFJ"))
            result = mbti.result[9]
        if(temp_mbti.equals("ESTJ"))
            result = mbti.result[10]
        if(temp_mbti.equals("ESFJ"))
            result = mbti.result[11]

        if(temp_mbti.equals("ISTP"))
            result = mbti.result[12]
        if(temp_mbti.equals("ISFP"))
            result = mbti.result[13]
        if(temp_mbti.equals("ESTP"))
            result = mbti.result[14]
        if(temp_mbti.equals("ESFP"))
            result = mbti.result[15]

        return temp_mbti + ", " + result
    }
}
