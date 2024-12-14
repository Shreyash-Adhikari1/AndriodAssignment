package com.example.andriodassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andriodassignment.R

class RecyclerAdapter(
    private val context: Context,
    private val imageList: ArrayList<Int>,
    private val titleList: ArrayList<String>,
    private val descList: ArrayList<String>
) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    // ViewHolder class to hold item views
    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    // Inflate the item layout and create a ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.image_recycler, parent, false)
        return RecyclerViewHolder(itemView)
    }

    // Return the total count of items
    override fun getItemCount(): Int {
        return imageList.size
    }

    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position])
        holder.titleTextView.text = titleList[position]
        holder.descriptionTextView.text = descList[position]
    }
}
