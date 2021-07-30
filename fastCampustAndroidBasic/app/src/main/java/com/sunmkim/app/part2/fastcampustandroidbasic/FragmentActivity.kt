package com.sunmkim.app.part2.fastcampustandroidbasic

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_practice.*

class FragmentActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_practice)


        btn1.setOnClickListener{
            setFragment(0)
        }
        btn2.setOnClickListener{
            setFragment(1)
        }
        btn3.setOnClickListener{
            setFragment(2)
        }


    }

    private fun setFragment(pageNumber:Int) {
        val ft = supportFragmentManager.beginTransaction()

        when (pageNumber) {
            0 -> ft.replace(R.id.mainPage,Fragment1()).commit()
            1 -> ft.replace(R.id.mainPage,Fragment2()).commit()
            2 -> ft.replace(R.id.mainPage,Fragment3()).commit()
        }


    }
}