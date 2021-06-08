package com.example.mybti

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

data class MbtiTest(
    var title: String = "",
    var image: ArrayList<Bitmap> = ArrayList(),
    var font: String = "",

    var EorIQuestion: ArrayList<String> = ArrayList(),
    var EorIAnswer: ArrayList<String> = ArrayList(),
    var SorNQuestion: ArrayList<String> = ArrayList(),
    var SorNAnswer: ArrayList<String> = ArrayList(),
    var TorFQuestion: ArrayList<String> = ArrayList(),
    var TorFAnswer: ArrayList<String> = ArrayList(),
    var PorJQuestion: ArrayList<String> = ArrayList(),
    var PorJAnswer: ArrayList<String> = ArrayList(),

    // result 순서는
    // INTJ, INTP, ENTJ , ENTP, INFJ, INFP, ENFJ, ENFP, ISTJ, ISFJ, ESTJ, ESFJ, ISTP, ISFP, ESTP, ESFP

    var result: ArrayList<String> = ArrayList(),
    var result_images: ArrayList<Bitmap> = ArrayList(),
    var result_detail: ArrayList<String> = ArrayList()
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readArrayList(Bitmap::class.java.classLoader) as ArrayList<Bitmap>,
        parcel.readString().toString(),
        parcel.readArrayList(String::class.java.classLoader) as ArrayList<String>,
        parcel.readArrayList(String::class.java.classLoader) as ArrayList<String>,
        parcel.readArrayList(String::class.java.classLoader) as ArrayList<String>,
        parcel.readArrayList(String::class.java.classLoader) as ArrayList<String>,
        parcel.readArrayList(String::class.java.classLoader) as ArrayList<String>,
        parcel.readArrayList(String::class.java.classLoader) as ArrayList<String>,
        parcel.readArrayList(String::class.java.classLoader) as ArrayList<String>,
        parcel.readArrayList(String::class.java.classLoader) as ArrayList<String>,
        parcel.readArrayList(String::class.java.classLoader) as ArrayList<String>,
        parcel.readArrayList(Bitmap::class.java.classLoader) as ArrayList<Bitmap>,
        parcel.readArrayList(String::class.java.classLoader) as ArrayList<String>
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeList(image as List<*>?)
        parcel.writeString(font)
        parcel.writeList(EorIQuestion as List<*>?)
        parcel.writeList(EorIAnswer as List<*>?)
        parcel.writeList(SorNQuestion as List<*>?)
        parcel.writeList(SorNAnswer as List<*>?)
        parcel.writeList(TorFQuestion as List<*>?)
        parcel.writeList(TorFAnswer as List<*>?)
        parcel.writeList(PorJQuestion as List<*>?)
        parcel.writeList(PorJAnswer as List<*>?)
        parcel.writeList(result as List<*>?)
        parcel.writeList(result_images as List<*>?)
        parcel.writeList(result_detail as List<*>?)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MbtiTest> {
        override fun createFromParcel(parcel: Parcel): MbtiTest {
            return MbtiTest(parcel)
        }

        override fun newArray(size: Int): Array<MbtiTest?> {
            return arrayOfNulls(size)
        }
    }
}

