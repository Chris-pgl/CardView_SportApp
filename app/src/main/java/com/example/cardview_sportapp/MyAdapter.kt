package com.example.cardview_sportapp

import android.R.attr.onClick
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val sportList: List<Sport>): RecyclerView.Adapter<MyAdapter.SportViewHolder>() {



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SportViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_layout,parent,false)

        return SportViewHolder(view) { position ->
            Toast.makeText(
                parent.context,
                "You clicked on: ${sportList[position].sport}",
                Toast.LENGTH_SHORT)
                .show()
        }
    }


    override fun onBindViewHolder(holder: MyAdapter.SportViewHolder, position: Int) {

        holder.textView.text = sportList[position].sport
        holder.imageView.setImageResource(sportList[position].img)

    }

    override fun getItemCount(): Int {
        return sportList.size
    }


    class SportViewHolder(itemView: View,  onClick: (Int) -> Unit): RecyclerView.ViewHolder(itemView) {


        val textView = itemView.findViewById<TextView>(R.id.textviewCard)
        val imageView = itemView.findViewById<ImageView>(R.id.imageviewCard)

        init{
            itemView.setOnClickListener{
                val position = bindingAdapterPosition
                if(position != RecyclerView.NO_POSITION){
                    onClick(position)
                }
            }
        }

    }

}