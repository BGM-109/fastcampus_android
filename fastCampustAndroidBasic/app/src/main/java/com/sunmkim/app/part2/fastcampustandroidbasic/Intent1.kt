package com.sunmkim.app.part2.fastcampustandroidbasic

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent1.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)


        props.setOnClickListener{
            val number1 = intent.getIntExtra("Number1",0)
            val number2 = intent.getIntExtra("Number2",0)

            var result = number1 + number2
            Log.d("result",result.toString())
            var resultIntent = Intent()
            resultIntent.putExtra("result",result)
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Activity 종료
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("number","!111111")
        super.onActivityResult(requestCode, resultCode, data)
    }
}