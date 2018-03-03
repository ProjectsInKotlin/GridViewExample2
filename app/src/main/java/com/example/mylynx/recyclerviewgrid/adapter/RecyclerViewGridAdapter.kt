package com.example.mylynx.recyclerviewgrid.adapter

import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.mylynx.recyclerviewgrid.R


/**
 * Created by mylynx on 02.03.18.
 */
class RecyclerViewGridAdapter(private var context: Context, private var data: Array<String>) : RecyclerView.Adapter<RecyclerViewGridAdapter.ViewHolder>() {


    // inflates the cell layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the textview in each cell
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = data[position]
        holder.myTextView.text = animal
        holder.bindItem()
    }

    // total number of cells
    override fun getItemCount(): Int {
        return data.size
    }


    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var myTextView = itemView.findViewById<TextView>(R.id.info_text)

        fun bindItem() {
            itemView.setOnClickListener {
                Toast.makeText(context, myTextView.text, Toast.LENGTH_SHORT).show()
            }
        }






    }
}

