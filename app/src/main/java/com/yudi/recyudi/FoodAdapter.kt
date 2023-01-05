package com.yudi.recyudi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FoodAdapter (): RecyclerView.Adapter<FoodAdapter.FoodHolder>() {

    private var item:List<Food> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.food_item,parent,false)
        return FoodHolder(view)
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        when (holder){
            is FoodHolder ->{
                holder.bind(item.get(position))
            }
        }
    }

    fun submitList(foodList: List<Food>){
        item=foodList;
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class FoodHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name:TextView = itemView.findViewById(R.id.foodName)
        var ket:TextView = itemView.findViewById(R.id.foodKet)
        var price:TextView = itemView.findViewById(R.id.foodPrice)
        var image:ImageView = itemView.findViewById(R.id.foodImage)
        fun bind(food: Food){
            Glide
                .with(itemView.context)
                .load(food.foodImage)
                .into(image)
            name.setText(food.foodName)
            ket.setText(food.foodKet)
            price.setText(food.foodPrice)
        }
    }



}