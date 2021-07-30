package com.sunmkim.app.part2.fastcampustandroidbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        val a = 10
        val b = a + 10
        val c = a + 30

        navigation.setOnClickListener{
            val intent = Intent(this@Intent3, Intent1::class.java)
            intent.putExtra("Number1",1)
            intent.putExtra("Number2",2)
            startActivity(intent)
        }
    }
}