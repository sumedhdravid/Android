package com.example.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R



data class PhoneItem(
    val number : String,
    val name : String,
    val created : String
)

class PhoneAdapter(
    private val ctx : Context,
    private val dataSource : List<PhoneItem>
) : RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    inner class PhoneViewHolder(private val itVw: View) : RecyclerView.ViewHolder(itVw){

        fun name() = itVw.findViewById<TextView>(R.id.txtNm)
        fun number() = itVw.findViewById<TextView>(R.id.txtnum)
        fun created() = itVw.findViewById<TextView>(R.id.txtCrd)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {

        val itemView = LayoutInflater.from(ctx).inflate(R.layout.phone_list_item, parent, false)
        return PhoneViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {

        holder.name().text = dataSource[position].name
        holder.number().text = dataSource[position].number
        holder.created().text = dataSource[position].created

    }

    override fun getItemCount() = dataSource.size
}