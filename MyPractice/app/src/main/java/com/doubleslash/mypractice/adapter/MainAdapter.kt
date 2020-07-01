package com.doubleslash.mypractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.doubleslash.mypractice.R
import com.doubleslash.mypractice.model.Item
import com.doubleslash.mypractice.viewholder.MainViewHolder

class MainAdapter(val itemList : Array<Item>,val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<MainViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(itemList[position],itemClickListener)
    }
}