package com.example.mybti

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import java.util.*

class MbtiTestResult (
    var mbti: Array<String> = arrayOf<String>("I", "N", "F", "J"), // initialize

    var EorIpoint: Int = 0, // 2보다 작으면 E, 2보다 크면 I
    var SorNpoint: Int = 0, // 2보다 작으면 S, 2보다 크면 N
    var TorFpoint: Int = 0, // 2보다 작으면 T, 2보다 크면 F
    var PorJpoint: Int = 0  // 2보다 작으면 P, 2보다 크면 J
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.createStringArray() as Array<String>,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    fun resultCalculating() {
        if (EorIpoint < 2)
            mbti[0] = "E"
        else mbti[0] = "I"

        if (SorNpoint < 2)
            mbti[1] = "S"
        else mbti[1] = "N"

        if (TorFpoint < 2)
            mbti[2] = "T"
        else mbti[2] = "F"

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

        return temp[0] + temp[1] + temp[2] + temp[3]
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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringArray(mbti)
        parcel.writeInt(EorIpoint)
        parcel.writeInt(SorNpoint)
        parcel.writeInt(TorFpoint)
        parcel.writeInt(PorJpoint)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MbtiTestResult> {
        override fun createFromParcel(parcel: Parcel): MbtiTestResult {
            return MbtiTestResult(parcel)
        }

        override fun newArray(size: Int): Array<MbtiTestResult?> {
            return arrayOfNulls(size)
        }
    }
}