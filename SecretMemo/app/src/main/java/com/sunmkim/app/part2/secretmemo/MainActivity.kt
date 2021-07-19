package com.sunmkim.app.part2.secretmemo

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    private val numberPicker1: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.np1)
            .apply{
                minValue = 0
                maxValue = 9
            }
    }
    private val numberPicker2: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.np2)
            .apply{
                minValue = 0
                maxValue = 9
            }
    }
    private val numberPicker3: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.np3)
            .apply{
                minValue = 0
                maxValue = 9
            }
    }

    private val openButton: AppCompatButton by lazy {
        findViewById<AppCompatButton>(R.id.openButton)
    }

    private val changeButton: AppCompatButton by lazy {
        findViewById<AppCompatButton>(R.id.changeButton)
    }

    private var changePasswordMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker1
        numberPicker2
        numberPicker3 // 호출해주지않으면 생성되지않음

        openButton.setOnClickListener {
            if (changePasswordMode){
                Toast.makeText(this,"비밀번호를 변경중입니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val passwordPreference = getSharedPreferences("password", Context.MODE_PRIVATE)

            val passwordFromUser = "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}"

            if (passwordPreference.getString("password","000").equals(passwordFromUser)){
                startActivity(Intent(this,DiaryActivity::class.java))
            } else {
                //실패    에러
                showErrorAlertDialog()
            }


        }

        changeButton.setOnClickListener{
            val passwordPreference = getSharedPreferences("password", Context.MODE_PRIVATE)
            val passwordFromUser = "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}"
            if(changePasswordMode){
                //번호를 저장
                passwordPreference.edit(true){
                    putString("password",passwordFromUser)
                }
                changePasswordMode = false
                changeButton.setBackgroundColor(Color.BLACK)

            }else {
                // 모드 활성화 && 번호확인
                if (passwordPreference.getString("password","000").equals(passwordFromUser)){
                    // 비밀번호재셋팅
                    changePasswordMode = true
                    Toast.makeText(this,"변경할 비밀번호를 입력해주세요",Toast.LENGTH_SHORT).show()
                    changeButton.setBackgroundColor(Color.RED)
                } else {
                    //실패    에러
                    showErrorAlertDialog()
                }

            }
        }

    }

    private fun showErrorAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Fail!")
            .setMessage("비밀번호가 다릅니다.")
            .setPositiveButton("확인"){ _,_ -> }
            .create()
            .show()
    }
}