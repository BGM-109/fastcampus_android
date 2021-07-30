package com.sunmkim.app.part2.fastcampustandroidbasic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sunmkim.app.part2.fastcampustandroidbasic.R
import com.sunmkim.app.part2.fastcampustandroidbasic.model.User

class UserAdapter (val context: Context, val UserList: ArrayList<User>) : BaseAdapter() {
    override fun getCount(): Int {
        return UserList.size
    }

    override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.list_item_user,null)
        val profile = view.findViewById<ImageView>(R.id.iv_profile)
        val name = view.findViewById<TextView>(R.id.tv_name)
        val greet = view.findViewById<TextView>(R.id.tv_greet)
        val age = view.findViewById<TextView>(R.id.tv_age)

        val user = UserList[position]

        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age.toString()
        greet.text = user.greet

        return view
    }

}

class UserAdapterR (val UserList: ArrayList<User>) : RecyclerView.Adapter<UserAdapterR.CustomViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapterR.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_list_item,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapterR.CustomViewHolder, position: Int) {
        holder.profile.setImageResource(UserList.get(position).profile)
        holder.name.text = UserList.get(position).name
        holder.age.text = UserList.get(position).age.toString()
        holder.greet.text = UserList.get(position).greet


    }

    override fun getItemCount(): Int {
        return UserList.size
    }
    class CustomViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val profile = itemView.findViewById<ImageView>(R.id.riv_profile)
        val name = itemView.findViewById<TextView>(R.id.rtv_name)
        val greet = itemView.findViewById<TextView>(R.id.rtv_greet)
        val age = itemView.findViewById<TextView>(R.id.rtv_age)



    }
}

