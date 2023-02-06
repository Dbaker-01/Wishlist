package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    lateinit var wItems: List<Items>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        var itemsToAdd : MutableList<Items> = ArrayList()
        val wListRV = findViewById<RecyclerView>(R.id.itemRecycle)

        fun setItem(): MutableList<Items>
        {
            val itemName = findViewById<EditText>(R.id.nameInput).text.toString()
            val price = findViewById<EditText>(R.id.priceInput).text.toString()
            val itemLocation = findViewById<EditText>(R.id.itemLocationInput).text.toString()
            val item2 = Items(itemName,price,itemLocation)
            itemsToAdd.add(item2)
            return itemsToAdd
        }


        button.setOnClickListener{
            wItems = setItem()
            val adapter = WishlistAdapter(wItems)
            wListRV.adapter = adapter
            wListRV.layoutManager = LinearLayoutManager(this)
            adapter.notifyDataSetChanged()
            wListRV.invalidate()
            adapter.notifyItemInserted(adapter.itemCount)
        }



    }
}