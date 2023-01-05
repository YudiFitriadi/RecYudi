package com.yudi.recyudi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerFood:RecyclerView
    lateinit var foodAdapter:FoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerFood=findViewById(R.id.recycleView)

        initRecyclerFood()
        addDataFood()
    }

    private fun addDataFood() {
        val dataFood = Data.createDataFood()
        foodAdapter.submitList(dataFood)
    }

    private fun initRecyclerFood() {
        recyclerFood.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            val topSpaceDecoration = SpaceDecoration(30)
            addItemDecoration(topSpaceDecoration)
            foodAdapter=FoodAdapter()
            adapter= foodAdapter
        }
    }
}