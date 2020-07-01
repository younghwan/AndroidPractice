package com.doubleslash.mypractice.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.doubleslash.mypractice.R
import com.doubleslash.mypractice.activity.bmi.BMIActivity
import com.doubleslash.mypractice.activity.browser.BrowserActivity
import com.doubleslash.mypractice.activity.stopwatch.StopwatchActivity
import com.doubleslash.mypractice.adapter.MainAdapter
import com.doubleslash.mypractice.adapter.OnItemClickListener
import com.doubleslash.mypractice.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(),OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameList = arrayOf(
            Item("BMI검사기"),
            Item("스톱워치"),
            Item("웹브라우져")
        )
        val mLayoutManager = LinearLayoutManager(this)
        val mRecyclerView = main_list
        val mAdapter = MainAdapter(nameList,this)

        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = mLayoutManager

    }

    override fun onItemClicked(item: Item) {
        Toast.makeText(this, item.name,Toast.LENGTH_SHORT).show()
        var itemName = item.name

        when(itemName){
            "BMI검사기" -> startActivity<BMIActivity>()
            "스톱워치" -> startActivity<StopwatchActivity>()
            "웹브라우져" -> startActivity<BrowserActivity>()
        }
    }
}
