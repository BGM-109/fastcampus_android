package com.sunmkim.app.part2.fastcampustandroidbasic

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 10){
            carList.add(CarForList("$i 번째 자동차", "$i 순위 엔진") )
        }

        val adapter = ListViewAdapter(carList,this@ListViewActivity as Context)
        ListView.adapter = adapter
        ListView.setOnItemClickListener{ parent,view,position,id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine
            Toast.makeText(this, carName + " " + carEngine,Toast.LENGTH_SHORT).show()

        }

    }

}

class CarForList(var name:String, var engine:String)

class ListViewAdapter(
    val carForList: ArrayList<CarForList>,
    val context: Context
  ): BaseAdapter() {

    override fun getCount(): Int {
        return carForList.size
    }

    override fun getItem(position: Int): Any {
        return carForList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item_view,null)
        var carNameTextView = view.findViewById<TextView>(R.id.car_name)
        var carEngineTextView = view.findViewById<TextView>(R.id.car_engine)

        carNameTextView.setText(carForList.get(position).name)
        carEngineTextView.setText(carForList.get(position).engine)

        return view
    }
}