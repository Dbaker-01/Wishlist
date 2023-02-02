package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    lateinit var witems: List<Items>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)

        val wListRV = findViewById<RecyclerView>(R.id.itemRecycle)

        val itemsToAdd : MutableList<Items> = ArrayList()

        val adapter = WishlistAdapter(witems)
        wListRV.adapter = adapter
        wListRV.layoutManager = LinearLayoutManager(this)


        button.setOnClickListener{
            val itemName = findViewById<EditText>(R.id.nameInput).toString()
            val price = findViewById<EditText>(R.id.priceInput).toString()
            val itemLocation = findViewById<EditText>(R.id.itemLocationInput).toString()
            val item = Items(itemName,price,itemLocation)
            itemsToAdd.add(item)
            witems = itemsToAdd
        }
    }
}