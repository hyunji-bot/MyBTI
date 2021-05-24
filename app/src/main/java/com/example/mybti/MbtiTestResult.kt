package com.example.mybti

import android.util.Log
import java.util.*

class MbtiTestResult {
    var mbti = arrayOf<String>("I", "S", "T", "J") // initialize

    var EorIpoint: Int = 0 // 2보다 작으면 E, 2보다 크면 I
    var NorSpoint: Int = 0 // 2보다 작으면 N, 2보다 크면 S
    var ForTpoint: Int = 0 // 2보다 작으면 F, 2보다 크면 T
    var PorJpoint: Int = 0 // 2보다 작으면 P, 2보다 크면 J

    fun resultCalculating() {
        if (EorIpoint < 2)
            mbti[0] = "E"
        else mbti[0] = "I"

        if (NorSpoint < 2)
            mbti[1] = "N"
        else mbti[1] = "S"

        if (ForTpoint < 2)
            mbti[2] = "F"
        else mbti[2] = "T"

        if (PorJpoint < 2)
            mbti[3] = "P"
        else mbti[3] = "J"
    }

    fun bestCompatibility(): String {
        var temp = arrayOf<String>("A", "B", "C", "D")

        if (mbti[0].equals("I"))
            temp[0] = "E"
        else temp[0] = "I"

        if (mbti[1].equals("N"))
            temp[1] = "S"
        else temp[1] = "N"

        if (mbti[2].equals("F"))
            temp[2] = "T"
        else temp[2] = "F"

        if (mbti[3].equals("P"))
            temp[3] = "J"
        else temp[3] = "P"

        return temp.contentToString()
    }

    fun worstCompatibility(): String {
        var temp = arrayOf<String>("A", "B", "C", "D")

        if (mbti[0].equals("I"))
            temp[0] = "E"
        else temp[0] = "I"

        if (mbti[1].equals("N"))
            temp[1] = "S"
        else temp[1] = "N"

        if (mbti[2].equals("F"))
            temp[2] = "T"
        else temp[2] = "F"

        temp[3] = mbti[3]

        return temp.contentToString()
    }
}