package com.doubleslash.mypractice.adapter

import com.doubleslash.mypractice.model.Item

interface OnItemClickListener {
    fun onItemClicked(item: Item)
}