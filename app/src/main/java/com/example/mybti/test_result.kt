package com.example.mybti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_test_result_l.*

class test_result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_result)

        val temp = this.intent.getParcelableExtra<MbtiTestResult>("result")
        Log.d("tag", temp.mbti[0] + temp.mbti[1] + temp.mbti[2] + temp.mbti[3])
        temp.resultCalculating()
        textView3.text = temp.mbti[0] + temp.mbti[1] + temp.mbti[2] + temp.mbti[3]

        val intentMain = Intent(this, activity_main::class.java)
        button4.setOnClickListener {
            startActivity(intentMain)
            finish()
        }

    }
}
