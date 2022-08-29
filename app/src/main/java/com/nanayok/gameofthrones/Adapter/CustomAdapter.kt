package com.nanayok.gameofthrones.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nanayok.gameofthrones.DetailActivity
import com.nanayok.gameofthrones.Models.ItemsViewModel
import com.nanayok.gameofthrones.R

class CustomAdapter (private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text
        holder.itemView.setOnClickListener {
//            val intent = Intent(context, DetailsActivity::class.java)
//            startActivity(intent)
            println("Item clicked"+position)
            println("Item clicked"+ItemsViewModel.text)

            val context=holder.textView.context
            val intent = Intent( context, DetailActivity::class.java)
            intent.putExtra("name",ItemsViewModel.text)
            intent.putExtra("region",ItemsViewModel.region)
            intent.putExtra("coatOfArms",ItemsViewModel.coatOfArms)
            context.startActivity(intent)

        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

}