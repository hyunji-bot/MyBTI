package com.example.mybti

import android.graphics.Bitmap

data class MbtiTest(
    var title: String = "",
    var image: String = "",
    var font: String = "",

    var IorEQuestion: ArrayList<String> = ArrayList(),
    var IorEAnswer: ArrayList<String> = ArrayList(),
    var NorSQuestion: ArrayList<String> = ArrayList(),
    var NorSAnswer: ArrayList<String> = ArrayList(),
    var ForTQuestion: ArrayList<String> = ArrayList(),
    var ForTAnswer: ArrayList<String> = ArrayList(),
    var PorJQuestion: ArrayList<String> = ArrayList(),
    var PorJAnswer: ArrayList<String> = ArrayList(),

    // result 순서는
    // ENTJ , ENTP, INTJ, INTP, ESTJ, ESFJ, ISTJ, ISFJ, ENFJ, ENFP, INFJ, INFP, ESTP, ESFP, ISTP, ISFP

    var result: ArrayList<String> = ArrayList(),
    var result_images: ArrayList<Bitmap> = ArrayList(),
    var result_detail: ArrayList<String> = ArrayList()
)