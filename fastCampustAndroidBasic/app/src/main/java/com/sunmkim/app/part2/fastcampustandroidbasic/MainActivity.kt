package com.sunmkim.app.part2.fastcampustandroidbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.calculator.*

class MainActivity : AppCompatActivity() {
    var history = ""
    var answer: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        number1.setOnClickListener{
            
            history += "1"
            contentTextView.setText(history)
        }
        number2.setOnClickListener{

            history += "2"
            contentTextView.setText(history)
        }
        number3.setOnClickListener{

            history += "3"
            contentTextView.setText(history)
        }
        number4.setOnClickListener{

            history += "4"
            contentTextView.setText(history)
        }
        number5.setOnClickListener{

            history += "6"
            contentTextView.setText(history)
        }
        number6.setOnClickListener{

            history += "7"
            contentTextView.setText(history)
        }


        addBtn.setOnClickListener{
            if (history == "") {
                Toast.makeText(this,"내용이없습니다. ",Toast.LENGTH_SHORT).show()
            }
            else {
                val temp = history.toInt()
                answer += temp
                history = ""
                contentTextView.setText(history)
                resultTextView.setText(answer.toString())
            }

        }
        clearBtn.setOnClickListener{
            history = ""
            contentTextView.setText(history)
        }
    }
}



