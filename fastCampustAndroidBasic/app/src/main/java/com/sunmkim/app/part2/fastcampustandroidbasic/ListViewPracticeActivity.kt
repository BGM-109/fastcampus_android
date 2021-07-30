package com.sunmkim.app.part2.fastcampustandroidbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.sunmkim.app.part2.fastcampustandroidbasic.adapter.UserAdapter
import com.sunmkim.app.part2.fastcampustandroidbasic.model.User
import kotlinx.android.synthetic.main.activity_list_view_practice.*

class ListViewPracticeActivity : AppCompatActivity() {

    var UserList = arrayListOf<User>(
        User(R.drawable.nike,"나이키",30,"안녕하세요"),
        User(R.drawable.nike,"아디다스",30,"안녕하세요"),
        User(R.drawable.nike,"언더아머",30,"안녕하세요"),
        User(R.drawable.nike,"아크테릭스",30,"안녕하세요"),
        User(R.drawable.nike,"나이키",30,"안녕하세요"),
        User(R.drawable.nike,"나이키",30,"안녕하세요"),
        User(R.drawable.nike,"나이키",30,"안녕하세요"),
        User(R.drawable.nike,"나이키",30,"안녕하세요"),
        User(R.drawable.nike,"나이키",30,"안녕하세요"),
        User(R.drawable.nike,"나이키",30,"안녕하세요"),
        User(R.drawable.nike,"나이키",30,"안녕하세요"),
        User(R.drawable.nike,"나이키",30,"안녕하세요"),
        User(R.drawable.nike,"나이키",30,"안녕하세요"),
        User(R.drawable.nike,"나이키",30,"안녕하세요"),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_practice)

//        val item = arrayOf("apple","pineapple","kiwi","melon")
//        listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, item)

        val adapter = UserAdapter(this,UserList)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent,view,position,id->
            val selectItem = parent.getItemAtPosition(position) as User

            Toast.makeText(this,selectItem.name,Toast.LENGTH_SHORT).show()


        }

    }


}