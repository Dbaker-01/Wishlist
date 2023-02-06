package com.example.wishlist

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class WishlistAdapter(private val wishItem: List<Items>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val itemNameView: TextView
        val price: TextView
        val itemLocation: TextView

        init
        {
            itemNameView = itemView.findViewById(R.id.itemName)
            price = itemView.findViewById(R.id.priceText)
            itemLocation = itemView.findViewById(R.id.locationText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val wishlistView = inflater.inflate(R.layout.wish_list_item,parent,false)
        return ViewHolder(wishlistView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val witem = wishItem.get(position)
        holder.itemNameView.setText(witem.itemName)
        holder.price.setText(witem.price)
        holder.itemLocation.setText(witem.itemFound)

    }

    override fun getItemCount(): Int {
        return wishItem.count()
    }
}