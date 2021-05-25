package com.example.mybti

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import androidx.core.app.ActivityCompat.startActivityForResult
import kotlinx.android.synthetic.main.activity_create.*
import java.io.ByteArrayOutputStream

class create : AppCompatActivity() {
    private val OPEN_GALLERY = 1
    var imageToString: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val intent = Intent(this, create_qna::class.java) // 인텐트를 생성

        button.setOnClickListener {
            openGallery()
        }

        button2.setOnClickListener { // 버튼 클릭시 할 행동
            intent.putExtra("title", editTextTextPersonName.text.toString())
            Log.d("image", imageToString)
            intent.putExtra("image", imageToString)
            startActivity(intent)  // 화면 전환하기
        }
    }

    fun BitMapToString(bitmap: Bitmap): String {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val b = baos.toByteArray()
        Log.d("tag2", Base64.encodeToString(b, Base64.DEFAULT))
        return Base64.encodeToString(b, Base64.DEFAULT)
    }

    private fun openGallery() {
        val intent2: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent2.setType("image/*")
        startActivityForResult(intent2, OPEN_GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLERY) {

                var currentImageUrl : Uri? = data?.data

                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver,currentImageUrl)
                    Log.d("tag", currentImageUrl.toString())
                    val scale = 8
                    Log.d("tag", scale.toString())
                    val resized = Bitmap.createScaledBitmap(bitmap, (bitmap.width)/scale, (bitmap.height)/scale, true)
                    imageView.setImageBitmap(resized)
                    Log.d("tag", resized.toString())
                    imageToString = BitMapToString(resized)
                }catch(e:Exception){
                    e.printStackTrace()
                }
            }
        }
        else {
            Log.d("tag", "failed iamges")
        }
    }
}