package com.sunmkim.app.part2.fastcampustandroidbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunmkim.app.part2.fastcampustandroidbasic.adapter.UserAdapterR
import com.sunmkim.app.part2.fastcampustandroidbasic.model.User
import kotlinx.android.synthetic.main.activity_recycler_view_practice.*

class RecyclerViewPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_practice)

        var UserList = arrayListOf<User>(
            User(R.drawable.nike,"나이키",30,"글로벌 스포츠 브랜드"),
            User(R.drawable.adidas,"아디다스",30,"글로벌 스포츠 브랜드"),
            User(R.drawable.yoga,"요가",30,"유연하게"),
            User(R.drawable.nike,"아크테릭스",30,"글로벌 스포츠 브랜드"),
            User(R.drawable.nike,"언더아머",30,"글로벌 스포츠 브랜드"),
            User(R.drawable.muscles,"짐웨어1",30,"안녕하세요"),
            User(R.drawable.puma,"퓨마",30,"글로벌 스포츠 브랜드"),
            User(R.drawable.nike,"나이키",30,"안녕하세요"),
            User(R.drawable.nike,"나이키",30,"안녕하세요"),
            User(R.drawable.nike,"나이키",30,"안녕하세요"),
            User(R.drawable.nike,"나이키",30,"안녕하세요"),
            User(R.drawable.nike,"나이키",30,"안녕하세요"),
            User(R.drawable.nike,"나이키",30,"안녕하세요"),
            User(R.drawable.nike,"나이키",30,"안녕하세요"),

            )

        rv_profile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_profile.setHasFixedSize(true)

        rv_profile.adapter = UserAdapterR(UserList)


    }
}