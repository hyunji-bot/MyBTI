package com.example.mybti

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val OPEN_GALLERY = 1
    var mbtiTest :MbtiTest = MbtiTest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val intent = Intent(this, create::class.java) // 인텐트를 생성

        button6.setOnClickListener { // 버튼 클릭시 할 행동
            startActivity(intent)  // 화면 전환하기
        }
    }

    // images loading
    private fun openGallery() {
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, OPEN_GALLERY)
    }
    
    /* 갤러리에서 이미지 불러오고 싶을 때 onActivityResult에 넣기
    
    if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLERY) {

                var currentImageUrl : Uri? = data?.data

                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver,currentImageUrl)
                    Log.d("tag", currentImageUrl.toString())
                    imageView.setImageBitmap(bitmap)
                    Log.d("tag", bitmap.toString())
                    mbtiTest.result_images.add(bitmap)
                    Log.d("tag", mbtiTest.result_images[0].toString())
                }catch(e:Exception){
                    e.printStackTrace()
                }
            }
        }
        else {
            Log.d("tag", "failed iamges")
    */

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    /*
    TEST CODES

    var iorEQ: ArrayList<String> = ArrayList()
        iorEQ.add("iorE Q1")
        iorEQ.add("iorE Q2")
        iorEQ.add("iorE Q3")

        var iorEA: ArrayList<String> = ArrayList()
        iorEA.add("iorE A1-1")
        iorEA.add("iorE A1-2")
        iorEA.add("iorE A2-1")
        iorEA.add("iorE A2-2")
        iorEA.add("iorE A3-1")
        iorEA.add("iorE A3-2")

        var norSQ: ArrayList<String> = ArrayList()
        norSQ.add("norS Q1")
        norSQ.add("norS Q2")
        norSQ.add("norS Q3")

        var norSA: ArrayList<String> = ArrayList()
        norSA.add("norS A1-1")
        norSA.add("norS A1-2")
        norSA.add("norS A2-1")
        norSA.add("norS A2-2")
        norSA.add("norS A3-1")
        norSA.add("norS A3-2")

        var forTQ: ArrayList<String> = ArrayList()
        forTQ.add("forT Q1")
        forTQ.add("forT Q2")
        forTQ.add("forT Q3")

        var forTA: ArrayList<String> = ArrayList()
        forTA.add("forT A1-1")
        forTA.add("forT A1-2")
        forTA.add("forT A2-1")
        forTA.add("forT A2-2")
        forTA.add("forT A3-1")
        forTA.add("forT A3-2")

        var porJQ: ArrayList<String> = ArrayList()
        porJQ.add("porJ Q1")
        porJQ.add("porJ Q2")
        porJQ.add("porJ Q3")

        var porJA: ArrayList<String> = ArrayList()
        porJA.add("porJ A1-1")
        porJA.add("porJ A1-2")
        porJA.add("porJ A2-1")
        porJA.add("porJ A2-2")
        porJA.add("porJ A3-1")
        porJA.add("porJ A3-2")

        var result: ArrayList<String> = ArrayList()
        result.add("INFP")

        var test1 = MbtiTest("고양이", "image.jpg", "글꼴",
            iorEQ, iorEA, norSQ, norSA, forTQ, forTA, porJQ, porJA, result, compatibility)
        tests.add(test1)

        Log.d(tests.get(0).ForTAnswer.toString(), tests.get(0).compatibility.get(0))

        //file 입출력으로 저장

        val file = File(this.applicationContext.filesDir, filename)
        var temp: String = test1.font +"\n"+ test1.title + test1.image + test1.IorEAnswer[1]
        file.writeText(temp)

        val filename2 = "test2"
        val file2 = File(this.applicationContext.filesDir, filename2)
        val temp2: String = test1.ForTAnswer[0]
        file2.writeText(temp2)

        Log.d("tag", file.readText())
        Log.d("tag", file.readLines()[1])
        Log.d("tag", this.applicationContext.fileList()[0].plus(this.applicationContext.fileList()[1]))
     */
}
