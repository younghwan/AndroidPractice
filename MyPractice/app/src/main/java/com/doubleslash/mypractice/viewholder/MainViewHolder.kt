package com.doubleslash.mypractice.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.doubleslash.mypractice.R
import com.doubleslash.mypractice.adapter.OnItemClickListener
import com.doubleslash.mypractice.model.Item

class MainViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    var name = item.findViewById<TextView>(R.id.list_name)

    fun bind(item:Item, clickListener: OnItemClickListener){
        name.text = item.name

        itemView.setOnClickListener {
            clickListener.onItemClicked(item)
        }
    }
}