package com.sunmkim.app.part2.lotto45

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private val numberPicker : NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.picker)
    }
    private val clearButton : Button by lazy {
        findViewById<Button>(R.id.clearButton)
    }
    private val runButton : Button by lazy {
        findViewById<Button>(R.id.runButton)
    }
    private val addButton : Button by lazy {
        findViewById<Button>(R.id.addButton)
    }

    private var didRun = false

    private val pickedNumbers = hashSetOf<Int>()

    private val textViewList: List<TextView> by lazy {
        listOf<TextView>(
            findViewById<TextView>(R.id.numTextView1),
            findViewById<TextView>(R.id.numTextView2),
            findViewById<TextView>(R.id.numTextView3),
            findViewById<TextView>(R.id.numTextView4),
            findViewById<TextView>(R.id.numTextView5),
            findViewById<TextView>(R.id.numTextView6),

        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker.minValue = 1
        numberPicker.maxValue = 45

        initRunButton()
        initAddButton()
        initClearButton()
    }

    private fun initRunButton() {
        runButton.setOnClickListener{
            val list = getRandomNumber()

            didRun = true
            
            list.forEachIndexed { index, number ->
                val textView = textViewList[index]

                textView.text = number.toString()
                textView.isVisible = true
                changeBackGround(number,textView)
            }





        }
    }

    private fun initAddButton() {
        addButton.setOnClickListener {
            if (didRun) {
                Toast.makeText(this,"초기화 후에 실행 해 주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pickedNumbers.size >= 5){
                Toast.makeText(this,"번호는 5개 까지 가능합니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pickedNumbers.contains(numberPicker.value)){
                Toast.makeText(this,"이미 선택한 번호 입니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val textView = textViewList[pickedNumbers.size]
            textView.isVisible = true
            textView.text = numberPicker.value.toString()


            changeBackGround(numberPicker.value,textView)
            pickedNumbers.add(numberPicker.value)

        }
    }

    private fun initClearButton(){
        clearButton.setOnClickListener{
            pickedNumbers.clear()
            textViewList.forEach{
                it.isVisible = false
            }

            didRun = false

        }
    }

    private fun getRandomNumber():List<Int>{
        val numberList = mutableListOf<Int>()
            .apply {
                for (i in 1..45) {
                    if(pickedNumbers.contains(i)){
                        continue
                    }
                    this.add(i)
                }
            }
        numberList.shuffle()

        val newList = pickedNumbers.toList() + numberList.subList(0, 6 - pickedNumbers.size )
        return newList.sorted()
    }

    private fun changeBackGround(number:Int, textView: TextView) {
        when(number) {
            in 1..10 -> textView.background = ContextCompat.getDrawable(this,R.drawable.circle_yellow)
            in 11..20 -> textView.background = ContextCompat.getDrawable(this,R.drawable.circle_blue)
            in 21..30 -> textView.background = ContextCompat.getDrawable(this,R.drawable.circle_red)
            in 31..40 -> textView.background = ContextCompat.getDrawable(this,R.drawable.circle_gray)
            else -> textView.background = ContextCompat.getDrawable(this,R.drawable.circle_green)
        }


    }

}